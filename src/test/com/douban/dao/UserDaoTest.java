package com.douban.dao;

import com.douban.entity.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Random;

/**
 * Created by lidey on 2017/5/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaoTest {
    @Resource
    private UserDao userDao;

    @Test
    public void insertUser() throws Exception {
        User user = new User();
        int random1 = new Random().nextInt(10000);
        int random2 = new Random().nextInt(10000);
        user.setUsername("admin"+random1);
        user.setPassword("admin"+random2);
        user.setIconurl("img/1.jpg");
        user.setNickname("管理员");
        user.setStatus(1);
        System.out.println(userDao.insertUser(user));
    }

    @Test
    public void deleteUserById() throws Exception{
        System.out.println(userDao.deleteUserById(1003));
    }

    @Test
    public void updatetUser() throws Exception {
        User user = new User();
        int random1 = new Random().nextInt(10000);
        int random2 = new Random().nextInt(10000);
        user.setId(1000);
        user.setUsername("normal"+random1);
        user.setPassword("normal"+random2);
        user.setIconurl("img/2.jpg");
        user.setNickname("普通用户");
        user.setStatus(2);
        System.out.println(userDao.updateUser(user));
    }

    @Test
    public void getUserById() throws Exception{
        System.out.println(userDao.getUserById(1000));
    }

    @Test
    public void getUserByUsername() throws Exception{
        System.out.println(userDao.getUserByUsername("admin"));
    }

    @Test
    public void getUsersByFuzzyUsername() throws Exception{
        System.out.println(userDao.getUsersByFuzzyUsername("%admin%"));
    }

    @Test
    public void getUsersByNickname() throws Exception{
        System.out.println(userDao.getUsersByNickname("管理员"));
    }

    @Test
    public void getUsersByFuzzyNickname() throws Exception{
        System.out.println(userDao.getUsersByFuzzyNickname("%管理%"));
    }

    @Test
    public void getUsersByStatus() throws Exception{
        System.out.println(userDao.getUsersByStatus(1));
    }
}
