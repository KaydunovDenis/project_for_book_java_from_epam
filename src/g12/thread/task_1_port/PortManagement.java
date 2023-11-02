package g12.thread.task_1_port;

import g12.thread.task_1_port.model.Port;
import g12.thread.task_1_port.model.Ship;
import g12.thread.task_1_port.service.PortService;

import java.util.LinkedList;
import java.util.List;

public class PortManagement {
    public static void main(String[] args) {
        PortService portService = initPortService();
        portService.start();

    }

    private static PortService initPortService() {
        Port port = new Port(40, 50, 5);

        Ship ship1 = new Ship(10, 1);
        Ship ship2 = new Ship(9, 2);
        Ship ship3 = new Ship(6, 3);
        Ship ship4 = new Ship(5, 4);
        Ship ship5 = new Ship(10, 5);
        Ship ship6 = new Ship(10, 6);
        Ship ship7 = new Ship(10, 7);
        Ship ship8 = new Ship(15, 1);
        Ship ship9 = new Ship(10, 9);
        Ship ship10 = new Ship(10, 10);

        LinkedList<Ship> ships = new LinkedList<>(List.of(ship1, ship2, ship3, ship4, ship5, ship6, ship7, ship8, ship9, ship10));
        port.setShips(ships);

        return new PortService(port);
    }
}
