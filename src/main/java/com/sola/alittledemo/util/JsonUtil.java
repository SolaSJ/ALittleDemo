package com.sola.alittledemo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Sola
 * @date 2018/11/01
 */
public class JsonUtil {

    private JSONObject json;

    public JsonUtil(JSONObject json) {
        Objects.requireNonNull(json);
        this.json = json;
    }

    public JsonUtil(Map<String, Object> json) {
        Objects.requireNonNull(json);
        this.json = JSONObject.parseObject(JSON.toJSONString(json));
    }

    public String json2Str(String arrKey, String key, String separator) {
        return Optional.ofNullable(json.getJSONArray(arrKey))
                .map(array -> array.stream()
                        .map(o -> ((JSONObject) o).get(key))
                        .map(String::valueOf)
                        .collect(Collectors.joining(separator)))
                .orElse(null);
    }

}
