package ra.config;

import ra.business.entity.Catalog;
import ra.business.entity.FlowersSpecies;
import ra.business.entity.FlowersType;

import java.util.List;

public class ShopValidate {
    public static boolean checkCatalogId(List<Catalog> list, String cataloId) {
        boolean check = true;
        boolean checkvalidate = cataloId.matches("^T[0-9]{4}$");
        if (!checkvalidate) {
            System.err.println("khong hp le,nhap lai");
        } else {
            if (list!=null){
                for (Catalog cat : list) {
                    if (cat.getCatalogId().equals(cataloId)) {
                        check = false;
                        System.err.println("id da ton tai, vui long nhap lai");
                        break;
                    }
                }
            }

        }
        if (checkvalidate && check){
            return true;
        }
    return false;
    }
    public static boolean checkCatalogName(List<Catalog> list, String catalogName) {
        boolean check = true;
        boolean checkValiDate = catalogName.matches("^.{6,30}$");
        if (!checkValiDate){
            System.err.println("khong dung dinh dang. nhap lai");
        }else {
            if (list!=null){
                for (Catalog cat : list) {
                    if (cat.getCatalogname().equals(catalogName)) {
                        check = false;
                        break;
                    }
                }
            }

        }
        if (checkValiDate && check){
            return true;
        }
        return false;
    }
    public static boolean checkFlowersSpeciesId(List<FlowersSpecies> list, String id) {
        boolean check = true;
        boolean checkvalidate = id.matches("^H[0-9]{4}$");
        if (!checkvalidate) {
            System.err.println("khong hp le,nhap lai");
        } else {
            if (list!=null){
                for (FlowersSpecies f : list) {
                    if (f.getId().equals(id)) {
                        check = false;
                        System.err.println("id da ton tai, vui long nhap lai");
                        break;
                    }
                }
            }

        }
        if (checkvalidate && check){
            return true;
        }
    return false;
    }
    public static boolean checkFlowersSpeciesName(List<FlowersSpecies> list, String name) {
        boolean check = true;
        boolean checkValiDate = name.matches("^.{6,30}$");
        if (!checkValiDate){
            System.err.println("khong dung dinh dang. nhap lai");
        }else {
            if (list!=null){
                for (FlowersSpecies f : list) {
                    if (f.getName().equals(name)) {
                        check = false;
                        break;
                    }
                }
            }

        }
        if (checkValiDate && check){
            return true;
        }
        return false;
    }
    public static boolean checkFlowersTypeName(List<FlowersType> list, String name) {
        boolean check = true;
        boolean checkValiDate = name.matches("^.{6,30}$");
        if (!checkValiDate){
            System.err.println("khong dung dinh dang. nhap lai");
        }else {
            if (list!=null){
                for (FlowersType f : list) {
                    if (f.getName().equals(name)) {
                        check = false;
                        break;
                    }
                }
            }

        }
        if (checkValiDate && check){
            return true;
        }
        return false;
    }

}
