package com.sola.alittledemo.controller.vo;

import com.sola.alittledemo.mapper.entity.BookImageDO;
import com.sola.alittledemo.service.bo.BookBO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * book工具类
 *
 * @author Sola
 * @date 2018/11/20
 */
public class BookUtils {

    public static void copy(BookBO bookBo, BookVO bookVo) {
        Objects.requireNonNull(bookVo);
        Optional.ofNullable(bookBo).ifPresent(bo -> {
            BeanUtils.copyProperties(bo, bookVo);
            Optional.ofNullable(bo.getBookImages())
                    .ifPresent(bookImagePos ->
                                       bookVo.setImgMd5s(bookImagePos.stream().map(BookImageDO::getImgMd5).collect(Collectors.toList())));
        });
    }

    public static void copy(List<BookBO> bookBOS, List<BookVO> bookVOS) {
        Objects.requireNonNull(bookVOS);
        Optional.ofNullable(bookBOS).ifPresent(bookList -> bookList.forEach(bo -> {
            BookVO vo = new BookVO();
            copy(bo, vo);
            bookVOS.add(vo);
        }));
    }

}
