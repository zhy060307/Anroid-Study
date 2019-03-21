package com.dodola.model;

public class DuitangInfo {

    public static final int TYPE_1_1 = 0;
    public static final int TYPE_1_2 = 1;
    public static final int TYPE_1_3 = 2;
    public static final int TYPE_2_1 = 3;
    public static final int TYPE_2_2 = 4;
    public static final int TYPE_2_3 = 5;
    public static final int TYPE_3_1 = 6;
    public static final int TYPE_3_2 = 7;
    public static final int TYPE_3_3 = 8;

    private String albid = "";
    private String msg = "";
    private String isrc = "";

    private int type;

    public String getAlbid() {
        return albid;
    }

    public void setAlbid(String albid) {
        this.albid = albid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getIsrc() {
        return isrc;
    }

    public void setIsrc(String isrc) {
        this.isrc = isrc;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public DuitangInfo(int type) {
        this.type = type;
        this.isrc = "https://www.baidu.com/img/bd_logo1.png";
    }

    public DuitangInfo() {
    }
}
