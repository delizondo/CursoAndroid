package llbean.myapplication.ui;

import android.os.Bundle;
import android.view.View;

import llbean.myapplication.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.button1:
                startActivity(ListViewActivity.makeIntent(this));
                break;
            case R.id.button2:
                startActivity(RecyclerActivity.makeIntent(this));
                break;
            case R.id.button3:
                startActivity(PagerActivity.makeIntent(this));
                break;

        }
    }
}
