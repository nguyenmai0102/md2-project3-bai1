package ra.business.entity;

import ra.business.design.Iorder;

import java.util.List;
import java.util.Scanner;

public class Order {
    private int id;
    private float total;

    private String phoneNumber;
    private  String Status;
    private User user;

    public Order() {
    }

    public Order(int id, float total, String phoneNumber, String status, User user) {
        this.id = id;
        this.total = total;
        this.phoneNumber = phoneNumber;
        Status = status;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
