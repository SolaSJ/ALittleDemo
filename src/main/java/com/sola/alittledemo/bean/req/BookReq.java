package com.sola.alittledemo.bean.req;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sola.alittledemo.bean.UpdateGroup;
import com.sola.alittledemo.entity.User;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Sola
 * @date 2018/10/08
 */
@TableName(value = "book")
public class BookReq {

    @TableId(value = "book_id", type = IdType.AUTO)
    @NotNull(message = "bookId不能为null", groups = {UpdateGroup.class})
    private Long bookId;

    @NotNull
    private String bookName;

    private String image;

    @TableField(exist = false)
    private List<String> chapters;

    private List<User> users;

    private LocalDateTime ctime;

    private LocalDateTime utime;

    public BookReq() {

    }

    public BookReq(Long bookId, String bookName) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getChapters() {
        return chapters;
    }

    public void setChapters(List<String> chapters) {
        this.chapters = chapters;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "BookReq{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", chapters=" + chapters +
                '}';
    }

}
