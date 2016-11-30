package myapplication.lookformovie.api;

import myapplication.lookformovie.models.MovieFeed;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by david on 11/28/16.
 */

public interface ApiInterface {

    @GET("?y=&plot=short&r=json")
    Call<MovieFeed> getImages(@Query("s") String query, @Query("page") int page);
}
