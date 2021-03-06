package g9.example_8_Consol;

import java.io.Console;
// обработчик ошибок ввода
import java.util.InputMismatchException;
import java.util.Scanner;

public class Helper {
    //чтение информации из консоли с помощью класса Console
    public void readFromConsole() {
        Console con = System.console();
        if (con != null) {
            con.printf("Введите числовой код:");
            int code = 0;
            try {
                code = Integer.valueOf(con.readLine());
                System.out.println("Код доступа:" + code);
            } catch (InputMismatchException e) {
                con.printf("неправильный формат кода" + e);
            }
            if (code != 0) {
                con.printf("Введите пароль:");
                String password;
                char passTemp[] =
                        con.readPassword("Введите пароль: ");
                password = new String(passTemp);
                System.out.println("Пароль:" + password);
            }
        } else {
            System.out.println("Консоль недоступна");
        }
    }
}
