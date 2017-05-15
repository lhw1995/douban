package com.douban.entity.vo;

import java.util.Date;

/**
 * Created by lhw2 on 2017/5/15.
 */
public class FilmCriticsVo {
    private Long id;
    private Integer score;
    private String title;
    private String content;
    private Integer praiseCount;
    private Long filmId;
    private String userName;
    private Date createTime;

    public FilmCriticsVo() {
    }

    @Override
    public String toString() {
        return "FilmCriticsVo{" +
                "id=" + id +
                ", score=" + score +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", praiseCount=" + praiseCount +
                ", filmId=" + filmId +
                ", userName='" + userName + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public FilmCriticsVo(Long id, Integer score, String title, String content, Integer praiseCount, Long filmId, String userName, Date createTime) {
        this.id = id;
        this.score = score;
        this.title = title;
        this.content = content;
        this.praiseCount = praiseCount;
        this.filmId = filmId;
        this.userName = userName;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
