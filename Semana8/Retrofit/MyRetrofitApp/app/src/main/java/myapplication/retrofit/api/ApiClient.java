package myapplication.retrofit.api;

import myapplication.retrofit.Constants;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by david on 11/21/16.
 */

public class ApiClient {

    private static Retrofit sRetrofit;


    public static Retrofit getInstance() {

        if (sRetrofit == null) {


            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();

            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();

            okHttpClient.addInterceptor(loggingInterceptor);

            sRetrofit = new Retrofit.Builder()
                    .baseUrl(Constants.ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient.build())
                    .build();
        }
        return sRetrofit;
    }


}
