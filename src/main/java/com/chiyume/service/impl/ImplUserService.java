package com.chiyume.service.impl;

import com.chiyume.dao.UserDao;
import com.chiyume.pojo.User;
import com.chiyume.service.UserService;

import java.util.List;

public class ImplUserService implements UserService {
    @Override
    public User getUserByName(String name) {
        UserDao userDao = new UserDao();
        User user = userDao.getUserByName(name);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        UserDao userDao = new UserDao();
        List<User> allUser = userDao.getAllUser();
        return allUser;
    }

    @Override
    public int addUser(User user) {
        UserDao userDao = new UserDao();
        int i = userDao.addUser(user);
        return i;
    }

    @Override
    public int deleteById(int id) {
        UserDao userDao = new UserDao();
        int i = userDao.deleteById(id);
        return i;
    }

    @Override
    public int updateById(int id, User user) {
        UserDao userDao = new UserDao();
        int i = userDao.updateUserById(id, user);
        return i;
    }

    @Override
    public User getUserById(int id) {
        UserDao userDao = new UserDao();
        User userById = userDao.getUserById(id);
        return userById;
    }
}
