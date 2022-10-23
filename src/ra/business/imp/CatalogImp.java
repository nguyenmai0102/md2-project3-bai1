package ra.business.imp;


import ra.business.design.ICatalog;
import ra.business.entity.Catalog;
import ra.config.ShopValidate;
import ra.data.FileImp;
import ra.data.dataURL;

;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatalogImp implements ICatalog<Catalog, String> {



    @Override
    public boolean create(Catalog catalog) {
        List<Catalog> listCatalog = readFromFile();
        if (listCatalog== null){
            listCatalog = new ArrayList<>();
        }
        listCatalog.add(catalog);
        boolean result = writeToFile(listCatalog);
        return result;
    }

    @Override
    public boolean upDate(Catalog catalog) { //sửa
        List<Catalog> listCatalog = readFromFile();
        boolean returnData = false;
        for (int i = 0; i < listCatalog.size(); i++) {
            if (listCatalog.get(i).getCatalogId() == catalog.getCatalogId()) {
                listCatalog.set(i, catalog);
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
    public List<Catalog> findAll() {
        return readFromFile();
    }

    @Override
    public Catalog inputData(Scanner sc) {
        List<Catalog> listCatalog = readFromFile();
        //Khoi tao doi tuong de nhap thong tin
        String catlogId;
        String catlogName;
        String des;
        int int1 ;



            System.out.println("Nhap vao ma id danh muc(bat dau tu T + 4 so bat ki): ");
        do {
            catlogId= sc.nextLine();
            boolean check = ShopValidate.checkCatalogId(listCatalog,catlogId);
            if (check){
                break;
            }
        }while (true);
        System.out.println("Nhập vào tên danh mục: ");
        do{
        catlogName= sc.nextLine();
        boolean checkName = ShopValidate.checkCatalogName(listCatalog,catlogName);
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

        System.out.println("Nhập vào đô ưu tiên danh mục: ");
        do {
            try {
                int1 =Integer.parseInt(sc.nextLine());
            }catch (Exception e){
                e.printStackTrace();
                continue;
            }
            break;
        }while (true);


        System.out.println("Nhập vào trạng thái danh mục: ");
        boolean isStatus = true;
        Catalog catnew = new Catalog(catlogId, catlogName, des,  int1,isStatus );
        return catnew;
    }

    @Override
    public void displayData() {
        List<Catalog> listCatalog = readFromFile();
        System.out.printf("%-10s%-31s%-40s%-15s%-10s\n","MA DM","TEN DM", "MO TA", "DO UU TIEN", "TRANG THAI");
        for (Catalog cat : listCatalog) {
            System.out.printf("%-10s%-31s%-40s%-15d%-10b\n", cat.getCatalogId(),cat.getCatalogname(),cat.getDescription(), cat.getzIndex(), cat.isStatus());

        }
    }

    @Override
    public List<Catalog> readFromFile() {
        FileImp<Catalog> fileImp = new FileImp<>();
        return fileImp.readFromFile(dataURL.URL_CATALOG_FILE);

    }


    @Override
    public boolean writeToFile(List<Catalog> list) {
        FileImp<Catalog> fileImp  = new FileImp<>();
      return   fileImp.writeToFile(dataURL.URL_CATALOG_FILE, list);

    }

    @Override
    public List<Catalog> sort() {
        return null;
    }


    @Override
    public List<Catalog> findByName(String name) {
        List<Catalog> listCatalogFull = readFromFile();
        List<Catalog> list = new ArrayList<>();
        for (Catalog cat : listCatalogFull) {
            if (cat.getCatalogname().contains(name)) {
                list.add(cat);
            }
        }
        return list;
    }


    @Override
    public boolean changStatus(Catalog catalog) {
        List<Catalog> listCatalogFull = readFromFile();
        boolean check = false;
        for (Catalog cat : listCatalogFull) {
            if (cat.getCatalogId()==catalog.getCatalogId()) {
                cat.setStatus(!catalog.isStatus());
                check =true;
            }
        }
        boolean checkSave= writeToFile(listCatalogFull);
        if (checkSave && checkSave){
            return true;
        }
        return false;
    }


}

