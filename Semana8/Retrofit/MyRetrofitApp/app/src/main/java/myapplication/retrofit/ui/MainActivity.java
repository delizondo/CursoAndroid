package myapplication.retrofit.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.squareup.picasso.Picasso;

import myapplication.retrofit.MyApplication;
import myapplication.retrofit.R;
import myapplication.retrofit.models.MovieFeed;
import myapplication.retrofit.ui.adapter.MarginDecoration;
import myapplication.retrofit.ui.adapter.MovieAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    public static final String TAG = MainActivity.class.getName();

    private EditText mSearch;

    private RecyclerView mRecyclerView;

    private MovieAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button1).setOnClickListener(this);
        mSearch = (EditText) findViewById(R.id.search);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mRecyclerView.addItemDecoration(new MarginDecoration(this));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        Picasso.with(this).setIndicatorsEnabled(true);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                searchMovies();
                break;
        }
    }


    private void searchMovies() {
        String query = mSearch.getText().toString();
        Call<MovieFeed> call = MyApplication.getInstance().getAPI().getImages(query);
        Log.d(TAG, call.request().toString());
        call.enqueue(new Callback<MovieFeed>() {
            @Override
            public void onResponse(Call<MovieFeed> call, Response<MovieFeed> response) {
                Log.d(TAG, "success");

                mAdapter = new MovieAdapter(response.body().getMovies(), MainActivity.this);
                mRecyclerView.setAdapter(mAdapter);

            }

            @Override
            public void onFailure(Call<MovieFeed> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });
    }
}
