package llbeam.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText mEditText;
    private TextView mTextView;
    private static final String SAVED_VALUE = "saved_value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        mEditText = (EditText) findViewById(R.id.edittext1);
        mTextView = (TextView) findViewById(R.id.textview1);

        String value = MyApplication.getInstance().getApplicationPreferences().getString(SAVED_VALUE, "");
        if (!TextUtils.isEmpty(value)) {
            mTextView.setText(getString(R.string.saved_value, value));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                saveOnSharedPreferences();
                break;
            case R.id.button2:
                cleanPreferences();
                break;
            case R.id.button3:
                openContactsActivity();
                break;
        }
    }


    private void saveOnSharedPreferences() {
        String value = mEditText.getText().toString();
        SharedPreferences.Editor editor = MyApplication.getInstance().getApplicationPreferences().edit();
        editor.putString(SAVED_VALUE, value);
        editor.commit();

        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }


    private void cleanPreferences() {
        SharedPreferences.Editor editor = MyApplication.getInstance().getApplicationPreferences().edit();
        editor.clear();
        editor.commit();

        Toast.makeText(this, "Cleaned", Toast.LENGTH_SHORT).show();
        mTextView.setText("");
    }

    private void openContactsActivity() {
        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
    }



}
