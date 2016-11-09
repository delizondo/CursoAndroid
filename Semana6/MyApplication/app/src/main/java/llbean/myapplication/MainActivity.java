package llbean.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static llbean.myapplication.Constants.BROADCAST_FILTER;
import static llbean.myapplication.Constants.EXTRA_TIMER_VALUE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView mTextView;
    private TimerReceiver mTimerReceiver;

    public static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTimerReceiver = new TimerReceiver();
        LocalBroadcastManager.getInstance(this).registerReceiver(mTimerReceiver, new IntentFilter(BROADCAST_FILTER));

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        mTextView = (TextView) findViewById(R.id.text1);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                startService();
                break;
            case R.id.button2:
                stopService();
                break;
            case R.id.button3:
                openIntentActivity();
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mTimerReceiver);
    }

    private void startService() {
        Log.d(TAG, "Starting Service");
        Intent intent = new Intent(this, ExampleService.class);
        startService(intent);
    }


    private void stopService() {
        Log.d(TAG, "Stopping Service");
        Intent intent = new Intent(this, ExampleService.class);
        stopService(intent);
    }

    private void openIntentActivity() {
        Intent intent = new Intent(this, IntentActivity.class);
        startActivity(intent);
    }


    private class TimerReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.hasExtra(EXTRA_TIMER_VALUE)) {
                int timerValue = intent.getIntExtra(EXTRA_TIMER_VALUE, 0);
                mTextView.setText(String.valueOf(timerValue));
            }
        }
    }


}
