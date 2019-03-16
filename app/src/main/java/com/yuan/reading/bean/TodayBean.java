package com.yuan.reading.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/3/15 0015.
 */

public class TodayBean {

    /**
     * category : ["iOS","拓展资源","瞎推荐","Android","App","休息视频","福利","前端"]
     * error : false
     * results : {"Android":[{"_id":"5bbb061e9d2122610ee409d8","createdAt":"2018-10-08T07:24:14.959Z","desc":"WMRouter是一款Android路由框架，基于组件化的设计思路，有功能灵活、使用简单的特点。","publishedAt":"2019-03-12T01:41:06.815Z","source":"chrome","type":"Android","url":"https://github.com/meituan/WMRouter","used":true,"who":"潇湘剑雨"},{"_id":"5bbbd36d9d212203189ecd46","createdAt":"2018-10-08T22:00:13.979Z","desc":"回归初心：极简 Android 组件化方案 \u2014 AppJoint","publishedAt":"2019-03-08T07:06:58.689Z","source":"web","type":"Android","url":"https://juejin.im/post/5bb9c0d55188255c7566e1e2","used":true,"who":"潇湘剑雨"},
     */




    public static class ResultsBean {
        private List<AndroidBean> Android;
        private List<AppBean> App;
        private List<IOSBean> iOS;
        private List<休息视频Bean> 休息视频;
        private List<前端Bean> 前端;
        private List<拓展资源Bean> 拓展资源;
        private List<瞎推荐Bean> 瞎推荐;
        private List<福利Bean> 福利;

        public List<AndroidBean> getAndroid() {
            return Android;
        }

        public void setAndroid(List<AndroidBean> Android) {
            this.Android = Android;
        }

        public List<AppBean> getApp() {
            return App;
        }

        public void setApp(List<AppBean> App) {
            this.App = App;
        }

        public List<IOSBean> getIOS() {
            return iOS;
        }

        public void setIOS(List<IOSBean> iOS) {
            this.iOS = iOS;
        }

        public List<休息视频Bean> get休息视频() {
            return 休息视频;
        }

        public void set休息视频(List<休息视频Bean> 休息视频) {
            this.休息视频 = 休息视频;
        }

        public List<前端Bean> get前端() {
            return 前端;
        }

        public void set前端(List<前端Bean> 前端) {
            this.前端 = 前端;
        }

        public List<拓展资源Bean> get拓展资源() {
            return 拓展资源;
        }

        public void set拓展资源(List<拓展资源Bean> 拓展资源) {
            this.拓展资源 = 拓展资源;
        }

        public List<瞎推荐Bean> get瞎推荐() {
            return 瞎推荐;
        }

        public void set瞎推荐(List<瞎推荐Bean> 瞎推荐) {
            this.瞎推荐 = 瞎推荐;
        }

        public List<福利Bean> get福利() {
            return 福利;
        }

        public void set福利(List<福利Bean> 福利) {
            this.福利 = 福利;
        }

        public static class AndroidBean {
            /**
             * _id : 5bbb061e9d2122610ee409d8
             * createdAt : 2018-10-08T07:24:14.959Z
             * desc : WMRouter是一款Android路由框架，基于组件化的设计思路，有功能灵活、使用简单的特点。
             * publishedAt : 2019-03-12T01:41:06.815Z
             * source : chrome
             * type : Android
             * url : https://github.com/meituan/WMRouter
             * used : true
             * who : 潇湘剑雨
             * images : ["http://img.gank.io/0cd8baa4-7d96-40fb-ab0c-4b3668a7ac4d","http://img.gank.io/35066fc9-4c67-498d-b9e1-f8e3ca7410e1","http://img.gank.io/ad8b369e-c643-4631-afdd-4466aab4f7fd","http://img.gank.io/101d45df-c66b-4610-809a-734fbca99967","http://img.gank.io/d8755a02-fe71-4562-ac9f-4d7d6b0d3358"]
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;
            private List<String> images;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }
        }

        public static class AppBean {
            /**
             * _id : 5c31d8a79d21222bd38ce73e
             * createdAt : 2019-01-06T10:29:59.746Z
             * desc : flutter开发的干货集中营客户端
             * publishedAt : 2019-01-25T13:02:10.57Z
             * source : web
             * type : App
             * url : https://github.com/fujianlian/GankFlutter
             * used : true
             * who : lijinshanmx
             * images : ["https://ww1.sinaimg.cn/large/0073sXn7ly1fze9706gdzj30ae0kqmyw","https://ww1.sinaimg.cn/large/0073sXn7ly1fze970ocgxj30ae0ks0tc","https://ww1.sinaimg.cn/large/0073sXn7ly1fze97124aej30af0kq404"]
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;
            private List<String> images;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }
        }

        public static class IOSBean {
            /**
             * _id : 58e98313421aa9544b773f9d
             * createdAt : 2017-04-09T08:40:51.874Z
             * desc : 购物车类的抛物线动画（支持上抛或者下抛） && 阻尼动画（弹球动画）
             * images : ["http://img.gank.io/99a2362c-3c39-4975-b98f-6c8981bc970d"]
             * publishedAt : 2019-02-13T03:02:27.510Z
             * source : web
             * type : iOS
             * url : https://github.com/jinht/ShopCarAnimation
             * used : true
             * who : lijinshanmx
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;
            private List<String> images;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }
        }

        public static class 休息视频Bean {
            /**
             * _id : 5c4578ae9d212264ce006f4b
             * createdAt : 2019-01-21T07:45:50.59Z
             * desc : #大早上的你是想笑死我吗
             * publishedAt : 2019-01-21T00:00:00.0Z
             * source : web
             * type : 休息视频
             * url : https://v.douyin.com/NwdsVy/
             * used : true
             * who : lijinshanmx
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }
        }

        public static class 前端Bean {
            /**
             * _id : 5c4bfdc19d212243205cc7f3
             * createdAt : 2019-01-26T06:27:13.191Z
             * desc : 这篇文章聊明白管理状态这一堆看起来挺复杂的东西。
             * publishedAt : 2019-01-27T14:18:02.608Z
             * source : web
             * type : 前端
             * url : https://zhuanlan.zhihu.com/p/53599723
             * used : true
             * who : bym
             * images : ["http://img.gank.io/a7a104ee-6e5e-460e-9a31-d90d064ca7b6","http://img.gank.io/bfa17787-8671-42c6-af89-240b60bc0165","http://img.gank.io/26f08070-3fd7-4e2e-9607-966d3edada17","http://img.gank.io/7ae3f909-ce15-40aa-989e-b5b2178d967d","http://img.gank.io/5cd11a95-8aba-45d6-b9c1-b0d67fb500fc"]
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;
            private List<String> images;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }
        }

        public static class 拓展资源Bean {
            /**
             * _id : 5a5570d8421aa9115b930657
             * createdAt : 2018-01-10T09:48:08.708Z
             * desc : 用Python爬取各Android市场应用下载量（3分钟学会）
             * publishedAt : 2019-01-21T00:00:00.0Z
             * source : web
             * type : 拓展资源
             * url : https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247489179&idx=1&sn=4b99a633b1f4fc1804782c6e85faa5bf
             * used : true
             * who : 陈宇明
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }
        }

        public static class 瞎推荐Bean {
            /**
             * _id : 5a614fc6421aa9115b930678
             * createdAt : 2019-01-21T07:51:14.120Z
             * desc : 12款堪称神器的 Chrome 插件
             * publishedAt : 2019-01-21T00:00:00.0Z
             * source : web
             * type : 瞎推荐
             * url : https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247489341&idx=2&sn=f4c9ed88bbd724018e39e42fa1dc0fca
             * used : true
             * who : 陈宇明
             * images : ["https://ww1.sinaimg.cn/large/0073sXn7ly1fze96x48bng30mw09y7b0","https://ww1.sinaimg.cn/large/0073sXn7ly1fze96ziljwg31dc0l8qu2"]
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;
            private List<String> images;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }
        }

        public static class 福利Bean {
            /**
             * _id : 5c4578db9d212264d4501d40
             * createdAt : 2019-01-21T07:46:35.304Z
             * desc : 2019-01-21
             * publishedAt : 2019-01-21T00:00:00.0Z
             * source : web
             * type : 福利
             * url : https://ws1.sinaimg.cn/large/0065oQSqgy1fze94uew3jj30qo10cdka.jpg
             * used : true
             * who : lijinshanmx
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }
        }
    }
}
