package com.douban.dao;

import com.douban.entity.po.FilmCritics;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by lhw2 on 2017/4/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class FilmCriticsDaoTest {

    @Resource
    private FilmCriticsDao filmCriticsDao;

    @Test
    public void getFilmCriticsById() throws Exception {
        System.out.println(filmCriticsDao.getFilmCriticsById(1000L));
    }

    @Test
    public void insertFilmCritics() throws Exception {
        FilmCritics filmCritics = new FilmCritics();
        filmCritics.setScore(6);
        filmCritics.setContent("abcde");
        filmCritics.setTitle("abc");
        filmCritics.setFilmId(1L);
        filmCritics.setUserId(1L);
        filmCritics.setCreateTime(new Date());
        filmCriticsDao.insertFilmCritics(filmCritics);
    }

    @Test
    public void deleteFilmCriticsById() throws Exception {

    }

    @Test
    public void listTest() throws Exception {
        System.out.println(filmCriticsDao.getFilmCriticsList(1L,5L,5L));
    }

}