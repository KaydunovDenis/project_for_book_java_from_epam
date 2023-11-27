package g12.thread.task_3_parking.model;



public class Auto {
    private int id;
    private int parkingTime;
    private int waitingTime;

    public Auto(int id, int parkingTime, int waitingTime) {
        this.id = id;
        this.parkingTime = parkingTime;
        this.waitingTime = waitingTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParkingTime() {
        return parkingTime;
    }

    public void setParkingTime(int parkingTime) {
        this.parkingTime = parkingTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
