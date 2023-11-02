package g12.thread.task_3_parking;

import g12.thread.task_3_parking.service.ParkingService;

public class ParkingApp {
    public static void main(String[] args) {
        ParkingService parkingService = new ParkingService(2, 5);
        parkingService.start();
    }
}
