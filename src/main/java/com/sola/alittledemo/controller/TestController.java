package com.sola.alittledemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sola.alittledemo.common.client.search.SearchClient;
import com.sola.alittledemo.common.client.search.query.SongCkQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Sola
 * @date 2018/12/13
 */
@Slf4j
@RestController
public class TestController {

    @Resource
    private SearchClient searchClient;

    @GetMapping("/hello")
    public Object hello() {
        SongCkQuery songCkQuery = new SongCkQuery();
        songCkQuery.setPageNo(1);
        songCkQuery.setPageSize(50);
        JSONObject jsonObject = searchClient.listSongCk(JSON.parseObject(JSON.toJSONString(songCkQuery)));
        log.debug("返回结果: {}", jsonObject);
        return jsonObject;
    }


}
