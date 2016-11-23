package myapplication.myvolleyapp;

import android.app.Application;

import myapplication.myvolleyapp.api.ApiClient;

/**
 * Created by david on 11/22/16.
 */

public class MyApplication extends Application {


    private static MyApplication sInstance;

    private ApiClient mApiClient;


    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        mApiClient = ApiClient.getInstance(this);
    }

    public static MyApplication getInstance() {
        return sInstance;
    }


    public ApiClient getApiClient() {
        return mApiClient;
    }
}
