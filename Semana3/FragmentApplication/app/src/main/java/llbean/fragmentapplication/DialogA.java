package llbean.fragmentapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by david on 10/12/16.
 */

public class DialogA extends DialogFragment implements DialogInterface.OnClickListener {

    public static final String TAG = DialogA.class.getName();


    public static DialogA newInstance(){
        return new DialogA();
    }



    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Alert!")
                .setMessage("This is a Fragment Dialog")
                .setPositiveButton("Ok", this)
                .setNegativeButton("Cancel", this);


        return builder.create();
    }


    @Override
    public void onClick(DialogInterface dialogInterface, int i) {


        if (i == Dialog.BUTTON_POSITIVE) {
            Toast.makeText(getContext(), "Positive", Toast.LENGTH_SHORT).show();


        } else if (i == Dialog.BUTTON_NEGATIVE) {
            Toast.makeText(getContext(), "Negative", Toast.LENGTH_SHORT).show();
        }
    }
}
