package com.bakigoal.repository.impl;

import com.bakigoal.entity.User;
import com.bakigoal.entity.UserFriend;
import com.bakigoal.repository.UserFriendRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by bakigoal on 15.09.15.
 */
@Repository
public class UserFriendRepositoryImpl extends AbstractBaseRepositoryImpl<UserFriend, Integer>
        implements UserFriendRepository {
    @Override
    public Set<User> getUserFriends(User user) {
        Set<User> friends = new HashSet<>();
        List<UserFriend> resultList = getUserFriendList(user);
        for (UserFriend userFriend : resultList) {
            friends.add(userFriend.getFriend());
        }
        return friends;
    }

    private List<UserFriend> getUserFriendList(User user) {
        List<UserFriend> userFriends = new ArrayList<>();
        if (user == null) {
            return userFriends;
        }
        TypedQuery<UserFriend> namedQuery =
                em.createQuery("SELECT u FROM UserFriend u WHERE u.user.username= :userId", UserFriend.class);
        namedQuery.setParameter("userId", user.getUsername());
        return namedQuery.getResultList();
    }

    @Override
    public void addFriendToUser(User user, User friend) {
        UserFriend userFriend = new UserFriend();
        userFriend.setUser(user);
        userFriend.setFriend(friend);
        create(userFriend);
    }

    @Override
    public void deleteFriendFromUser(User user, User friend) {
        List<UserFriend> userFriends = getUserFriendList(user);
        for (UserFriend userFriend : userFriends) {
            User friendUser = userFriend.getFriend();
            if (friendUser != null && friend.getUsername().equals(friendUser.getUsername())) {
                delete(userFriend);
            }
        }
    }

    @Override
    protected Class<UserFriend> getEntityClass() {
        return UserFriend.class;
    }
}
