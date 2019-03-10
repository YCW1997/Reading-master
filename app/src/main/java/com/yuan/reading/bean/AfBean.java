package com.yuan.reading.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/3/2 0002.
 */

public class AfBean {

                private int curPage;
                private int offset;
                private boolean over;
                private int pageCount;
                private int size;
                private int total;
                private List<ArticleDetailBean> datas;

    public List<ArticleDetailBean> getDatas() {
        return datas;
    }

    public static class ArticleDetailBean {
                        /**
                         * apkLink :
                         * author : 玉刚说
                         * chapterId : 410
                         * chapterName : 玉刚说
                         * collect : false
                         * courseId : 13
                         * desc :
                         * envelopePic :
                         * fresh : false
                         * id : 7978
                         * link : https://mp.weixin.qq.com/s/iZj-DpJ6u9vUrCotMQ0rmA
                         * niceDate : 2019-02-26
                         * origin :
                         * projectLink :
                         * publishTime : 1551110400000
                         * superChapterId : 408
                         * superChapterName : 公众号
                         * tags : [{"name":"公众号","url":"/wxarticle/list/410/1"}]
                         * title : 推荐一个实用漂亮的弹窗库
                         * type : 0
                         * userId : -1
                         * visible : 1
                         * zan : 0
                         */

                        private String apkLink;
                        private String author;
                        private int chapterId;
                        private String chapterName;
                        private boolean collect;
                        private int courseId;
                        private String desc;
                        private String envelopePic;
                        private boolean fresh;
                        private int id;
                        private String link;
                        private String niceDate;
                        private String origin;
                        private String projectLink;
                        private long publishTime;
                        private int superChapterId;
                        private String superChapterName;
                        private String title;
                        private int type;
                        private int userId;
                        private int visible;
                        private int zan;
                        private List<TagBean> tags;
        private byte[] url;

        public String getapkLink() {
            return apkLink;
        }

        public String getauthor() {
            return author;
        }

        public String getchapterName() {
            return chapterName;
        }

        public String getdesc() {
            return desc;
        }

        public String getenvelopePic() {
            return envelopePic;
        }

        public String gettitle() {
            return title;
        }

        public String getsuperChapterName() {
            return superChapterName;
        }

        public String getniceDate() {
            return niceDate;
        }

        public byte[] getUrl() {
            return url;
        }

        public static class TagBean {
                                /**
                                 * name : 公众号
                                 * url : /wxarticle/list/410/1
                                 */

                                private String name;
                                private String url;
                        }
                }
        }

