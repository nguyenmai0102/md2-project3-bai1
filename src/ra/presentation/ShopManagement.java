package ra.presentation;

import java.util.Scanner;


public class ShopManagement {

    public static void ShopFlowersManagement(String[] args) {

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("*************Flowers Shop****************");
            System.out.println("1. đăng nhập");
            System.out.println(" 2. đăng  kí");
            System.out.println("3. thoát");
            System.out.println(" sự lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:

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
        }while (true);
    }
        public static void login(Scanner sc){

        }

    public static void  displayMenuShopManagement(Scanner sc) {
        boolean exit = true;
        do {
            System.out.println("**********************QUẢN LÝ CỬA HÀNG******************************************************");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2.Quản lý loại hoa");
            System.out.println("3.Quản lý Loài Hoa");
            System.out.println("4.Quản lý sản phẩm từ hoa");
            System.out.println("5.Quản lý người dùng");
            System.out.println("6.Quản Lý đơn hàng");
            System.out.println("7.thoát");
            System.out.println(" lựa chọn của bạn");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
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

        }while (exit);
    }

    public static void displayManuCatalogManagement(Scanner sc) {
        boolean exit = true;
        do {
            System.out.println("********** QUẢN LÝ DANH MỤC******************");
            System.out.println("1.  xếp danh sách danh mục theo mức độ ưu tiên tăng dần");
            System.out.println("2. tạo mới danh mục");
            System.out.println("3. cập nhập danh mục");
            System.out.println("4. xóa danh mục");
            System.out.println("5.tìm kiếm danh mục theo tên" );
            System.out.println("6. thoát");
            System.out.println(" sụ lựa chọn của bạn");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
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
                    exit= false;
                    break;
                default:
                    System.out.println("vui lòng chọn từ 1 đến 6");

            }
        }while (exit);

    }

    public static void displayManuFlowersTypeManagement(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = true;
        do {
            System.out.println("******************QUẢN LÝ LOẠI HOA********************");
            System.out.println("1.cập nhập danh sách theo thứ tự ABC");
            System.out.println("2. tạo mới loài hoa");
            System.out.println("3. cập nhập thông tin loài hoa");
            System.out.println("4.tìm kiếm loại hoa theo tên hoặc mã");
            System.out.println("5. thoát");
            System.out.println(" vui lòng chọn từ 1 đến 5");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
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

        }while (exit);

    }

    public static void displayManuFlowersSpeciesManagement(Scanner sc) {
        boolean exit = true;
        do {
            System.out.println("******************QUẢN LÝ LOAFI HOA********************");
            System.out.println("1.cập nhập danh sách theo thứ tự ABC");
            System.out.println("2. tạo mới loài hoa");
            System.out.println("3. cập nhập thông tin loài hoa");
            System.out.println("4.tìm kiếm loại hoa theo tên hoặc giá tiền");
            System.out.println("5. thoát");
            System.out.println(" vui lòng chọn từ 1 đến 5");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
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

        }while (exit);

    }

    public static void BuyProductFromFlowersManagement(Scanner sc) {
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

    public static void ContactUsers(Scanner sc) {
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
            switch (choice){
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
                    exit =false;
                    break;
                default:
                    System.out.println("vui lòng chọn từ 1 đến 7");
            }

        }while (exit);
    }

    public static void OderManagement(String[] args) {
        Scanner sc = new Scanner(System.in);
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
            switch (choice){
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
                    exit =  false;
                    break;
                default:
                    System.out.println("vui lòng lựa chọn từ 1 đến 7");
            }

        }while (exit);

    }
}


