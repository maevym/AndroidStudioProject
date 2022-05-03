package com.example.projectinsorma_maevymarvella;

public class Users {
    Integer userID;
    String UserEmailAddress, UserUsername, UserPhoneNumber, UserPassword;

    public Users(Integer userID, String userEmailAddress, String userUsername, String userPhoneNumber, String userPassword) {
        this.userID = userID;
        UserEmailAddress = userEmailAddress;
        UserUsername = userUsername;
        UserPhoneNumber = userPhoneNumber;
        UserPassword = userPassword;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserEmailAddress() {
        return UserEmailAddress;
    }

    public void setUserEmailAddress(String userEmailAddress) {
        UserEmailAddress = userEmailAddress;
    }

    public String getUserUsername() {
        return UserUsername;
    }

    public void setUserUsername(String userUsername) {
        UserUsername = userUsername;
    }

    public String getUserPhoneNumber() {
        return UserPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        UserPhoneNumber = userPhoneNumber;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }
}
