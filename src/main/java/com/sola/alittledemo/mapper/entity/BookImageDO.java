package com.sola.alittledemo.mapper.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Sola
 * @date 2018/11/08
 */
@Data
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "book_image")
public class BookImageDO {

    @TableField(value = "book_id")
    private Long bookId;

    @TableField(value = "img_md5")
    private String imgMd5;

}
