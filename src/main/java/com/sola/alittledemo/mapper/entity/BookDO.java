package com.sola.alittledemo.mapper.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author Sola
 * @date 2018/10/08
 */
@Data
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "sola_book")
public class BookDO {

    @TableId(value = "book_id", type = IdType.AUTO)
    private Long bookId;

    private String bookName;

    private LocalDateTime ctime;

    private LocalDateTime utime;

}
