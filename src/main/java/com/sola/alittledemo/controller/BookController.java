package com.sola.alittledemo.controller;

import com.alibaba.fastjson.JSON;
import com.sola.alittledemo.bean.UpdateGroup;
import com.sola.alittledemo.bean.bo.BookBo;
import com.sola.alittledemo.bean.po.BookImagePo;
import com.sola.alittledemo.bean.po.BookPo;
import com.sola.alittledemo.bean.req.BookReq;
import com.sola.alittledemo.bean.vo.BookVo;
import com.sola.alittledemo.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sola
 * @date 2018/10/08
 */

@Validated
@RestController
public class BookController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/{bookId}")
    public Object getBook(@PathVariable(name = "bookId") @Min(value = 1, message = "bookId最小为1") Long bookId) {
        BookBo bookBo = bookService.getBook(bookId);
        if (bookBo == null) {
            return null;
        }
        BookVo bookVo = new BookVo();
        BeanUtils.copyProperties(bookBo, bookVo);
        List<String> imgMd5s = bookBo.getBookImagePoList().stream().map(BookImagePo::getImgMd5).collect(Collectors.toList());
        bookVo.setImgMd5s(imgMd5s);
        return bookVo;
    }

    @GetMapping("/books")
    public Object getBook(@RequestParam(required = false) String where) {
        // BookReq bookReq = JSON.parseObject(where, BookReq.class);
        List<BookVo> bookVoList = new ArrayList<>();
        bookService.getAllBook().forEach(bookPo -> {
            BookVo bookVo = new BookVo();
            BeanUtils.copyProperties(bookPo, bookVo);
            bookVoList.add(bookVo);
        });
        return bookVoList;
    }

    @PostMapping("/books")
    public Object insertBook(@RequestBody @Validated BookReq bookReq) {
        BookPo bookPo = new BookPo();
        BeanUtils.copyProperties(bookReq, bookPo);
        return bookService.insertBook(bookPo);
    }

    @PostMapping("/books/upload")
    public Object uploadBook(@RequestParam("file") MultipartFile file) {
        return bookService.uploadBook(file);
    }

    @PostMapping("/books/multi")
    public Object insertMultiBooks(@RequestBody @Valid List<BookReq> bookList) {
        return null;
    }

    @PutMapping("/books")
    public Object updateBook(@RequestBody @Validated({UpdateGroup.class}) BookReq bookReq) {
        return null;
    }

    @DeleteMapping("/books/{bookId}")
    public Object deleteBook(@PathVariable("bookId") Long bookId) {
        return bookService.deleteBook(bookId);
    }

    @DeleteMapping("/books")
    public Object deleteBooks(@RequestParam String bookIds) {
        List<Long> list = JSON.parseArray(bookIds, Long.class);
        return bookService.deleteBooks(list);
    }

}
