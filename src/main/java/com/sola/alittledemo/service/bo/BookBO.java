package com.sola.alittledemo.service.bo;

import com.sola.alittledemo.common.annotation.Image;
import com.sola.alittledemo.mapper.entity.BookImageDO;
import com.sola.alittledemo.mapper.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Sola
 * @date 2018/11/08
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookBO {

    private Long bookId;

    @NotNull(message = "bookName不能为空")
    private String bookName;

    @Image(message = "bookImage必须以.jpg结尾")
    private List<String> imgMd5s;

    private LocalDateTime ctime;

    private LocalDateTime utime;

    private List<BookImageDO> bookImages;

    private List<User> users;

    private List<Long> bookIds;

    private List<String> bookNames;

}
