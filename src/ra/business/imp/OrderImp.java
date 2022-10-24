package ra.business.imp;

import ra.business.design.Iorder;
import ra.business.entity.FlowersSpecies;
import ra.business.entity.FlowersType;
import ra.business.entity.Order;
import ra.business.entity.Product;
import ra.data.dataURL;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderImp implements Iorder<Order, Integer> {
    @Override
    public boolean create(Order order) {
        List<Order> list = readFromFile();
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(order);
        boolean result = writeToFile(list);
        return result;
    }

    @Override
    public boolean upDate(Order order) {
        List<Order> list = readFromFile();
        boolean returnData = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == order.getId()) {
                list.set(i, order);
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
    public List<Order> findAll() {

        return readFromFile();
    }

    @Override
    public Order inputData(Scanner sc) {
         return  null;
    }

    @Override
    public void displayData() {
        List<Order> list = readFromFile();
        System.out.printf("%-10s%-20s%-40s%-50s-\n", "ID", "TOTAL" ,"STATUS", " USER");
        for (Order od : list) {
            System.out.printf("%-10s%-20s%-40s%-50s-\n", od.getId(),od.getId(), od.getTotal(),od.getStatus(),od.getUser());

        }
    }

    @Override
    public List<Order> readFromFile() {
        List<Order> lisst = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            File file = new File(dataURL.URL_ORDER_FILE);
            if (file.exists()){
                fis =new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                lisst = (List<Order>) ois.readObject();
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
    public boolean writeToFile(List<Order> list) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        boolean returndata = true;
        try{
            File file = new File(dataURL.URL_ORDER_FILE);
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
