package com.masterspring.dao.user.impl;

import com.masterspring.dao.user.LoginDao;
import com.masterspring.domain.user.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by lihuiyan on 2016/3/4.
 */
@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insertLoginLog(LoginLog loginLog) {
        String sqlStr = "insert into t_login_info(user_id,ip,login_datetime) values (?,?,?)";
        jdbcTemplate.update(sqlStr, new Object[]{loginLog.getUserId(), loginLog.getLoginIp(), loginLog.getLoginDate()});
    }
}
