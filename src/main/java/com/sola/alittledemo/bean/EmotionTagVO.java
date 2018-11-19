package com.sola.alittledemo.bean;

/**
 * @author Sola
 * @date 2018/11/06
 */
public class EmotionTagVO {

    private Double score;
    private String tagName;

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String toString() {
        return "EmotionTagVO{" +
                "score=" + score +
                ", tagName='" + tagName + '\'' +
                '}';
    }
}
