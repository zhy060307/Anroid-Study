package zhy.com.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class CornerImageLayout extends FrameLayout {

    private int width;
    private int height;
    private int childWidth;
    private int childHeight;
    private int cornerLocation;
    private boolean cornerVisible;

    public CornerImageLayout(@NonNull Context context) {
        this(context, null);
    }

    public CornerImageLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CornerImageLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CornerImageLayout);
        cornerLocation = typedArray.getInt(R.styleable.CornerImageLayout_cornerLocation, 0);
        if (cornerLocation != 0) {
            cornerVisible = true;
        }
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //测量总控件的宽和高
        //测量总控件的宽和高
        width = getMeasuredWidth();
        height = getMeasuredHeight();
        //测量第二个子控件的宽和高
        childWidth = getChildAt(1).getMeasuredWidth();
        childHeight = getChildAt(1).getMeasuredHeight();

    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        if (getChildCount() != 2) {
            throw new IllegalStateException("you should have two child ,你必须拥有两个子控件");
        }
        View containerView = getChildAt(0);
        View cornerView = getChildAt(1);
        if (!cornerVisible) {
            cornerView.setVisibility(GONE);
            containerView.layout(0, 0, width, height);
            return;
        }
        cornerView.setVisibility(VISIBLE);
        //对控件进行位置布局
        containerView.layout(childWidth / 2, childHeight / 2,
                width - childWidth / 2, height - childHeight / 2);

        switch (cornerLocation) {
            case 1://topLeft
                cornerView.layout(0, 0, childWidth, childHeight);
                break;
            case 2://topRight
                cornerView.layout(width - childWidth, 0, width, childHeight);
                break;
            case 3://bottomRight
                cornerView.layout(width - childWidth, height - childHeight, width, height);
                break;
            case 4://bottomLeft
                cornerView.layout(0, height - childHeight, childWidth, height);
                break;
            default:
                break;
        }
    }


    public void setCornerVisible(boolean cornerVisible) {
        this.cornerVisible = cornerVisible;
        requestLayout();
    }

}
