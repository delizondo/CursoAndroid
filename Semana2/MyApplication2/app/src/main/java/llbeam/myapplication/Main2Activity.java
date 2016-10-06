package llbeam.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        mTextView = (TextView) findViewById(R.id.tex123);
        mTextView.setText(getIntent().getStringExtra(Constants.EXTRA));


        Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new ResultClickListener());


    }


    private class ResultClickListener implements View.OnClickListener {


        @Override
        public void onClick(View v) {

            Intent intent = new Intent(Main2Activity.this, ResultActivity.class);
            startActivityForResult(intent, 123);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 123 && resultCode == Activity.RESULT_OK) {
            mTextView.setText(data.getStringExtra(Constants.EXTRA_RESULT));
        }


    }
}
