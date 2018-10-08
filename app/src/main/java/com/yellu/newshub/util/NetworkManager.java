package com.yellu.newshub.util;

import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;
import com.yellu.newshub.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okhttp3.internal.platform.Platform;
import okio.Okio;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;

public class NetworkManager {
    private static NetworkManager manager = null;
    private Retrofit retrofit;
    private String token = "831501f6e103407294b32b83cb8851c0";

    private NetworkManager(){
        OkHttpClient.Builder httpClient
                = new OkHttpClient.Builder();

        httpClient.interceptors().clear();
        httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            Request.Builder builder1 = original.newBuilder()
                    .header("Authorization", token);
            Request request = builder1.build();
            return chain.proceed(request);
        });


        httpClient.addInterceptor(new LoggingInterceptor.Builder()
                .loggable(BuildConfig.DEBUG)
                .setLevel(Level.BASIC)
                .log(Platform.INFO)
                .request("Request")
                .response("Response")
                .addHeader("version", BuildConfig.VERSION_NAME)
                .addQueryParam("query", "0")
//                .enableMock(true, 1000L, request -> {
//                    String segment = request.url().pathSegments().get(0);
//                    return Okio.buffer(Okio.source(mAssetManager.open(String.format("mock/%s.json", segment)))).readUtf8();
//                })
//              .enableAndroidStudio_v3_LogsHack(true) /* enable fix for logCat logging issues with pretty format */
//              .logger(new Logger() {
//                  @Override
//                  public void log(int level, String tag, String msg) {
//                      Log.w(tag, msg);
//                  }
//              })
//              .executor(Executors.newSingleThreadExecutor())
                .build());


        String baseUrl = "https://newsapi.org/";
        Retrofit.Builder builder
                = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create());

        retrofit = builder.build();
    }

    private <T> T createService(Class<T> service){
        return retrofit.create(service);
    }


    public static NetworkManager getInstance(){
        if (manager == null){
            manager = new NetworkManager();
        }
        return manager;
    }

    public interface NewsService{
        @GET("/v2/top-headlines")
        Call<ResponseBody> getHeadLines();
    }

    public Call<ResponseBody> headLines(){
       return createService(NewsService.class).getHeadLines();
    }
}
