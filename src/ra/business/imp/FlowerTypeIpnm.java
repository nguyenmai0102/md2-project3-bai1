package ra.business.imp;

import ra.business.design.IFlowersType;

import ra.business.entity.FlowersSpecies;
import ra.business.entity.FlowersType;
import ra.config.ShopValidate;
import ra.data.FileImp;
import ra.data.dataURL;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FlowerTypeIpnm implements IFlowersType<FlowersType, Integer> {

    @Override
    public void findById(Integer id) {
        List<FlowersType> list = readFromFile();
        for (FlowersType f : list) {
            if (f.getId() == id) {
                System.out.printf("%-10s%-31s%-40s%-10s\n", "MA DM", "TEN LOAIJ HOA", "MO TA", "TRANG THAI");
                System.out.printf("%-10s%-31s%-40s%-10s\n", f.getId(), f.getName(), f.getDescription(), f.isStatus());
            }
        }


    }

    public  List<FlowersType> findByName(String name){
        List<FlowersType> list = readFromFile();
        List<FlowersType> newlist = new ArrayList<>();
        for (FlowersType f : list) {
            if (f.getName().contains(name) ) {
                list.add(f);
            }
        }
        return list;
    }
    @Override
    public List<FlowersType> sort() {
        List<FlowersType> list= readFromFile();
        return null;
    }

    @Override
    public boolean changeStatus(Integer id) {
        List<FlowersType> list = readFromFile();
        boolean check = false;
        for (FlowersType f : list) {
            if (f.getId() == id) {
                f.setStatus(!f.isStatus());
                check = true;
            }
        }
        boolean checkSave = writeToFile(list);
        if (checkSave && checkSave) {
            return true;
        }
        return false;
    }

    @Override
    public boolean create(FlowersType flowersType) {
        List<FlowersType> list = readFromFile();
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(flowersType);
        boolean result = writeToFile(list);
        return result;
    }

    @Override
    public boolean upDate(FlowersType flowersType) {
        List<FlowersType> list = readFromFile();
        boolean returnData = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == flowersType.getId()) {
                list.set(i, flowersType);
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
    public List<FlowersType> findAll() {
        return readFromFile();
    }

    @Override
    public FlowersType inputData(Scanner sc) {
        List<FlowersType> list = readFromFile();
        if (list == null){
            list = new ArrayList<>();
        }
        //Khoi tao doi tuong de nhap thong tin
        int id;
        String name;
        String des;

        System.out.println("Nhập vào tên loaij hoa: ");
        do{
            name= sc.nextLine();
            boolean checkName = ShopValidate.checkFlowersTypeName(list,name);
            if (checkName){
                break;
            }
        }while (true);
        System.out.println("Nhập vào mô tả danh mục: ");
        do {
            des = sc.nextLine();
            if (des!= null){
                break;
            }else {
                System.err.println("khong duoc de trong");
            }
        }while (true);
        boolean isStatus = true;
        FlowersType newF = new FlowersType(name,des,isStatus);
        newF.setId(getnewId());
        return  newF;
    }

    @Override
    public void displayData() {
        List<FlowersType> list = readFromFile();
        System.out.printf("%-10s%-31s%-40s%-10s\n", "MA DM", "TEN LOAIJ HOA",  "MO TA", "TRANG THAI");
        for (FlowersType f : list) {
            System.out.printf("%-10s%-31s%-40s%-10s\n", f.getId(), f.getName(), f.getDescription(), f.isStatus());

        }
    }

    @Override
    public List<FlowersType> readFromFile() {
        List<FlowersType> lisst = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            File file = new File(dataURL.URL_FLOWERSTYPE_FILE);
            if (file.exists()){
                fis =new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                lisst = (List<FlowersType>) ois.readObject();
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
    public boolean writeToFile(List<FlowersType> list) {
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            boolean returndata = true;
            try{
                File file = new File(dataURL.URL_FLOWERSTYPE_FILE);
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

    public int getnewId(){
        List<FlowersType> list = readFromFile();
        int id;
        if (list == null){
          id=1;
        }else {
            int maxId = 1;
            for (FlowersType f:list) {
                if (f.getId()>maxId){
                    maxId= f.getId();
                }
            }
            id=maxId+1;
        }
        return id;
    }
}
