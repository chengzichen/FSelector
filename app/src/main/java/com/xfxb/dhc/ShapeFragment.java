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

import com.xfxb.dhc.drawable.RightDrawable;
import com.xfxb.dhc.drawable.RoundedBitmapDrawable;


public class ShapeFragment extends Fragment implements View.OnClickListener {


    private int[] nomColor = new int[]{R.color.clr_7f5954, R.color.clr_8a92a1, R.color.clr_ff00d2e0, R.color.clr_8800d2e0};


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
    /**
     * 左半圆
     */
    private TextView mTvL;
    /**
     * 右半圆
     */
    private TextView mTvR;
    /**
     * 圆形
     */
    private TextView mTvRound;
    /**
     * 圆形带边框
     */
    private TextView mTvRoundStoke;
    /**
     * 圆形虚线边框
     */
    private TextView mTvRoundStokeDash;
    /**
     * 圆形选择器
     */
    private TextView mTvRoundStokeDashSelect;
    /**
     * 四周圆角
     */
    private TextView mTvAllAc;
    /**
     * 四周圆角带边框
     */
    private TextView mRvAllAcStoke;


    /**
     * 四周圆角带边框
     */
    private TextView mRvAllDiy;
    /**
     * 四周圆角
     */
    private TextView mTvAllStokeDash;

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_shape, null);
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
//        tvtext1 = findViewById(R.id.tv_text1);
//        tvtext2 = (TextView) findViewById(R.id.tv_text2);
//        tvtext3 = (TextView) findViewById(R.id.tv_text3);
//        tvtext4 = (TextView) findViewById(R.id.tv_text4);
//        tvtext5 = (TextView) findViewById(R.id.tv_text5);
//        tvtext6 = (TextView) findViewById(R.id.tv_text6);
//        tvtext7 = (TextView) findViewById(R.id.tv_text7);
////        initOne();// 圆角背景
//        initTwo();//带边框的圆角背景
//        initThree();//圆角选择器
//        initFour();//圆角带边框选择器
//        initFive();//分割线圆角选择器
//        initSix();//圆角自定义背景选择器
//        initSeven();//自定义任意背景裁剪圆角选择器
        mTvTl = (TextView) findViewById(R.id.tv_tl);
        initTl();//左上角
        mTvTr = (TextView) findViewById(R.id.tv_tr);
        initTr();//右上角
        mTvBl = (TextView) findViewById(R.id.tv_bl);
        initBL();
        mTvBr = (TextView) findViewById(R.id.tv_br);
        initBR();

        mTvL = (TextView) findViewById(R.id.tv_l);
        initLeft();//左边圆
        mTvR = (TextView) findViewById(R.id.tv_r);
        initRight();//右边圆


        mTvRound = (TextView) findViewById(R.id.tv_round);
        initRound();
        mTvRoundStoke = (TextView) findViewById(R.id.tv_round_stoke);
        initRoundStoke();
        mTvRoundStokeDash = (TextView) findViewById(R.id.tv_round_stoke_Dash);
        initRoundStokeDash();
        mTvRoundStokeDashSelect = (TextView) findViewById(R.id.tv_round_stoke_Dash_select);
        initRoundStokeDashSelect();

        mTvAllAc = (TextView) findViewById(R.id.tv_all_ac);
        initAllAc();
        mRvAllAcStoke = (TextView) findViewById(R.id.rv_all_ac_stoke);
        initAllAcStoke();
        mTvRoundStokeDash.setOnClickListener(this);
        mRvAllDiy = (TextView) findViewById(R.id.rv_all_diy);
        initAllDiy();
        mTvAllStokeDash = (TextView) findViewById(R.id.tv_all_stoke_Dash);
        initAllStokeDash();
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
                .bind();
    }


//------------------------------上下左右圆角  end--------------------------------


//------------------------------左右圆角  start--------------------------------

    /***
     *  圆角背景
     *
     <shape xmlns:android="http://schemas.android.com/apk/res/android" >

     <corners
     android:bottomLeftRadius="15dp"
     android:topLeftRadius="15dp"
     />

     <solid android:color="@color/clr_fb720e" />

     </shape>
     */
    private void initLeft() {

        FSelector.with(mTvL)
                .addDrawable().btLeftCA(dp2px(15)).topLeftCA(dp2px(15))
                .bgColor(getColors(R.color.clr_00d2e0))
                .create()
                .bind();
    }

    /***
     *  圆角背景
     *
     <shape xmlns:android="http://schemas.android.com/apk/res/android" >

     <corners
     android:bottomRightRadius="15dp"
     android:topRightRadius="15dp" />

     <solid android:color="@color/clr_fb720e" />

     </shape>
     */
    private void initRight() {
        FSelector.with(mTvR)
                .addDrawable().btRightCA(dp2px(15)).topRightCA(dp2px(15))
                .bgColor(getColors(R.color.clr_8800d2e0))
                .create()
                .bind();
    }


//------------------------------左右圆角  end--------------------------------


//------------------------------四周带圆角  start--------------------------------


    private void initAllAc() {
        FSelector.with(mTvAllAc)
                .addDrawable()
                .circleAngle(dp2px(20))
                .bgColor(getColors(nomColor[0]))
                .create()
                .bind();
    }

    private void initAllAcStoke() {
        FSelector.with(mRvAllAcStoke)
                .addDrawable()
                .circleAngle(dp2px(20))
                .bgColor(getColors(nomColor[1]))
                .stokeWidth(dp2px(2))
                .strokeClr(getColors(stokeColor[1]))
                .create()
                .bind();
    }

    private void initAllStokeDash() {
        FSelector.with(mTvAllStokeDash)
                .addDrawable()
                .circleAngle(dp2px(20))
                .bgColor(getColors(nomColor[2]))
                .stokeWidth(dp2px(2))
                .strokeClr(getColors(stokeColor[2]))
                .strokeDashWidth(dp2px(10))//虚线
                .strokeDashGap(dp2px(5))//虚线
                .create()
                .bind();
    }

    private void initAllDiy() {
        RightDrawable selectDrawable = new RightDrawable();
        selectDrawable.setPantWidth(dp2px(1));
        FSelector.with(mRvAllDiy)
                .addDrawable()
                .stateDraw(selectDrawable)
                .circleAngle(dp2px(15))
                .stokeWidth(dp2px(2))
                .strokeClr(getColors(stokeColor[3]))
                .strokeDashWidth(dp2px(10))//虚线
                .strokeDashGap(dp2px(5))//虚线
                .create()
                .bind();
    }

    //------------------------------四周带圆角  end--------------------------------


    //------------------------------圆形   start--------------------------------

    private void initRound() {
        FSelector.with(mTvRound)
                .addDrawable()
                .shapeType(FSelector.OVAL)
                .size(dp2px(80), dp2px(80))
                .useLevel(true)
                .bgColor(getColors(R.color.clr_8a92a1))
                .create()
                .bind();
    }

    private void initRoundStoke() {
        mTvRoundStoke.setTextColor(getColors(R.color.clr_66000000));
        FSelector.with(mTvRoundStoke)
                .addDrawable()
                .shapeType(FSelector.OVAL)
                .size(dp2px(80), dp2px(80))
                .useLevel(true)
                .stokeWidth(dp2px(2))
                .strokeClr(getColors(R.color.clr_ffff6239))
                .bgColor(getColors(R.color.clr_f5f5f7))
                .create()
                .bind();
    }

    private void initRoundStokeDash() {
        FSelector.with(mTvRoundStokeDash)
                .addDrawable()
                .shapeType(FSelector.OVAL)
                .size(dp2px(80), dp2px(80))
                .useLevel(true)
                .stokeWidth(dp2px(2))
                .strokeClr(getColors(R.color.clr_ff658598))
                .bgColor(getColors(R.color.clr_ff00d2e0))
                .strokeDashWidth(dp2px(10))//虚线
                .strokeDashGap(dp2px(5))//虚线
                .create()
                .bind();
    }

    private void initRoundStokeDashSelect() {
        RoundedBitmapDrawable shapeBitmapDrawable = new RoundedBitmapDrawable();
        shapeBitmapDrawable.setBitmap(this.getResources(), R.drawable.ic_drawer_setting);
        FSelector.with(mTvRoundStokeDashSelect)
                .addDrawable()
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
        mTvRoundStokeDashSelect.setOnClickListener(this);
//        tvtext2.setOnClickListener(this);
//        tvtext3.setOnClickListener(this);
//        tvtext4.setOnClickListener(this);
//        tvtext5.setOnClickListener(this);
//        tvtext6.setOnClickListener(this);
//        tvtext7.setOnClickListener(this);
    }
//
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.tv_round_stoke_Dash_select:
//                Toast.makeText(this, "好痛", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.tv_text2:
//                Toast.makeText(this, "好痛", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.tv_text3:
//                Toast.makeText(this, "好痛", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.tv_text4:
//                Toast.makeText(this, "好痛", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.tv_text5:
//                Toast.makeText(this, "好痛", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.tv_text6:
//                Toast.makeText(this, "好痛", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.tv_text7:
//                Toast.makeText(this, "好痛", Toast.LENGTH_SHORT).show();
//                break;
//            default:
//                break;
//            case R.id.tv_round_stoke_Dash:
//                break;
//        }
//
//    }


    public int getColors(int color) {
        return ContextCompat.getColor(getActivity(), color);
    }

    private int dp2px(double dpValue) {
        float density = this.getResources().getDisplayMetrics().density;
        return (int) (dpValue * (double) density + 0.5D);
    }

    @Override
    public void onClick(View v) {

    }
}
