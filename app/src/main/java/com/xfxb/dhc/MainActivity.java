package com.xfxb.dhc;

import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.xfxb.dhc.BitmapUtil.CORNER_ALL;
import static com.xfxb.dhc.BitmapUtil.drawableToBitmap;
import static com.xfxb.dhc.FSelector.State.STATE_PRESSED;
import static com.xfxb.dhc.RoundedBitmapDrawable.CORNER_NONE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    View tvtext1;
    TextView tvtext2;
    TextView tvtext3;
    TextView tvtext4;
    TextView tvtext5;
    TextView tvtext6;

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
        initOne();
        initTwo();
        initThree();
        initFour();
        initFive();
    }

    private void initOne() {
        SelectDrawable selectDrawable = new SelectDrawable();
        selectDrawable.setmStrokeWidth(dp2px(1));
        selectDrawable.setmRoundC(dp2px(5));
        RoundedBitmapDrawable shapeBitmapDrawable=       new RoundedBitmapDrawable
                (drawableToBitmap(this.getResources().getDrawable(R.drawable
                        .ic_launcher_background)),25,CORNER_ALL);
        FSelector.with(tvtext1)
                .addDrawable().circleAngle(5).bgColor(R.color.clr_f6f6f6)
                .storkeWidth(1).strokeClr(R.color.clr_cdcdcd).create()
                .addDrawable(STATE_PRESSED).circleAngle(15).stateDraw(shapeBitmapDrawable)
                .storkeWidth(1).strokeClr(R.color.clr_cdcdcd).create()
                .bind();
    }
    private void initTwo() {
        FSelector.with(tvtext2)
                .addDrawable().circleAngle(5).bgColor(R.color.clr_f6f6f6)
                .storkeWidth(1).strokeClr(R.color.clr_cdcdcd).create()
                .addDrawable(STATE_PRESSED).circleAngle(5).bgColor(R.color.clr_fffcf7)
                .storkeWidth(1).strokeClr(R.color.clr_fb720e).create()
                .bind();
    }
    private void initThree() {
        FSelector.with(tvtext3)
                .addDrawable(STATE_PRESSED).circleAngle(15).bgColor(R.color.clr_fb720e).create()
                .addDrawable().circleAngle(15).bgColor(R.color.clr_cdcdcd).create()
                .bind();
    }
    private void initFour() {
        FSelector.with(tvtext4)
                .addDrawable().circleAngle(15).bgColor(R.color.clr_fb720e).create()
                .bind();
    }
    private void initFive() {
        FSelector.with(tvtext5)
                .addDrawable().circleAngle(15).bgColor(R.color.clr_fb720e).create()
                .addDrawable(STATE_PRESSED).circleAngle(15).stateDraw(this.getResources()
                .getDrawable(R.drawable.ic_launcher_background))
                .create()
                .bind();
    }
    private void initListener() {
        tvtext1.setOnClickListener(this);
        tvtext2.setOnClickListener(this);
        tvtext3.setOnClickListener(this);
        tvtext4.setOnClickListener(this);
        tvtext5.setOnClickListener(this);
        tvtext6.setOnClickListener(this);
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
