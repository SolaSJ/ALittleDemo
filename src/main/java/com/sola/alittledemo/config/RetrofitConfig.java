package com.sola.alittledemo.config;

import com.sola.alittledemo.client.search.SearchClient;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author Sola
 */
@Configuration
public class RetrofitConfig {

    private Retrofit createRetrofit(String host, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(host)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient().newBuilder()
                .addInterceptor(httpLoggingInterceptor())
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    @Bean
    public HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        // 日志级别
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        // 注入日志类
        return loggingInterceptor;
    }

    @Bean
    public SearchClient searchClient(@Value("${search.baseUrl}") String host, OkHttpClient okHttpClient) {
        Retrofit retrofit = createRetrofit(host, okHttpClient);
        return retrofit.create(SearchClient.class);
    }

}
