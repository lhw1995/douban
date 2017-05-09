package com.douban.service.filmcritics;

import com.douban.dao.FilmCriticsDao;
import com.douban.entity.po.FilmCritics;
import com.douban.entity.vo.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Integer insertFilmCritics(FilmCritics filmCritics, HttpSession session) {
        // TODO: 2017/4/30 从session中获取当前用户id
        filmCritics.setUserId(1L);
        filmCritics.setCreateTime(new Date());
        filmCritics.setPraiseCount(0);
        return filmCriticsDao.insertFilmCritics(filmCritics);
    }

    public Integer deleteFilmCriticsById(Long id) {
        return filmCriticsDao.deleteFilmCriticsById(id);
    }

    public Map<String,Object> getFilmCriticsList(Long filmId, Page page) {
        //获得该页影评
        Long startNum = (page.getCurrPageNo() - 1) * page.getPageSize();
        Long pageSize = page.getPageSize();
        List<FilmCritics> filmCriticsList = filmCriticsDao.getFilmCriticsList(filmId,startNum,pageSize);
        //获得分页信息
        Long totalCount = filmCriticsDao.getFilmCriticsTotalCount(filmId);
        Long totalPageCount = totalCount % pageSize > 0? totalCount/pageSize+1 : totalCount/pageSize;
        page.setTotalCount(totalCount);
        page.setTotalPageCount(totalPageCount);
        //返回Json
        Map<String,Object> map = new HashMap<>();
        map.put("filmCriticsList",filmCriticsList);
        map.put("page",page);
        return map;
    }
}
