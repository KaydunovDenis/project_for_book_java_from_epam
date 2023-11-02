package g12.thread.task_1_port.model;

import g12.thread.task_1_port.util.CapacityProgressBar;

public class Ship {

    private static int countOfShip = 0;

    private final int id;
    private final int maxCapacity;
    private int currentCapacity;


    public Ship(int maxCapacity, int currentCapacity) {
        countOfShip++;
        id = countOfShip;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) throws InterruptedException {
        this.currentCapacity = currentCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        String progressBar = CapacityProgressBar.getProgressBar(currentCapacity, maxCapacity);
        return String.format("Ship: id=%-2d %s\n", id, progressBar);
    }



}
