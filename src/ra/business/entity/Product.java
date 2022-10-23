package ra.business.entity;

import ra.business.design.Iproduct;

import java.util.List;
import java.util.Scanner;

public class Product  {
    private  int Id;
    private boolean Status;
    private  String Name;
    List<FlowersSpecies> list;
    private String Description;
    private Catalog Catalog;
    private float Price;

    public Product() {
    }

    public Product(int id, boolean status, String name, List<FlowersSpecies> list, String description, ra.business.entity.Catalog catalog, float price) {
        Id = id;
        Status = status;
        Name = name;
        this.list = list;
        Description = description;
        Catalog = catalog;
        Price = price;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<FlowersSpecies> getList() {
        return list;
    }

    public void setList(List<FlowersSpecies> list) {
        this.list = list;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public ra.business.entity.Catalog getCatalog() {
        return Catalog;
    }

    public void setCatalog(ra.business.entity.Catalog catalog) {
        Catalog = catalog;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }


}
