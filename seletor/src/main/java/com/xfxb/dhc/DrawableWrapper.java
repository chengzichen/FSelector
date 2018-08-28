package com.xfxb.dhc;

import android.graphics.drawable.Drawable;

/**
 * @creator：denghc(desoce)
 * @updateTime：2018/7/5$ 17:27$
 * @description： GradientDrawable 的包装类
 */
public class DrawableWrapper {

    private int[] mStates;
    private int  mTextColor;
    private Drawable gradientDrawable;

    public int[] getStates() {
        return mStates;
    }

    public DrawableWrapper(int[] states, Drawable drawable) {
        this.mStates = states;
        this.gradientDrawable = drawable;
    }

    public int getTextColor() {
        return mTextColor;
    }

    public void setTextColor(int mTextColor) {
        this.mTextColor = mTextColor;
    }

    public void setStates(int[] states) {
        this.mStates = states;
    }

    public Drawable getGradientDrawable() {
        return gradientDrawable;
    }

    public void setGradientDrawable(Drawable gradientDrawable) {
        this.gradientDrawable = gradientDrawable;
    }
}
