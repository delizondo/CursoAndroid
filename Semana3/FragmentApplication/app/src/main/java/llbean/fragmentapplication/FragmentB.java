package llbean.fragmentapplication;

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

public class FragmentB extends Fragment implements View.OnClickListener {


    public static final String TAG = FragmentB.class.getName();


    public static FragmentB newInstance() {
        return new FragmentB();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b_layout, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button2 = (Button) view.findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.button2) {

            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.first_container, FragmentC.newInstance(), FragmentC.TAG)
                    .addToBackStack(FragmentC.TAG)
                    .commit();

        }

    }
}
