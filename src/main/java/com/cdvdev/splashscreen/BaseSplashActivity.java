package com.cdvdev.splashscreen;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.lang.ref.WeakReference;

/**
 * Activity for branded logo (Splash Screen)
 * <p>
 * Created by Dmitriy V. Chernysh
 * https://plus.google.com/+DmitriyChernysh-V/
 */

public abstract class BaseSplashActivity extends AppCompatActivity implements ISplash.View {

    private static final int SPLASH_DISPLAY_LENGHT = 1500;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this.getSplashLayoutId());

        mHandler.postDelayed(
                new StartActivityRunnable(this),
                getSplashShowTime()
        );
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        //Remove any delayed Runnable(s) and prevent them from executing.
        mHandler.removeCallbacksAndMessages(null);
        //clear mHandler allocated memory
        mHandler = null;

        super.onDestroy();
    }

    private static class StartActivityRunnable implements Runnable {

        private WeakReference<AppCompatActivity> mActivityReference;

        private StartActivityRunnable(AppCompatActivity activity) {
            mActivityReference = new WeakReference<>(activity);
        }

        @Override
        public void run() {
            if (mActivityReference.get() != null) {
                AppCompatActivity activity = mActivityReference.get();

                ((ISplash.View) activity).onStartNextActivity(activity);
            }

        }
    }

    @Override
    public int getSplashShowTime() {
        return SPLASH_DISPLAY_LENGHT;
    }
}
