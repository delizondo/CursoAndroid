package llbean.myapplication.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import llbean.myapplication.R;
import llbean.myapplication.ui.Adapter.DividerDecorator;
import llbean.myapplication.ui.Adapter.RecyclerAdapter;
import llbean.myapplication.util.ContactUtil;

/**
 * Created by david on 10/31/16.
 */

public class RecyclerActivity extends BaseActivity {


    public static Intent makeIntent(Context context) {
        return new Intent(context, RecyclerActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        RecyclerAdapter adapter = new RecyclerAdapter(ContactUtil.createContacts());


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        int dividerHeight = getResources().getDimensionPixelSize(R.dimen.divider);
        DividerDecorator dividerDecorator = new DividerDecorator(dividerHeight);
        recyclerView.addItemDecoration(dividerDecorator);


        recyclerView.setAdapter(adapter);

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.recycler_activity;
    }
}
