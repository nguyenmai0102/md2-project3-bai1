package ra.business.imp;

import ra.business.design.IflowerSpecies;
import ra.business.entity.Catalog;
import ra.business.entity.FlowersSpecies;
import ra.business.entity.FlowersType;
import ra.config.ShopValidate;
import ra.data.FileImp;
import ra.data.dataURL;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlowersSpeciesImp implements IflowerSpecies<FlowersSpecies, String> {
    @Override
    public boolean changStatus(FlowersSpecies flowersSpecies) {
        List<FlowersSpecies> list = readFromFile();
        boolean check = false;
        for (FlowersSpecies f : list) {
            if (f.getId() == flowersSpecies.getId()) {
                f.setStatus(!flowersSpecies.isStatus());
                check = true;
            }
        }
        boolean checkSave = writeToFile(list);
        if (check && checkSave) {
            return true;
        }
        return false;
    }

    @Override
    public List<FlowersSpecies> findByName(String s) {
        List<FlowersSpecies> list = readFromFile();
        List<FlowersSpecies> newlist = new ArrayList<>();
        for (FlowersSpecies f : list) {
            if (f.getId().contains(s) || f.getName().contains(s)) {
                list.add(f);
            }
        }
        return list;
    }


    @Override
    public boolean create(FlowersSpecies f) {
        List<FlowersSpecies> list = readFromFile();
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(f);
        boolean result = writeToFile(list);
        return result;
    }

    @Override
    public boolean upDate(FlowersSpecies f) {
        List<FlowersSpecies> list = readFromFile();
        boolean returnData = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == f.getId()) {
                list.set(i, f);
                returnData = true;
                break;
            }
        }
        boolean result = writeToFile(list);
        if (result && returnData) {
            return true;
        }
        return false;
    }

    @Override
    public List findAll() {
        return readFromFile();
    }

    @Override
    public FlowersSpecies inputData( Scanner sc) {
        FlowerTypeIpnm fl= new FlowerTypeIpnm();
        List<FlowersType> listType = fl.readFromFile();
        List<FlowersSpecies> list = readFromFile();
        //Khoi tao doi tuong de nhap thong tin
        String id;
        String name;
        FlowersType f1 = null;
        float inPrice, outPrice;
        String des;
        boolean status;


        System.out.println("Nhap vao ma id danh muc(bat dau tu H + 4 so bat ki): ");
        do {
            id = sc.nextLine();
            boolean check = ShopValidate.checkFlowersSpeciesId(list, id);
            if (check) {
                break;
            }
        } while (true);
        System.out.println("Nhập vào tên loaif hoa: ");
        do {
            name = sc.nextLine();
            boolean checkName = ShopValidate.checkFlowersSpeciesName(list, name);
            if (checkName) {
                break;
            }
        } while (true);
        System.out.println("Nhap loaij hoa");
        do{
            for (int i=1;i<listType.size();i++){
                System.out.printf("%d. %s",i,listType.get(i).getName());
            }
            System.out.println("Moi ban chon loaij hoa");
            try {
                int chose = Integer.parseInt(sc.nextLine());

                if (chose<1 || chose>listType.size()){
                    System.err.println("Nhap khong chinh xac");
                }
                break;
            }catch (NumberFormatException e){
                System.err.println("So khong dung dinh dang");
                continue;
            }
        }while (true);
        System.out.println("Gia Nhap :");
        do {
            try {
                inPrice = Float.parseFloat(sc.nextLine());
                if (inPrice <= 0) {
                    System.err.println("Phai nhap so > 0");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.err.println("Nhap khong dung dinh dang, vui long nhap lai");
            }
        } while (true);
        System.out.println("Gia Ban :");
        do {
            try {
                outPrice = Float.parseFloat(sc.nextLine());
                if (inPrice <= inPrice) {
                    System.err.println("Gia ban phai lon hon gia nhap");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.err.println("Nhap khong dung dinh dang, vui long nhap lai");
            }
        } while (true);
        System.out.println("Nhập vào mô tả danh mục: ");
        do {
            des = sc.nextLine();
            if (des != null) {
                break;
            } else {
                System.err.println("khong duoc de trong");
            }
        } while (true);

        System.out.println("Nhập vào trạng thái danh mục: ");
        status = true;
        FlowersSpecies f = new FlowersSpecies(id, name, des, inPrice, outPrice, f1, status);
        return f;
    }


    @Override
    public void displayData() {
        List<FlowersSpecies> list = readFromFile();
        if (list==null){
            list = new ArrayList<>();
        }
        System.out.printf("%-10s%-31s%-31s%-15s%-15s%-40s%-10s\n", "MA DM", "TEN LOAIF HOA", "LOAIJ HOA", "GIA NHAP", "GIA BAN", "MO TA", "TRANG THAI");
        for (FlowersSpecies f : list) {
            System.out.printf("%-10s%-31s%-31s%-15s%-15s%-40s%-10s\n", f.getId(), f.getName(), f.getTypeFlowers().getName(), f.getInputPrice(), f.getOutphutPrice(), f.getDescription(), f.isStatus());

        }
    }

    @Override
    public List<FlowersSpecies> readFromFile() {
        List<FlowersSpecies> lisst = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            File file = new File(dataURL.URL_FLOWERSSPECIES_FILE);
            if (file.exists()){
                fis =new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                lisst = (List<FlowersSpecies>) ois.readObject();
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (ois!=null){
                    ois.close();
                }
                if (fis!= null){
                    fis.close();
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return lisst;
    }

    @Override
    public boolean writeToFile(List<FlowersSpecies> list) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        boolean returndata = true;
        try{
            File file = new File(dataURL.URL_FLOWERSSPECIES_FILE);
            if (file.exists()){
                fos =new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(list);
            }

        }catch (Exception e){
            returndata = false;
            e.printStackTrace();
        }finally {
            try {
                if (oos!=null){
                    oos.close();
                }
                if (fos!= null){
                    fos.close();
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return returndata;
    }




}
