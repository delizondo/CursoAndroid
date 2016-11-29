package myapplication.lookformovie;

import android.app.Application;

import myapplication.lookformovie.api.ApiClient;
import myapplication.lookformovie.api.ApiInterface;

/**
 * Created by david on 11/28/16.
 */

public class MyApplication extends Application{

    private static MyApplication sInstance;


    private ApiInterface mApiInterface;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        mApiInterface = ApiClient.getInstance().create(ApiInterface.class);
    }

    public ApiInterface getAPI() {
        return mApiInterface;
    }

    public static MyApplication getInstance() {
        return sInstance;
    }
}
