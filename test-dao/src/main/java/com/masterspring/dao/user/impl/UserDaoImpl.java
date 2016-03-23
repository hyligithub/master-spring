package com.masterspring.dao.user.impl;

import com.masterspring.dao.user.UserDao;
import com.masterspring.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lihuiyan on 2016/3/4.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final static String querySql = "SELECT count(*) from t_user" +
            " where user_name = ? and password=? ";

    @Override
    public int getMatchCount(String userName, String password) {

        return jdbcTemplate.queryForInt(querySql, new Object[]{userName, password});
    }

    @Override
    public User findUserByUserName(final String userName) {
        String sqlStr = "select user_id ,user_name,credits from " +
                "t_user where user_name = ?";
        final User user = new User();
        jdbcTemplate.query(sqlStr, new Object[]{userName}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(userName);
                user.setCredits(resultSet.getInt("credits"));
            }
        });
        return user;
    }

    @Override
    public void updateLoginInfo(User user) {
        String sqlStr = "update t_user set last_visit = ? and last_ip = ? and credits = ? " +
                "where user_id =?";
        jdbcTemplate.update(sqlStr, new Object[]{user.getLastIp(), user.getLastVist(), user.getCredits(), user.getUserId()});
    }
}
