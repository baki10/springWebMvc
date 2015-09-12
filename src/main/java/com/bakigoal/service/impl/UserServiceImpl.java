package com.bakigoal.service.impl;

import com.bakigoal.entity.User;
import com.bakigoal.repository.UserRepository;
import com.bakigoal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bakigoal on 12.09.15.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userDAO;

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
    public User getUserById(Long id) {
        return userDAO.get(id);
    }

    @Override
    public User updateUser(User customer) {
        return userDAO.update(customer);
    }
}

