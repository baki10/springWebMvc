package com.bakigoal.repository;

import com.bakigoal.entity.User;
import com.bakigoal.entity.UserFriend;

import java.util.Set;

/**
 * Created by bakigoal on 12.09.15.
 */
public interface UserFriendRepository extends SuperRepository<UserFriend, Integer> {

    Set<User> getUserFriends(User user);

    void addFriendToUser(User user, User friend);

    void deleteFriendFromUser(User user, User friend);
}
