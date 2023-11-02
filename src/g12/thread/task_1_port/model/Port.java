package g12.thread.task_1_port.model;


import g12.thread.task_1_port.util.CapacityProgressBar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Port {
    private int currentCapacity;

    private final int maxCapacity;

    private List<Dock> docks = new ArrayList<>();

    private LinkedList<Ship> ships = new LinkedList<>();

    public Port(int currentCapacity, int maxCapacity, int countOfDock) {
        this.currentCapacity = currentCapacity;
        this.maxCapacity = maxCapacity;
        for (int i = 1; i <= countOfDock; i++) {
            docks.add(new Dock(i));
        }
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }


    public void setCurrentCapacity(int currentCapacity) throws InterruptedException {
        this.currentCapacity = currentCapacity;
    }


    public List<Dock> getDocks() {
        return docks;
    }


    public LinkedList<Ship> getShips() {
        return ships;
    }

    public void setShips(LinkedList<Ship> ships) {
        this.ships = ships;
    }

    public boolean isAvailable() {
        return currentCapacity < maxCapacity;
    }

    @Override
    public String toString() {
        StringBuilder progressBar = new StringBuilder()
                .append("Port: ")
                .append(CapacityProgressBar.getProgressBar(currentCapacity, maxCapacity))
                .append("\n");
        docks.stream()
                .forEach(dock -> progressBar.append(dock.toString()));
        progressBar.append("\n");
        ships.forEach(ship -> progressBar.append(ship.toString()));

        return progressBar.toString();
    }
}
