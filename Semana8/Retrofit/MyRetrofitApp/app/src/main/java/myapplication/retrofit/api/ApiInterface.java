package myapplication.retrofit.api;

import myapplication.retrofit.models.MovieFeed;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by david on 11/21/16.
 */

public interface ApiInterface {

    @GET("?y=&plot=short&apikey=6cbcbe3c&r=json")
    Call<MovieFeed> getImages(@Query("s") String query);

}
