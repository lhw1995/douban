package com.douban.service.user;

import com.douban.entity.po.User;

import java.util.Map;

/**
 * Created by lidey on 2017/5/9.
 */
public interface UserService {
    Map<String,Object> register(User user);
    Map<String,Object> login(String username, String password);
    Map<String,Object> updateUser(User user);
    Map<String,Object> disableUser(int id);
    Map<String,Object> getUserById(int id);
    Map<String,Object> getAdmins();
    Map<String,Object> getNormalUsers();
    Map<String,Object> getDisabledUsers();
}
