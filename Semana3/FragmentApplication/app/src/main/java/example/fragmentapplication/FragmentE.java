package example.fragmentapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by david on 10/12/16.
 */

public class FragmentE extends Fragment implements View.OnClickListener {

    public static final String TAG = FragmentE.class.getName();


    public static FragmentE newInstance() {
        return new FragmentE();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_e_layout, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button6 = (Button)view.findViewById(R.id.button6);
        button6.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button6) {
            startActivity(SecondActivity.makeIntent(getContext()));
        }
    }
}
