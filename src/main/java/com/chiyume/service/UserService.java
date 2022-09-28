package com.chiyume.service;

import com.chiyume.pojo.User;

import java.util.List;

public interface UserService {
    User getUserByName(String name);
    List<User> getAllUser();
    int addUser(User user);
    int deleteById(int id);
    int updateById(int id,User user);
    User getUserById(int id);
}
