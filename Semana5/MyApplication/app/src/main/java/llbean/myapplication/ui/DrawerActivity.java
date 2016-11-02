package llbean.myapplication.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;

import llbean.myapplication.R;
import llbean.myapplication.ui.common.DrawerListener;

/**
 * Created by david on 11/1/16.
 */

public class DrawerActivity extends BaseActivity implements DrawerListener {


    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawer;

    public static Intent makeIntent(Context context) {
        return new Intent(context, DrawerActivity.class);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mDrawer = (DrawerLayout) findViewById(R.id.nav_drawer);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar, 0, 0);
        mDrawer.addDrawerListener(mDrawerToggle);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        if (savedInstanceState != null) {
            return;
        }

        getSupportFragmentManager().beginTransaction().add(R.id.content, FragmentA.newInstance(), FragmentA.TAG).commit();

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.drawer_activity;
    }

    @Override
    public void openFragmentA() {
        mDrawer.closeDrawers();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.content, FragmentA.newInstance(), FragmentA.TAG).commit();
    }

    @Override
    public void openFragmentB() {
        mDrawer.closeDrawers();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.content, FragmentB.newInstance(), FragmentB.TAG).commit();
    }
}
