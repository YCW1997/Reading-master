package com.yuan.reading.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/3/10 0010.
 */

public class CateBean {

        /**
         * children : []
         * courseId : 13
         * id : 294
         * name : 完整项目
         * order : 145000
         * parentChapterId : 293
         * userControlSetTop : false
         * visible : 0
         */

        private int courseId;
        private int id;
        private String name;
        private int order;
        private int parentChapterId;
        private boolean userControlSetTop;
        private int visible;
        private List<?> children;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
