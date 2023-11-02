package g12.thread.task_1_port.service;

import g12.thread.task_1_port.model.Port;

public class Coordinator  {

    public static void startCoordinator(Port port) {
        Thread thread = new Thread(() -> {
            while (true) {
                moveShipToDock(port);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException("Coordinator", e);
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
     private static void moveShipToDock(Port port) {
        port.getDocks()
                .stream()
                .filter(dock -> dock.getShip() == null)
                .forEach(dock -> dock.setShip(port.getShips().poll()));

    }
}
