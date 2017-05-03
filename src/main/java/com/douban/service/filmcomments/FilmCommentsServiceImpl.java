package com.douban.service.filmcomments;

import com.douban.dao.FilmCommentsDao;
import com.douban.entity.po.FilmComments;
import com.douban.entity.po.FilmCritics;
import com.douban.entity.vo.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lhw2 on 2017/5/3.
 */
@Service
public class FilmCommentsServiceImpl implements FilmCommentsService{

    @Resource
    private FilmCommentsDao filmCommentsDao;


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
        //返回Json
        Map<String,Object> map = new HashMap<>();
        map.put("影评列表",filmCommentsList);
        map.put("分页信息",page);
        return map;
    }

    @Override
    public int insertFilmComments(FilmComments filmComments) {
        // TODO: 2017/4/30 从session中获取当前用户id
        filmComments.setUserId(1L);
        filmComments.setCreateTime(new Date());
        return filmCommentsDao.insertFilmComments(filmComments);
    }

    @Override
    public int deleteFilmCommentsById(Long id) {
        return filmCommentsDao.deleteFilmCommentsById(id);
    }
}
