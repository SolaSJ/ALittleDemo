package com.sola.alittledemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sola.alittledemo.service.bo.BookBO;
import com.sola.alittledemo.mapper.entity.BookDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Sola
 * @date 2018/10/11
 */
@Mapper
public interface BookMapper extends BaseMapper<BookDO> {

    /**
     * 查询book列表
     *
     * @param bookBo
     * @return
     */
    List<BookDO> listBooks(@Param("query") BookBO bookBo);

}
