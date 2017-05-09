package com.douban.service.user;

import com.douban.dao.UserDao;
import com.douban.entity.po.User;
import com.douban.util.EncryptionUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lidey on 2017/5/9.
 */

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public Map<String, Object> register(User user) {
        Map<String, Object> map = new HashMap<>();

        if (userDao.getUserByUsername(user.getUsername()) != null) {
            map.put("status", "username exists");
        }else if (user.getUsername().trim().equals("")||user.getPassword().trim().equals("")){
            map.put("status","input is none");
        }
        else {
            if (user.getNickname() == null) {
                user.setNickname(user.getUsername());
            }
            if (user.getIconurl() == null) {
                user.setIconurl("img/default.png");
            }
            if (user.getStatus() == 0) {
                user.setStatus(2);
            }

            int status = userDao.insertUser(user);
            if (status == 1) {
                map.put("status", "success");
            } else {
                map.put("status", "failed");
            }
        }
        return map;
    }

    @Override
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<>();

        User user = userDao.getUserByUsername(username);
        if (user == null) {
            map.put("status", "username dose not exist");
        } else {
            String md5Pwd = EncryptionUtil.getHash2(password,"MD5");
            if (user.getPassword().equals(md5Pwd)) {
                map.put("status", "success");
                map.put("login", user);
            } else {
                map.put("status", "password error");
            }
        }
        return map;
    }

    @Override
    public Map<String, Object> updateUser(User user) {
        Map<String, Object> map = new HashMap<>();

        if (userDao.getUserByUsername(user.getUsername()) == null) {
            map.put("status", "user dose not exist");
        } else {
            int status = userDao.updateUser(user);
            if (status == 1) {
                map.put("status", "success");
            } else {
                map.put("status", "failed");
            }
        }
        return map;
    }

    @Override
    public Map<String, Object> disableUser(int id) {
        Map<String, Object> map = new HashMap<>();

        User user = userDao.getUserById(id);
        if (user == null) {
            map.put("status", "user dose not exist");
        } else {
            user.setStatus(3);
            int status = userDao.updateUser(user);
            if (status == 1) {
                map.put("status", "success");
            } else {
                map.put("status", "failed");
            }
        }
        return map;
    }

    @Override
    public Map<String, Object> getUserById(int id) {
        Map<String, Object> map = new HashMap<>();
        User user = userDao.getUserById(id);
        map.put("user", user);
        return map;
    }

    @Override
    public Map<String, Object> getAdmins() {
        Map<String, Object> map = new HashMap<>();
        List<User> admins = userDao.getUsersByStatus(1);
        map.put("userList", admins);
        return map;
    }

    @Override
    public Map<String, Object> getNormalUsers() {
        Map<String, Object> map = new HashMap<>();
        List<User> normals = userDao.getUsersByStatus(2);
        map.put("userList", normals);
        return map;
    }

    @Override
    public Map<String, Object> getDisabledUsers() {
        Map<String, Object> map = new HashMap<>();
        List<User> disables = userDao.getUsersByStatus(3);
        map.put("userList", disables);
        return map;
    }
}
