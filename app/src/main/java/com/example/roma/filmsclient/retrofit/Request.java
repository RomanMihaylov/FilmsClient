package com.example.roma.filmsclient.retrofit;

import com.example.roma.filmsclient.pojo.Movie;
import com.example.roma.filmsclient.pojo.SessionId;
import com.example.roma.filmsclient.pojo.TokenLoginPass;
import com.example.roma.filmsclient.pojo.TokenRequest;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.roma.filmsclient.utils.Const.API_v3;
import static com.example.roma.filmsclient.utils.Const.URL_TMDb;


public class Request {


    public static Single<TokenRequest> getRequestToken(String apiKey) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_TMDb)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(Server.class)
                .getTokenReauest(apiKey)
                .doOnError(new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });

    }

    public static Single<TokenLoginPass> getTokenLoginPass(String apiKey, String login, String pass, String token) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_TMDb)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(Server.class)
                .getTokenLoginPass(apiKey, login, pass, token)
                .doOnError(new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });
    }

    public static Single<SessionId> createSessionId(String apiKey, String requestToken) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_TMDb)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(Server.class)
                .getSessionId(apiKey, requestToken);
    }

    public static Single<Movie> getMoviesNowShow() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_TMDb)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(Server.class)
                .getMoviewNowShow(API_v3,"en-US","1");

    }
}
