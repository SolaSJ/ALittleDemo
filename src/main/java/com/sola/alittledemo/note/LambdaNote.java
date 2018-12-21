package com.sola.alittledemo.note;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author Sola
 * @date 2018/11/02
 */
public class LambdaNote {

    private static final Logger log = LoggerFactory.getLogger(LambdaNote.class);

    // {
    //     Arrays.asList()
    //     new BookDO();
    // }

    public static void main(String[] args) {
        List<Object> integerList = new ArrayList<>(Arrays.asList(1, 2, 3, null, null, 4, ""));
        integerList.add(4);
        integerList.add(null);

        // Optional<List<Integer>> integerListOpt = Optional.ofNullable(integerList);
        // String collect = integerListOpt.orElse(new ArrayList<>())
        //         .stream()
        //         .filter(Objects::nonNull)
        //         .map(String::valueOf)
        //         .collect(Collectors.joining(", "));
        //
        //
        // List<Integer> integerList1 = null;
        // List<String> collect1 = Optional.ofNullable(integerList1).orElse(new ArrayList<>())
        //         .stream()
        //         .map(String::valueOf)
        //         .collect(Collectors.toList());

        String s = LambdaNote.getIdsFilterNull(null);
        String idsFilterNull = LambdaNote.getIdsFilterNull(integerList);
        log.info(idsFilterNull);
    }

    private static String getIdsFilterNull(Collection<Object> ids) {

        return null;

    }

}
