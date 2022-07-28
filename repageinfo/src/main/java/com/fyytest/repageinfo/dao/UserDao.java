package com.fyytest.repageinfo.dao;

import com.fyytest.repageinfo.pojo.User;
import com.fyytest.repageinfo.pojo.query.UserQuery;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    public List<User> listAllUsers();

    public List<User> listUserByName(UserQuery userQuery);

    //    根据id删除用户
    public Integer deleteUser(Integer id);
    //    根据id查询用户

    public User queryUserId(Integer id);

    //    修改用户
    public Integer updateUser(User user);
    public Integer insertUser(User user);
}
