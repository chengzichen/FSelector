package com.xfxb.dhc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * @creator：denghc(desoce)
 * @updateTime：2018/8/28 下午2:47
 * @description： 主界面
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private List<Fragment> fragments = new ArrayList<>();
    private ViewPager mMainFragmentVp;
    /**
     * shape
     */
    private TextView mTvLeft;
    /**
     * selector
     */
    private TextView mTvRight;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initViewPager();
        intListen();
    }

    private void intListen() {
        mTvLeft.setOnClickListener(this);
        mTvRight.setOnClickListener(this);
    }

    private void initViewPager() {

        fragments.add(new ShapeFragment());
        fragments.add(new SelectorFragment());
        // 绑定适配器
        mMainFragmentVp.setAdapter(adapter);
        mMainFragmentVp.setCurrentItem(0);
        // 设置滑动监听
        mMainFragmentVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTvLeft.setSelected(position == 0);
                mTvRight.setSelected(position == 1);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    // 设置适配器
    FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public Fragment getItem(int arg0) {
            return fragments.get(arg0);
        }


    };

    private void initView() {
        mMainFragmentVp = (ViewPager) findViewById(R.id.main_fragment_vp);
        mTvLeft = (TextView) findViewById(R.id.tv_left);
        mTvRight = (TextView) findViewById(R.id.tv_right);
        FSelector.with(mTvLeft)
                .addDrawable().btLeftCA(dp2px(15)).topLeftCA(dp2px(15))
                .bgColor(getColors(R.color.clr_00d2e0))
                .create()
                .addDrawable(FSelector.State.STATE_SELECTED).btLeftCA(dp2px(15)).topLeftCA(dp2px(15))
                .bgColor(getColors(R.color.clr_ff6239))
                .create()
                .bind();
        FSelector.with(mTvRight)
                .addDrawable().btRightCA(dp2px(15)).topRightCA(dp2px(15))
                .bgColor(getColors(R.color.clr_00d2e0))
                .create()
                .addDrawable(FSelector.State.STATE_SELECTED).btRightCA(dp2px(15)).topRightCA(dp2px(15))
                .bgColor(getColors(R.color.clr_ff6239))
                .create()
                .bind();
        mTvLeft.setSelected(true);
    }

    public int getColors(int color) {
        return ContextCompat.getColor(this, color);
    }

    private int dp2px(double dpValue) {
        float density = this.getResources().getDisplayMetrics().density;
        return (int) (dpValue * (double) density + 0.5D);
    }

    @Override
    public void onClick(View v) {
            if (v.getId()==R.id.tv_left){
                mMainFragmentVp.setCurrentItem(0);
            } else if (v.getId()==R.id.tv_right){
                mMainFragmentVp.setCurrentItem(1);
            }
    }
}