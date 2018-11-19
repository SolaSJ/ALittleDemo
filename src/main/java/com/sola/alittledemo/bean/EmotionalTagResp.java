package com.sola.alittledemo.bean;

import java.util.List;

/**
 * @author Sola
 * @date 2018/11/06
 */
public class EmotionalTagResp {

    /**
     * state : {"code":200,"msg":"ok","enMsg":"ok"}
     * data : [{"score":0.15,"tags":"快乐 "},{"score":0.12,"tags":"放松"},{"score":0.12,"tags":"甜蜜"}]
     */

    private StateBean state;
    private List<DataBean> data;

    public StateBean getState() {
        return state;
    }

    public void setState(StateBean state) {
        this.state = state;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class StateBean {
        /**
         * code : 200
         * msg : ok
         * enMsg : ok
         */

        private Integer code;
        private String msg;
        private String enMsg;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getEnMsg() {
            return enMsg;
        }

        public void setEnMsg(String enMsg) {
            this.enMsg = enMsg;
        }
    }

    public static class DataBean {
        /**
         * score : 0.15
         * tags : 快乐
         */

        private Double score;
        private String tags;

        public Double getScore() {
            return score;
        }

        public void setScore(Double score) {
            this.score = score;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }
    }
}
