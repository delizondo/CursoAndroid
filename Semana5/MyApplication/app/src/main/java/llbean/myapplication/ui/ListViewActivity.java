package llbean.myapplication.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import llbean.myapplication.R;
import llbean.myapplication.ui.Adapter.ListAdapter;
import llbean.myapplication.util.ContactUtil;

/**
 * Created by david on 10/31/16.
 */

public class ListViewActivity extends AppCompatActivity {

    public static Intent makeIntent(Context context) {
        return new Intent(context, ListViewActivity.class);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        ListView listView = (ListView) findViewById(R.id.list_view);

        //ArrayAdapter<Contact> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ContactUtil.createContacts());
        ListAdapter adapter = new ListAdapter(this, ContactUtil.createContacts());

        listView.setAdapter(adapter);


    }
}