package g9.example_8_Consol;

import g9.example_8_Consol.Helper;

import java.io.Console;

public class Runner {
    public static void main(String[] args) {
        g9.example_8_Consol.Helper helper = new Helper();
        helper.readFromConsole();
        Console console = System.console();
        System.out.println(console);
    }
}
