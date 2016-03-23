package com.masterspring.dao.user;

import com.masterspring.domain.user.LoginLog;

/**
 * Created by lihuiyan on 2016/3/4.
 */
public interface LoginDao {
    public  void insertLoginLog(LoginLog loginLog);
}
