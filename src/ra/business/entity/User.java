package ra.business.entity;

import ra.business.design.Iuser;

import java.util.List;
import java.util.Scanner;

public class User {
    private int userId;
    private String userName;
    private String fullName;
    private boolean status = true;
    private String email;
    private String createdDate;
    private String phoneNumber;
    private String passWord;
    private boolean ispermistion;

    public User() {
    }

    public User(int userId, String userName, String fullName, boolean status, String email, String createdDate, String phoneNumber, String passWord, boolean ispermistion) {
        this.userId = userId;
        this.userName = userName;
        this.fullName = fullName;
        this.status = status;
        this.email = email;
        this.createdDate = createdDate;
        this.phoneNumber = phoneNumber;
        this.passWord = passWord;
        this.ispermistion = ispermistion;
    }

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean isIspermistion() {
        return ispermistion;
    }

    public void setIspermistion(boolean ispermistion) {
        this.ispermistion = ispermistion;
    }


}