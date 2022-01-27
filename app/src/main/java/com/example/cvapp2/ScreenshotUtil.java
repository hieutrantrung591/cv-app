package com.example.cvapp2;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.MeasureSpec;

public class ScreenshotUtil {
    private static com.example.cvapp2.ScreenshotUtil mInstance;
    private ScreenshotUtil() {
    }
    public static com.example.cvapp2.ScreenshotUtil getInstance() {
        if (mInstance == null) {
            synchronized (com.example.cvapp2.ScreenshotUtil.class) {
                if (mInstance == null) {
                    mInstance = new com.example.cvapp2.ScreenshotUtil();
                }
            }
        }
        return mInstance;
    }
    /**
     * Measures and takes a screenshot of the provided {@link View}.
     *
     * @param view The view of which the screenshot is taken
     * @return A {@link Bitmap} for the taken screenshot.
     */
    public Bitmap takeScreenshotForView(View view) {
        view.measure(MeasureSpec.makeMeasureSpec(view.getWidth(), MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(view.getHeight(), MeasureSpec.EXACTLY));
        view.layout((int) view.getX(), (int) view.getY(), (int) view.getX() + view.getMeasuredWidth(), (int) view.getY() + view.getMeasuredHeight());
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache(true);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return bitmap;
    }
    public Bitmap takeScreenshotForScreen(Activity activity) {
        return takeScreenshotForView(activity.getWindow().getDecorView().getRootView());
    }
}