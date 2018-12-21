package com.sola.alittledemo.common.config;

import com.sola.alittledemo.common.client.search.SearchClient;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

/**
 * feign配置类
 *
 * @author Sola
 * @date 2018/12/09
 */
@Configuration
public class FeignConfig {

    @Value("${feign.connectTimeoutMillis}")
    private int connectTimeoutMillis;
    @Value("${feign.readTimeoutMillis}")
    private int readTimeoutMillis;
    @Value("${mzk.token}")
    private String token;

    private <T> T builder(Class<T> tClass, String baseUrl) {
        return this.builder(tClass, baseUrl, connectTimeoutMillis, readTimeoutMillis);
    }

    private <T> T builder(Class<T> tClass, String baseUrl, int connectTimeoutMillis, int readTimeoutMillis) {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logLevel(Logger.Level.FULL)
                .logger(new Slf4jLogger(tClass))
                .options(new Request.Options(connectTimeoutMillis, readTimeoutMillis))
                .requestInterceptor(requestTemplate -> requestTemplate.header(HttpHeaders.AUTHORIZATION, token))
                .target(tClass, baseUrl);
    }

    @Bean
    public SearchClient searchClient(@Value("${mzk.search.baseUrl}") String baseUrl) {
        return this.builder(SearchClient.class, baseUrl);
    }

}
