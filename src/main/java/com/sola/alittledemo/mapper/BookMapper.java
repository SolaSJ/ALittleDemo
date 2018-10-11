package com.sola.alittledemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sola.alittledemo.entity.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Sola
 * @date 2018/10/11
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
