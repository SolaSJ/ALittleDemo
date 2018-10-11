package com.sola.alittledemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Sola
 * @date 2018/10/08
 */
@TableName(value = "book")
public class Book {

    @TableId(value = "book_id", type = IdType.AUTO)
    private Long bookId;

    @NotBlank(message = "bookName不能为null或''")
    private String bookName;

    @TableField(exist = false)
    private List<String> chapters;

    private LocalDateTime ctime;
    private LocalDateTime utime;

    public Book() {

    }

    public Book(Long bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

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

    public List<String> getChapters() {
        return chapters;
    }

    public void setChapters(List<String> chapters) {
        this.chapters = chapters;
    }

    public LocalDateTime getCtime() {
        // return ctime != null ? ctime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")) : null;
        return ctime;
    }

    public void setCtime(LocalDateTime ctime) {
        this.ctime = ctime;
    }

    public LocalDateTime getUtime() {
        // return utime != null ? utime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")) : null;
        return utime;
    }

    public void setUtime(LocalDateTime utime) {
        this.utime = utime;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", chapters=" + chapters +
                '}';
    }

}
