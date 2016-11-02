package llbean.myapplication.ui;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import llbean.myapplication.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private CoordinatorLayout mCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);

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
            case R.id.button4:
                startActivity(DrawerActivity.makeIntent(this));
                break;
            case R.id.button5:
                startActivity(AnimationsActivity.makeIntent(this));
                break;

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu1:
                Snackbar.make(mCoordinatorLayout, "Option 1", Snackbar.LENGTH_LONG).show();
                break;
            case R.id.menu2:
                Snackbar.make(mCoordinatorLayout, "Option 2", Snackbar.LENGTH_LONG).show();
                break;
            case R.id.menu3:
                Snackbar.make(mCoordinatorLayout, "Option 3", Snackbar.LENGTH_LONG).show();
                break;

        }
        return true;
    }
}
