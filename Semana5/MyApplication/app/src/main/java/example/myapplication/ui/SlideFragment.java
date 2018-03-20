package example.myapplication.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import example.myapplication.R;

/**
 * Created by david on 11/1/16.
 */

public class SlideFragment extends Fragment {


    public static final String TAG = SlideFragment.class.getName();

    public static final String POSITION = "position";

    public static SlideFragment newInstance(int position) {
        Bundle args = new Bundle();
        args.putInt(POSITION, position);
        SlideFragment fragment = new SlideFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.slide_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView) view.findViewById(R.id.text1);
        textView.setText(String.valueOf(getArguments().getInt(POSITION)));
    }


}
