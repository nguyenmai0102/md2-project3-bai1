package ra.config;

import ra.business.entity.*;
import ra.business.imp.UserImp;

import java.util.List;

public class ShopValidate {
    public static boolean checkCatalogId(List<Catalog> list, String cataloId) {
        boolean check = true;
        boolean checkvalidate = cataloId.matches("^T[0-9]{4}$");
        if (!checkvalidate) {
            System.err.println("khong hp le,nhap lai");
        } else {
            if (list != null) {
                for (Catalog cat : list) {
                    if (cat.getCatalogId().equals(cataloId)) {
                        check = false;
                        System.err.println("id da ton tai, vui long nhap lai");
                        break;
                    }
                }
            }

        }
        if (checkvalidate && check) {
            return true;
        }
        return false;
    }

    public static boolean checkCatalogName(List<Catalog> list, String catalogName) {
        boolean check = true;
        boolean checkValiDate = catalogName.matches("^.{6,30}$");
        if (!checkValiDate) {
            System.err.println("khong dung dinh dang. nhap lai");
        } else {
            if (list != null) {
                for (Catalog cat : list) {
                    if (cat.getCatalogname().equals(catalogName)) {
                        check = false;
                        break;
                    }
                }
            }

        }
        if (checkValiDate && check) {
            return true;
        }
        return false;
    }

    public static boolean checkFlowersSpeciesId(List<FlowersSpecies> list, String id) {
        boolean check = true;
        boolean checkvalidate = id.matches("^H[0-9]{4}$");
        if (!checkvalidate) {
            System.err.println("khong hp le,nhap lai");
        } else {
            if (list != null) {
                for (FlowersSpecies f : list) {
                    if (f.getId().equals(id)) {
                        check = false;
                        System.err.println("id da ton tai, vui long nhap lai");
                        break;
                    }
                }
            }

        }
        if (checkvalidate && check) {
            return true;
        }
        return false;
    }

    public static boolean checkFlowersSpeciesName(List<FlowersSpecies> list, String name) {
        boolean check = true;
        boolean checkValiDate = name.matches("^.{6,30}$");
        if (!checkValiDate) {
            System.err.println("khong dung dinh dang. nhap lai");
        } else {
            if (list != null) {
                for (FlowersSpecies f : list) {
                    if (f.getName().equals(name)) {
                        check = false;
                        break;
                    }
                }
            }

        }
        if (checkValiDate && check) {
            return true;
        }
        return false;
    }

    public static boolean checkFlowersTypeName(List<FlowersType> list, String name) {
        boolean check = true;
        boolean checkValiDate = name.matches("^.{6,30}$");
        if (!checkValiDate) {
            System.err.println("khong dung dinh dang. nhap lai");
        } else {
            if (list != null) {
                for (FlowersType f : list) {
                    if (f.getName().equals(name)) {
                        check = false;
                        break;
                    }
                }
            }

        }
        if (checkValiDate && check) {
            return true;
        }
        return false;
    }

    public static boolean checkProductId(List<Product> list, String id) {
        boolean check = true;
        boolean checkvalidate = id.matches("^P[0-9]{4}$");
        if (!checkvalidate) {
            System.err.println("khong hp le,nhap lai");
        } else {
            if (list != null) {
                for (Product f : list) {
                    if (f.getId().equals(id)) {
                        check = false;
                        System.err.println("id da ton tai, vui long nhap lai");
                        break;
                    }
                }
            }

        }
        if (checkvalidate && check) {
            return true;
        }
        return false;
    }
    public static boolean checkProductName(List<Product> list, String name) {
        boolean check = true;
        boolean checkValiDate = name.matches("^.{6,50}$");
        if (!checkValiDate) {
            System.err.println("khong dung dinh dang. nhap lai");
        } else {
            if (list != null) {
                for (Product f : list) {
                    if (f.getName().equals(name)) {
                        check = false;
                        break;
                    }
                }
            }

        }
        if (checkValiDate && check) {
            return true;
        }
        return false;
    }
    public static boolean checkUserName(String userName) {
        UserImp u = new UserImp();
        List<User> list = u.readFromFile();
        boolean check = true;
        boolean checkvalidate = userName.matches("^[\\w]{6,}$");
        if (!checkvalidate) {
            System.err.println("khong hp le,nhap lai");
        } else {
            if (list!=null){
                for (User user : list) {
                    if (user.getUserName().equals(userName)) {
                        check = false;
                        System.err.println("ten dang nhap da ton tai, vui long nhap lai");
                        break;
                    }
                }
            }

        }
        if (checkvalidate && check){
            return true;
        }
        return false;
    }
    public static boolean checkPassword(String password) {
        boolean checkvalidate = password.matches("^.{6,}$");
        if (!checkvalidate) {
            System.err.println("khong hp le,nhap lai");
        }
        return checkvalidate;
    }
    public static boolean checkEmailil(String email) {
        UserImp u = new UserImp();
        List<User> list = u.readFromFile();
        boolean check = true;
        boolean checkvalidate = email.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$");
        if (!checkvalidate) {
            System.err.println("khong hp le,nhap lai");
        } else {
            if (list!=null){
                for (User user : list) {
                    if (user.getEmail().equals(email)) {
                        check = false;
                        System.err.println("Email da duoc dang ki, vui long nhap email khac");
                        break;
                    }
                }
            }

        }
        if (checkvalidate && check){
            return true;
        }
        return false;
    }
    public static boolean checkPhone(String phone) {
        UserImp u = new UserImp();
        List<User> list = u.readFromFile();
        boolean check = true;
        boolean checkvalidate = phone.matches("^(0|84)(2(0[3-9]|1[0-6|8|9]|2[0-2|5-9]|3[2-9]|4[0-9]|5[1|2|4-9]|6[0-3|9]|7[0-7]|8[0-9]|9[0-4|6|7|9])|3[2-9]|5[5|6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])([0-9]{7})$");
        if (!checkvalidate) {
            System.err.println("khong hop le,nhap lai");
        } else {
            if (list!=null){
                for (User user : list) {
                    if (user.getPhoneNumber().equals(phone)) {
                        check = false;
                        System.err.println("So dien thoai da duoc dang ki, vui long nhap so khac");
                        break;
                    }
                }
            }

        }
        if (checkvalidate && check){
            return true;
        }
        return false;
    }

}