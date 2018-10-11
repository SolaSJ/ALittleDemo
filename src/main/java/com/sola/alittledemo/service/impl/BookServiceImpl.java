package com.sola.alittledemo.service.impl;

import com.sola.alittledemo.entity.Book;
import com.sola.alittledemo.mapper.BookMapper;
import com.sola.alittledemo.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Sola
 * @date 2018/10/11
 */
@Service
public class BookServiceImpl implements BookService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private final BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public Integer insertBook(Book book) {
        book.setCtime(LocalDateTime.now());
        book.setUtime(LocalDateTime.now());
        return bookMapper.insert(book);
    }

    @Override
    public Book getBook(Long bookId) {
        Book book = bookMapper.selectById(bookId);
        return book;
    }

}
