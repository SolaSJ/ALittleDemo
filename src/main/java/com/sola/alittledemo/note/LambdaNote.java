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

    public static void main(String[] args) {
        List<Object> integerList = new ArrayList<>(Arrays.asList(1, 2, 3, null, null, 4, ""));
        integerList.add(4);
        integerList.add(null);

        String s = LambdaNote.getIdsFilterNull(null);
        String idsFilterNull = LambdaNote.getIdsFilterNull(integerList);
        log.info(idsFilterNull);
    }

    private static String getIdsFilterNull(Collection<Object> ids) {
        return null;
    }

}
