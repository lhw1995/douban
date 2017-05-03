package com.douban.dao;

import com.douban.entity.po.FilmComments;
import com.douban.entity.po.FilmCritics;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lhw2 on 2017/5/3.
 */
public interface FilmCommentsDao {

    /**
     * 分页查询短评
     * @param filmId 电影id
     * @param startNum 本页第一条的序号
     * @param pageSize 本页大小
     * @return
     */
    List<FilmComments> getFilmCommentsList(@Param("filmId") Long filmId, @Param("startNum") Long startNum, @Param("pageSize") Long pageSize);

    /**
     * 插入影评
     * @param filmComments
     * @return
     */
    int insertFilmComments(FilmComments filmComments);

    /**
     *删除短评
     * @param id 短评id
     * @return
     */
    int deleteFilmCommentsById(Long id);

    /**
     * 获得短评总数
     * @param filmId
     * @return
     */
    Long getFilmCommentsTotalCount(@Param("filmId") Long filmId);

}
