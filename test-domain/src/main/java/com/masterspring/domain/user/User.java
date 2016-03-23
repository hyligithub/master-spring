package com.masterspring.domain.user;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lihuiyan on 2016/3/4.
 */
public class User implements Serializable {

    private int userId;
    private String userName;
    private String password;
    private int credits;
    private String lastIp;
    private Date lastVist;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public Date getLastVist() {
        return lastVist;
    }

    public void setLastVist(Date lastVist) {
        this.lastVist = lastVist;
    }


}
