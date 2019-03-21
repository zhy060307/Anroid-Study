package zhy.com.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import android.util.Log;

import zhy.com.utils.DimenUtils;

/**
 * 使TextView中不同大小字体垂直居中
 */
public class CustomVerticalCenterSpan extends ReplacementSpan {
    private Context context;
    private int fontSizeSp;    //字体大小sp

    public CustomVerticalCenterSpan(Context context, int fontSizeSp) {
        this.context = context;
        this.fontSizeSp = fontSizeSp;
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        text = text.subSequence(start, end);
        Paint p = getCustomTextPaint(paint);
        return (int) p.measureText(text.toString());
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        text = text.subSequence(start, end);
        Paint p = getCustomTextPaint(paint);
        Paint.FontMetricsInt fm = p.getFontMetricsInt();
        Log.d("TAG", "fm = " + fm.toString());
        Log.d("TAG", "x = " + x + " ,base = " + y + ", top = " + top + " , bottom = " + bottom);
        int baseY = y - ((y + fm.descent + y + fm.ascent) / 2 - (bottom + top) / 2);
        Log.d("TAG", "baseY =" + baseY);
        canvas.drawText(text.toString(), x, baseY, p);    //此处重新计算y坐标，使字体居中
    }

    private TextPaint getCustomTextPaint(Paint srcPaint) {
        TextPaint paint = new TextPaint(srcPaint);
        paint.setTextSize(DimenUtils.sp2px(fontSizeSp, context));   //设定字体大小, sp转换为px
        return paint;
    }
}