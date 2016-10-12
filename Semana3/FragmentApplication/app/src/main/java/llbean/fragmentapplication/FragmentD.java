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

public class FragmentD extends Fragment implements View.OnClickListener {


    public static final String TAG = FragmentD.class.getName();


    public static FragmentD newInstance() {
        return new FragmentD();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_d_layout, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button5 = (Button) view.findViewById(R.id.button5);
        button5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button5) {
            getChildFragmentManager().beginTransaction().replace(R.id.third_container, FragmentE.newInstance(), FragmentE.TAG).commit();
        }
    }
}
