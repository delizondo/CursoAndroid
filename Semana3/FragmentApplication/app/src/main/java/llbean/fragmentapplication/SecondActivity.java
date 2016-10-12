package llbean.fragmentapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by david on 10/12/16.
 */

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {


    public static Intent makeIntent(Context context) {
        return new Intent(context, SecondActivity.class);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity_layout);

        Button timePickerButton = (Button) findViewById(R.id.button8);
        Button datePickerButton = (Button) findViewById(R.id.button7);

        timePickerButton.setOnClickListener(this);
        datePickerButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button7:
                DatePickerDialogFragment.newInstance().show(getSupportFragmentManager(), DatePickerDialogFragment.TAG);
                break;
            case R.id.button8:
                TimePickerDialogFragment.newInstance().show(getSupportFragmentManager(), TimePickerDialogFragment.TAG);
                break;

        }
    }
}
