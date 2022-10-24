package ra.business.imp;

import ra.business.design.Iproduct;
import ra.business.entity.Catalog;
import ra.business.entity.FlowersSpecies;
import ra.business.entity.FlowersType;
import ra.business.entity.Product;
import ra.config.ShopValidate;
import ra.data.dataURL;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductImp implements Iproduct<Product, String> {

    @Override
    public List<Product> sort() {
        return null;
    }

    @Override
    public boolean changeStatus(Product product) {
        List<Product> list = readFromFile();
        boolean check = false;
        for (Product f : list) {
            if (f.getId() == product.getId()) {
                f.setStatus(!f.isStatus());
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
    public boolean create(Product product) {
        List<Product> list = readFromFile();
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(product);
        boolean result = writeToFile(list);
        return result;
    }

    @Override
    public boolean upDate(Product product) {
        List<Product> list = readFromFile();
        boolean returnData = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == product.getId()) {
                list.set(i, product);
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
    public List<Product> findAll() {
        return readFromFile();
    }

    @Override
    public Product inputData(Scanner sc) {
        List<Product> list = readFromFile();
        if (list == null) {
            list = new ArrayList<>();
        }
        //Khoi tao doi tuong de nhap thong tin
        String id;
        boolean status = true;

        String name;
        List<FlowersSpecies> list2 = null;
        String des;

        Catalog catalog;
        float price =0;

        System.out.println("Nhap vao ma id danh muc(bat dau tu P + 4 so bat ki): ");
        do {
            id = sc.nextLine();
            boolean check = ShopValidate.checkProductId(list, id);
            if (check) {
                break;
            }
        } while (true);
        System.out.println("Nhập vào tên san pham (6 -50 ki tu): ");
        do {
            name = sc.nextLine();
            boolean checkName = ShopValidate.checkProductName(list, name);
            if (checkName) {
                break;
            }
        } while (true);

        System.out.println(" chon ten loaif hoa");
        FlowersSpeciesImp fsimp = new FlowersSpeciesImp();
        List<FlowersSpecies> listSp = fsimp.readFromFile();
        fsimp.displayData();

        System.out.println("vui long nhap Id cua loaif hoa muon them");

        do {
            String idsp = sc.nextLine();
            if (listSp != null) {

                for (FlowersSpecies f : listSp) {
                    if (f.getId().equals(idsp)) {
                        list2.add(f);
                        System.out.println("1.chon them loaif hoa");
                        System.out.println("2. thoat");
                        int chose2 = Integer.parseInt(sc.nextLine());
                        if (chose2 !=1){
                            break;
                        }else {
                            System.out.println("hay nhap id cua loaif hoa muon them");
                        }
                    } else {
                        System.out.println("vui long nhap lai");
                    }
                }
            }else {
                System.out.println("danh sach trong, nhap lai");
                break;
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
        CatalogImp catImp = new CatalogImp();
        List<Catalog> listCata = catImp.readFromFile();
        System.out.println("chon danh muc cho san pham");
        do{
            for (int i=1;i<=listCata.size();i++){
                System.out.printf("%d. %s",i,listCata.get(i-1).getCatalogname());
            }
            System.out.println("Moi ban chon loaij hoa");
            try {
                int chose = Integer.parseInt(sc.nextLine());

                if (chose<1 || chose>listCata.size()){
                    System.err.println("Nhap khong chinh xac, nhap lai");
                }else {
                    catalog= listCata.get(chose-1);
                    break;
                }

            }catch (NumberFormatException e){
                System.err.println("So khong dung dinh dang");
                continue;
            }
        }while (true);
        for (FlowersSpecies f: list2){
            price += f.getOutphutPrice();
        }
        price *= 1.3;
        Product proNew = new Product(id,status,name,list2,des,catalog,price);
        return  proNew;
    }

    @Override
    public void displayData() {
        List<Product> list = readFromFile();
        System.out.printf("%-10s%-20s%-60s%-10s%-60s-%30s-\n", "ID", "STATUS" ,"NAME", " LIST", " DESCRIPTION", "CATALOG", "PRICE");
        for (Product f : list) {
            System.out.printf("%-10s%-20s%-60s%-10s%-60s-%30s-\n", f.getId(),f.isStatus(), f.getName(),f.getList(),f.getDescription(), f.getCatalog(), f.getPrice());

        }
    }

    @Override
    public List<Product> readFromFile() {
        List<Product> lisst = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            File file = new File(dataURL.URL_PRODUCT_FILE);
            if (file.exists()) {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                lisst = (List<Product>) ois.readObject();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (fis != null) {
                    fis.close();
                }

            } catch (IOException e) {
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
        try {
            File file = new File(dataURL.URL_PRODUCT_FILE);
            if (file.exists()) {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(list);
            }

        } catch (Exception e) {
            returndata = false;
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (fos != null) {
                    fos.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return returndata;
    }
}
