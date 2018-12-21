package com.sola.alittledemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author Sola
 * @date 2018/12/13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mv implements Comparable {

    private Integer id;
    private String name1;
    private String name2;
    private String name3;

    @Override
    public boolean equals(Object o) {
        Mv mv = (Mv) o;
        return name1.equals(mv.name1) ||
                name1.equals(mv.name2) ||
                name1.equals(mv.name3) ||
                name2.equals(mv.name1) ||
                name2.equals(mv.name2) ||
                name2.equals(mv.name3) ||
                name3.equals(mv.name1) ||
                name3.equals(mv.name2) ||
                name3.equals(mv.name3);
    }

    @Override
    public int compareTo(Object o) {
        return this.equals(o) ? 0 : -1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name1, name2, name3);
    }
}
