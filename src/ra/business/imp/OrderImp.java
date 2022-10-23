package ra.business.imp;

import ra.business.design.Iorder;
import ra.business.entity.FlowersType;
import ra.business.entity.Order;
import ra.data.dataURL;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class OrderImp implements Iorder<Order, Integer> {
    @Override
    public boolean create(Order order) {
        return false;
    }

    @Override
    public boolean upDate(Order order) {
        return false;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order inputData(Scanner sc) {
        return null;
    }

    @Override
    public void displayData() {

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
