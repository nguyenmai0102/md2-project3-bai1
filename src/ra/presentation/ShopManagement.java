package ra.presentation;

import com.sun.media.sound.SF2GlobalRegion;
import ra.business.entity.Catalog;
import ra.business.entity.FlowersSpecies;
import ra.business.entity.User;
import ra.business.imp.CatalogImp;
import ra.business.imp.FlowersSpeciesImp;

import java.util.List;
import java.util.Scanner;


public class ShopManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("*************Flowers Shop****************");
            System.out.println("1. đăng nhập");
            System.out.println("2. đăng  kí");
            System.out.println("3. thoát");
            System.out.println(" sự lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    ShopManagement.displayMenuShopManagement(sc);
                    break;
                case 2:

                    break;
                case 3:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.err.println("vui lòng chọn từ 1 đến 3");
            }
        } while (true);
    }


    public static void displayMenuShopManagement(Scanner sc) {
        boolean exit = true;
        do {
            System.out.println("**********************QUẢN LÝ CỬA HÀNG******************************************************");

            System.out.println("1.Quản lý loại hoa");
            System.out.println("2.Quản lý Loài Hoa");
            System.out.println("3. Quản lý danh mục");
            System.out.println("4.Quản lý sản phẩm từ hoa");
            System.out.println("5.Quản lý người dùng");
            System.out.println("6.Quản Lý đơn hàng");
            System.out.println("7.thoát");
            System.out.println(" lựa chọn của bạn");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    displayManuFlowersTypeManagement(sc);
                    break;
                case 2:
                    displayManuFlowersSpeciesManagement(sc);
                    break;
                case 3:
                    displayManuCatalogManagement(sc);
                    break;
                case 4:
                    buyProductFromFlowersManagement(sc);
                    break;
                case 5:
                    ContactUsers(sc);
                    break;
                case 6:
                    OderManagement(sc);
                    break;
                case 7:
                    exit = false;
                    break;
                default:
                    System.out.println("vui lòng chọn từ 1 đến 7");
            }

        } while (exit);
    }



    public static void displayManuFlowersTypeManagement(Scanner sc) {
        boolean exit = true;

        FlowersSpeciesImp fsipnm = new FlowersSpeciesImp();


        do {
            System.out.println("******************QUẢN LÝ LOẠI HOA********************");
            System.out.println("1.danh sách theo thứ tự ABC");
            System.out.println("2. tạo mới loài hoa");
            System.out.println("3. cập nhập trạng thái loài hoa");
            System.out.println("4.tìm kiếm loại hoa theo tên hoặc giá tiền");
            System.out.println("5. thoát");
            System.out.println(" vui lòng chọn từ 1 đến 5");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
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
                    for (FlowersSpecies f : list) {
                        if (f.getId().equals(id)) {
                            fsipnm.changStatus(f);
                        }
                        break;

                    }
                case 4:
                    System.out.println("Nhap vao chuoi muon tim kiem");
                    String str = sc.nextLine();
                    List<FlowersSpecies> lists = fsipnm.findByName(str);
                    System.out.printf("%-10s%-31s%-31s%-15s%-15s%-40s%-10s\n", "MA DM", "TEN LOAIF HOA", "LOAIJ HOA", "GIA NHAP", "GIA BAN", "MO TA", "TRANG THAI");
                    for (FlowersSpecies fs : lists) {
                        System.out.printf("%-10s%-31s%-31s%-15s%-15s%-40s%-10s\n", fs.getId(), fs.getName(), fs.getTypeFlowers().getName(), fs.getInputPrice(), fs.getOutphutPrice(), fs.getDescription(), fs.isStatus());

                    }
                    break;
                case 5:
                    break;
            }
        }while (true);
    }

            public static void displayManuFlowersSpeciesManagement (Scanner sc){
                boolean exit = true;
                do {
                    System.out.println("******************QUẢN LÝ lOÀI HOA********************");
                    System.out.println("1.cập nhập danh sách theo thứ tự ABC");
                    System.out.println("2. tạo mới loài hoa");
                    System.out.println("3. cập nhập thông tin loài hoa");
                    System.out.println("4.tìm kiếm loại hoa theo tên hoặc giá tiền");
                    System.out.println("5. thoát");
                    System.out.println(" vui lòng chọn từ 1 đến 5");
                    int choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            exit = false;
                            break;
                        default:
                            break;
                    }

                } while (exit);

            }
    public static void displayManuCatalogManagement(Scanner sc) {
        CatalogImp catimp = new CatalogImp();
        boolean exit = true;
        do {
            System.out.println("********** QUẢN LÝ DANH MỤC******************");
            System.out.println("1.  xếp danh sách danh mục theo mức độ ưu tiên tăng dần");
            System.out.println("2. tạo mới danh mục");
            System.out.println("3. cập nhập danh mục");
            System.out.println("4. xóa danh mục");
            System.out.println("5.tìm kiếm danh mục theo tên");
            System.out.println("6. thoát");
            System.out.println(" sụ lựa chọn của bạn");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:

                    break;
                case 2:
                    System.out.println("nhập số danh mục muốn thêm");
                    int input1 = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < input1; i++) {

                        Catalog catnew = catimp.inputData(sc);
                        catimp.create(catnew);
                        System.out.println("nhập tên danh mục muốn thêm");

                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    exit = false;
                    break;
                default:
                    System.out.println("vui lòng chọn từ 1 đến 6");

            }
        } while (exit);

    }

            public static void buyProductFromFlowersManagement (Scanner sc){
                boolean exit = true;
                do {
                    System.out.println("*********QUẢN LÝ BÁN SẢN PHẨM******************");
                    System.out.println("1.liệt kê danh sách sản phẩm theo giá bán tăng dần");
                    System.out.println("2. thêm mới sản phẩm");
                    System.out.println("3. cập nhập sản phẩm");
                    System.out.println("4. xóa sản phẩm");
                    System.out.println("5. thoaát");
                    System.out.println("lựa chọn của bạn");
                    int choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            exit = false;
                            break;
                        default:
                            System.out.println("vui lòng chọn từ 1 đến 5");
                    }

                } while (exit);

            }

            public static void ContactUsers (Scanner sc){
                boolean exit = true;
                do {
                    System.out.println("************QUẢN LÝ NGƯỜI DÙNG************ ");
                    System.out.println("1. xép xếp tài khoản theo ngày tạo tài khoản giảm dần");
                    System.out.println("2. thêm tài khoản người dùng");
                    System.out.println("3. thêm tài khoản qua trị");
                    System.out.println("4.cập nhập tài khoản người dùng");
                    System.out.println("cập nhập tai khoản quản trị");
                    System.out.println("6. tìm  kiếm tài khoản khách hàng theo tên đăng nhập hoặc tên chủ tài khoản");
                    System.out.println("7. thoát");
                    System.out.println("lựa chọn của bạn");
                    int choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        case 7:
                            exit = false;
                            break;
                        default:
                            System.out.println("vui lòng chọn từ 1 đến 7");
                    }

                } while (exit);
            }

            public static void OderManagement (Scanner sc){
                boolean exit = true;
                do {
                    System.out.println("*************** QUẢN TRỊ ĐƠN HÀNG***********************");
                    System.out.println("1. danh sách đơn hàng");
                    System.out.println("2. tổng tiền của một đơn hàng");
                    System.out.println("3. trạng thái đơn hàng");
                    System.out.println("4. đơn hàng chi tiết");
                    System.out.println("5. duyệt đơn và hủy đơn");
                    System.out.println("6. nhận phản hồi của khách hàng");
                    System.out.println("7. thoát");
                    System.out.println("lựa chọn của bạn");
                    int choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        case 7:
                            exit = false;
                            break;
                        default:
                            System.out.println("vui lòng lựa chọn từ 1 đến 7");
                    }

                } while (exit);

            }


        }


