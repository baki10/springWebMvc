package com.bakigoal.service.impl;

import com.bakigoal.entity.User;
import com.bakigoal.repository.UserFriendRepository;
import com.bakigoal.repository.UserRepository;
import com.bakigoal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by bakigoal on 12.09.15.
 */
@Service
@Transactional(value = "transactionManager")
public class UserServiceImpl implements UserService {

    private UserRepository userDAO;

    @Autowired
    private UserFriendRepository userFriendRepository;

    @Autowired
    public void setUserDAO(UserRepository userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getUsers() {
        return userDAO.getAll();
    }

    @Override
    public void registerNewUser(User customer) {
        userDAO.create(customer);
    }

    @Override
    public User getUserByUsername(String id) {
        return userDAO.get(id);
    }

    @Override
    public User updateUser(User customer) {
        return userDAO.update(customer);
    }

    @Override
    public void removeUser(User deleteUser) {
        userDAO.delete(deleteUser);
    }

    @Override
    public void addFriendToUser(User user, User friend) {
        if (user == null || friend == null) {
            return;
        }
        Set<User> userFriends = userFriendRepository.getUserFriends(user);
        for (User u : userFriends) {
            if (u.getUsername().equals(friend.getUsername())) {
                return;
            }
        }
        userFriendRepository.addFriendToUser(user, friend);
    }

    @Override
    public void deleteFriendFromUser(User user, User friend) {
        if (user == null || friend == null) {
            return;
        }
        userFriendRepository.deleteFriendFromUser(user, friend);
    }

    @Override
    public List<User> getUserFriends(String userId) {
        List<User> users = new ArrayList<>();
        User user = getUserByUsername(userId);
        if (user != null) {
            Set<User> userFriends = userFriendRepository.getUserFriends(user);
            users.addAll(userFriends);
        }
        return users;
    }
}

