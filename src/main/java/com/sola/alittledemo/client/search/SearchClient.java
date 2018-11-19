package com.sola.alittledemo.client.search;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * @author Sola
 * @date 2018/11/05
 */
public interface SearchClient {

    /**
     * 获取歌曲列表
     *
     * @param data
     * @param authorization
     * @return
     */
    @GET("1/search/song")
    Call<SongResp> listSong(@Query("data") String data, @Header("Authorization") String authorization);

    /**
     * 获取专辑列表
     *
     * @param data
     * @param authorization
     * @return
     */
    @GET("1/search/album")
    Call<AlbumResp> listAlbum(@Query("data") String data, @Header("Authorization") String authorization);

}
