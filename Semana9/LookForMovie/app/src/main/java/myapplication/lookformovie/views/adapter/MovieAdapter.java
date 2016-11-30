package myapplication.lookformovie.views.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import myapplication.lookformovie.R;
import myapplication.lookformovie.databinding.MovieViewBinding;
import myapplication.lookformovie.models.MovieObject;
import myapplication.lookformovie.viewModel.MovieViewModel;

/**
 * Created by david on 11/28/16.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {
    private Context mContext;

    private List<MovieObject> mMovies;

    public MovieAdapter(Context context) {
        mContext = context;
        mMovies = new ArrayList<>();
    }


    public void setMovies(List<MovieObject> movies) {
        mMovies = movies;
        notifyDataSetChanged();
    }

    public void addMovies(List<MovieObject> movies) {
        mMovies.addAll(movies);
        notifyDataSetChanged();
    }

    public void reset() {
        mMovies.clear();
        notifyDataSetChanged();
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MovieViewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.movie_view, parent, false);

        return new MovieHolder(binding);
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
        MovieObject movieObject = mMovies.get(position);
        MovieViewBinding binding = holder.mBinding;
        binding.setMovie(new MovieViewModel(mContext, movieObject));
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public static class MovieHolder extends RecyclerView.ViewHolder {

        MovieViewBinding mBinding;

        public MovieHolder(MovieViewBinding binding) {
            super(binding.movieView);
            mBinding = binding;
        }
    }
}
