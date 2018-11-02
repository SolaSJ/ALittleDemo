package com.sola.alittledemo.service.impl;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSON;
import com.sola.alittledemo.annotation.LogTime;
import com.sola.alittledemo.bean.excel.BookExcel;
import com.sola.alittledemo.bean.po.BookPo;
import com.sola.alittledemo.bean.param.BookParam;
import com.sola.alittledemo.mapper.BookMapper;
import com.sola.alittledemo.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Sola
 * @date 2018/10/11
 */
@Service
public class BookServiceImpl implements BookService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private final BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public Integer insertBook(BookPo bookPo) {
        bookPo.setCtime(LocalDateTime.now());
        bookPo.setUtime(LocalDateTime.now());
        return bookMapper.insert(bookPo);
    }

    @Override
    public BookPo getBook(Long bookId) {
        return bookMapper.selectById(bookId);
    }

    @LogTime("[导出excel]")
    @Override
    public Object uploadBook(MultipartFile[] file) {

        MultipartFile file0 = file[0];

        String uploadFilePath = ResourceUtils.CLASSPATH_URL_PREFIX + "file/uploadFile.xls";
        File test = new File(uploadFilePath);
        try {
            file0.transferTo(test);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImportParams importParams = new ImportParams();
        String[] importsFields = {"书号", "书名"};
        importParams.setImportFields(importsFields);
        List<BookExcel> bookExcelList;
        try {
            bookExcelList = ExcelImportUtil.importExcel(file0.getInputStream(), BookParam.class, importParams);
            log.info("[导出excel] 导出结果: {}", JSON.toJSONString(bookExcelList));
        } catch (Exception e) {
            log.error("[导出excel] 导出excel异常, 文件名: {}", file0.getOriginalFilename(), e);
            throw new RuntimeException(e);
        }
        // TODO 对于批量插入, 优化效率
        bookExcelList.forEach(bookExcel -> {
            BookPo bookPo = new BookPo();
            BeanUtils.copyProperties(bookExcel, bookPo);
            bookPo.setCtime(LocalDateTime.now());
            bookPo.setUtime(LocalDateTime.now());
            bookMapper.insert(bookPo);
        });
        return null;
    }

}
