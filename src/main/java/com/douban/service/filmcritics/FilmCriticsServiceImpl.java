package com.douban.service.filmcritics;

import com.douban.dao.FilmCriticsDao;
import com.douban.entity.FilmCritics;
import com.douban.entity.vo.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by lhw2 on 2017/4/30.
 */
@Service("filmCriticsService")
public class FilmCriticsServiceImpl implements FilmCriticsService {

    @Resource
    private FilmCriticsDao filmCriticsDao;

    public FilmCritics getFilmCriticsById(Long id) {
        return filmCriticsDao.getFilmCriticsById(id);
    }

    public Integer insertFilmCritics(FilmCritics filmCritics,HttpSession session) {
        // TODO: 2017/4/30 从session中获取当前用户id
        filmCritics.setUserId(1L);
        filmCritics.setCreateTime(new Date());
        return filmCriticsDao.insertFilmCritics(filmCritics);
    }

    public Integer deleteFilmCriticsById(Long id) {
        return filmCriticsDao.deleteFilmCriticsById(id);
    }

    public List<FilmCritics> getFilmCriticsList(Long filmId, Page page) {
        Long startNum = (page.getCurrPageNo() - 1) * page.getPageSize();
        Long pageSize = page.getPageSize();
        return filmCriticsDao.getFilmCriticsList(filmId,startNum,pageSize);
    }
}
