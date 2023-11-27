package g12.thread.task_3_parking.service;

import g12.thread.task_3_parking.model.Auto;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ParkingService {
    private static BlockingQueue<Auto> parkingSpaces;
    private static List<Auto> orderAutos;

    public ParkingService(int numberOfPlaces, int countOfAutos) {
        parkingSpaces = new ArrayBlockingQueue<>(numberOfPlaces);
        orderAutos = new LinkedList<>();
        orderAutos = UtilAutoService.fillOrderAutos(countOfAutos);
    }

    public void start() {
        System.out.println("ParkingService started");
        startLogger();
        startPArkingProcess();
        System.out.println("ParkingService finished");
    }

    private static void startPArkingProcess() {
        new Thread(() -> {
            Auto auto = orderAutos.removeFirst();
            try {
                parkingSpaces.offer(auto, auto.getWaitingTime(), TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException("Parking process ERROR!", e);
            }
        }).start();
    }

    private static void startLogger() {
        new Thread(() -> {
            System.out.println("Logger started");
            while (true) {
                log();
            }
        }).start();
    }

    private static void log() {
        System.out.println(parkingSpaces.toString());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Logger ERROR!",e);
        }
    }

    @Override
    public String toString() {
        return "ParkingService: "
                + parkingSpaces.toString() + "/n"
                + orderAutos.toString();
    }
}
