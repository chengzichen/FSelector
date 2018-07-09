package com.xfxb.dhc;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.GradientDrawable;

/**
 * 创建者     邓浩宸
 * 创建时间   2017/10/27 13:58
 * 描述	      自定义的背景
 */

public class SelectDrawable extends GradientDrawable implements IDrawDelegate{
    private Paint mPaint;
    private Path path;
    private Path path2;
    private PaintFlagsDrawFilter pfd;

    private RectF rectF;
    private int mHeight;
    private int mWidth;
    private  float mRoundC;
    private float mStrokeWidth;

    public SelectDrawable() {
        init();
    }

    public SelectDrawable(Orientation orientation, int[] colors) {
        super(orientation, colors);
        init();
    }

    @Override
    public void init() {
        pfd = new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setAntiAlias(true);
        path = new Path();
        path2 = new Path();
        rectF = new RectF();
        invalidateSelf();
    }

    public float getmRoundC() {
        return mRoundC;
    }

    public void setmRoundC(float mRoundC) {
        this.mRoundC = mRoundC;
    }

    public float getmStrokeWidth() {
        return mStrokeWidth;
    }

    public void setmStrokeWidth(float mStrokeWidth) {
        this.mStrokeWidth = mStrokeWidth;
    }

    @Override
    protected void onBoundsChange(Rect r) {
        super.onBoundsChange(r);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.setDrawFilter(pfd);
        mHeight = getBounds().height();
        mWidth = getBounds().width();
        mPaint.setColor(Color.parseColor("#fb720e"));
        mPaint.setStyle(Paint.Style.FILL);
        rectF.set(getpx(), getpx(), mWidth - getpx(), mHeight - getpx());
        path.addRoundRect(rectF,  mRoundC, mRoundC, Path.Direction.CW);
        path2.moveTo(mWidth - mHeight * 0.45f,mHeight);
        path2.lineTo(mWidth, mHeight * 0.55f);
        path2.lineTo(mWidth, mHeight);
        path2.close();
        canvas.clipPath(path, Region.Op.INTERSECT);
        canvas.drawPath(path2, mPaint);
        canvas.save();
        path.reset();
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(mStrokeWidth);
        mPaint.setStyle(Paint.Style.STROKE);
        path.moveTo(mWidth - mHeight * 0.45f * 0.55f, mHeight * 0.84f);
        path.lineTo(mWidth - mHeight * 0.45f * 0.42f, mHeight * 0.95f - getpx());
        path.lineTo(mWidth * 0.97f - getpx(), mHeight * 0.76f);
        canvas.drawPath(path, mPaint);
        path.reset();
    }

    private float getpx() {
        return mStrokeWidth-0.3f;
    }

}
