package com.sola.alittledemo.common.client.search;

import com.alibaba.fastjson.JSONObject;
import feign.Param;
import feign.RequestLine;

/**
 * @author Sola
 * @date 2018/12/21
 */
public interface SearchClient {

    /**
     * 查询歌曲抽查列表
     *
     * @param songCkQuery
     * @return
     */
    @RequestLine("GET /v2/checksearch/song?data={data}")
    JSONObject listSongCk(@Param("data") JSONObject songCkQuery);

}
