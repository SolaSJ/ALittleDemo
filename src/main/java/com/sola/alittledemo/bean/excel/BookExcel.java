package com.sola.alittledemo.bean.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @author Sola
 * @date 2018/10/17
 */
public class BookExcel {

    @Excel(name = "书号")
    private Long bookId;

    @Excel(name = "书名")
    private String bookName;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

}
