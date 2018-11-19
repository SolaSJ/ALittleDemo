package com.sola.alittledemo.service;

import com.sola.alittledemo.bean.bo.BookBo;
import com.sola.alittledemo.bean.po.BookPo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
    BookBo getBook(Long bookId);

    /**
     * 查询所有book
     *
     * @return
     */
    List<BookPo> getAllBook();

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
