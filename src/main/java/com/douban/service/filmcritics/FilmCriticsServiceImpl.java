package com.douban.service.filmcritics;

import com.douban.dao.FilmCriticsDao;
import com.douban.dao.UserDao;
import com.douban.entity.po.FilmCritics;
import com.douban.entity.po.User;
import com.douban.entity.vo.FilmCommentsVo;
import com.douban.entity.vo.FilmCriticsVo;
import com.douban.entity.vo.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by lhw2 on 2017/4/30.
 */
@Service("filmCriticsService")
public class FilmCriticsServiceImpl implements FilmCriticsService {

    @Resource
    private FilmCriticsDao filmCriticsDao;

    @Resource
    private UserDao userDao;


    public FilmCritics getFilmCriticsById(Long id) {
        return filmCriticsDao.getFilmCriticsById(id);
    }

    public Integer insertFilmCritics(FilmCritics filmCritics, HttpSession session) {
        User user = (User) session.getAttribute("login");
        filmCritics.setUserId(Long.valueOf(user.getId()));
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
        //获得用户名
        List<FilmCriticsVo> filmCriticsVoList = new ArrayList<>();
        for (int i = 0; i < filmCriticsList.size();i ++) {
            Long id = filmCriticsList.get(i).getUserId();
            String userName = userDao.getUserById(Integer.valueOf(id.toString())).getNickname();
            FilmCriticsVo filmCriticsVo = new FilmCriticsVo(
                    filmCriticsList.get(i).getId(),
                    filmCriticsList.get(i).getScore(),
                    filmCriticsList.get(i).getTitle(),
                    filmCriticsList.get(i).getContent(),
                    filmCriticsList.get(i).getPraiseCount(),
                    filmCriticsList.get(i).getFilmId(),
                    userName,
                    filmCriticsList.get(i).getCreateTime());
            filmCriticsVoList.add(filmCriticsVo);
        }
        //返回Json
        Map<String,Object> map = new HashMap<>();
        map.put("filmCriticsVoList",filmCriticsVoList);
        map.put("page",page);
        return map;
    }
}
