package com.etisalat.sampletask.bases;

import android.app.Application;
import android.content.Context;

/**
 * Created by Ahmed Etman on 4/25/2018.
 */

public class ApplicationContextProvider extends Application{

    private static Context sContext;
    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }

    public static Context getContext() {
        return sContext;
    }
}
