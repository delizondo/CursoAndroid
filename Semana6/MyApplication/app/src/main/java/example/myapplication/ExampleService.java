package example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import static example.myapplication.Constants.BROADCAST_FILTER;
import static example.myapplication.Constants.EXTRA_TIMER_VALUE;


/**
 * Created by david on 11/9/16.
 */

public class ExampleService extends Service {


    public static final String TAG = ExampleService.class.getName();

    //every 1 second
    private static final long THRESHOLD = 1000;
    private Handler mHandler;
    private TimerTask mTimerTask;
    private int mStartValue;


    @Override
    public void onCreate() {
        super.onCreate();
        mHandler = new Handler();
        mTimerTask = new TimerTask();
        mStartValue = 0;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mHandler.post(mTimerTask);
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        mHandler.removeCallbacks(mTimerTask);
        super.onDestroy();
    }

    private class TimerTask extends Thread {
        @Override
        public void run() {
            mStartValue++;
            Intent intent = new Intent(BROADCAST_FILTER);
            intent.putExtra(EXTRA_TIMER_VALUE, mStartValue);
            LocalBroadcastManager.getInstance(ExampleService.this).sendBroadcast(intent);
            Log.d(TAG, "Timer is: " + String.valueOf(mStartValue));
            mHandler.postDelayed(this, THRESHOLD);
        }
    }

}
