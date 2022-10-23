package ra.business.entity;

import ra.business.design.Iuser;

import java.util.List;
import java.util.Scanner;

public class User {
    private String userId;
    private String userName;
    private boolean status;
    private String email;
    private int creatDate;
    private String phoneNumber;
    private String passWord;
    private boolean ispermistion;

    public User() {
    }

    public User(String userId, String userName, boolean status, String email, int creatDate, String phoneNumber, String passWord, boolean ispermistion) {
        this.userId = userId;
        this.userName = userName;
        this.status = status;
        this.email = email;
        this.creatDate = creatDate;
        this.phoneNumber = phoneNumber;
        this.passWord = passWord;
        this.ispermistion = ispermistion;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public int getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(int creatDate) {
        this.creatDate = creatDate;
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