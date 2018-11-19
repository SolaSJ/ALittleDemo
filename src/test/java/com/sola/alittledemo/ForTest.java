package com.sola.alittledemo;

import com.sola.alittledemo.bean.EmotionalTagResp;
import com.sola.alittledemo.bean.po.BookPo;
import com.sola.alittledemo.constant.TimeDimensionEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sola
 * @date 2018/11/01
 */
public class ForTest {

    private static final Logger log = LoggerFactory.getLogger(ForTest.class);

    public static void main(String[] args) {


        BookPo bookPo = null;
        if (bookPo instanceof BookPo) {
            System.out.println("222");
        } else {

        }

        List<BookPo> bookPoList = new ArrayList<>();
        bookPoList.add(new BookPo(1L, "324", null, null));
        bookPoList.add(new BookPo(2L, "324", null, null));
        Map<String, String> collect = bookPoList.stream().collect(Collectors.toMap(o -> String.valueOf(o.getBookId()), BookPo::getBookName));

        String s111 = "MONTH";
        TimeDimensionEnum.contains(s111);

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

    private List<EmotionalTagResp.DataBean> filterAndSort(List<EmotionalTagResp.DataBean> dataBeans, double score) {
        if (dataBeans == null) {
            return new ArrayList<>();
        }
        return dataBeans.stream()
                .filter(dataBean -> dataBean.getScore() >= score)
                .sorted(Comparator.comparingDouble(EmotionalTagResp.DataBean::getScore).reversed())
                .collect(Collectors.toList());
    }

}
