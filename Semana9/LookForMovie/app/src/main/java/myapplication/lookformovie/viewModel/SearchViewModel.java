package myapplication.lookformovie.viewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import myapplication.lookformovie.BR;
import myapplication.lookformovie.MyApplication;
import myapplication.lookformovie.models.MovieFeed;
import myapplication.lookformovie.views.adapter.MovieAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by david on 11/28/16.
 */

public class SearchViewModel extends BaseObservable {


    private String mQuery;

    private MovieAdapter mAdapter;

    private int mTotalPages;

    private int mCurrentPage;

    private boolean mIsLoading;

    private String mMovieTitle;


    public SearchViewModel(Context context, RecyclerView recyclerView) {
        mAdapter = new MovieAdapter(context);
        recyclerView.setAdapter(mAdapter);
        mCurrentPage = 1;
    }


    public View.OnClickListener searchMoviesClickListener() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                searchMovies();
            }
        };
    }

    @Bindable
    public String getQuery() {
        return mQuery;
    }


    public void setQuery(String query) {
        mQuery = query;
        notifyPropertyChanged(BR.search);

    }

    private void searchMovies() {
        mMovieTitle = getQuery();
        mAdapter.reset();
        requestMovies();
    }


    private void requestMovies() {
        Call<MovieFeed> call = MyApplication.getInstance().getAPI().getImages(mMovieTitle, mCurrentPage);
        Log.d(TAG, call.request().toString());
        call.enqueue(new Callback<MovieFeed>() {
            @Override
            public void onResponse(Call<MovieFeed> call, Response<MovieFeed> response) {
                Log.d(TAG, "success");
                mIsLoading = false;
                if (response.body().getMovies() != null) {
                    mAdapter.addMovies(response.body().getMovies());
                    mTotalPages = response.body().getTotalResults();
                }
            }

            @Override
            public void onFailure(Call<MovieFeed> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });
    }


    public RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

            int total = layoutManager.getItemCount();
            int lastVisibleItemCount = layoutManager.findLastVisibleItemPosition();

            if (!mIsLoading) {
                if (total > 0)
                    if ((total - 1) == lastVisibleItemCount) {
                        if (mCurrentPage < mTotalPages) {
                            mCurrentPage++;
                            mIsLoading = true;
                            requestMovies();
                        }
                    }
            }
        }
    };
}
