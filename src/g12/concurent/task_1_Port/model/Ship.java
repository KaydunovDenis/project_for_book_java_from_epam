package g12.concurent.task_1_Port.model;

public class Ship {
    private int maxCapacity;
    private int currentCapacity;


    public Ship(int maxCapacity, int currentCapacity) {
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) throws InterruptedException {
        this.currentCapacity = currentCapacity;
        Thread.sleep(1000);
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}
