package example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getName();


    private static String STATE = "state";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new ButtonClickListener());


        if (savedInstanceState != null) {
            Log.d(TAG, "recreate");
            Log.d(TAG, savedInstanceState.getString(STATE));

        }else{
            Log.d(TAG, "onCreate");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }


    private class ButtonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            intent.putExtra(Constants.EXTRA, "this is my extra");
            startActivity(intent);
        }
    }



    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE, "saved state");
        Log.d(TAG, "onSavedInstanceState");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
