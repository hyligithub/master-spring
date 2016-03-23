package com.masterspring.domain.user;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lihuiyan on 2016/3/4.
 */
public class LoginLog implements Serializable {
    private int loginId;
    private int userId;
    private String loginIp;
    private Date loginDate;

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
