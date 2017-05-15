package com.douban.service.filmcomments;

import com.douban.dao.FilmCommentsDao;
import com.douban.dao.UserDao;
import com.douban.entity.po.FilmComments;
import com.douban.entity.po.FilmCritics;
import com.douban.entity.po.User;
import com.douban.entity.vo.FilmCommentsVo;
import com.douban.entity.vo.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lhw2 on 2017/5/3.
 */
@Service
public class FilmCommentsServiceImpl implements FilmCommentsService{

    @Resource
    private FilmCommentsDao filmCommentsDao;

    @Resource
    private UserDao userDao;

    @Override
    public Map<String, Object> getFilmCommentsList(Long filmId, Page page) {
        //获得该页短评
        Long startNum = (page.getCurrPageNo() - 1) * page.getPageSize();
        Long pageSize = page.getPageSize();
        List<FilmComments> filmCommentsList = filmCommentsDao.getFilmCommentsList(filmId,startNum,pageSize);
        //获得分页信息
        Long totalCount = filmCommentsDao.getFilmCommentsTotalCount(filmId);
        Long totalPageCount = totalCount % pageSize > 0? totalCount/pageSize+1 : totalCount/pageSize;
        page.setTotalCount(totalCount);
        page.setTotalPageCount(totalPageCount);

        //获得用户名
        List<FilmCommentsVo> filmCommentsVoList = new ArrayList<>();
        for (int i = 0; i < filmCommentsList.size();i ++) {
            Long id = filmCommentsList.get(i).getUserId();
            String userName = userDao.getUserById(Integer.valueOf(id.toString())).getNickname();
            FilmCommentsVo filmCommentsVo = new FilmCommentsVo(
                    filmCommentsList.get(i).getId(),
                    filmCommentsList.get(i).getScore(),
                    filmCommentsList.get(i).getContent(),
                    filmCommentsList.get(i).getPraiseCount(),
                    filmCommentsList.get(i).getFilmId(),
                    userName,
                    filmCommentsList.get(i).getCreateTime());
            filmCommentsVoList.add(filmCommentsVo);
        }

        //返回Json
        Map<String,Object> map = new HashMap<>();
        map.put("filmCommentsVoList",filmCommentsVoList);
        map.put("page",page);
        return map;
    }

    @Override
    public int insertFilmComments(FilmComments filmComments, HttpSession session) {
        // TODO: 2017/4/30 从session中获取当前用户id
        User user = (User) session.getAttribute("login");
        filmComments.setUserId(Long.valueOf(user.getId()));
        filmComments.setUserId(1L);
        filmComments.setCreateTime(new Date());
        filmComments.setPraiseCount(0);
        return filmCommentsDao.insertFilmComments(filmComments);
    }

    @Override
    public int deleteFilmCommentsById(Long id) {
        return filmCommentsDao.deleteFilmCommentsById(id);
    }
}
