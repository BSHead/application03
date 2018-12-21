package com.exam.application03.bean;

import java.util.List;

public class PageData {

    /**
     * msg :
     * code : 0
     * data : [{"aid":1,"createtime":"2018-12-17T14:53:49","icon":"http://www.zhaoapi.cn/images/quarter/ad1.png","productId":null,"title":"第十三界瑞丽模特大赛","type":0,"url":"http://m.mv14449315.icoc.bz/index.jsp"},{"aid":2,"createtime":"2018-12-17T14:53:49","icon":"http://www.zhaoapi.cn/images/quarter/ad2.png","productId":null,"title":"文化艺术节","type":0,"url":"http://m.mv14449315.icoc.bz/index.jsp"},{"aid":3,"createtime":"2018-12-17T14:53:49","icon":"http://www.zhaoapi.cn/images/quarter/ad3.png","productId":null,"title":"直播封面标准","type":0,"url":"http://m.mv14449315.icoc.bz/index.jsp"},{"aid":4,"createtime":"2018-12-17T14:53:49","icon":"http://www.zhaoapi.cn/images/quarter/ad4.png","productId":"1","title":"人气谁最高，金主谁最豪气","type":1,"url":""}]
     */

    private String msg;
    private String code;
    private List<Page> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Page> getData() {
        return data;
    }

    public void setData(List<Page> data) {
        this.data = data;
    }
}
