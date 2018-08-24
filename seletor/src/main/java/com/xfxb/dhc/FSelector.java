package com.xfxb.dhc;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
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

        private DrawableWrapper gradientDrawableWrapper;
        private Drawable mStateDraw;
        private int mBgColor;
        private int mTopLeftCA;
        private int mTopRightCA;
        private int mBtLeftCA;
        private int mBtRightCA;
        private int mStokeWidth;
        private int mStrokeClr;
        private int mStrokeDashWidth;
        private int mStrokeDashGap;
        private int mCircleAngle;
        private List<State> mState = new ArrayList<>();

        public DrawableBuilder(State state) {
            mState.add(state);
        }

        public DrawableBuilder() {

        }

        /**
         * 设置  drawable
         * @param drawable  自定义drawable
         * @return
         */
        public DrawableBuilder stateDraw(Drawable drawable) {
            this.mStateDraw = drawable;
            return this;
        }

        /**
         * 当前 drawable 的显示状态
         * @param state
         * @return
         */
            public DrawableBuilder addState(State state) {
            this.mState.add(state);
            return this;
        }

        /**
         * 背景颜色
         * @param bgColor
         * @return
         */
        public DrawableBuilder bgColor(int bgColor) {
            this.mBgColor = bgColor;
            return this;
        }

        /**
         * 左上角弧度
         * @param topLeftCA 值
         * @return
         */
        public DrawableBuilder topLeftCA(int topLeftCA) {
            this.mTopLeftCA = topLeftCA;
            return this;
        }

        /**
         * 右上角弧度
         * @param topRigthCA 值
         * @return
         */
        public DrawableBuilder topRigthCA(int topRigthCA) {
            this.mTopRightCA = topRigthCA;
            return this;
        }

        /**
             * 左下角度
         * @param btLeftCA 值
         * @return
         */
        public DrawableBuilder btLeftCA(int btLeftCA) {
            this.mBtLeftCA = btLeftCA;
            return this;
        }

        /**
         * 右下角
         * @param btRightCA 值
         * @return
         */
        public DrawableBuilder btRightCA(int btRightCA) {
            this.mBtRightCA = btRightCA;
            return this;
        }

        /**
         * 边框线的宽度
         * @param stokeWidth  宽度
         * @return
         */
        public DrawableBuilder stokeWidth(int stokeWidth) {
            this.mStokeWidth = stokeWidth;
            return this;
        }

        /**
         * 边框线的颜色
         * @param strokeClr  颜色
         * @return
         */
        public DrawableBuilder strokeClr(int strokeClr) {
            this.mStrokeClr = strokeClr;
            return this;
        }

        /**圆角弧度
         *
         * @param circleAngle  弧度
         * @return
         */
        public DrawableBuilder circleAngle(int circleAngle) {
            this.mCircleAngle = circleAngle;
            return this;
        }

        /**
         * 虚线中实线的长度
         * @param strokeDashWidth
         * @return
         */
        public DrawableBuilder strokeDashWidth(int strokeDashWidth) {
            this.mStrokeDashWidth = strokeDashWidth;
            return this;
        }

        /**
         * 虚线间隔的长度
         * @param strokeDashGap
         * @return
         */
        public DrawableBuilder strokeDashGap(int strokeDashGap) {
            this.mStrokeDashGap = strokeDashGap;
            return this;
        }


        public FSelector create() {
            //把边框值设置成dp对应的px

            float[] circleAngleArr = {mTopLeftCA != 0 ? mTopLeftCA : mCircleAngle,
                    mTopLeftCA != 0 ? mTopLeftCA : mCircleAngle,
                    mTopRightCA != 0 ? mTopRightCA : mCircleAngle,
                    mTopRightCA != 0 ? mTopRightCA : mCircleAngle,
                    mBtLeftCA != 0 ? mBtLeftCA : mCircleAngle,
                    mBtLeftCA != 0 ? mBtLeftCA : mCircleAngle,
                    mBtRightCA != 0 ? mBtRightCA : mCircleAngle,
                    mBtRightCA != 0 ? mBtRightCA : mCircleAngle};
            if (mStateDraw == null) {
                mStateDraw = new GradientDrawable();
            }
            if (mStateDraw instanceof GradientDrawable){
                ((GradientDrawable) mStateDraw).setCornerRadii(circleAngleArr);//圆角
                ((GradientDrawable) mStateDraw).setColor(mBgColor != 0 ?mBgColor : 0); //背景色
                if (mStokeWidth != 0 || mStrokeClr != 0) {
                    (  (GradientDrawable) mStateDraw).setStroke(mStokeWidth, mStrokeClr != 0 ? mStrokeClr : 0,mStrokeDashWidth,mStrokeDashGap);
                }
            }
            //边框宽度，边框颜色
            int[] states = new int[mState.size()];
            for (int i = 0; i < mState.size(); i++) {
                states[i] = mState.get(i).getValue();
            }
            gradientDrawableWrapper = new DrawableWrapper(states, mStateDraw);
            selector.stateDrawableMap.add(states.length == 0 ? selector.stateDrawableMap.size() : 0, gradientDrawableWrapper);
            return selector;
        }


    }


}
