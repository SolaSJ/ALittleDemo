package com.sola.alittledemo.bean.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Sola
 * @date 2018/11/08
 */
@Data
@TableName(value = "book_image")
public class BookImagePo {

    @TableField(value = "book_id")
    private Long bookId;

    @TableField(value = "img_md5")
    private String imgMd5;

}
