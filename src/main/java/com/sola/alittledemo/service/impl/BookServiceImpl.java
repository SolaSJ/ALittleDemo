package com.sola.alittledemo.service.impl;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sola.alittledemo.common.annotation.Log;
import com.sola.alittledemo.controller.excel.BookExcel;
import com.sola.alittledemo.service.bo.BookBO;
import com.sola.alittledemo.mapper.entity.BookDO;
import com.sola.alittledemo.mapper.entity.BookImageDO;
import com.sola.alittledemo.mapper.BookImageMapper;
import com.sola.alittledemo.mapper.BookMapper;
import com.sola.alittledemo.service.IBookService;
import lombok.extern.slf4j.Slf4j;
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
import java.util.stream.Collectors;

/**
 * @author Sola
 * @date 2018/10/11
 */
@Slf4j
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, BookDO> implements IBookService {

    private final BookMapper bookMapper;
    private final BookImageMapper bookImageMapper;

    @Autowired
    public BookServiceImpl(BookMapper bookMapper, BookImageMapper bookImageMapper) {
        this.bookMapper = bookMapper;
        this.bookImageMapper = bookImageMapper;
    }

    @Override
    public int insertBook(BookDO bookDO) {
        LocalDateTime now = LocalDateTime.now();
        return bookMapper.insert(bookDO.setCtime(now).setUtime(now));
    }

    @Override
    public BookBO getBook(Long bookId) {
        // 查询book
        BookDO bookDO = bookMapper.selectById(bookId);
        if (bookDO == null) {
            return null;
        }

        // 查询book关联的imgMd5
        BookImageDO query = BookImageDO.builder().bookId(bookId).build();
        List<BookImageDO> bookImageDOS = bookImageMapper.selectList(new QueryWrapper<>(query));

        // 组装bookBo关联的数据
        BookBO bookBo = new BookBO();
        BeanUtils.copyProperties(bookDO, bookBo);
        bookBo.setBookImages(bookImageDOS);

        return bookBo;
    }

    @Override
    public List<BookBO> listBooks(BookBO bookBo) {
        List<BookDO> bookDOS = bookMapper.listBooks(bookBo);

        return bookDOS.stream().map(po -> {
            BookBO bo = new BookBO();
            BeanUtils.copyProperties(po, bo);
            return bo;
        }).collect(Collectors.toList());
    }

    @Log("[根据excel导入book数据]")
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
        List<BookDO> insertBookList = new ArrayList<>();
        bookExcelList.forEach(bookExcel -> {
            BookDO bookDO = new BookDO();
            BeanUtils.copyProperties(bookExcel, bookDO);
            bookDO.setCtime(LocalDateTime.now());
            bookDO.setUtime(LocalDateTime.now());
            int insert = bookMapper.insert(bookDO);
            if (insert > 0) {
                insertBookList.add(bookDO);
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
