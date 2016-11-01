package llbean.myapplication.ui.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import llbean.myapplication.R;
import llbean.myapplication.bo.Contact;

/**
 * Created by david on 10/31/16.
 */

public class ListAdapter extends BaseAdapter {

    private List<Contact> mList;
    private Context mContext;
    private final LayoutInflater mInflater;


    public ListAdapter(Context context, List<Contact> contacts) {
        mContext = context;
        mList = contacts;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ContactHolder viewHolder;
        if (view == null) {
            viewHolder = new ContactHolder();
            view = mInflater.inflate(R.layout.contact_layout, viewGroup, false);
            viewHolder.mName = (TextView) view.findViewById(R.id.name);
            viewHolder.mEmail = (TextView) view.findViewById(R.id.email);
            viewHolder.mPhone = (TextView) view.findViewById(R.id.phone);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ContactHolder) view.getTag();
        }

        Contact contact = mList.get(i);

        viewHolder.mName.setText(contact.getFullName());
        viewHolder.mPhone.setText(mContext.getString(R.string.phone, contact.getPhone()));
        viewHolder.mEmail.setText(mContext.getString(R.string.email, contact.getEmail()));

        return view;
    }

    private class ContactHolder {
        TextView mName;
        TextView mEmail;
        TextView mPhone;
    }

}
