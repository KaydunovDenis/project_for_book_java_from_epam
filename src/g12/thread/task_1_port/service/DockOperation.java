package g12.thread.task_1_port.service;

import g12.thread.task_1_port.model.Dock;
import g12.thread.task_1_port.model.Port;
import g12.thread.task_1_port.model.Ship;

public class DockOperation extends Thread {
    private final Port port;
    private final Dock dock;

    public DockOperation(Port port, Dock dock) {
        this.port = port;
        this.dock = dock;
    }

    @Override
    public void run() {
        serve();
    }

    public void serve() {
        Ship ship = dock.getShip();
        if (ship != null && ship.getCurrentCapacity() > 0) {
            try {
                unloadShip(ship);
                loadChip(ship);
                dock.setShip(null);
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted. Port is overload", e);
            }
        }
    }

    private void loadChip(Ship ship) throws InterruptedException {
        while (port.getCurrentCapacity() > 0 && ship.getCurrentCapacity() < ship.getMaxCapacity()) {
            port.setCurrentCapacity(port.getCurrentCapacity() - 1);
            ship.setCurrentCapacity(ship.getCurrentCapacity() + 1);
            Thread.sleep(150);
        }
    }


    private void unloadShip(Ship ship) throws InterruptedException {
        while (port.isAvailable() && ship.getCurrentCapacity() > 0) {
            ship.setCurrentCapacity(ship.getCurrentCapacity() - 1);
            port.setCurrentCapacity(port.getCurrentCapacity() + 1);
            Thread.sleep(120);
        }
    }
}
