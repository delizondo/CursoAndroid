package myapplication.retrofit;

import android.app.Application;

import myapplication.retrofit.api.ApiClient;
import myapplication.retrofit.api.ApiInterface;

/**
 * Created by david on 11/21/16.
 */

public class MyApplication extends Application {


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
