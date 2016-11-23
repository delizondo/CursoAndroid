package myapplication.myvolleyapp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by david on 11/22/16.
 */

public class MovieObject {

    @SerializedName("Title")
    private String mTitle;

    @SerializedName("Year")
    private String mYear;

    @SerializedName("Poster")
    private String mPoster;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getYear() {
        return mYear;
    }

    public void setYear(String year) {
        mYear = year;
    }

    public String getPoster() {
        return mPoster;
    }

    public void setPoster(String poster) {
        mPoster = poster;
    }
}
