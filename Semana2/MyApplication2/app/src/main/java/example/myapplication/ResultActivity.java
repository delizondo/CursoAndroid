package example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by david on 10/5/16.
 */

public class ResultActivity extends AppCompatActivity {


    private EditText mTextEntry;

    private Button mFinish;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity_layout);

        mTextEntry = (EditText) findViewById(R.id.text_entry);
        mFinish = (Button) findViewById(R.id.button2);
        mFinish.setOnClickListener(new FinishClickListener());

    }



    private class FinishClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {


            Intent intent = new Intent();
            intent.putExtra(Constants.EXTRA_RESULT, mTextEntry.getText().toString());
            setResult(RESULT_OK, intent);
            finish();

        }
    }

}
