package com.sola.alittledemo.service;

import com.sola.alittledemo.entity.Book;

/**
 * @author Sola
 * @date 2018/10/08
 */
public interface UserService {

    /**
     * 执行异步任务
     */
    void testAsync(Book book, String name, int age);

    void test();

}
