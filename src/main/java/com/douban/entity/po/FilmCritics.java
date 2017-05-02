package com.douban.entity.po;

import java.util.Date;

/**
 * Created by lhw2 on 2017/4/30.
 */
public class FilmCritics {
    private Long id;
    private Integer score;
    private String title;
    private String content;
    private Long filmId;
    private Long userId;
    private Date createTime;

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

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "FilmCritics{" +
                "id=" + id +
                ", score=" + score +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", filmId=" + filmId +
                ", userId=" + userId +
                ", createTime=" + createTime +
                '}';
    }
}
