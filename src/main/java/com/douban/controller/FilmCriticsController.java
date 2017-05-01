package com.douban.controller;

import com.douban.entity.FilmCritics;
import com.douban.entity.vo.Page;
import com.douban.service.filmcritics.FilmCriticsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lhw2 on 2017/5/1.
 */
@Controller
public class FilmCriticsController {

    @Resource
    private FilmCriticsService filmCriticsService;

    /**
     * 添加影评
     * @param filmCritics 影评
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "film_critics", method = RequestMethod.POST)
    public Object insertFilmCritics(FilmCritics filmCritics, HttpSession session) {
        int success = filmCriticsService.insertFilmCritics(filmCritics,session);
        Map<String,Object> map = new HashMap<>();
        if (success > 0) {
            map.put("操作状态","成功");
        } else {
            map.put("操作状态","失败");
        }
        return map;
    }

    /**
     *
     * @param filmId 影评Id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "film_critics/{filmId}", method = RequestMethod.DELETE)
    public Object deleteFilmCritics(@PathVariable("filmId") Long filmId) {
        int success = filmCriticsService.deleteFilmCriticsById(filmId);
        Map<String,Object> map = new HashMap<>();
        if (success > 0) {
            map.put("操作状态","成功");
        } else {
            map.put("操作状态","失败");
        }
        return map;
    }

    /**
     * 获得本电影本页影评
     * @param filmId 影评Id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "film_critics/{filmId}", method = RequestMethod.GET)
    public Object getFilmCriticsList(@PathVariable("filmId") Long filmId,Page page) {
        List<FilmCritics> filmCriticsList = filmCriticsService.getFilmCriticsList(filmId,page);
        Map<String,Object> map = new HashMap<>();
        map.put("本页影评",filmCriticsList);
        return map;
    }

}
