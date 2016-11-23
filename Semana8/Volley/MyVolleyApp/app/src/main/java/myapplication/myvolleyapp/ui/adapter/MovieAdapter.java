package myapplication.myvolleyapp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import myapplication.myvolleyapp.MyApplication;
import myapplication.myvolleyapp.R;
import myapplication.myvolleyapp.models.MovieObject;

/**
 * Created by david on 11/22/16.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {


    private Context mContext;

    private List<MovieObject> mMovies;

    private ImageLoader mImageLoader;

    public MovieAdapter(List<MovieObject> movies, Context context) {
        mMovies = movies;
        mContext = context;
        mImageLoader = MyApplication.getInstance().getApiClient().getImageLoader();
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_view, parent, false);
        return new MovieHolder(v);
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
        MovieObject movieObject = mMovies.get(position);
        holder.mName.setText(mContext.getString(R.string.movie_name, movieObject.getTitle()));
        holder.mYear.setText(mContext.getString(R.string.movie_year, movieObject.getYear()));
        holder.mImageView.setImageUrl(movieObject.getPoster(), mImageLoader);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public static class MovieHolder extends RecyclerView.ViewHolder {


        NetworkImageView mImageView;
        TextView mName;
        TextView mYear;

        public MovieHolder(View v) {
            super(v);
            mImageView = (NetworkImageView) v.findViewById(R.id.poster);
            mName = (TextView) v.findViewById(R.id.name);
            mYear = (TextView) v.findViewById(R.id.year);
        }
    }


}
