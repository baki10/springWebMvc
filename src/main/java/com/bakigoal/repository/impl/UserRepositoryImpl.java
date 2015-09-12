package com.bakigoal.repository.impl;

import com.bakigoal.entity.User;
import com.bakigoal.repository.UserRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by bakigoal on 12.09.15.
 */
@Repository
public class UserRepositoryImpl extends AbstractBaseRepositoryImpl<User, String> implements UserRepository {

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}
