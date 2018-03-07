package example.fragmentapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by david on 10/12/16.
 */

public class DatePickerDialogFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    public static final String TAG = DatePickerDialogFragment.class.getName();


    public static DatePickerDialogFragment newInstance() {
        return new DatePickerDialogFragment();
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        final Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);


        return new DatePickerDialog(getContext(), this, year, month, day);

    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Toast.makeText(getContext(), "Date Selected: " + day + "/" + month + "/" + year, Toast.LENGTH_SHORT).show();
    }
}
