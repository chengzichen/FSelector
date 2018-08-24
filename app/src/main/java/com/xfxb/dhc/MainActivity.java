package com.xfxb.dhc;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.xfxb.dhc.drawable.RightDrawable;
import com.xfxb.dhc.drawable.RoundedBitmapDrawable;

import static com.xfxb.dhc.FSelector.State.STATE_PRESSED;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    View tvtext1;
    TextView tvtext2;
    TextView tvtext3;
    TextView tvtext4;
    TextView tvtext5;
    TextView tvtext6;
    TextView tvtext7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }


    private void initView() {
        tvtext1 = findViewById(R.id.tv_text1);
        tvtext2 = (TextView) findViewById(R.id.tv_text2);
        tvtext3 = (TextView) findViewById(R.id.tv_text3);
        tvtext4 = (TextView) findViewById(R.id.tv_text4);
        tvtext5 = (TextView) findViewById(R.id.tv_text5);
        tvtext6 = (TextView) findViewById(R.id.tv_text6);
        tvtext7 = (TextView) findViewById(R.id.tv_text7);
        initOne();// 圆角背景
        initTwo();//带边框的圆角背景
        initThree();//圆角选择器
        initFour();//圆角带边框选择器
        initFive();//分割线圆角选择器
        initSix();//圆角自定义背景选择器
        initSeven();//自定义任意背景裁剪圆角选择器
    }


    /***
     *  圆角背景
     *
     <shape xmlns:android="http://schemas.android.com/apk/res/android" >

     <corners
     android:bottomLeftRadius="15dp"
     android:bottomRightRadius="15dp"
     android:topLeftRadius="15dp"
     android:topRightRadius="15dp" />

     <solid android:color="@color/clr_fb720e" />

     </shape>
     */
    private void initOne() {
        FSelector.with(tvtext1)
                .addDrawable().circleAngle(dp2px(15)).bgColor(getColors(R.color.clr_fb720e))
                .create()
                .bind();
    }

    /***
     *  带边框的圆角背景
     *
         <shape xmlns:android="http://schemas.android.com/apk/res/android" >

         <corners
         android:bottomLeftRadius="15dp"
         android:bottomRightRadius="15dp"
         android:topLeftRadius="15dp"
         android:topRightRadius="15dp" />

         <solid android:color="@color/clr_fb720e" />

         <size
         android:height="65dp"
         android:width="180dp" />

         <stroke
         android:width="2dp"
         android:color="@color/clr_f0f0f0" />

         </shape>
     */
    private void initTwo() {
        FSelector.with(tvtext2)
                .addDrawable().circleAngle(dp2px(15)).bgColor(getColors(R.color.clr_fb720e))
                .strokeClr(Color.BLUE).stokeWidth(dp2px(2))
                .create()
                .bind();
    }

    /**
     * 圆角选择器

         //圆角1
         <shape xmlns:android="http://schemas.android.com/apk/res/android" >
         <corners
         android:bottomLeftRadius="15dp"
         android:bottomRightRadius="15dp"
         android:topLeftRadius="15dp"
         android:topRightRadius="15dp" />
         <solid android:color="@color/clr_fb720e" />
         </shape>

         //圆角2
         <shape xmlns:android="http://schemas.android.com/apk/res/android" >
         <corners
         android:bottomLeftRadius="15dp"
         android:bottomRightRadius="15dp"
         android:topLeftRadius="15dp"
         android:topRightRadius="15dp" />
         <solid android:color="@color/clr_fb720e" />

         </shape>
          <selector xmlns:android="http://schemas.android.com/apk/res/android">
         <item android:state_pressed="true" android:drawable="@drawable/shape1" />
         <item android:state_pressed="false" android:drawable="@drawable/shape2" />
         </selector>
     *
     */
    private void initThree() {
        FSelector.with(tvtext3)
                .addDrawable(STATE_PRESSED).circleAngle(dp2px(15)).bgColor(getColors(R.color
                .clr_fb720e))
                .create()
                .addDrawable().circleAngle(dp2px(15)).bgColor(getColors(R.color.clr_cdcdcd))
                .create()
                .bind();

    }

    /**
     * 圆角带边框选择器

     //圆角带边框1
     <shape xmlns:android="http://schemas.android.com/apk/res/android" >
     <corners
     android:bottomLeftRadius="15dp"
     android:bottomRightRadius="15dp"
     android:topLeftRadius="15dp"
     android:topRightRadius="15dp" />
     <solid android:color="@color/clr_fb720e" />
     <size
     android:height="65dp"
     android:width="180dp" />
     <stroke
     android:width="2dp"
     android:color="@color/clr_f0f0f0" />
     </shape>

     //圆角带边框2
     <shape xmlns:android="http://schemas.android.com/apk/res/android" >
     <corners
     android:bottomLeftRadius="15dp"
     android:bottomRightRadius="15dp"
     android:topLeftRadius="15dp"
     android:topRightRadius="15dp" />
     <solid android:color="@color/clr_fb720e" />
     <size
     android:height="65dp"
     android:width="180dp" />
     <stroke
     android:width="2dp"
     android:color="@color/clr_f0f0f0" />
     </shape>

    //选择器
     </shape>
     <selector xmlns:android="http://schemas.android.com/apk/res/android">
     <item android:state_pressed="true" android:drawable="@drawable/shape1" />
     <item android:state_pressed="false" android:drawable="@drawable/shape2" />
     </selector>
     *
     */
    private void initFour() {
        FSelector.with(tvtext4)
                .addDrawable().circleAngle(dp2px(5)).bgColor(getColors(R.color.clr_f6f6f6))
                .stokeWidth(dp2px(1)).strokeClr(getColors(R.color.clr_cdcdcd)).create()
                .addDrawable(STATE_PRESSED).circleAngle(dp2px(5)).bgColor(getColors(R.color.clr_fffcf7))
                .stokeWidth(dp2px(1)).strokeClr(getColors(R.color.clr_fb720e)).create()
                .bind();
    }
/**
 <shape xmlns:android="http://schemas.android.com/apk/res/android"
 android:shape="rectangle">
 <corners android:radius="20dip"/>
 <solid android:color="#00ff00"/>
 <stroke
 android:width="5dip"
 android:color="#FF4081"
 android:dashGap="5dip"
 android:dashWidth="10dip"/>
 </shape>
 */
    private void initFive() {
        FSelector.with(tvtext5)
                .addDrawable().circleAngle(dp2px(5)).bgColor(getColors(R.color.clr_f6f6f6))
                .stokeWidth(dp2px(1)).strokeClr(getColors(R.color.clr_cdcdcd))
                .strokeDashWidth(dp2px(10))
                .strokeDashGap(dp2px(5))
                .create()
                .addDrawable(STATE_PRESSED).circleAngle(dp2px(5)).bgColor(getColors(R.color.clr_fffcf7))
                .stokeWidth(dp2px(1))
                .strokeClr(getColors(R.color.clr_fb720e))
                .strokeDashWidth(dp2px(10))
                .strokeDashGap(dp2px(5))
                .create()
                .bind();
    }


    //圆角自定义背景选择器
    private void initSix() {
        RightDrawable selectDrawable = new RightDrawable();
        selectDrawable.setmPantWidth(dp2px(1));
        FSelector.with(tvtext6)
                .addDrawable().circleAngle(dp2px(5)).bgColor(getColors(R.color.clr_f6f6f6))
                .strokeDashWidth(dp2px(10))
                .strokeDashGap(dp2px(5))
                .stokeWidth(dp2px(3)).strokeClr(getColors(R.color.clr_cdcdcd)).create()
                .addDrawable(STATE_PRESSED).circleAngle(dp2px(5)).stateDraw(selectDrawable)
                .stokeWidth(dp2px(3)).strokeClr(Color.RED).create()
                .bind();
    }

    //圆角自定义背景选择器
    private void initSeven() {
        RoundedBitmapDrawable shapeBitmapDrawable=    new RoundedBitmapDrawable();
        shapeBitmapDrawable.setBitmap(this.getResources(),R.drawable.ic_drawer_setting);
        FSelector.with(tvtext7)
                .addDrawable().circleAngle(dp2px(5)).bgColor(getColors(R.color.clr_f6f6f6))
                .stokeWidth(dp2px(5)).strokeClr(getColors(R.color.clr_cdcdcd)).create()
                .addDrawable(STATE_PRESSED).circleAngle(dp2px(5))
                .strokeDashWidth(dp2px(10))
                .strokeDashGap(dp2px(5))
                .stateDraw(shapeBitmapDrawable)
                .stokeWidth(dp2px(5)).strokeClr(Color.RED).create()
                .bind();
    }

    private void initListener() {
        tvtext1.setOnClickListener(this);
        tvtext2.setOnClickListener(this);
        tvtext3.setOnClickListener(this);
        tvtext4.setOnClickListener(this);
        tvtext5.setOnClickListener(this);
        tvtext6.setOnClickListener(this);
        tvtext7.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_text1:
                Toast.makeText(this,"好痛",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_text2:
                Toast.makeText(this,"好痛",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_text3:
                Toast.makeText(this,"好痛",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_text4:
                Toast.makeText(this,"好痛",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_text5:
                Toast.makeText(this,"好痛",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_text6:
                Toast.makeText(this,"好痛",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_text7:
                Toast.makeText(this,"好痛",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

    }


    public  int getColors(int color) {
        return ContextCompat.getColor(this, color);
    }

    private int dp2px(double dpValue) {
        float density = this.getResources().getDisplayMetrics().density;
        return (int) (dpValue * (double) density + 0.5D);
    }

}
