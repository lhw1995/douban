package com.douban.controller;

import com.douban.entity.po.FilmComments;
import com.douban.entity.po.FilmCritics;
import com.douban.entity.vo.Page;
import com.douban.service.filmcomments.FilmCommentsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "film_comments",method = RequestMethod.POST)
    public Object insertFilmComments(@RequestBody Map<String,Object> params, HttpSession session) {
        FilmComments filmComments = new FilmComments();
        filmComments.setScore(Integer.valueOf (params.get("score").toString()));
        filmComments.setContent((String) (params.get("content")));
        filmComments.setFilmId(Long.valueOf(params.get("filmId").toString()));
        int status = filmCommentsService.insertFilmComments(filmComments,session);
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
    @RequestMapping(value = "film_comments/{film_id}", method = RequestMethod.POST)
    public Object getFilmCriticsList(@PathVariable("film_id") Long filmId,@RequestBody Map<String,Object> pageMap) {
        Page page = new Page();
        page.setCurrPageNo(Long.valueOf(pageMap.get("currPageNo").toString()));
        page.setPageSize(Long.valueOf(pageMap.get("pageSize").toString()));
        Map<String,Object> map = filmCommentsService.getFilmCommentsList(filmId,page);
        return map;
    }
}
