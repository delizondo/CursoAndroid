package llbeam.practica1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FragmentListener {


    private String mMessage;

    private static String MESSAGE_STATE = "message_state";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState != null) {
            mMessage = savedInstanceState.getString(MESSAGE_STATE);
            return;
        }


        getSupportFragmentManager().beginTransaction().add(R.id.container, FragmentA.newInstance(), FragmentA.TAG).commit();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(MESSAGE_STATE, mMessage);
    }

    @Override
    public void setMessage(String message) {
        mMessage = message;
    }

    @Override
    public String getMessage() {
        return mMessage;
    }
}
