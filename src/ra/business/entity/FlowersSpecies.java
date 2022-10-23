package ra.business.entity;

import ra.business.design.IflowerSpecies;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class FlowersSpecies  implements Serializable {
    private String id;
    private String name;
    private String description;
    private float inputPrice;
    private  float outphutPrice;
    private FlowersType typeFlowers;
    private boolean status;

    public FlowersSpecies() {
    }

    public FlowersSpecies(String id, String name, String description, float inputPrice, float outphutPrice, FlowersType typeFlowers, boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.inputPrice = inputPrice;
        this.outphutPrice = outphutPrice;
        this.typeFlowers = typeFlowers;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getInputPrice() {
        return inputPrice;
    }

    public void setInputPrice(float inputPrice) {
        this.inputPrice = inputPrice;
    }

    public float getOutphutPrice() {
        return outphutPrice;
    }

    public void setOutphutPrice(float outphutPrice) {
        this.outphutPrice = outphutPrice;
    }

    public FlowersType getTypeFlowers() {
        return typeFlowers;
    }

    public void setTypeFlowers(FlowersType typeFlowers) {
        this.typeFlowers = typeFlowers;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
