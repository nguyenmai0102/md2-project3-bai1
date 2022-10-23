package ra.business.imp;

import ra.business.design.Iuser;
import ra.business.entity.Product;
import ra.business.entity.User;
import ra.data.dataURL;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class UserImp implements Iuser<User, Integer> {
    @Override
    public boolean create(User user) {
        return false;
    }

    @Override
    public boolean upDate(User user) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User inputData(Scanner sc) {
        return null;
    }

    @Override
    public void displayData() {

    }

    @Override
    public List<User> readFromFile() {
        List<User> lisst = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            File file = new File(dataURL.URL_USER_FILE);
            if (file.exists()){
                fis =new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                lisst = (List<User>) ois.readObject();
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
    public boolean writeToFile(List<User> list) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        boolean returndata = true;
        try{
            File file = new File(dataURL.URL_USER_FILE);
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


    @Override
    public List<User> sort() {
        return null;
    }

    @Override
    public boolean changStatus(User user) {
        return false;
    }

    @Override
    public boolean changPermision(User user) {
        return false;
    }

    @Override
    public List<User> findByName(Integer integer) {
        return null;
    }
}
