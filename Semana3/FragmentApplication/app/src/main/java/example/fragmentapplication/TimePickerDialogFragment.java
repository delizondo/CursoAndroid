package example.fragmentapplication;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by david on 10/12/16.
 */

public class TimePickerDialogFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    public static final String TAG = TimePickerDialogFragment.class.getName();


    public static TimePickerDialogFragment newInstance() {
        return new TimePickerDialogFragment();
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);


        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }


    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        Toast.makeText(getContext(), "Time Selected: " + hour + ":" + minute, Toast.LENGTH_SHORT).show();

    }
}

