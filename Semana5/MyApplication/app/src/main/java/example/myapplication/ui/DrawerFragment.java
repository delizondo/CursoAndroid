package example.myapplication.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.myapplication.R;
import example.myapplication.ui.common.DrawerListener;

/**
 * Created by david on 11/1/16.
 */

public class DrawerFragment extends Fragment implements View.OnClickListener {


    private DrawerListener mListener;

    public static final String TAG = DrawerFragment.class.getName();

    public static DrawerFragment newInstance() {
        return new DrawerFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.drawer_layout, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.button1).setOnClickListener(this);
        view.findViewById(R.id.button2).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                mListener.openFragmentA();
                break;
            case R.id.button2:
                mListener.openFragmentB();
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (DrawerListener) context;
        } catch (ClassCastException e) {
            Log.e(TAG, "must implement DrawerListener");
        }
    }


}
