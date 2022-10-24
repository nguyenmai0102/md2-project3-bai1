package ra.business.entity;

import ra.business.design.Iproduct;

import java.util.List;
import java.util.Scanner;

public class Product  {
    private  String id;
    private boolean status;
    private  String name;
    List<FlowersSpecies> list;
    private String description;
    private Catalog catalog;
    private float price;

    public Product() {
    }

    public Product(String id, boolean status, String name, List<FlowersSpecies> list, String description, Catalog catalog, float price) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.list = list;
        this.description = description;
        this.catalog = catalog;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FlowersSpecies> getList() {
        return list;
    }

    public void setList(List<FlowersSpecies> list) {
        this.list = list;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
