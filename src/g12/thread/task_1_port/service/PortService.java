package g12.thread.task_1_port.service;

import g12.thread.task_1_port.model.Port;

import java.util.List;

import static g12.thread.task_1_port.util.Logger.startLogger;

public class PortService extends Thread {

    private Port port;


    public PortService(Port port) {
        this.port = port;
    }

    @Override
    public void run() {
        startLogger(port);
        Coordinator.startCoordinator(port);
        List<DockOperation> dockOperations = port.getDocks().stream()
                .map(dock -> new DockOperation(port, dock))
                .toList();
        while (!port.getShips().isEmpty() || isDocksInProgress()) {
            process(dockOperations);
        }
        System.out.println("Port stopped work");
    }

    private void process(List<DockOperation> dockOperations) {
        dockOperations.forEach(dockOperation -> dockOperation.run());
    }



    private boolean isDocksInProgress() {
        long count = port.getDocks().stream()
                .filter(dock -> dock.getShip() != null)
                .count();
        return count > 0;
    }


}
