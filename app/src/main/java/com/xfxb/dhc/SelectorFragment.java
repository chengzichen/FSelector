package com.xfxb.dhc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.xfxb.dhc.drawable.RightDrawable;
import com.xfxb.dhc.drawable.RoundedBitmapDrawable;

import static com.xfxb.dhc.FSelector.State.STATE_PRESSED;


public class SelectorFragment extends Fragment implements View.OnClickListener {


    private int[] nomColor = new int[]{R.color.clr_7f5954, R.color.clr_8a92a1, R.color.clr_ff00d2e0, R.color.clr_8800d2e0};
    private int[] selectColor = new int[]{R.color.clr_FF00FF, R.color.clr_FFFF00, R.color
            .clr_ffff6239, R.color.clr_ff6239};


    private int[] stokeColor = new int[]{R.color.clr_ff6239, R.color.clr_b15725, R.color.clr_ff484b69, R
            .color.clr_2C97DE};


    /**
     * 左上角
     */
    private TextView mTvTl;
    /**
     * 右上角
     */
    private TextView mTvTr;
    /**
     * 左下角
     */
    private TextView mTvBl;
    /**
     * 右下角
     */
    private TextView mTvBr;

    private View rootView;
    /**
     * 背景色\ n改变
     */
    private TextView mTvSelectBg;
    /**
     * 背景色/边框色\n 改变
     */
    private TextView mTvSelectBgStoke;
    /**
     * 背景色/边框色/字体色\n 改变
     */
    private TextView mTvSelectBgStokeText;
    /**
     * 自定义
     */
    private TextView mRvSelectDiy;
    /**
     * 背景色/边框色/字体色\n 改变
     */
    private TextView mTvSelectRoundBgText;
    /**
     * 自定义
     */
    private TextView mTvSelectRoundDiy;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_selector, null);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListener();
    }

    private View findViewById(int id) {
        return rootView.findViewById(id);
    }

    private void initView() {

        mTvTl = (TextView) findViewById(R.id.tv_tl);
        initTl();//左上角
        mTvTr = (TextView) findViewById(R.id.tv_tr);
        initTr();//右上角
        mTvBl = (TextView) findViewById(R.id.tv_bl);
        initBL();
        mTvBr = (TextView) findViewById(R.id.tv_br);
        initBR();


        mTvSelectBg = (TextView) rootView.findViewById(R.id.tv_select_bg);
        initSelectBg();//
        mTvSelectBgStoke = (TextView) rootView.findViewById(R.id.tv_select_bg_stoke);
        initSelectBgStoke();
        mTvSelectBgStokeText = (TextView) rootView.findViewById(R.id.tv_select_bg_stoke_text);
        initSelectBgStokeText();
        mRvSelectDiy = (TextView) rootView.findViewById(R.id.rv_select_diy);
        initSelectDiy();


        mTvSelectRoundBgText = (TextView) rootView.findViewById(R.id.tv_select_round_bg_text);
        initSelectRoundBgText();
        mTvSelectRoundDiy = (TextView) rootView.findViewById(R.id.tv_select_round_diy);
        initSelectRoundDiy();
    }


//------------------------------上下左右圆角  start----------------------------

    /**
     * 左上角
     * <shape xmlns:android="http://schemas.android.com/apk/res/android" >
     * <p>
     * <corners
     * android:topLeftRadius="15dp"
     * />
     * <p>
     * <solid android:color="@color/clr_fb720e" />
     * <p>
     * </shape>
     */
    private void initTl() {
        FSelector.with(mTvTl)
                .addDrawable().topLeftCA(dp2px(15)).bgColor(getColors(nomColor[0]))
                .create()
                .addDrawable(STATE_PRESSED).topLeftCA(dp2px(15)).bgColor(getColors(selectColor[0]))
                .create()
                .bind();
    }


    /**
     * 右上角
     * <shape xmlns:android="http://schemas.android.com/apk/res/android" >
     * <p>
     * <corners
     * android:topRightRadius="15dp"
     * />
     * <p>
     * <solid android:color="@color/clr_fb720e" />
     * <p>
     * </shape>
     */
    private void initTr() {
        FSelector.with(mTvTr)
                .addDrawable().topRightCA(dp2px(15)).bgColor(getColors(nomColor[1]))
                .create()
                .addDrawable(STATE_PRESSED).topRightCA(dp2px(15)).bgColor(getColors(selectColor[1]))
                .create()
                .bind();
    }


    /**
     * 左下角
     * <shape xmlns:android="http://schemas.android.com/apk/res/android" >
     * <p>
     * <corners
     * android:bottomLeftRadius="15dp"
     * />
     * <p>
     * <solid android:color="@color/clr_fb720e" />
     * <p>
     * </shape>
     */
    private void initBL() {
        FSelector.with(mTvBl)
                .addDrawable().btLeftCA(dp2px(15)).bgColor(getColors(nomColor[2]))
                .create()
                .addDrawable(STATE_PRESSED).btLeftCA(dp2px(15)).bgColor(getColors(selectColor[2]))
                .create()
                .bind();
    }

    /**
     * 右下角
     * <shape xmlns:android="http://schemas.android.com/apk/res/android" >
     * <p>
     * <corners
     * android:bottomRightRadius="15dp"
     * />
     * <p>
     * <solid android:color="@color/clr_fb720e" />
     * <p>
     * </shape>
     */
    private void initBR() {
        FSelector.with(mTvBr)
                .addDrawable().btRightCA(dp2px(15)).bgColor(getColors(nomColor[3]))
                .create()
                .addDrawable(STATE_PRESSED).btRightCA(dp2px(15)).bgColor(getColors(selectColor[3]))
                .create()
                .bind();
    }


//------------------------------上下左右圆角  end--------------------------------


//------------------------------四周带圆角  start--------------------------------


    private void initSelectBg() {
        FSelector.with(mTvSelectBg)
                .addDrawable()
                .circleAngle(dp2px(20))
                .bgColor(getColors(nomColor[0]))
                .create()
                .addDrawable(FSelector.State.STATE_PRESSED)
                .circleAngle(dp2px(20))
                .bgColor(getColors(selectColor[0]))
                .create()
                .bind();
    }

    private void initSelectBgStoke() {
        FSelector.with(mTvSelectBgStoke)
                .addDrawable()
                .circleAngle(dp2px(20))
                .bgColor(getColors(nomColor[1]))
                .stokeWidth(dp2px(2))
                .strokeClr(getColors(stokeColor[1]))
                .create()
                .addDrawable(FSelector.State.STATE_PRESSED)
                .circleAngle(dp2px(20))
                .bgColor(getColors(selectColor[1]))
                .stokeWidth(dp2px(2))
                .strokeClr(getColors(stokeColor[2]))
                .create()
                .bind();
    }

    private void initSelectBgStokeText() {
        FSelector.with(mTvSelectBgStokeText)
                .addDrawable()
                .circleAngle(dp2px(20))
                .bgColor(getColors(nomColor[2]))
                .stokeWidth(dp2px(2))
                .strokeClr(getColors(stokeColor[2]))
                .strokeDashWidth(dp2px(10))//虚线
                .strokeDashGap(dp2px(5))//虚线
                .textStateColor(getColors(R.color.clr_ffffff))
                .create()
                .addDrawable(FSelector.State.STATE_PRESSED)
                .circleAngle(dp2px(20))
                .bgColor(getColors(selectColor[2]))
                .stokeWidth(dp2px(2))
                .strokeClr(getColors(stokeColor[3]))
                .strokeDashWidth(dp2px(10))//虚线
                .strokeDashGap(dp2px(5))//虚线
                .textStateColor(getColors(R.color.clr_2196F3))
                .create()
                .bind();
    }

    private void initSelectDiy() {
        RightDrawable selectDrawable = new RightDrawable();
        selectDrawable.setPantWidth(dp2px(1));
        FSelector.with(mRvSelectDiy)
                .addDrawable()
                .circleAngle(dp2px(15))
                .stokeWidth(dp2px(2))
                .strokeClr(getColors(selectColor[2]))
                .strokeDashWidth(dp2px(10))//虚线
                .strokeDashGap(dp2px(5))//虚线
                .textStateColor(getColors(R.color.clr_2196F3))
                .create()
                .addDrawable(FSelector.State.STATE_PRESSED)
                .stateDraw(selectDrawable)
                .circleAngle(dp2px(15))
                .stokeWidth(dp2px(2))
                .strokeClr(getColors(stokeColor[3]))
                .strokeDashWidth(dp2px(10))//虚线
                .strokeDashGap(dp2px(5))//虚线
                .textStateColor(getColors(stokeColor[2]))
                .create()
                .bind();
    }

    //------------------------------四周带圆角  end--------------------------------


    //------------------------------圆形   start--------------------------------


    private void initSelectRoundBgText() {
        FSelector.with(mTvSelectRoundBgText)
                .addDrawable()
                .shapeType(FSelector.OVAL)
                .size(dp2px(80), dp2px(80))
                .useLevel(true)
                .stokeWidth(dp2px(2))
                .strokeClr(getColors(R.color.colorPrimary))
                .bgColor(getColors(R.color.clr_ff00d2e0))
                .strokeDashWidth(dp2px(10))//虚线
                .strokeDashGap(dp2px(5))//虚线
                .textStateColor(getColors(R.color.clr_FFFFFFFF))
                .create()
                .addDrawable(FSelector.State.STATE_PRESSED)
                .shapeType(FSelector.OVAL)
                .size(dp2px(80), dp2px(80))
                .useLevel(true)
                .stokeWidth(dp2px(2))
                .strokeClr(getColors(R.color.clr_ff658598))
                .bgColor(getColors(R.color.clr_ff00d2e0))
                .strokeDashWidth(dp2px(10))//虚线
                .strokeDashGap(dp2px(5))//虚线
                .textStateColor(getColors(R.color.clr_6e6e6e))
                .create()
                .bind();
    }

    private void initSelectRoundDiy() {
        RoundedBitmapDrawable shapeBitmapDrawable = new RoundedBitmapDrawable();
        shapeBitmapDrawable.setBitmap(this.getResources(), R.drawable.ic_drawer_setting);
        FSelector.with(mTvSelectRoundDiy)
                .addDrawable()
                .shapeType(FSelector.OVAL)
                .size(dp2px(80), dp2px(80))
                .useLevel(true)
                .stokeWidth(dp2px(2))
                .strokeClr(getColors(R.color.colorPrimary))
                .strokeDashWidth(dp2px(10))//虚线
                .strokeDashGap(dp2px(5))//虚线
                .create()
                .addDrawable(FSelector.State.STATE_PRESSED)
                .shapeType(FSelector.OVAL)
                .stateDraw(shapeBitmapDrawable)
                .size(dp2px(80), dp2px(80))
                .useLevel(true)
                .stokeWidth(dp2px(2))
                .strokeClr(getColors(R.color.clr_ff658598))
                .strokeDashWidth(dp2px(10))//虚线
                .strokeDashGap(dp2px(5))//虚线
                .create()
                .bind();

    }

//------------------------------圆形  end--------------------------------


//    /***
//     *  圆角背景
//     *
//     <shape xmlns:android="http://schemas.android.com/apk/res/android" >
//
//     <corners
//     android:bottomLeftRadius="15dp"
//     android:bottomRightRadius="15dp"
//     android:topLeftRadius="15dp"
//     android:topRightRadius="15dp" />
//
//     <solid android:color="@color/clr_fb720e" />
//
//     </shape>
//     */
//    private void initOne() {
//        FSelector.with(tvtext1)
//                .addDrawable().circleAngle(dp2px(15)).bgColor(getColors(R.color.clr_fb720e))
//                .create()
//                .bind();
//    }

//    /***
//     *  带边框的圆角背景
//     *
//     <shape xmlns:android="http://schemas.android.com/apk/res/android" >
//
//     <corners
//     android:bottomLeftRadius="15dp"
//     android:bottomRightRadius="15dp"
//     android:topLeftRadius="15dp"
//     android:topRightRadius="15dp" />
//
//     <solid android:color="@color/clr_fb720e" />
//
//     <size
//     android:height="65dp"
//     android:width="180dp" />
//
//     <stroke
//     android:width="2dp"
//     android:color="@color/clr_f0f0f0" />
//
//     </shape>
//     */
//    private void initTwo() {
//        FSelector.with(tvtext2)
//                .addDrawable().circleAngle(dp2px(15)).bgColor(getColors(R.color.clr_fb720e))
//                .strokeClr(Color.BLUE).stokeWidth(dp2px(2))
//                .create()
//                .bind();
//    }
//
//    /**
//     * 圆角选择器
//     * <p>
//     * //圆角1
//     * <shape xmlns:android="http://schemas.android.com/apk/res/android" >
//     * <corners
//     * android:bottomLeftRadius="15dp"
//     * android:bottomRightRadius="15dp"
//     * android:topLeftRadius="15dp"
//     * android:topRightRadius="15dp" />
//     * <solid android:color="@color/clr_fb720e" />
//     * </shape>
//     * <p>
//     * //圆角2
//     * <shape xmlns:android="http://schemas.android.com/apk/res/android" >
//     * <corners
//     * android:bottomLeftRadius="15dp"
//     * android:bottomRightRadius="15dp"
//     * android:topLeftRadius="15dp"
//     * android:topRightRadius="15dp" />
//     * <solid android:color="@color/clr_fb720e" />
//     * <p>
//     * </shape>
//     * <selector xmlns:android="http://schemas.android.com/apk/res/android">
//     * <item android:state_pressed="true" android:drawable="@drawable/shape1" />
//     * <item android:state_pressed="false" android:drawable="@drawable/shape2" />
//     * </selector>
//     */
//    private void initThree() {
//        FSelector.with(tvtext3)
//                .addDrawable(STATE_PRESSED).circleAngle(dp2px(15)).bgColor(getColors(R.color
//                .clr_fb720e))
//                .create()
//                .addDrawable().circleAngle(dp2px(15)).bgColor(getColors(R.color.clr_cdcdcd))
//                .create()
//                .bind();
//
//    }
//
//    /**
//     * 圆角带边框选择器
//     * <p>
//     * //圆角带边框1
//     * <shape xmlns:android="http://schemas.android.com/apk/res/android" >
//     * <corners
//     * android:bottomLeftRadius="15dp"
//     * android:bottomRightRadius="15dp"
//     * android:topLeftRadius="15dp"
//     * android:topRightRadius="15dp" />
//     * <solid android:color="@color/clr_fb720e" />
//     * <size
//     * android:height="65dp"
//     * android:width="180dp" />
//     * <stroke
//     * android:width="2dp"
//     * android:color="@color/clr_f0f0f0" />
//     * </shape>
//     * <p>
//     * //圆角带边框2
//     * <shape xmlns:android="http://schemas.android.com/apk/res/android" >
//     * <corners
//     * android:bottomLeftRadius="15dp"
//     * android:bottomRightRadius="15dp"
//     * android:topLeftRadius="15dp"
//     * android:topRightRadius="15dp" />
//     * <solid android:color="@color/clr_fb720e" />
//     * <size
//     * android:height="65dp"
//     * android:width="180dp" />
//     * <stroke
//     * android:width="2dp"
//     * android:color="@color/clr_f0f0f0" />
//     * </shape>
//     * <p>
//     * //选择器
//     * </shape>
//     * <selector xmlns:android="http://schemas.android.com/apk/res/android">
//     * <item android:state_pressed="true" android:drawable="@drawable/shape1" />
//     * <item android:state_pressed="false" android:drawable="@drawable/shape2" />
//     * </selector>
//     */
//    private void initFour() {
//        FSelector.with(tvtext4)
//                .addDrawable().circleAngle(dp2px(5)).bgColor(getColors(R.color.clr_f6f6f6))
//                .stokeWidth(dp2px(1)).strokeClr(getColors(R.color.clr_cdcdcd)).create()
//                .addDrawable(STATE_PRESSED).circleAngle(dp2px(5)).bgColor(getColors(R.color.clr_fffcf7))
//                .stokeWidth(dp2px(1)).strokeClr(getColors(R.color.clr_fb720e)).create()
//                .bind();
//    }
//
//    /**
//     * <shape xmlns:android="http://schemas.android.com/apk/res/android"
//     * android:shape="rectangle">
//     * <corners android:radius="20dip"/>
//     * <solid android:color="#00ff00"/>
//     * <stroke
//     * android:width="5dip"
//     * android:color="#FF4081"
//     * android:dashGap="5dip"
//     * android:dashWidth="10dip"/>
//     * </shape>
//     */
//    private void initFive() {
//        FSelector.with(tvtext5)
//                .addDrawable().circleAngle(dp2px(5)).bgColor(getColors(R.color.clr_f6f6f6))
//                .stokeWidth(dp2px(1)).strokeClr(getColors(R.color.clr_cdcdcd))
//                .strokeDashWidth(dp2px(10))
//                .strokeDashGap(dp2px(5))
//                .create()
//                .addDrawable(STATE_PRESSED).circleAngle(dp2px(5)).bgColor(getColors(R.color.clr_fffcf7))
//                .stokeWidth(dp2px(1))
//                .strokeClr(getColors(R.color.clr_fb720e))
//                .strokeDashWidth(dp2px(10))
//                .strokeDashGap(dp2px(5))
//                .create()
//                .bind();
//    }
//
//
//    //圆角自定义背景选择器
//    private void initSix() {
//        RightDrawable selectDrawable = new RightDrawable();
//        selectDrawable.setPantWidth(dp2px(1));
//        FSelector.with(tvtext6)
//                .addDrawable().circleAngle(dp2px(5)).bgColor(getColors(R.color.clr_f6f6f6))
//                .strokeDashWidth(dp2px(10))
//                .strokeDashGap(dp2px(5))
//                .stokeWidth(dp2px(3)).strokeClr(getColors(R.color.clr_cdcdcd)).create()
//                .addDrawable(STATE_PRESSED).circleAngle(dp2px(5)).stateDraw(selectDrawable)
//                .stokeWidth(dp2px(3)).strokeClr(Color.RED).create()
//                .bind();
//    }
//
//    //圆角自定义背景选择器
//    private void initSeven() {
//        RoundedBitmapDrawable shapeBitmapDrawable = new RoundedBitmapDrawable();
//        shapeBitmapDrawable.setBitmap(this.getResources(), R.drawable.ic_drawer_setting);
//        FSelector.with(tvtext7)
//                .addDrawable().circleAngle(dp2px(5)).bgColor(getColors(R.color.clr_f6f6f6))
//                .stokeWidth(dp2px(5)).strokeClr(getColors(R.color.clr_cdcdcd)).create()
//                .addDrawable(STATE_PRESSED).circleAngle(dp2px(5))
//                .strokeDashWidth(dp2px(10))
//                .strokeDashGap(dp2px(5))
//                .stateDraw(shapeBitmapDrawable)
//                .stokeWidth(dp2px(5)).strokeClr(Color.RED).create()
//                .bind();
//    }

    private void initListener() {
        mTvTl.setOnClickListener(this);
        mTvTr.setOnClickListener(this);
        mTvBl.setOnClickListener(this);
        mTvBr.setOnClickListener(this);
        mTvSelectBg.setOnClickListener(this);
        mTvSelectBgStoke.setOnClickListener(this);
        mTvSelectBgStokeText.setOnClickListener(this);
        mRvSelectDiy.setOnClickListener(this);
        mTvSelectRoundBgText.setOnClickListener(this);
        mTvSelectRoundDiy.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_round_stoke_Dash_select:
                Toast.makeText(getActivity(), "好痛", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_tl:
                Toast.makeText(getActivity(), "好痛", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_tr:
                Toast.makeText(getActivity(), "好痛", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_bl:
                Toast.makeText(getActivity(), "好痛", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_br:
                Toast.makeText(getActivity(), "好痛", Toast.LENGTH_SHORT).show();
                break;
//            case R.id.tv_text6:
//                Toast.makeText(getActivity(), "好痛", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.tv_text7:
//                Toast.makeText(getActivity(), "好痛", Toast.LENGTH_SHORT).show();
//                break;
            default:
                Toast.makeText(getActivity(), "好痛", Toast.LENGTH_SHORT).show();
                break;

        }

    }


    public int getColors(int color) {
        return ContextCompat.getColor(getActivity(), color);
    }

    private int dp2px(double dpValue) {
        float density = this.getResources().getDisplayMetrics().density;
        return (int) (dpValue * (double) density + 0.5D);
    }


}
