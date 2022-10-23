package ra.business.imp;

import ra.business.design.Iproduct;
import ra.business.entity.FlowersType;
import ra.business.entity.Product;
import ra.data.dataURL;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class ProductImp implements Iproduct<Product,String> {

    @Override
    public List<Product> sort() {
        return null;
    }

    @Override
    public boolean changeStatus(Product product) {
        return false;
    }

    @Override
    public boolean create(Product product) {
        return false;
    }

    @Override
    public boolean upDate(Product product) {
        return false;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product inputData(Scanner sc) {
        return null;
    }

    @Override
    public void displayData() {

    }

    @Override
    public List<Product> readFromFile() {
        List<Product> lisst = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            File file = new File(dataURL.URL_PRODUCT_FILE);
            if (file.exists()){
                fis =new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                lisst = (List<Product>) ois.readObject();
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
    public boolean writeToFile(List<Product> list) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        boolean returndata = true;
        try{
            File file = new File(dataURL.URL_PRODUCT_FILE);
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
