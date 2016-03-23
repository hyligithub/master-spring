package com.masterspring.common.annotation;

import java.util.List;

/**
 * Created by lihuiyan on 2016/3/15.
 */
public class PasswordUtils {
    @UseCase(id = 47, description = "" +
            "Passwords must contain at least one numberic")
    public boolean validatePassword(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49, description = "new password can't equals pre password")
    public boolean checkNewPassword(List<String> prePasswords, String password) {
        return !prePasswords.contains(password);
    }
}
