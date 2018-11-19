package com.sola.alittledemo.bean.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author Sola
 * @date 2018/10/08
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "book")
public class BookPo {

    @TableId(value = "book_id", type = IdType.AUTO)
    private Long bookId;

    private String bookName;

    private LocalDateTime ctime;

    private LocalDateTime utime;

    // public BookPo(Long bookId, String bookName) {
    //     this.bookId = bookId;
    //     this.bookName = bookName;
    // }

}
