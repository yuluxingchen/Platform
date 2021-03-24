package com.fenghen.pojo;

import java.util.Date;

public class Article {
    private String tID;
    private String uID;
    private String uName;
    private String tTitle;
    private String tContents;
    private Date tTime;
    private Integer tReplyCount;
    private Integer tClickCount;
    private Integer tCollectCount;
    private Integer tLikeCount;

    @Override
    public String toString() {
        return "Article{" +
                "tID='" + tID + '\'' +
                ", uID='" + uID + '\'' +
                ", uName='" + uName + '\'' +
                ", tTitle='" + tTitle + '\'' +
                ", tContents='" + tContents + '\'' +
                ", tTime=" + tTime +
                ", tReplyCount=" + tReplyCount +
                ", tClickCount=" + tClickCount +
                ", tCollectCount=" + tCollectCount +
                ", tLikeCount=" + tLikeCount +
                '}';
    }

    public String gettID() {
        return tID;
    }

    public void settID(String tID) {
        this.tID = tID;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String gettTitle() {
        return tTitle;
    }

    public void settTitle(String tTitle) {
        this.tTitle = tTitle;
    }

    public String gettContents() {
        return tContents;
    }

    public void settContents(String tContents) {
        this.tContents = tContents;
    }

    public Date gettTime() {
        return tTime;
    }

    public void settTime(Date tTime) {
        this.tTime = tTime;
    }

    public Integer gettReplyCount() {
        return tReplyCount;
    }

    public void settReplyCount(Integer tReplyCount) {
        this.tReplyCount = tReplyCount;
    }

    public Integer gettClickCount() {
        return tClickCount;
    }

    public void settClickCount(Integer tClickCount) {
        this.tClickCount = tClickCount;
    }

    public Integer gettCollectCount() {
        return tCollectCount;
    }

    public void settCollectCount(Integer tCollectCount) {
        this.tCollectCount = tCollectCount;
    }

    public Integer gettLikeCount() {
        return tLikeCount;
    }

    public void settLikeCount(Integer tLikeCount) {
        this.tLikeCount = tLikeCount;
    }
}
