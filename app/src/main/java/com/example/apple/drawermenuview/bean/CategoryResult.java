package com.example.apple.drawermenuview.bean;

import java.util.List;

/**
 * Created by apple on 2017/8/7.
 */

public class CategoryResult {
    public boolean error;
    public List<ResultsBean> results;

    public static class ResultsBean{

        public String _id;
        public String createdAt;
        public String desc;
        public String publishedAt;
        public String source;
        public String type;
        public String url;
        public boolean used;
        public String who;
        public List<String> images;

    }
}
