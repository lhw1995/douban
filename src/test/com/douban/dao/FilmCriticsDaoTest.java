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
        filmCritics.setContent("前言：在写《我的少女时代》的影评的时候，我以 为这会是近几年最触动我的青春电影，但却未料到 会不经意邂逅这部爱奇艺的网剧，那些耿耿于怀的 岁月一一重现在眼前，迟迟不能忘记。回忆如潮水 般汹涌而至，原来这才是我不曾忘记的时光。 抄送 少女时代影评： https://movie.douban.... 版权归作者所有，任何形式转载请联系作者。 作者：山水烟花（来自豆瓣） 来源：https://movie.douban.com/review/7967743/ 【少年少女的爱情呀，是未说出口的喜欢啊】 暧昧的情愫，羞红的脸，偶尔碰到的手，无处不在的摸头杀，随着剧情一步步推进下去，那些恍如隔世的寻常样子仿佛一一又重现在眼前。 他和她四目相对，带着一起温书的浅浅笑容，那不是轰轰烈烈的爱情，只是细水长流的喜欢。也许未说出口，却真实的存在于每时每刻每个细节。 耿耿说，被爱的人是幸运而感动的，而爱人却是一次又一次猝不及防的心跳加速。她和余淮的喜欢发端于点点滴滴的学习生活，也许是哪一次他为了她向老师提问，也许是哪一次他说她是他的人，也许是哪一次他宠溺的摸摸她的头，骂她小白痴......因为喜欢所以亲昵，而亲昵但不敢越距，这是高中时候的小小心思，你和我都懂，懂就够了。 在一起，是最自然而然的事情。 在年少的时候，我们能为喜欢的人做很多很多未来不会去做的事情。心里眼里都是他，所以会为了他而做出最出于本心的选择，因他的喜而喜，因他的忧而忧。——耿耿是这样，贝塔是这样，简单更是这样，尽管他们的喜欢不尽相同，但少女的心思却出奇的一致。 尤其，是在涉及到文理分科的那一晚。她们撕碎的分科志愿单，是少女时代最大的一次勇敢。但，并不是你勇敢过了，就会有一个最好的结局。 ——耿耿与余淮有多少年不曾相见； ——贝塔与张平永远止于师生之情； ——简单和韩叙终究还是一场愿赌服输的一厢情愿。 成长就是这样，你做你想做的，但生活未必给你最想要的。 如果当我喜欢你的时候，你也喜欢我，那最好不过，如果没有，我也不曾后悔。\n");
        filmCritics.setTitle("如果有一座时光机，我多想重读一次高中");
        filmCritics.setFilmId(1L);
        filmCritics.setPraiseCount(0);
        filmCritics.setUserId(1L);
        filmCritics.setCreateTime(new Date());
        for (int i = 0; i < 10; i++) {
            filmCriticsDao.insertFilmCritics(filmCritics);

        }
    }

    @Test
    public void deleteFilmCriticsById() throws Exception {

    }

    @Test
    public void listTest() throws Exception {
        System.out.println(filmCriticsDao.getFilmCriticsList(1L,5L,5L));
    }

}