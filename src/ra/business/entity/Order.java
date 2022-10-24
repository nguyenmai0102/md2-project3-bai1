package ra.business.entity;

import ra.business.design.Iorder;

import java.util.List;
import java.util.Scanner;

public class Order {
    private int id;
    private float total;
    private  String Status;
    private  List<Product> list;
    private User user;

    public Order() {
    }

    public Order(int id, float total, String status, List<Product> list, User user) {
        this.id = id;
        this.total = total;
        Status = status;
        this.list = list;
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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
