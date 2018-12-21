package com.sola.alittledemo.service;

import com.sola.alittledemo.service.bo.BookBO;

/**
 * @author Sola
 * @date 2018/10/08
 */
public interface UserService {

    /**
     * 执行异步任务
     */
    void testAsync(BookBO book, String name, int age);

    void test();

}
