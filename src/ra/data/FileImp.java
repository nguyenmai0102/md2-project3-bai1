package ra.data;

import ra.business.entity.Catalog;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileImp<T> implements Serializable{
    public List<T> readFromFile(String path){
        List<T> alist = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            File file = new File(path);
            if (file.exists()) {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                alist = (List<T>) ois.readObject();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex2) {
                ex2.printStackTrace();
            }
        }
         return alist;
    }


    public boolean writeToFile(String path,List<T> list) {

        File file = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        boolean returnData = true;
        try {
            file = new File(path);
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        } catch (Exception ex) {
            returnData = false;
            ex.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ex2) {
                ex2.printStackTrace();
            }
        }
        return returnData;
    }

}
