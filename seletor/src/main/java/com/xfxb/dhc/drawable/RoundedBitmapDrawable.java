package com.xfxb.dhc.drawable;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
/**
 * @creator：denghc(desoce)
 * @updateTime：2018/7/9 19:30
 * @description： 自定义Bitmap转Drawable
 */
public  class RoundedBitmapDrawable extends GradientDrawable {

    private int mStrokWidth;

    private final Path mPath = new Path();
    protected RectF mRect = new RectF(), mBitmapRect;
    protected BitmapShader bitmapShader;
    protected final Paint paint;


    public RoundedBitmapDrawable() {
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    public void setBitmap(Bitmap bitmap) {
        bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mBitmapRect = new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight());
        paint.setShader(bitmapShader);
    }

    public void setBitmap(Resources res, int id) {
        Bitmap bitmap = BitmapFactory.decodeResource(res, id);
        bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mBitmapRect = new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight());
        paint.setShader(bitmapShader);
    }


    @Override
        protected void onBoundsChange(Rect bounds) {
            super.onBoundsChange(bounds);
        buildPathIfDirty();
            Matrix shaderMatrix = new Matrix();
            shaderMatrix.setRectToRect(mBitmapRect, mRect, Matrix.ScaleToFit.FILL);
            bitmapShader.setLocalMatrix(shaderMatrix);
        }

        @Override
        @SuppressLint("NewApi")
        public void draw(Canvas canvas) {
            if (getCornerRadii() != null) {
                buildPathIfDirty();
                canvas.drawPath(mPath, paint);
            } else if (getCornerRadius() > 0.0f) {
                float rad = Math.min(getCornerRadius(),
                        Math.min(mRect.width(), mRect.height()) * 0.5f);
                canvas.drawRoundRect(mRect, rad, rad, paint);
            } else {
                if (paint.getColor() != 0 || paint != null ||
                        paint.getShader() != null) {
                    canvas.drawRect(mRect, paint);
                }
            }
            super.draw(canvas);
        }

    @Override
        public int getOpacity() {
            return PixelFormat.TRANSLUCENT;
        }

    @Override
        public void setAlpha(int alpha) {
            paint.setAlpha(alpha);
        }

    @Override
        public void setColorFilter(ColorFilter cf) {
            paint.setColorFilter(cf);
        }


    private boolean ensureValidRect() {
        Rect bounds = getBounds();
        float inset = mStrokWidth * 0.5f;
        mRect.set(bounds.left + inset, bounds.top + inset,
                bounds.right - inset, bounds.bottom - inset);
        return !mRect.isEmpty();
    }

    @SuppressLint("NewApi")
    private void buildPathIfDirty() {
        ensureValidRect();
        mPath.reset();
        mPath.addRoundRect(mRect, getCornerRadii(), Path.Direction.CW);
    }

    @Override
    public void setStroke(int width, int color, float dashWidth, float dashGap) {
        mStrokWidth = width;
        super.setStroke(width, color, dashWidth, dashGap);
    }

    @Override
    public void setStroke(int width, ColorStateList colorStateList, float dashWidth, float dashGap) {
        mStrokWidth = width;
        super.setStroke(width, colorStateList, dashWidth, dashGap);
    }
}