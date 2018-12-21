package com.sola.alittledemo.controller.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sola
 * @date 2018/10/17
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookExcel {

    @Excel(name = "书号")
    private Long bookId;

    @Excel(name = "书名")
    private String bookName;

}
