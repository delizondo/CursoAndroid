package llbeam.practica1;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by david on 10/12/16.
 */

public class FragmentC extends Fragment implements View.OnClickListener {

    public static final String TAG = FragmentC.class.getName();

    private FragmentListener mListener;


    private EditText mEditText;

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

        mEditText = (EditText) view.findViewById(R.id.edit_text);

        Button button3 = (Button) view.findViewById(R.id.button3);
        button3.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button3) {
            mListener.setMessage(mEditText.getText().toString());
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }
}
