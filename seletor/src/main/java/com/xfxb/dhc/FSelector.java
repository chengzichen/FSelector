package com.xfxb.dhc;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建者     邓浩宸
 * 创建时间   2017/10/27 13:44
 * 描述	     自定一个的Selector和Shape Drawable 工具类
 */

public class FSelector {
    private Context mContext;
    private List<DrawableWrapper> stateDrawableMap = new ArrayList<>();
    private View mView;
    private static DrawableBuilder builder;
    private static FSelector selector;

    public FSelector(View view) {
        mView = view;
        mContext = view.getContext();
    }

    public FSelector(Context context) {
        mContext = context;
    }


    public static FSelector with(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null View");
        }
        selector = new FSelector(context);
        return selector;
    }


    public DrawableBuilder addDrawable(State state) {
        builder = new DrawableBuilder(state);
        return builder;
    }

    public DrawableBuilder addDrawable() {
        builder = new DrawableBuilder();
        return builder;
    }

    public static FSelector with(View view) {
        if (view == null) {
            throw new IllegalArgumentException("You cannot start a load on a null View");
        }
        selector = new FSelector(view);
        return selector;
    }


    public enum State {
        WINDOW_FOCUSED(android.R.attr.state_window_focused),//true，当此activity获得焦点在最前面时显示该图片；false，当没在最前面时显示该图片。
        STATE_ENABLED(android.R.attr.state_enabled),//当该组件能使用时显示该图片；false，当该组件不能使用时显示该图片
        STATE_CHECKABLE(android.R.attr.state_checked),//当CheckBox能使用时显示该图片；false，当CheckBox不能使用时显示该图片
        STATE_CHECKED(android.R.attr.state_checked),//true，当CheckBox选中时显示该图片；false，当CheckBox为未选中时显示该图片
        STATE_SELECTED(android.R.attr.state_selected),//true 选择时显示的图片；false 为选择时的图片（例如用在Tab)
        STATE_PRESSED(android.R.attr.state_pressed),//true，当被点击时显示该图片；false没被按下时显示图片 ==click
        STATE_FOCUSED(android.R.attr.state_focused),//获取焦点
        STATE_ACTIVE(android.R.attr.state_active),
        STATE_DRAG_HOVERED(android.R.attr.state_drag_hovered),//true 能够drop 或者 drag 鼠标指针移动到该位置图片
        STATE_DRAG_CAN_ACCEPT(android.R.attr.state_drag_can_accept),//true 能够dorp 或者 drag 时图片
        STATE_ACTIVATED(android.R.attr.state_activated);
        private int mState;

        State(int state) {
            mState = state;
        }

        public int getValue() {
            return mState;
        }
    }

    public Drawable build() {
        Drawable drawable = null;
        if (stateDrawableMap.size() == 0) {
            throw new IllegalArgumentException("You cannot start a load on a null Drawable");
        } else if (stateDrawableMap.size() == 1) {
            drawable = stateDrawableMap.get(0).getGradientDrawable();
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            for (DrawableWrapper gradientDrawableWraper : stateDrawableMap) {
                stateListDrawable.addState(gradientDrawableWraper.getStates(), gradientDrawableWraper.getGradientDrawable());
            }
            drawable = stateListDrawable;
        }
        return drawable;
    }

    public void bind() {
        if (mView == null) {
            throw new IllegalArgumentException("You cannot start a with on a null View");
        }
        Drawable drawable = build();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mView.setBackground(drawable);
        } else {
            mView.setBackgroundDrawable(drawable);
        }
    }

    public class DrawableBuilder {

        private DrawableWrapper gradientDrawableWraper;
        private Drawable mStateDraw;
        private int mBgColor;
        private int mTopLeftCA;
        private int mTopRigthCA;
        private int mBtLeftCA;
        private int mBtRightCA;
        private int mStorkeWidth;
        private int mStrokeClr;

        private int mCircleAngle;
        private List<State> mState = new ArrayList<>();

        public DrawableBuilder(State state) {
            mState.add(state);
        }

        public DrawableBuilder() {

        }

        public DrawableBuilder stateDraw(Drawable drawable) {
            this.mStateDraw = drawable;
            return this;
        }

        public DrawableBuilder addState(State state) {
            this.mState.add(state);
            return this;
        }

        public DrawableBuilder bgColor(int bgColor) {
            this.mBgColor = bgColor;
            return this;
        }

        public DrawableBuilder topLeftCA(int topLeftCA) {
            this.mTopLeftCA = topLeftCA;
            return this;
        }

        public DrawableBuilder topRigthCA(int topRigthCA) {
            this.mTopRigthCA = topRigthCA;
            return this;
        }

        public DrawableBuilder btLeftCA(int btLeftCA) {
            this.mBtLeftCA = btLeftCA;
            return this;
        }

        public DrawableBuilder btRightCA(int btRightCA) {
            this.mBtRightCA = btRightCA;
            return this;
        }

        public DrawableBuilder storkeWidth(int storkeWidth) {
            this.mStorkeWidth = storkeWidth;
            return this;
        }

        public DrawableBuilder strokeClr(int strokeClr) {
            this.mStrokeClr = strokeClr;
            return this;
        }

        public DrawableBuilder circleAngle(int circleAngle) {
            this.mCircleAngle = circleAngle;
            return this;
        }

        public FSelector create() {
            //把边框值设置成dp对应的px

            float[] circleAngleArr = {mTopLeftCA != 0 ? mTopLeftCA : mCircleAngle,
                    mTopLeftCA != 0 ? mTopLeftCA : mCircleAngle,
                    mTopRigthCA != 0 ? mTopRigthCA : mCircleAngle,
                    mTopRigthCA != 0 ? mTopRigthCA : mCircleAngle,
                    mBtLeftCA != 0 ? mBtLeftCA : mCircleAngle,
                    mBtLeftCA != 0 ? mBtLeftCA : mCircleAngle,
                    mBtRightCA != 0 ? mBtRightCA : mCircleAngle,
                    mBtRightCA != 0 ? mBtRightCA : mCircleAngle};
            //把圆角设置成dp对应的px
            for (int i = 0; i < circleAngleArr.length; i++) {
                circleAngleArr[i] = dp2px(circleAngleArr[i]);
            }
            if (mStateDraw == null) {
                mStateDraw = new GradientDrawable();
            }
            if (mStateDraw instanceof GradientDrawable){
                ((GradientDrawable) mStateDraw).setCornerRadii(circleAngleArr);//圆角
                ((GradientDrawable) mStateDraw).setColor(mBgColor != 0 ? getColors(mBgColor) : 0); //背景色
                if (mStorkeWidth != 0 || mStrokeClr != 0) {
                    (  (GradientDrawable) mStateDraw).setStroke(dp2px(mStorkeWidth), mStrokeClr != 0 ? getColors(mStrokeClr) : 0);
                }
            }else{
                mStateDraw= BitmapUtil. runodDrawable(mStateDraw,mCircleAngle,mStorkeWidth);
            }
            //边框宽度，边框颜色
            int[] states = new int[mState.size()];
            for (int i = 0; i < mState.size(); i++) {
                states[i] = mState.get(i).getValue();
            }
            gradientDrawableWraper = new DrawableWrapper(states, mStateDraw);
            selector.stateDrawableMap.add(states.length == 0 ? selector.stateDrawableMap.size() : 0,gradientDrawableWraper);
            return selector;
        }


    }

    private int dp2px(double dpValue) {
        float density = mContext.getResources().getDisplayMetrics().density;
        return (int) (dpValue * (double) density + 0.5D);
    }


    private int getColors(int color) {
        if (Build.VERSION.SDK_INT >= 23) {
            return mContext.getColor(color);
        } else {
            return mContext.getResources().getColor(color);
        }
    }


}
