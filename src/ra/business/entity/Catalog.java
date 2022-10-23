package ra.business.entity;

import ra.business.design.ICatalog;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class Catalog implements Serializable {
    private  String catalogId;
    private  String catalogname;
    private  String description;
    private int zIndex;
    private boolean status;

    public Catalog() {
    }

    public Catalog(String catalogId, String catalogname, String description, int zIndex, boolean status) {
        this.catalogId = catalogId;
        this.catalogname = catalogname;
        this.description = description;
        this.zIndex = zIndex;
        this.status = status;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogname() {
        return catalogname;
    }

    public void setCatalogname(String catalogname) {
        this.catalogname = catalogname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getzIndex() {
        return zIndex;
    }

    public void setzIndex(int zIndex) {
        this.zIndex = zIndex;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
