package llbean.myapplication.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import llbean.myapplication.R;

/**
 * Created by david on 11/2/16.
 */

public class FragmentA extends Fragment {

    public static final String TAG = FragmentA.class.getName();

    public static FragmentA newInstance() {
        return new FragmentA();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }
}
