package com.sola.alittledemo.mapper.entity;

/**
 * @author Sola
 * @date 2018/10/16
 */
public class User {

    private Long userId;
    private String name;
    private Integer age;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
