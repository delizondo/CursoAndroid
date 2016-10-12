package llbean.fragmentapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by david on 10/12/16.
 */

public class FragmentC extends Fragment implements View.OnClickListener {

    public static final String TAG = FragmentC.class.getName();


    public static FragmentC newInstance() {
        return new FragmentC();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_c_layout, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button3 = (Button) view.findViewById(R.id.button3);
        button3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button3) {

            Fragment fragment = getActivity().getSupportFragmentManager().findFragmentByTag(FragmentB.TAG);

            if (fragment != null) {
                getActivity().getSupportFragmentManager().beginTransaction().remove(fragment).commit();

                Toast.makeText(getContext(), "Fragment B has been removed", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
