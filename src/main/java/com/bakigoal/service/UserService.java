package com.bakigoal.service;

import com.bakigoal.entity.User;

import java.util.List;

/**
 * Created by bakigoal on 12.09.15.
 */
public interface UserService {

    User getUserByUsername(String username);

    List<User> getUsers();

    void registerNewUser(User customer);

    User updateUser(User customer);

    void removeUser(User deleteUser);
}