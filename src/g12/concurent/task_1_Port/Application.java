package g12.concurent.task_1_Port;

import g12.concurent.task_1_Port.model.Port;
import g12.concurent.task_1_Port.model.Ship;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Port port = new Port(25, 50, 2);

        Ship ship1 = new Ship(10, 1);
        Ship ship2 = new Ship(9, 2);
        Ship ship3 = new Ship(6, 3);
        Ship ship4 = new Ship(5, 4);
        Ship ship5 = new Ship(10, 5);
        Ship ship6 = new Ship(10, 6);
        Ship ship7 = new Ship(10, 7);
        Ship ship8 = new Ship(8, 8);
        Ship ship9 = new Ship(10, 9);
        Ship ship10 = new Ship(10, 10);

        List<Ship> ships = List.of(ship1, ship2, ship3, ship4, ship5, ship6, ship7, ship8, ship9, ship10);



    }
}
