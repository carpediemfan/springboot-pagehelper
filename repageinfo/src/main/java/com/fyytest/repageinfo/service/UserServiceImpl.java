package com.fyytest.repageinfo.service;

import com.fyytest.repageinfo.dao.UserDao;
import com.fyytest.repageinfo.pojo.User;
import com.fyytest.repageinfo.pojo.query.UserQuery;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<User> listAllUsers() {
        return userDao.listAllUsers();
    }

    @Override
    public PageInfo<User> listUserByName(UserQuery userQuery) {
        PageHelper.startPage(userQuery.getPageNum(), userQuery.getPageSize());
        return new PageInfo<User>(userDao.listUserByName(userQuery));
    }

    @Override
    public boolean deleteUser(Integer id) {
        return userDao.deleteUser(id) > 0 ? true : false;

    }

    @Override
    public User queryUserId(Integer id) {
        return userDao.queryUserId(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user) > 0 ? true : false;

    }

    @Override
    public boolean insertUser(User user) {
        return userDao.insertUser(user) > 0 ? true : false;
    }


}
