package llbeam.practica1;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by david on 10/12/16.
 */

public class FragmentA extends Fragment implements View.OnClickListener {

    public static final String TAG = FragmentA.class.getName();


    private FragmentListener mListener;


    public static FragmentA newInstance() {
        return new FragmentA();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button1 = (Button) view.findViewById(R.id.button1);
        button1.setOnClickListener(this);

        if (!TextUtils.isEmpty(mListener.getMessage())) {

            TextView textView = (TextView) view.findViewById(R.id.text_view);
            textView.setText(mListener.getMessage());


        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, FragmentB.newInstance(), FragmentB.TAG)
                    .addToBackStack(FragmentB.TAG).commit();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (FragmentListener) context;
        } catch (ClassCastException e) {
            Log.e(TAG, e.getMessage(), e.getCause());
        }
    }
}
