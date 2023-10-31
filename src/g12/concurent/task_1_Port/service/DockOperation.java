package g12.concurent.task_1_Port.service;

import g12.concurent.task_1_Port.model.Ship;
import g12.concurent.task_1_Port.model.Port;

public class DockOperation extends Thread{

    private Port port;
    private Ship ship;

    public DockOperation(Port port, Ship ship) {
        this.port = port;
        this.ship = ship;
    }

    @Override
    public void start() {
        super.start();
        try {
            serve();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void serve() throws InterruptedException {
        if(ship.getCurrentCapacity() > 0) {
            unloadShip();
            loadChip();
        }
    }

    void loadChip() throws InterruptedException {
        if(port.getCurrentCapacity() > 0 && ship.getCurrentCapacity() < ship.getMaxCapacity()) {
            port.setCurrentCapacity(port.getCurrentCapacity() - 1);
            ship.setCurrentCapacity(ship.getCurrentCapacity() + 1);
        }
    }

    void unloadShip () throws InterruptedException {
        if(port.getCurrentCapacity() < port.getMaxCapacity() && ship.getCurrentCapacity() > 0) {
            port.setCurrentCapacity(port.getCurrentCapacity() - 1);
            ship.setCurrentCapacity(ship.getCurrentCapacity() + 1);
        }
    }



}
