package com.example.shrotbin.gankshrotybin.bean;

import java.util.List;

/**
 * <pre>
 *     author : shortbin
 *     e-mail : xxx@xx
 *     time   : 2017/08/01
 *     desc   : xxxx描述
 *     version: 1.0
 * </pre>
 */

public class VideoBean {

    /**
     * error : false
     * results : [{"_id":"597deb9d421aa90ca3bb6ba7","createdAt":"2017-07-30T22:22:21.321Z","desc":"【将军】几分钟看《西部世界》所有机器人都认为自己是人类，却被真人当作发泄工具","publishedAt":"2017-08-01T11:48:20.466Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av12753992/","used":true,"who":"LHF"},{"_id":"5978ad1d421aa90ca3bb6b7a","createdAt":"2017-07-26T22:54:21.793Z","desc":"电影最TOP 65: 热血！盘点最经典的二战电影","publishedAt":"2017-07-27T14:16:33.773Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av12595919/","used":true,"who":"LHF"},{"_id":"59760e4f421aa90ca209c4d3","createdAt":"2017-07-24T23:12:15.465Z","desc":"亚裔退伍军人参加《美国忍者勇士》，这身体素质全程跪着看完！","publishedAt":"2017-07-26T16:57:39.343Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av12532105/","used":true,"who":"LHF"},{"_id":"5973521e421aa90ca3bb6b56","createdAt":"2017-07-22T21:24:46.388Z","desc":"【牛叔】几分钟看科幻片《终结者4》谁才是这个世界的救世主","publishedAt":"2017-07-25T15:25:42.391Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av12465641/","used":true,"who":"LHF"},{"_id":"597354db421aa90ca209c4bc","createdAt":"2017-07-22T21:36:27.573Z","desc":"【C菌】天! 竟有如此不堪入目的游戏! 那些最奇葩智障的游戏集合!【第32期】","publishedAt":"2017-07-24T12:13:11.280Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av12455374/","used":true,"who":"LHF"},{"_id":"596f5dde421aa90c9203d3c4","createdAt":"2017-07-19T21:25:50.652Z","desc":"【谷阿莫】5分鐘看完2017當主角就是爽的電影《新木乃伊》","publishedAt":"2017-07-21T12:39:43.370Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av12361744/","used":true,"who":"LHF"},{"_id":"596f5ca8421aa90c9203d3c3","createdAt":"2017-07-19T21:20:40.76Z","desc":"机场里建森林，投资1200亿，有40米高瀑布，搞的一堆人忘了上飞机","publishedAt":"2017-07-20T15:11:16.10Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av12360684/","used":true,"who":"LHF"},{"_id":"59525f2e421aa90ca209c3c7","createdAt":"2017-06-27T21:35:42.903Z","desc":"【科普】铁血战士：生猛的战斗民族","publishedAt":"2017-07-19T13:23:20.375Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av11636124/","used":true,"who":"LHF"},{"_id":"596cd4f2421aa90ca3bb6b1e","createdAt":"2017-07-17T23:17:06.865Z","desc":"【敖厂长】20年前的电子游戏森林冒险","publishedAt":"2017-07-18T16:12:55.381Z","source":"chrome","type":"休息视频","url":"https://www.bilibili.com/video/av12293375/","used":true,"who":"LHF"},{"_id":"596b74d3421aa90ca209c474","createdAt":"2017-07-16T22:14:43.701Z","desc":"10年前的动画比真人还真实！阿斗带你速看顶尖CG《贝奥武夫》爵迹可否一战","publishedAt":"2017-07-17T12:22:21.307Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av12261700/","used":true,"who":"LHF"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 597deb9d421aa90ca3bb6ba7
         * createdAt : 2017-07-30T22:22:21.321Z
         * desc : 【将军】几分钟看《西部世界》所有机器人都认为自己是人类，却被真人当作发泄工具
         * publishedAt : 2017-08-01T11:48:20.466Z
         * source : chrome
         * type : 休息视频
         * url : http://www.bilibili.com/video/av12753992/
         * used : true
         * who : LHF
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
