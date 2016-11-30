package myapplication.lookformovie.viewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import myapplication.lookformovie.R;
import myapplication.lookformovie.models.MovieObject;

/**
 * Created by david on 11/28/16.
 */

public class MovieViewModel extends BaseObservable {

    private Context mContext;

    private MovieObject mMovieObject;


    public MovieViewModel(Context context, MovieObject movieObject) {
        mContext = context;
        mMovieObject = movieObject;
    }

    @Bindable
    public String getTitle() {
        return mContext.getString(R.string.movie_name, mMovieObject.getTitle());
    }

    public void setTitle(String title) {
        mMovieObject.setTitle(title);
        notifyChange();
    }

    @Bindable
    public String getYear() {
        return mContext.getString(R.string.movie_year, mMovieObject.getYear());
    }

    public void setYear(String year) {
        mMovieObject.setYear(year);
        notifyChange();
    }

    @Bindable
    public String getPoster() {
        return mMovieObject.getPoster();
    }

    public void setPoster(String poster) {
        mMovieObject.setPoster(poster);
        notifyChange();
    }

    @BindingAdapter("app:imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        Picasso.with(imageView.getContext()).load(url)
                .resizeDimen(R.dimen.image_width, R.dimen.image_height)
                .into(imageView);
    }

}
