package example.myapplication.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.myapplication.R;

/**
 * Created by david on 11/2/16.
 */

public class FragmentB extends Fragment {


    public static final String TAG = FragmentB.class.getName();

    public static FragmentB newInstance() {
        return new FragmentB();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container, false);
    }
}
