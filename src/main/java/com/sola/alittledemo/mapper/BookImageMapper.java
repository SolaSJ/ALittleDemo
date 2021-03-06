package com.sola.alittledemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sola.alittledemo.mapper.entity.BookImageDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Sola
 * @date 2018/11/08
 */
@Mapper
public interface BookImageMapper extends BaseMapper<BookImageDO> {
}
