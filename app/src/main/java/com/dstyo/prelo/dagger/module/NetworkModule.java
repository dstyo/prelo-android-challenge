package com.dstyo.prelo.dagger.module;

import com.dstyo.prelo.network.api.ApiService;
import com.dstyo.prelo.network.api.RestClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.07.12
 */
@Module
public class NetworkModule {
    String baseUrl;

    public NetworkModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    @Named("loggingInterceptor")
    public HttpLoggingInterceptor providesLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    @Named("baseOkhttp3")
    public OkHttpClient providesOkHttpClient3(@Named("loggingInterceptor") HttpLoggingInterceptor interceptor) {
        int timeout = 3;

        return new okhttp3.OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(timeout, TimeUnit.SECONDS)
                .writeTimeout(timeout, TimeUnit.SECONDS)
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    @Named("gson")
    public Gson providesGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    @Named("baseRetrofit")
    public Retrofit provideBaseRetrofit(@Named("baseOkhttp3") OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(this.baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    @Named("baseNetworkService")
    public RestClient providesNetworkService(@Named("baseRetrofit") Retrofit retrofit) {
        return retrofit.create(RestClient.class);
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public ApiService providesService(@Named("baseNetworkService") RestClient restClient) {
        return new ApiService(restClient);
    }
}
