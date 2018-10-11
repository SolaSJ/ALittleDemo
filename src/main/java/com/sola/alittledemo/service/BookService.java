package com.sola.alittledemo.service;

import com.sola.alittledemo.entity.Book;

/**
 * @author Sola
 * @date 2018/10/11
 */
public interface BookService {


    /**
     * 新增book
     *
     * @param book
     * @return
     */
    Integer insertBook(Book book);

    /**
     * 根据id查询book详情
     *
     * @param bookId
     * @return
     */
    Book getBook(Long bookId);

}
