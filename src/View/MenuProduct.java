package View;

import Manager.ProductManager;
import Model.Product;
import javafx.scene.Camera;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuProduct {
    Scanner inputInt = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    ProductManager productManager = new ProductManager();

    public void MainMenu() {
        int choice;
        do {
            System.out.println("|_______________Menu Admin___________________|\n|1.Thêm thông tin sản phẩm___________________|\n|2.Sửa thông tin sản phẩm____________________|\n|3.Xóa thông tin sản phẩm____________________|\n|4.Hiển thị thồn tin sản phẩm________________|\n|5.Tìm kiếm sản phẩm theo tên________________|\n|6.tìm kiếm sản phẩm theo loại_______________|\n|7.tìm kiếm sản phẩm theo id_________________|\n|0.thoát_____________________________________|\n|____________________________________________|");
            System.out.println("Nhập lựa chọn của bạn:");
            choice = inputInt.nextInt();
            switch (choice) {
                case 1:
                    showMenuAddProduct();
                    break;
                case 2:
                    showMenuEditProduct();
                    break;
                case 3:
                    showMenuDeleteProduct();
                    break;
                case 4:
                    showAllProduct();
                    break;
                case 5:
                    showMenuSearchByName();
                    break;
                case 6:
                    showMenuListProductByType();
                    break;
                case 7:
                    showMenuFindProductById();
                    break;
            }

        } while (choice != 0);
    }

    private void showMenuAddProduct() {
        System.out.println("|_______Menu Add_______|");
        int id;
        do {
            System.out.println("Nhập id");
            id = inputInt.nextInt();
            if (productManager.checkIdInList(id)) {
                System.out.println("Id đã tồn tại vui lòng nhập id khác");
            } else {
                break;
            }
        } while (true);
        System.out.println("Nhập tên:");
        String name = inputString.nextLine();
        System.out.println("Nhập số lượng sản phẩm:");
        int quantity = inputInt.nextInt();
        System.out.println("Nhập giá sản phẩm:");
        int price = inputInt.nextInt();
        System.out.println("Nhập loại sản phẩm:");
        String productType = inputString.nextLine();
        Product product = new Product(id, name, quantity, price, productType);
        productManager.add(product);
        System.out.println("===> thêm thành công");
    }

    private void showMenuEditProduct() {
        System.out.println("|_______Menu Edit_______|");
        int id;
        do {
            System.out.println("Nhập id");
            id = inputInt.nextInt();
            if (productManager.checkIdInList(id)) {
                break;
            } else {
                System.out.println("Id không tồn tại, vui lòng nhập lại");
            }
        } while (true);
        System.out.println("Nhập tên:");
        String name = inputString.nextLine();
        System.out.println("Nhập số lượng sản phẩm:");
        int quantity = inputInt.nextInt();
        System.out.println("Nhập giá sản phẩm:");
        int price = inputInt.nextInt();
        System.out.println("Nhập loại sản phẩm:");
        String productType = inputString.nextLine();
        Product product = new Product(id, name, quantity, price, productType);
        productManager.edit(id, product);
        System.out.println("===> sửa thành công");
    }

    private void showMenuDeleteProduct() {
        System.out.println("|_______Menu Delete_______|");
        int idDelete;
        do {
            System.out.println("Nhập id của sản phẩm muốn xóa:");
            idDelete = inputInt.nextInt();
            if (productManager.checkIdInList(idDelete)) {
                break;
            } else {
                System.out.println("Id không tồn tại, vui lòng nhập lại");
            }
        } while (true);
        productManager.delete(idDelete);
        System.out.println("===> xóa thành công");
    }

    private void showAllProduct() {
        List<Product> showList = productManager.showAll();
        for (Product product : showList
        ) {
            System.out.println(product);
        }
    }

    private void showMenuSearchByName() {
        System.out.println("Nhập tên sản phẩm cần tìm:");
        String name = inputString.nextLine();
        List<Product> showList = productManager.findByName(name);
        for (Product product : showList
        ) {
            System.out.println(product);
        }
    }

    private void showMenuListProductByType() {
        System.out.println("Nhập loại sản phẩm cần tìm:");
        String productType = inputString.nextLine();
        List<Product> showList = productManager.listProductType(productType);
        for (Product product : showList
        ) {
            System.out.println(product);
        }
    }

    private void showMenuFindProductById() {
        System.out.println("Nhập id sản phẩm cần tìm:");
        int id = inputInt.nextInt();
        Product product = productManager.searchProductById(id);
        System.out.println(product);
    }
}
