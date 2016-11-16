package llbeam.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by david on 11/16/16.
 */

public class MyContactAdapter extends RecyclerView.Adapter<MyContactAdapter.ViewHolder> {

    private List<MyContact> mList;

    private Context mContext;

    public MyContactAdapter(Context context, List<MyContact> list) {
        mList = list;
        mContext = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyContact contact = mList.get(position);
        holder.name.setText(mContext.getString(R.string.name, contact.getName()));
        holder.phone.setText(mContext.getString(R.string.phone, contact.getPhone()));
        holder.id.setText(mContext.getString(R.string.id, contact.getId()));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView phone;
        TextView id;


        public ViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.name);
            phone = (TextView) v.findViewById(R.id.phone);
            id = (TextView) v.findViewById(R.id.id);
        }


    }

}
