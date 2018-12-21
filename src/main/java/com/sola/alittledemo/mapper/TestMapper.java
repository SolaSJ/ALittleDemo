package com.sola.alittledemo.mapper;

import com.sola.alittledemo.mapper.entity.BookDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Sola
 * @date 2018/12/13
 */
@Mapper
public interface TestMapper {

    BookDO test();

}
