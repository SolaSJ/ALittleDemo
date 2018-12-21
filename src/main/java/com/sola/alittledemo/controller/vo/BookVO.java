package com.sola.alittledemo.controller.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sola.alittledemo.mapper.entity.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Sola
 * @date 2018/10/25
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookVO {

    private Long bookId;

    private String bookName;

    @JsonProperty(value = "createTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime ctime;

    @JsonProperty(value = "updateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime utime;

    List<String> imgMd5s;

    private List<String> chapters;

    private List<User> users;

}
