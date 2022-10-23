package ra.presentation;

import ra.business.entity.FlowersSpecies;
import ra.business.entity.FlowersType;
import ra.business.imp.FlowerTypeIpnm;
import ra.business.imp.FlowersSpeciesImp;

import java.util.List;
import java.util.Scanner;

public class FlowerMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = true;
        do {
            System.out.println("MENU");
            System.out.println("1.Quản lý loại hoa");
            System.out.println("2.Quản lý Loài Hoa");
            System.out.println("3. thoat");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    displayManuFlowersTypeManagement(sc);
                    break;
                case 2:
                    displayManuFlowersSpeciesManagement(sc);
                    break;
                case 3:
                    exit = false;
                    break;
                default:
                    System.err.println("Vui log nhap so 1-3");

            }
        } while (exit) ;

    }
    public static void displayManuFlowersSpeciesManagement(Scanner sc) {
        boolean exit = true;

        FlowersSpeciesImp fsipnm = new FlowersSpeciesImp();
        do {
            System.out.println("******************QUẢN LÝ LOẠI HOA********************");
            System.out.println("1.cập nhập danh sách");
            System.out.println("2. tạo mới loài hoa");
            System.out.println("3. xoa");
            System.out.println("4.tìm kiếm loại hoa theo tên hoặc giá tiền");
            System.out.println("5. thoát");
            System.out.println(" vui lòng chọn từ 1 đến 5");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    fsipnm.displayData();
                    break;
                case 2:
                    FlowersSpecies newF = fsipnm.inputData(sc);
                    fsipnm.create(newF);
                    break;
                case 3:
                    List<FlowersSpecies> list = fsipnm.readFromFile();
                    System.out.println("Nhap vao ma loai hoa muon xoa ");
                    String id = sc.nextLine();
                    for (FlowersSpecies f: list) {
                        if (f.getId().equals(id)){
                            fsipnm.changStatus(f);
                        }
                    }

                    break;
                case 4:
                    System.out.println("Nhap vao chuoi muon tim kiem");
                    String str = sc.nextLine();
                    List<FlowersSpecies> lists =fsipnm.findByName(str);
                    System.out.printf("%-10s%-31s%-31s%-15s%-15s%-40s%-10s\n", "MA DM", "TEN LOAIF HOA", "LOAIJ HOA", "GIA NHAP", "GIA BAN", "MO TA", "TRANG THAI");
                    for (FlowersSpecies f : lists) {
                        System.out.printf("%-10s%-31s%-31s%-15s%-15s%-40s%-10s\n", f.getId(), f.getName(), f.getTypeFlowers().getName(), f.getInputPrice(), f.getOutphutPrice(), f.getDescription(), f.isStatus());

                    }
                    break;
                case 5:
                    exit = false;
                    break;
                default:
                    break;
            }

        }while (exit);

    }
    public static void displayManuFlowersTypeManagement(Scanner sc) {
        boolean exit = true;
        FlowerTypeIpnm ftimp = new FlowerTypeIpnm();
        do {
            System.out.println("******************QUẢN LÝ LOẠI HOA********************");
            System.out.println("1.cập nhập danh sách theo thứ tự ABC");
            System.out.println("2. tạo mới loaji hoa");
            System.out.println("3. cập nhập thông tin loài hoa");
            System.out.println("4.Xoas");
            System.out.println("5.Tim kiem theo ten hoac ma");
            System.out.println("6. thoát");
            System.out.println(" vui lòng chọn từ 1 đến 5");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    ftimp.displayData();
                    break;
                case 2:
                    FlowersType newF = ftimp.inputData(sc);
                    boolean rs =ftimp.create(newF);
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Nhap id muon xoa");
                    int id = Integer.parseInt(sc.nextLine());
                    ftimp.changeStatus(id);
                    break;
                case 5:
                    System.out.println("Nhap vao chuoi muon tim kiem");
                    int so = Integer.parseInt(sc.nextLine());
                    ftimp.findById(so);
                    break;
                case 6:
                    exit = false;
                    break;
                default:
                    System.err.println("Loi");
                    break;
            }

        }while (exit);

    }


}
