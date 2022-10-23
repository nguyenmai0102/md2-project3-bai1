package ra.business.entity;

import ra.business.design.IFlowersType;

import java.io.Serializable;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.Scanner;

public class FlowersType implements Serializable {
    private int id;
    private String description;
    private String name;
    private boolean status;

    public FlowersType() {
    }

    public FlowersType(int id, String description, String name, boolean status) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.status = status;
    }

    public FlowersType(String description, String name, boolean status) {
        this.description = description;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
