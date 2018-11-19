package com.sola.alittledemo.note;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sola.alittledemo.bean.req.BookReq;
import com.sola.alittledemo.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Sola
 * @date 2018/10/11
 */
public class OptionalNote {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public void note(Long bookId) {
        BookReq book1 = new BookReq(bookId, "defaultBookName");

        // Optional构造方式,
        //
        // Optional.of(obj), Optional.ofNullable(obj)和Optional.empty()
        Optional<BookReq> bookOpt1 = Optional.of(book1);
        // 如果不能确定是否为空, 建议使用ofNullable()
        Optional<BookReq> bookOpt2 = Optional.ofNullable(book1);
        Optional<BookReq> bookOpt3 = Optional.ofNullable(null);

        // Optional的应用
        //
        // Optional中可依赖的应该是除了 isPresent()和get()的其他方法:
        // public<U> Optional<U> map(Function<? super T, ? extends U> mapper)
        // public T orElse(T other)
        // public T orElseGet(Supplier<? extends T> other)
        // public void ifPresent(Consumer<? super T> consumer)
        // public Optional<T> filter(Predicate<? super T> predicate)
        // public<U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper)
        // public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X

        // 如果不为null返回bookPo, 否则返回null, 而不是 return user.isPresent() ? user.get() : null;
        BookReq book2 = bookOpt3.orElse(null);
        BookReq book3 = bookOpt3.orElseGet(this::getBook);
        // 而不要 if (user.isPresent()) {}
        bookOpt1.ifPresent(System.out::println);

        // 关于map的使用
        String[] arr = {"第一章", "第二章"};
        book1.setChapters(Stream.of(arr).collect(Collectors.toList()));
        List<String> chapters = bookOpt1.map(BookReq::getChapters).orElse(new ArrayList<>());
        chapters.forEach(System.out::print);

        String bookName = null;
        if (book1 != null) {
            bookName = book1.getBookName();
            if (bookName != null) {
                bookName = bookName.toUpperCase();
            }
        }
        log.info("bookName: {}", bookName);

        // 结合lambda表达式的写法
        book1.setBookName(null);
        String bookName1 = bookOpt1.map(BookReq::getBookName).map(String::toUpperCase).orElse(null);
        log.info("bookName1: {}", bookName1);
    }

    private BookReq getBook() {
        return new BookReq();
    }

    private void demo() {
        JSONObject jsonObject = JSON.parseObject("{\n" +
                                                         "  \"splits\": null,\n" +
                                                         "  \"tagStatus\": 0,\n" +
                                                         "  \"language\": null,\n" +
                                                         "  \"primitiveName\": null,\n" +
                                                         "  \"type\": 1,\n" +
                                                         "  \"versionName\": null,\n" +
                                                         "  \"score\": null,\n" +
                                                         "  \"songDescs\": [],\n" +
                                                         "  \"orchestra\": null,\n" +
                                                         "  \"songNameOnly\": \"我们都一样\",\n" +
                                                         "  \"ctime\": 1534401087000,\n" +
                                                         "  \"copyrightCompany\": null,\n" +
                                                         "  \"songId\": 1110196853,\n" +
                                                         "  \"cantors\": [],\n" +
                                                         "  \"singers\": [],\n" +
                                                         "  \"manualScore\": null,\n" +
                                                         "  \"publishTime\": null,\n" +
                                                         "  \"mergeId\": null,\n" +
                                                         "  \"trackNumber\": null,\n" +
                                                         "  \"versionInfo\": null,\n" +
                                                         "  \"arranger\": null,\n" +
                                                         "  \"songArtistOnly\": null,\n" +
                                                         "  \"quality\": null,\n" +
                                                         "  \"tagUid\": null,\n" +
                                                         "  \"tags\": [\n" +
                                                         "    {\n" +
                                                         "      \"tagMzkState\": 0,\n" +
                                                         "      \"tagId\": 1000001808,\n" +
                                                         "      \"id\": 39308266,\n" +
                                                         "      \"sort\": 170000,\n" +
                                                         "      \"type\": 0,\n" +
                                                         "      \"tagName\": \"R&B\",\n" +
                                                         "      \"parentId\": 1001075745\n" +
                                                         "    },\n" +
                                                         "    {\n" +
                                                         "      \"tagMzkState\": 0,\n" +
                                                         "      \"tagId\": 1000001642,\n" +
                                                         "      \"id\": 39308261,\n" +
                                                         "      \"sort\": 511000,\n" +
                                                         "      \"type\": 0,\n" +
                                                         "      \"tagName\": \"世界民族音乐\",\n" +
                                                         "      \"parentId\": 1001075747\n" +
                                                         "    },\n" +
                                                         "    {\n" +
                                                         "      \"tagMzkState\": 0,\n" +
                                                         "      \"tagId\": 1002241227,\n" +
                                                         "      \"id\": 39308262,\n" +
                                                         "      \"sort\": 537000,\n" +
                                                         "      \"type\": 0,\n" +
                                                         "      \"tagName\": \"热带音乐\",\n" +
                                                         "      \"parentId\": 1000001642\n" +
                                                         "    },\n" +
                                                         "    {\n" +
                                                         "      \"tagMzkState\": 0,\n" +
                                                         "      \"tagId\": 1000001762,\n" +
                                                         "      \"id\": 39308264,\n" +
                                                         "      \"sort\": 565000,\n" +
                                                         "      \"type\": 15,\n" +
                                                         "      \"tagName\": \"国语\",\n" +
                                                         "      \"parentId\": 1001075733\n" +
                                                         "    },\n" +
                                                         "    {\n" +
                                                         "      \"tagMzkState\": 0,\n" +
                                                         "      \"tagId\": 1000001693,\n" +
                                                         "      \"id\": 39308263,\n" +
                                                         "      \"sort\": 715000,\n" +
                                                         "      \"type\": 0,\n" +
                                                         "      \"tagName\": \"激情\",\n" +
                                                         "      \"parentId\": 1003449580\n" +
                                                         "    },\n" +
                                                         "    {\n" +
                                                         "      \"tagMzkState\": 0,\n" +
                                                         "      \"tagId\": 1000001634,\n" +
                                                         "      \"id\": 39308265,\n" +
                                                         "      \"sort\": 752000,\n" +
                                                         "      \"type\": 0,\n" +
                                                         "      \"tagName\": \"咖啡馆\",\n" +
                                                         "      \"parentId\": 1001075737\n" +
                                                         "    }\n" +
                                                         "  ],\n" +
                                                         "  \"sysScore\": null,\n" +
                                                         "  \"translationName\": null,\n" +
                                                         "  \"status\": 10,\n" +
                                                         "  \"songName\": \"我们都一样\",\n" +
                                                         "  \"albums\": [\n" +
                                                         "    {\n" +
                                                         "      \"imgUrl\": \"23da5aac1e7c5052aee10a908895795a\",\n" +
                                                         "      \"albumName\": \"明天\",\n" +
                                                         "      \"albumId\": 1110196852,\n" +
                                                         "      \"songId\": 1110196853,\n" +
                                                         "      \"karakalStatus\": 10,\n" +
                                                         "      \"status\": 12\n" +
                                                         "    }\n" +
                                                         "  ],\n" +
                                                         "  \"composers\": [\n" +
                                                         "    {\n" +
                                                         "      \"imgUrl\": \"844856f1ef482b22550681f1bb33309b\",\n" +
                                                         "      \"artistId\": 1004674382,\n" +
                                                         "      \"artistName\": \"张大大\",\n" +
                                                         "      \"songId\": 1110196853,\n" +
                                                         "      \"karakalStatus\": 10,\n" +
                                                         "      \"artistSort\": 1,\n" +
                                                         "      \"status\": 10\n" +
                                                         "    }\n" +
                                                         "  ],\n" +
                                                         "  \"hotScore\": 0.0,\n" +
                                                         "  \"isolated\": 0,\n" +
                                                         "  \"description\": null,\n" +
                                                         "  \"lyricId\": \"\",\n" +
                                                         "  \"istag\": 1,\n" +
                                                         "  \"uid\": 63,\n" +
                                                         "  \"artists\": [\n" +
                                                         "    {\n" +
                                                         "      \"imgUrl\": \"\",\n" +
                                                         "      \"artistId\": 1000057314,\n" +
                                                         "      \"artistName\": \"卓琇琴\",\n" +
                                                         "      \"songId\": 1110196853,\n" +
                                                         "      \"karakalStatus\": 10,\n" +
                                                         "      \"artistSort\": 1,\n" +
                                                         "      \"status\": 12\n" +
                                                         "    }\n" +
                                                         "  ],\n" +
                                                         "  \"playTime\": null,\n" +
                                                         "  \"tuttiband\": null,\n" +
                                                         "  \"cids\": {\n" +
                                                         "    \"commercial\": \"是\",\n" +
                                                         "    \"coprPrice\": \"200\",\n" +
                                                         "    \"fullmusicAction\": \"2\",\n" +
                                                         "    \"dataAlbum\": 0,\n" +
                                                         "    \"walkmanId\": \"600701015383600908000004562456\",\n" +
                                                         "    \"colorringAction\": \"4\",\n" +
                                                         "    \"coprTerm\": 1546185600000,\n" +
                                                         "    \"coprCompany\": \"相信音乐文化传媒（北京）有限公司\",\n" +
                                                         "    \"fullmusicId\": \"600701015382600908000004562455\",\n" +
                                                         "    \"copyrightType\": 10,\n" +
                                                         "    \"callringId\": \"600701015381600908000004562454\",\n" +
                                                         "    \"callringAction\": \"2\",\n" +
                                                         "    \"copyrightStatus\": 1,\n" +
                                                         "    \"copyrightId\": \"60070101538\",\n" +
                                                         "    \"netImport\": \"否\",\n" +
                                                         "    \"colorringId\": \"600908000004562453\",\n" +
                                                         "    \"walkmanAction\": \"2\",\n" +
                                                         "    \"losslessId\": \"60070101538E600908000005282524\",\n" +
                                                         "    \"losslessAction\": \"0\",\n" +
                                                         "    \"songId\": 1110196853,\n" +
                                                         "    \"karakalStatus\": 10\n" +
                                                         "  },\n" +
                                                         "  \"lyricsers\": [\n" +
                                                         "    {\n" +
                                                         "      \"imgUrl\": \"844856f1ef482b22550681f1bb33309b\",\n" +
                                                         "      \"artistId\": 1004674382,\n" +
                                                         "      \"artistName\": \"张大大\",\n" +
                                                         "      \"songId\": 1110196853,\n" +
                                                         "      \"karakalStatus\": 10,\n" +
                                                         "      \"artistSort\": 1,\n" +
                                                         "      \"status\": 10\n" +
                                                         "    }\n" +
                                                         "  ],\n" +
                                                         "  \"originals\": [],\n" +
                                                         "  \"lyrics\": [],\n" +
                                                         "  \"bpm\": null,\n" +
                                                         "  \"tagExt\": null,\n" +
                                                         "  \"tagTaskId\": null,\n" +
                                                         "  \"performer\": null,\n" +
                                                         "  \"performers\": [],\n" +
                                                         "  \"utime\": 1537517979000,\n" +
                                                         "  \"copyrights\": [\n" +
                                                         "    {\n" +
                                                         "      \"coprPrice\": \"200\",\n" +
                                                         "      \"fullmusicAction\": \"2\",\n" +
                                                         "      \"dataAlbum\": 0,\n" +
                                                         "      \"walkmanId\": \"600701015383600908000004562456\",\n" +
                                                         "      \"colorringAction\": \"4\",\n" +
                                                         "      \"coprTerm\": 1546185600000,\n" +
                                                         "      \"coprCompany\": \"相信音乐文化传媒（北京）有限公司\",\n" +
                                                         "      \"fullmusicId\": \"600701015382600908000004562455\",\n" +
                                                         "      \"copyrightType\": 10,\n" +
                                                         "      \"callringId\": \"600701015381600908000004562454\",\n" +
                                                         "      \"callringAction\": \"2\",\n" +
                                                         "      \"copyrightStatus\": 1,\n" +
                                                         "      \"copyrightId\": \"60070101538\",\n" +
                                                         "      \"colorringId\": \"600908000004562453\",\n" +
                                                         "      \"walkmanAction\": \"2\",\n" +
                                                         "      \"losslessId\": \"60070101538E600908000005282524\",\n" +
                                                         "      \"losslessAction\": \"0\",\n" +
                                                         "      \"songId\": 1110196853,\n" +
                                                         "      \"karakalStatus\": 10\n" +
                                                         "    }\n" +
                                                         "  ],\n" +
                                                         "  \"composer\": null,\n" +
                                                         "  \"songAliasName\": null,\n" +
                                                         "  \"length\": 5,\n" +
                                                         "  \"playband\": null,\n" +
                                                         "  \"maker\": null,\n" +
                                                         "  \"belongArtists\": [],\n" +
                                                         "  \"lyricser\": null,\n" +
                                                         "  \"imgUrl\": null,\n" +
                                                         "  \"publishCompany\": null,\n" +
                                                         "  \"recordTime\": null,\n" +
                                                         "  \"firstAlbumId\": null,\n" +
                                                         "  \"mstat\": 0,\n" +
                                                         "  \"fingerprintId\": null,\n" +
                                                         "  \"chorus\": null,\n" +
                                                         "  \"cantor\": null,\n" +
                                                         "  \"karakalStatus\": 10,\n" +
                                                         "  \"taskId\": null\n" +
                                                         "}");

        JsonUtil jsonUtil = new JsonUtil(jsonObject);

        String s = jsonUtil.json2Str("tags", "tagName", ", ");
    }

}
