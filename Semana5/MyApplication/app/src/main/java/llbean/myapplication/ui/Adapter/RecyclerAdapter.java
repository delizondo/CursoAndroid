package llbean.myapplication.ui.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import llbean.myapplication.R;
import llbean.myapplication.bo.Contact;
import llbean.myapplication.ui.widget.ContactView;

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
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contact contact = mList.get(position);
        holder.mContactView.setContact(contact);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        ContactView mContactView;

        public ViewHolder(View itemView) {
            super(itemView);
            mContactView = (ContactView) itemView.findViewById(R.id.contact_view);
        }
    }
}
