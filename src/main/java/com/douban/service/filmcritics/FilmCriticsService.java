package com.douban.service.filmcritics;

import com.douban.entity.po.FilmCritics;
import com.douban.entity.vo.Page;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by lhw2 on 2017/4/30.
 */
public interface FilmCriticsService {
    /**
     * 通过id获取影评
     * @param id
     * @return
     */
    FilmCritics getFilmCriticsById(Long id);

    /**
     * 添加影评
     * @return 添加的行数
     */
    Integer insertFilmCritics(FilmCritics filmCritics, HttpSession session);

    /**
     * 删除影评
     * @param id
     * @return
     */
    Integer deleteFilmCriticsById(Long id);

    /**
     * 分页查询影评
     * @param filmId 电影id
     * @return
     */
    Map<String,Object> getFilmCriticsList(Long filmId, Page page);
}
