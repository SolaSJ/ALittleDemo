package com.sola.alittledemo;

import com.alibaba.fastjson.JSON;
import com.sola.alittledemo.service.bo.BookBO;
import com.sola.alittledemo.mapper.entity.BookDO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sola
 * @date 2018/11/01
 */
public class ForTest {

    private static final Logger log = LoggerFactory.getLogger(ForTest.class);

    private static final String TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static String formatTimestamp(Timestamp timestamp) {
        return Optional.ofNullable(timestamp).map(stamp -> {
            Instant instant = Instant.ofEpochMilli(stamp.getTime());
            ZoneId zone = ZoneId.systemDefault();
            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_PATTERN);
            return localDateTime.format(formatter);
        }).orElse(null);
    }


    public static void main(String[] args) throws UnsupportedEncodingException {

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();

        objectObjectHashMap.get(null);


        List<Mv> mvs = new ArrayList<>();

        mvs.add(new Mv(1, "aaa", "bbbb", "aaa"));
        mvs.add(new Mv(2, "aaa11", "aaaa", "ccc"));
        mvs.add(new Mv(3, "aaa22", "bbbb", "aaaa"));
        mvs.add(new Mv(4, "aaa33", "bbbb", "ccc"));
        mvs.add(new Mv(5, "ccc", "aaa", "aaa"));
        mvs.add(new Mv(6, "aaa", "bbbb", "aaa"));

        // Optional<Book> expensive = mvs.stream().collect();


        Map<Integer, List<Mv>> map1 = new HashMap<>();
        Set<Mv> set = new HashSet<>();
        for (int i = 0; i < mvs.size(); i++) {
            for (int j = 0; j < mvs.size(); j++) {
                if (i != j && mvs.get(i).equals(mvs.get(j)) && !set.contains(mvs.get(i)) && !set.contains(mvs.get(j))) {
                    List<Mv> list = new ArrayList<>();
                    list.add(mvs.get(i));
                    list.add(mvs.get(j));
                    set.add(mvs.get(i));
                    set.add(mvs.get(j));
                    map1.put(i, list);
                }
            }
        }
        //
        // mvs.forEach(mv -> {
        //     int i = 0;
        //     mvs.forEach(mv1 -> {
        //
        //     });
        // });

        // List<Mv> collect3 = mvs.stream()
        //         .collect(Collectors.collectingAndThen(Collectors.toCollection(() -> {
        //
        //         }, ArrayList::new));


        // List<ClassEntity> distinctClass = classEntities.stream()
        //         .collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getProfessionId() + ";" + o.getGrade()))), ArrayList::new));
        //

        log.info("结果: {}, 结果: {}", null, "111");

        String s4 = JSON.toJSONString(null);

        com.google.common.base.Preconditions.checkArgument(4 < 3, "失败", "不能大于等于3");


        List<String> arr = new ArrayList<String>() {

        };


        Optional.ofNullable(arr).filter(list -> !list.isEmpty()).ifPresent(list -> {
            String collect = list.stream().filter(Objects::nonNull).collect(Collectors.joining(","));
        });

        // String collect3 = arr;

        Timestamp timestamp = new Timestamp(Instant.now().getEpochSecond());
        String s3 = ForTest.formatTimestamp(null);

        String sss = "你好啊啊啊";
        int length = sss.length();
        byte[] bytes = sss.getBytes("utf-16");
        int length1 = bytes.length;

        String sss1 = "qwqwq";
        int length2 = sss1.getBytes("utf-16").length;


        List<Map<String, Object>> ts = null;
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> m = new HashMap<>();
        map.put("test", 11);
        if (ts != null && ts.size() > 0) {
            m.put("ckUser", ts.get(0));
        }

        Optional.ofNullable(ts).filter(maps -> !maps.isEmpty()).ifPresent(maps -> m.put("ckUser", maps.get(0)));


        BookDO bookDO = new BookDO();

        String splitStr = "--12123";
        String[] split = splitStr.split("-");
        Optional.ofNullable(split[0]).filter(StringUtils::isNotBlank).ifPresent(log::info);
        Optional.ofNullable(split[1]).filter(StringUtils::isNotBlank).ifPresent(log::info);
        Optional.ofNullable(split[2]).filter(StringUtils::isNotBlank).ifPresent(log::info);

        // bookDO.setBookName("   ");
        String s2 = Optional.ofNullable(bookDO).map(BookDO::getBookName).filter(StringUtils::isNotBlank).orElse(null);

        List<BookDO> bookDOList = new ArrayList<>();
        bookDOList.add(BookDO.builder().bookId(1L).bookName("1212").build());
        bookDOList.add(BookDO.builder().bookId(2L).bookName("1111").build());
        Map<String, String> collect = bookDOList.stream().collect(Collectors.toMap(o -> String.valueOf(o.getBookId()), BookDO::getBookName));

        String collect1 = bookDOList.stream().map(BookDO::getBookName).sorted(Comparator.reverseOrder()).collect(Collectors.joining("_"));

        List<BookBO> collect2 = bookDOList.stream().map(bookPo -> {
            BookBO bookBo = new BookBO();
            bookBo.setBookName(bookPo.getBookName());
            return bookBo;
        }).collect(Collectors.toList());

        String s111 = "MONTH";

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowMin7 = now.minusDays(7);
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String format = now.format(pattern);

        String format1 = nowMin7.format(pattern);

        String s = "eyJzdGF0ZSI6eyJjb2RlIjoyMDAsIm1zZyI6Im9rIiwiZW5Nc2ciOiJvayJ9LCJkYXRhIjpbeyJzY29yZSI6MC4xNSwidGFncyI6IuW/q+S5kCJ9LHsic2NvcmUiOjAuMTIsInRhZ3MiOiLmlL7mnb4ifSx7InNjb3JlIjowLjEyLCJ0YWdzIjoi55Sc6JycIn1dfQ==";
        byte[] decode = Base64.getDecoder().decode(s);
        String s1 = new String(decode);

        ForTest forTest = new ForTest();
        // Long[] songIds = {123123L, 23234L, 234234L, null, 546456L, 654654L};
        // String[] copyrightIds = {" aksdfjla ", null, "   asldkfjslak", "  ytutyru", "56756gfhd", "asdlfkj"};
        // List<Long> longs = Arrays.asList(songIds);
        //
        // final String or = " or ";
        // final String and = " and ";
        //
        // StringBuilder sql = new StringBuilder();
        // StringBuilder temp;
        // // 拼接sql 存储起来
        // for (int i = 0; i < longs.size(); i++) {
        //     Long songId = longs.get(i);
        //     String copyright = copyrightIds[i];
        //
        //     temp = new StringBuilder();
        //     if (songId != null) {
        //         temp.append(and).append("s.song_id = ").append(songId);
        //     }
        //     if (copyright != null) {
        //         temp.append(and).append("kc.copyright_id = '").append(copyright.trim()).append("'");
        //     }
        //     new ForTest().deletePrefix(temp, and);
        //     if (temp.length() > 0) {
        //         sql.append(or).append("(").append(temp).append(")");
        //     }
        // }
        // new ForTest().deletePrefix(sql, or);
        //
        // log.info(sql.toString());
    }

    private void deletePrefix(StringBuilder sb, String prefix) {
        if (sb.toString().startsWith(prefix)) {
            sb.delete(0, prefix.length());
        }
    }

}
