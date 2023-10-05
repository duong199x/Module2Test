package Validate;

import java.util.Scanner;

public class ValidateProduct {
    static Scanner input = new Scanner(System.in);

    public static int checkId() {
        String regex = "^\\d{3}$";
        String inputStringId;
        do {
            inputStringId = input.nextLine();
            if (inputStringId.matches(regex)) {
                break;
            } else {
                System.out.println("mật khẩu tối thiểu 6 kí tự");
            }
        } while (true);
        return Integer.parseInt(inputStringId);
    }

//    public static String checkName() {
//
//    }
//
//    public static int checkPrice() {
//
//    }
//
//    public static int checkQuantity() {
//
//    }
}
