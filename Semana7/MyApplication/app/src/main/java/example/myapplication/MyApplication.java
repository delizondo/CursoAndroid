package example.myapplication;

import android.app.Application;
import android.content.SharedPreferences;

/**
 * Created by david on 11/16/16.
 */

public class MyApplication extends Application {


    private SharedPreferences mSharedPreferences;

    private static final String PREFERENCES_FILE = "my_shared_preferences";


    private static MyApplication sInstance;


    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        mSharedPreferences = getSharedPreferences(PREFERENCES_FILE, MODE_PRIVATE);
    }


    public static MyApplication getInstance() {
        return sInstance;
    }

    public SharedPreferences getApplicationPreferences() {
        return mSharedPreferences;
    }
}
