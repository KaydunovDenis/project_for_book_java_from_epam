package g12.concurent.task_1_Port.model;


public class Port {
    private int currentCapacity;

    private int maxCapacity;
    private int countOfDock;

    public Port(int currentCapacity, int maxCapacity, int countOfDock) {
        this.currentCapacity = currentCapacity;
        this.maxCapacity = maxCapacity;
        this.countOfDock = countOfDock;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) throws InterruptedException {
        this.currentCapacity = currentCapacity;
        Thread.sleep(1000);
    }

    public int getCountOfDock() {
        return countOfDock;
    }

    public void setCountOfDock(int countOfDock) {
        this.countOfDock = countOfDock;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}
