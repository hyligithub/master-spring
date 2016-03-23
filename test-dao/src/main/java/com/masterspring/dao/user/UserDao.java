package com.masterspring.dao.user;

import com.masterspring.domain.user.User;

/**
 * Created by lihuiyan on 2016/3/4.
 */
public interface UserDao {

    int getMatchCount(String userName, String password);

    User findUserByUserName(String userName);

    void updateLoginInfo(User user);

}
