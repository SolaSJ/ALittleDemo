package com.sola.alittledemo.service.impl;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sola.alittledemo.annotation.LogTime;
import com.sola.alittledemo.bean.bo.BookBo;
import com.sola.alittledemo.bean.excel.BookExcel;
import com.sola.alittledemo.bean.po.BookImagePo;
import com.sola.alittledemo.bean.po.BookPo;
import com.sola.alittledemo.mapper.BookImageMapper;
import com.sola.alittledemo.mapper.BookMapper;
import com.sola.alittledemo.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sola
 * @date 2018/10/11
 */
@Service
public class BookServiceImpl implements BookService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final BookMapper bookMapper;
    private final BookImageMapper bookImageMapper;

    @Autowired
    public BookServiceImpl(BookMapper bookMapper, BookImageMapper bookImageMapper) {
        this.bookMapper = bookMapper;
        this.bookImageMapper = bookImageMapper;
    }

    @Override
    public Integer insertBook(BookPo bookPo) {
        bookPo.setCtime(LocalDateTime.now());
        bookPo.setUtime(LocalDateTime.now());
        return bookMapper.insert(bookPo);
    }

    @Override
    public BookBo getBook(Long bookId) {
        BookBo bookBo;

        // 查询book
        BookPo bookPo = bookMapper.selectById(bookId);
        if (bookPo == null) {
            return null;
        }
        bookBo = new BookBo();
        BeanUtils.copyProperties(bookPo, bookBo);

        // 查询book关联的imgMd5
        BookImagePo bookImagePo = new BookImagePo();
        bookImagePo.setBookId(bookId);
        Wrapper<BookImagePo> query = new QueryWrapper<>(bookImagePo);
        List<BookImagePo> bookImagePoList = this.bookImageMapper.selectList(query);

        // 组装bookBo关联的数据
        bookBo.setBookImagePoList(bookImagePoList);

        return bookBo;
    }

    @Override
    public List<BookPo> getAllBook() {
        return bookMapper.selectList(null);
    }

    @LogTime("[根据excel导入book数据]")
    @Override
    public Object uploadBook(MultipartFile file) {

        String uploadFilePath = "/file.xls";
        File test = new File(uploadFilePath);
        try {
            file.transferTo(test);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImportParams importParams = new ImportParams();
        String[] importsFields = {"书名"};
        importParams.setImportFields(importsFields);
        List<BookExcel> bookExcelList;
        try {
            bookExcelList = ExcelImportUtil.importExcel(file.getInputStream(), BookExcel.class, importParams);
            log.info("[导入excel] 文件名: {}, 导出结果: {}", test.getName(), JSON.toJSONString(bookExcelList));
        } catch (Exception e) {
            log.error("[导入excel] 导入excel异常, 文件名: {}", test.getName(), e);
            throw new RuntimeException(e);
        }

        // TODO 对于批量插入, 优化效率
        List<BookPo> insertBookList = new ArrayList<>();
        bookExcelList.forEach(bookExcel -> {
            BookPo bookPo = new BookPo();
            BeanUtils.copyProperties(bookExcel, bookPo);
            bookPo.setCtime(LocalDateTime.now());
            bookPo.setUtime(LocalDateTime.now());
            int insert = bookMapper.insert(bookPo);
            if (insert > 0) {
                insertBookList.add(bookPo);
            }
        });
        return insertBookList;
    }

    @Transactional
    @Override
    public Object deleteBook(Long bookId) {
        int i = bookMapper.deleteById(bookId);

        return i;
    }

    @Override
    public Object deleteBooks(List<Long> bookIds) {
        if (bookIds == null || bookIds.isEmpty()) {
            return 0;
        }
        return bookMapper.deleteBatchIds(bookIds);
    }

}
