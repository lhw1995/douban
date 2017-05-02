package com.douban.dao;

import com.douban.entity.FilmCritics;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lhw2 on 2017/4/30.
 */
public interface FilmCriticsDao {
    /**
     * 通过id获取影评
     * @param id
     * @return
     */
    FilmCritics getFilmCriticsById(Long id);

    /**
     * 添加影评
     * @param filmCritics
     * @return 添加的行数
     */
    Integer insertFilmCritics(FilmCritics filmCritics);

    /**
     * 删除影评
     * @param id
     * @return
     */
    Integer deleteFilmCriticsById(Long id);

    /**
     * 分页查询影评
     * @param filmId 电影id
     * @param startNum 本页第一条的序号
     * @param pageSize 本页大小
     * @return
     */
    List<FilmCritics> getFilmCriticsList(@Param("filmId") Long filmId, @Param("startNum") Long startNum, @Param("pageSize") Long pageSize);

    /**
     *
     * @param filmId 电影Id
     * @return
     */
    Long getFilmCriticsTotalCount(Long filmId);
}
