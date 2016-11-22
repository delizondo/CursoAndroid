package myapplication.retrofit.api;

import myapplication.retrofit.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by david on 11/21/16.
 */

public class ApiClient {

    private static Retrofit sRetrofit;


    public static Retrofit getInstance() {

        if (sRetrofit == null) {

            sRetrofit = new Retrofit.Builder()
                    .baseUrl(Constants.ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofit;
    }


}
