package com.sonu.app.splash.ui.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * @author Karim Abou Zeid (kabouzeid)
 * @https://github.com/kabouzeid
 */
public class WidthRelativeAspectRatioImageView extends AppCompatImageView {

    private float aspectRatio = 1;

    public WidthRelativeAspectRatioImageView(Context context) {
        super(context);
    }

    public WidthRelativeAspectRatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WidthRelativeAspectRatioImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //noinspection SuspiciousNameCombination
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension(getMeasuredWidth(), (int) (aspectRatio * getMeasuredWidth()));
    }

    public void setAspectRatio(float aspectRatio) {
        this.aspectRatio = aspectRatio;
        requestLayout();
    }
}