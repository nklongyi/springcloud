package com.nklongyi.Dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 文章
 * Created by longyi on 2017/8/24.
 */
@Entity
@Table(name = "Article")
public class Article implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false,name = "title")
    private String title;//文章标题

    @Column(nullable = false,name = "introduction")
    private String introduction;//文章简介

    @Column(nullable = false,name = "publishDate")
    @Temporal(TemporalType.DATE)
    private Date publishDate;//发布日期

    @Column(nullable = false,name = "ctime",insertable=true)
    @Temporal(TemporalType.TIMESTAMP)
    @org.hibernate.annotations.CreationTimestamp
    private Date ctime;//文章创建时间

    @Column(nullable = false,name = "uptime",updatable=true)
    @Temporal(TemporalType.TIMESTAMP)
    @org.hibernate.annotations.UpdateTimestamp
    private Date uptime;//文章更新时间

    @Column(nullable = false,name = "content")
    private String content;//文章内容

    @Column(nullable = false,name = "imgurl")
    private String imgurl;//文章缩略图

    @Column(nullable = false,name = "status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name="columns_id")
    private Columns columns;//1:1

    public Columns getColumns() {
        return columns;
    }

    public void setColumns(Columns columns) {
        this.columns = columns;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
