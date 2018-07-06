package com.xfxb.dhc;

import android.graphics.drawable.Drawable;

/**
 * @creator：denghc(desoce)
 * @updateTime：2018/7/5$ 17:27$
 * @description： GradientDrawable 的包装类
 */
public class DrawableWrapper {

    private int[] states;

    private Drawable gradientDrawable;

    public int[] getStates() {
        return states;
    }

    public DrawableWrapper(int[] states, Drawable drawable) {
        this.states = states;
        this.gradientDrawable = drawable;
    }

    public void setStates(int[] states) {
        this.states = states;
    }

    public Drawable getGradientDrawable() {
        return gradientDrawable;
    }

    public void setGradientDrawable(Drawable gradientDrawable) {
        this.gradientDrawable = gradientDrawable;
    }
}
