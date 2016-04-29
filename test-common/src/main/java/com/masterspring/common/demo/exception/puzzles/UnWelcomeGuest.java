package com.masterspring.common.demo.exception.puzzles;

/**
 * Created by lihuiyan on 2015/5/20.
 */
public class UnWelcomeGuest {
    private static final long GUEST_USER_ID = -1L;
    private static final long USER_ID = getUserIdOrGuest();

    private static long getUserIdOrGuest() {
        try {
            return getUserIdFromEnvironment();
        } catch (IdUnavailableException e) {
            System.out.println("Logging in as guest");
            return GUEST_USER_ID;
        }
    }

    public static void main(String[] args) {
        System.out.println("User ID: " + USER_ID);
    }

    private static long getUserIdFromEnvironment() throws IdUnavailableException {
        throw new IdUnavailableException();
    }
}

class IdUnavailableException extends Exception {

}