package com.cdvdev.splashscreen;

import android.support.v7.app.AppCompatActivity;

/**
 * Interface for Splash Screen view
 * <p>
 * Created by Dmitriy V. Chernysh
 * https://plus.google.com/+DmitriyChernysh-V/
 */

interface ISplash {
    interface View {

        /**
         * Get Layout resource ID
         *
         * @return Resource ID
         */
        int getSplashLayoutId();

        /**
         * Get timeout for show
         *
         * @return milliseconds
         */
        int getSplashShowTime();

        /**
         * Run operations after show timeout
         *
         * @param splashActivityReference Activity with WeakReference
         *                                (need to use this activity for finish or intent)
         */
        void onStartNextActivity(AppCompatActivity splashActivityReference);
    }
}
