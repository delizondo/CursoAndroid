package myapplication.myvolleyapp.api;

/**
 * Created by david on 11/22/16.
 */

public class EndPoints {

    private static final String ENDPOINT = "http://www.omdbapi.com/";

    public static String getMoviesEndpoint(String query) {
        return ENDPOINT + "?y=&plot=short&r=json" + "&s=" + query;
    }

}
