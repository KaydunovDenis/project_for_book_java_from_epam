package g12.thread.task_3_parking.service;

import g12.thread.task_3_parking.model.Auto;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ParkingService {

    private static final Random RANDOM = new Random();
    public static final int MAX_OF_PARKING_TIME = 10;
    public static final int MAX_OF_WAITING_TIME = 3;
    private static BlockingQueue<Auto> parkingSpaces;
    
    private static List<Auto> orderAutos;

    public ParkingService(int numberOfPlaces, int countOfAutos) {
        parkingSpaces = new ArrayBlockingQueue<>(numberOfPlaces);
        orderAutos = new LinkedList<>();
        fillOrderAutos(countOfAutos);
    }

    public void start() {
        startOrderAutos();
    }

    private void fillOrderAutos(int countOfAutos) {
        for (int i = 1; i <= countOfAutos; i++) {
            Auto auto = generateAuto(i);
            orderAutos.add(auto);
        }
    }
    
    private Auto generateAuto(int id) {
        int parkingTime = RANDOM.nextInt(0, MAX_OF_PARKING_TIME);
        int waitingTime = RANDOM.nextInt(0, MAX_OF_WAITING_TIME);
        return new Auto(id, parkingTime, waitingTime);
    }

    private void startOrderAutos() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Auto auto = orderAutos.removeFirst();
                try {
                    parkingSpaces.offer(auto, auto.getWaitingTime(), TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

}
