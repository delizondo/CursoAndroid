package example.myapplication.ui.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import example.myapplication.R;
import example.myapplication.bo.Contact;
import example.myapplication.ui.widget.ContactView;

/**
 * Created by david on 10/31/16.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Contact> mList;

    public RecyclerAdapter(List<Contact> contacts) {
        mList = contacts;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_view, parent, false);
        //View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Contact contact = mList.get(position);
        viewHolder.mContactView.setContact(contact);


        /*viewHolder.mName.setText(contact.getFullName());
        viewHolder.mPhone.setText(contact.getPhone());
        viewHolder.mEmail.setText(contact.getEmail());*/
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        /*TextView mName;
        TextView mEmail;
        TextView mPhone;*/
        ContactView mContactView;

        public ViewHolder(View view) {
            super(view);

          /*  mName = (TextView) view.findViewById(R.id.name);
            mEmail = (TextView) view.findViewById(R.id.email);
           mPhone = (TextView) view.findViewById(R.id.phone);*/


            mContactView = (ContactView) itemView.findViewById(R.id.contact_view);
        }
    }
}
