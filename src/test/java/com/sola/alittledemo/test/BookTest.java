package com.sola.alittledemo.test;

import com.sola.alittledemo.mapper.entity.BookDO;
import com.sola.alittledemo.mapper.BookMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Sola
 * @date 2018/11/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<BookDO> userList = bookMapper.selectList(null);
        Assert.assertEquals(17, userList.size());
        userList.forEach(System.out::println);
    }

}
