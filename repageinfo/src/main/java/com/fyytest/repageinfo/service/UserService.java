package com.fyytest.repageinfo.service;

import com.fyytest.repageinfo.pojo.User;
import com.fyytest.repageinfo.pojo.query.UserQuery;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    public List<User> listAllUsers();

    public PageInfo<User> listUserByName(UserQuery userQuery);

    //    删除用户

    public boolean deleteUser(Integer id);
    public User queryUserId(Integer id);


    public boolean updateUser(User user);
    public boolean insertUser(User user);
}
