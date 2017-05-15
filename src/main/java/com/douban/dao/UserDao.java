package com.douban.dao;

import com.douban.entity.po.User;

import java.util.List;

/**
 * Created by lidey on 2017/5/8.
 */
public interface UserDao {

    /**
     * 添加用户
     *
     * @param user 要插入的用户
     * @return 增加的行数
     */
    int insertUser(User user);

    /**
     * 删除用户
     *
     * @param id 要删除用户的id
     * @return 删除的行数
     */
    int deleteUserById(int id);

    /**
     * 更新用户
     *
     * @param user 新的用户信息
     * @return 更新的行数
     */
    int updateUser(User user);

    /**
     * 通过id获取用户
     *
     * @param id 要获取的用户的id
     * @return id对应的用户
     */
    User getUserById(int id);

    /**
     * 通过用户名获取用户信息
     *
     * @param username 用户名
     * @return 用户名对应的id
     */
    User getUserByUsername(String username);

    /**
     * 通过用户名模糊查找用户信息
     *
     * @param fuzzyUsername 应用模糊规则后的用户名
     * @return 包含给定部分用户名的用户集合
     */
    List<User> getUsersByFuzzyUsername(String fuzzyUsername);

    /**
     * 通过用户昵称获取用户信息
     *
     * @param nickname 用户昵称
     * @return 与给定用户昵称相同的用户集合
     */
    List<User> getUsersByNickname(String nickname);

    /**
     * 通过昵称模糊查找用户信息
     *
     * @param fuzzyNickname 应用模糊规则后的昵称
     * @return 包含给定部分昵称的用户集合
     */
    List<User> getUsersByFuzzyNickname(String fuzzyNickname);

    /**
     * 通过用户状态信息查找用户
     *
     * @param status 用户状态信息
     * @return 与给定状态信息相同的用户集合
     */
    List<User> getUsersByStatus(int status);
}
