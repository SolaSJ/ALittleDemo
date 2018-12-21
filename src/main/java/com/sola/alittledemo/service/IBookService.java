package com.sola.alittledemo.service;

import com.sola.alittledemo.service.bo.BookBO;
import com.sola.alittledemo.mapper.entity.BookDO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Sola
 * @date 2018/10/11
 */
public interface IBookService {

    /**
     * 新增book
     *
     * @param bookDO
     * @return
     */
    int insertBook(BookDO bookDO);

    /**
     * 根据id查询book详情
     *
     * @param bookId
     * @return
     */
    BookBO getBook(Long bookId);

    /**
     * 查询book列表
     *
     * @param bookBo
     * @return
     */
    List<BookBO> listBooks(BookBO bookBo);

    /**
     * 上传book excel
     *
     * @param file
     * @return
     */
    Object uploadBook(MultipartFile file);

    /**
     * 根据bookId删除
     *
     * @param bookId
     * @return
     */
    Object deleteBook(Long bookId);

    /**
     * 根据bookId数组删除
     *
     * @param bookIds
     * @return
     */
    Object deleteBooks(List<Long> bookIds);

}
