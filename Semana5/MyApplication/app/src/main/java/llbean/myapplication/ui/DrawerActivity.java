package llbean.myapplication.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import llbean.myapplication.R;

/**
 * Created by david on 11/1/16.
 */

public class DrawerActivity extends BaseActivity {

    public static Intent makeIntent(Context context) {
        return new Intent(context, DrawerActivity.class);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.drawer_layout;
    }
}
