package myapplication.lookformovie.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by david on 11/28/16.
 */

public class MovieFeed {

    @SerializedName("Search")
    private List<MovieObject> mMovies;


    @SerializedName("totalResults")
    private int mTotalResults;


    public List<MovieObject> getMovies() {
        return mMovies;
    }

    public void setMovies(List<MovieObject> movies) {
        mMovies = movies;
    }

    public int getTotalResults() {
        return mTotalResults;
    }

    public void setTotalResults(int totalResults) {
        mTotalResults = totalResults;
    }
}
