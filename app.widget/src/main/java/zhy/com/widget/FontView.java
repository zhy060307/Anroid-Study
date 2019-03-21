package zhy.com.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

public class FontView extends View {
    private static final String TEXT = ":";


    //    private static final String TEXT = "ap爱哥ξτβбпшㄎㄊ";
    private Paint textPaint, linePaint;// 文本的画笔和中心线的画笔

    private int baseX, baseY;// Baseline绘制的XY坐标

    public FontView(Context context) {
        this(context, null);
    }

    public FontView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // 初始化画笔
        initPaint();
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        // 实例化画笔
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextSize(100);
        textPaint.setColor(Color.BLACK);
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/DINOT-Bold.ttf");
        textPaint.setTypeface(typeface);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 计算Baseline绘制的起点X轴坐标
        baseX = (int) (getWidth() / 2 - textPaint.measureText(TEXT) / 2);

        // 计算Baseline绘制的Y坐标
        baseY = (int) ((getHeight() / 2) - ((textPaint.descent() + textPaint.ascent()) / 2));

//        baseY = (int) ((canvas.getHeight() / 2) + ((Math.abs(textPaint.ascent()-Math.abs(textPaint.descent()))) / 2));

        canvas.drawText(TEXT, baseX, baseY, textPaint);

    }

}
