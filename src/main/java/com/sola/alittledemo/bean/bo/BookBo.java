package com.sola.alittledemo.bean.bo;

import com.sola.alittledemo.bean.po.BookImagePo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Sola
 * @date 2018/11/08
 */
public class BookBo {

    private Long bookId;

    private String bookName;

    private List<BookImagePo> bookImagePoList;

    private LocalDateTime ctime;

    private LocalDateTime utime;

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

    public List<BookImagePo> getBookImagePoList() {
        return bookImagePoList;
    }

    public void setBookImagePoList(List<BookImagePo> bookImagePoList) {
        this.bookImagePoList = bookImagePoList;
    }

    public LocalDateTime getCtime() {
        return ctime;
    }

    public void setCtime(LocalDateTime ctime) {
        this.ctime = ctime;
    }

    public LocalDateTime getUtime() {
        return utime;
    }

    public void setUtime(LocalDateTime utime) {
        this.utime = utime;
    }
}
