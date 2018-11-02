package com.sola.alittledemo.service;

import com.sola.alittledemo.bean.po.BookPo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Sola
 * @date 2018/10/11
 */
public interface BookService {

    /**
     * 新增book
     *
     * @param bookPo
     * @return
     */
    Integer insertBook(BookPo bookPo);

    /**
     * 根据id查询book详情
     *
     * @param bookId
     * @return
     */
    BookPo getBook(Long bookId);

    /**
     * 上传book excel
     *
     * @param file
     * @return
     */
    Object uploadBook(MultipartFile[] file);

}
