package myapplication.myvolleyapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

import myapplication.myvolleyapp.MyApplication;
import myapplication.myvolleyapp.R;
import myapplication.myvolleyapp.api.EndPoints;
import myapplication.myvolleyapp.models.MovieFeed;
import myapplication.myvolleyapp.ui.adapter.MarginDecoration;
import myapplication.myvolleyapp.ui.adapter.MovieAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    public static final String TAG = MainActivity.class.getName();

    private EditText mSearch;

    private RecyclerView mRecyclerView;

    private MovieAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        findViewById(R.id.button1).setOnClickListener(this);
        mSearch = (EditText) findViewById(R.id.search);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mRecyclerView.addItemDecoration(new MarginDecoration(this));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
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

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, EndPoints.getMoviesEndpoint(query), null, new SuccessResponse(), new ErrorResponse());
        MyApplication.getInstance().getApiClient().addToRequestQueue(request);
    }


    private class SuccessResponse implements Response.Listener<JSONObject> {


        @Override
        public void onResponse(JSONObject response) {
            Log.d(TAG, "success");

            Gson gson = new Gson();

            MovieFeed movieFeed = gson.fromJson(response.toString(), MovieFeed.class);
            mAdapter = new MovieAdapter(movieFeed.getMovies(), MainActivity.this);
            mRecyclerView.setAdapter(mAdapter);
        }
    }


    private class ErrorResponse implements Response.ErrorListener {

        @Override
        public void onErrorResponse(VolleyError error) {
            Log.d(TAG, "error");
        }
    }

}
