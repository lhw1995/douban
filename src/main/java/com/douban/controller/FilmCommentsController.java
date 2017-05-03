package com.douban.controller;

import com.douban.entity.po.FilmComments;
import com.douban.entity.vo.Page;
import com.douban.service.filmcomments.FilmCommentsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lhw2 on 2017/5/3.
 */
@Controller
public class FilmCommentsController {

    @Resource
    private FilmCommentsService filmCommentsService;

    /**
     * 添加短评
     * @param filmComments
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "film_comments",method = RequestMethod.POST)
    public Object insertFilmComments(FilmComments filmComments) {
        int status = filmCommentsService.insertFilmComments(filmComments);
        Map<String,Object> map = new HashMap<>();
        if (status > 0) {
            map.put("操作状态","成功");
        } else {
            map.put("操作状态","失败");
        }
        return map;
    }

    /**
     *
     * @param filmCommentsId 影评Id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "film_comments/{film_comments_id}", method = RequestMethod.DELETE)
    public Object deleteFilmCritics(@PathVariable("film_critics_id") Long filmCommentsId) {
        int success = filmCommentsService.deleteFilmCommentsById(filmCommentsId);
        Map<String,Object> map = new HashMap<>();
        if (success > 0) {
            map.put("操作状态","成功");
        } else {
            map.put("操作状态","失败");
        }
        return map;
    }

    /**
     * 获得本电影本页短评
     * @param filmId 电影Id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "film_comments/{film_id}", method = RequestMethod.GET)
    public Object getFilmCriticsList(@PathVariable("film_id") Long filmId,Page page) {
        Map<String,Object> map = filmCommentsService.getFilmCommentsList(filmId,page);
        return map;
    }
}
