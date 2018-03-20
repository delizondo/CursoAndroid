package example.myapplication.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import example.myapplication.R;
import example.myapplication.bo.Contact;

/**
 * Created by david on 10/31/16.
 */

public class ContactView extends LinearLayout {


    public ContactView(Context context) {
        super(context);
        init(context);
    }

    public ContactView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ContactView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setOrientation(VERTICAL);
        setBackgroundResource(R.drawable.contact_view_background);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.contact_core, this, true);
    }

    public void setContact(Contact contact) {
        TextView name = (TextView) findViewById(R.id.name);
        TextView email = (TextView) findViewById(R.id.email);
        TextView phone = (TextView) findViewById(R.id.phone);

        name.setText(contact.getFullName());
        email.setText(getContext().getString(R.string.email, contact.getEmail()));
        phone.setText(getContext().getString(R.string.phone, contact.getPhone()));
    }

}
