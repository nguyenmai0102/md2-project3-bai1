package ra.business.imp;

import ra.business.design.Iuser;
import ra.business.entity.*;
import ra.config.ShopValidate;
import ra.data.dataURL;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserImp implements Iuser<User, Integer> {
    @Override
    public boolean create(User user) {
        List<User> listCatalog = readFromFile();
        if (listCatalog== null){
            listCatalog = new ArrayList<>();
        }
        listCatalog.add(user);
        boolean result = writeToFile(listCatalog);
        return result;
    }

    @Override
    public boolean upDate(User user) {
        List<User> listCatalog = readFromFile();
        boolean returnData = false;
        for (int i = 0; i < listCatalog.size(); i++) {
            if (listCatalog.get(i).getUserId() == user.getUserId()) {
                listCatalog.set(i, user);
                returnData = true;
                break;
            }
        }
        boolean result = writeToFile(listCatalog);
        if (result && returnData) {
            return true;
        }
        return false;

    }

    @Override
    public List<User> findAll() {
        return readFromFile();
    }

    @Override
    public User inputData(Scanner sc) {
        List<User> list = readFromFile();
        if (list == null){
            list = new ArrayList<>();
        }
        //Khoi tao doi tuong de nhap thong tin
        int  userId;
        String username;
        String fullname;
        String password;
        String repassword;
        String email;
        String phoneNumber;
        String createdDate;
        boolean status=true;
        boolean isPermission=false;


        System.out.println("Nhập username: ");
        do{
            username= sc.nextLine();
            boolean checkName = ShopValidate.checkUserName(username);
            if (checkName){
                break;
            }
        }while (true);
        System.out.println("Nhap password : ");
        do {
            password = sc.nextLine();
            boolean check = ShopValidate.checkPassword(password);
            if (check){
                break;
            }
        }while (true);
        System.out.println("Nhap lai password : ");
        do {
            repassword = sc.nextLine();
            if (repassword.equals(password)) {
                System.err.println("mat khau khong giong nhau, nhap lai");
            }else {
                break;
            }
        }while (true);
        System.out.println("Nhap email : ");
        do {
            email = sc.nextLine();
            boolean check = ShopValidate.checkEmailil(email);
            if (check){
                break;
            }
        }while (true);
        System.out.println("Nhap so dien thoai : ");
        do {
            phoneNumber = sc.nextLine();
            boolean check = ShopValidate.checkPhone(phoneNumber);
            if (check){
                break;
            }
        }while (true);
        System.out.println("Nhap ten day du : ");
        fullname = sc.nextLine();
        int userid = getnewId();
        Date date = new Date();

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
        createdDate = dateFormat.format(date);


        User newUser = new User(userid,username,fullname,status,email,createdDate,phoneNumber,password,isPermission);
        return  newUser;
    }


    @Override
    public void displayData() {
        List<User> users = readFromFile();
        System.out.printf("%-10s%-30s%-30s%-20s%-20s\n", "USER ID", "USERNAME","FULLNAME" ,"LOAI TAI KHOAN", "TRANG THAI");
        for (User u : users) {
            String permission = u.isIspermistion()?"Quan tri vien":"Khách hang";
            String status = u.isStatus()?"Hoat Dong":"Bi Khoa";
            System.out.printf("%-10s%-30s%-30s%-20s%-20s\n", u.getUserId(),u.getUserName(),u.getFullName(), permission, status);

        }
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
    public void sort() {
        List<User> userS = readFromFile();
        Collections.sort(userS, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getUserName().compareTo(o2.getUserName());
            }
        });
        System.out.printf("%-10s%-30s%-30s%-20s%-20s\n", "USER ID", "USERNAME","FULLNAME" ,"LOAI TAI KHOAN", "TRANG THAI");
        for (User u : userS) {
            String permission = u.isIspermistion()?"Quan tri vien":"Khách hang";
            String status = u.isStatus()?"Hoat Dong":"Bi Khoa";
            System.out.printf("%-10s%-30s%-30s%-20s%-20s\n", u.getUserId(),u.getUserName(),u.getFullName(), permission, status);

        }
    }

    @Override
    public boolean changStatus(User user) {
        List<User> list = readFromFile();
        boolean check = false;
        for (User f : list) {
            if (f.getUserId() == user.getUserId()) {
                f.setStatus(!user.isStatus());
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
    public boolean changePermision(User user) {
        List<User> list = readFromFile();
        boolean check = false;
        for (User f : list) {
            if (f.getUserId() == user.getUserId()) {
                f.setIspermistion(!user.isIspermistion());
                check = true;
            }
        }
        boolean checkSave = writeToFile(list);
        if (check && checkSave) {
            return true;
        }
        return false;
    }


    public List<User> findByName(String str) {
        List<User> listUserFull = readFromFile();
        List<User> list = new ArrayList<>();
        for (User u : listUserFull) {
            if (u.getUserName().contains(str)) {
                list.add(u);
            }
        }
        return list;
    }
    public int getnewId(){
        List<User> list = readFromFile();
        int id;
        if (list == null){
            id=1;
        }else {
            int maxId = 1;
            for (User f:list) {
                if (f.getUserId()>maxId){
                    maxId= f.getUserId();
                }
            }
            id=maxId+1;
        }
        return id;
    }

    public User checkLogin(String userName, String password) {
        List<User> listUser = readFromFile();
        for (User user : listUser) {
            if (user.getUserName().equals(userName)&&user.getPassWord().equals(password)){
                return user;
            }
        }
        return null;
    }
}
