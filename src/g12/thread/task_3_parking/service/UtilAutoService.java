package g12.thread.task_3_parking.service;

import g12.thread.task_3_parking.model.Auto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UtilAutoService {
    public static final int MAX_OF_PARKING_TIME = 10;
    public static final int MAX_OF_WAITING_TIME = 3;
    private static final Random RANDOM = new Random();

    public static List<Auto> fillOrderAutos(int countOfAutos) {
        List<Auto> autos = new ArrayList<>();
        for (int i = 0; i <= countOfAutos; i++) {
            Auto auto = generateAuto(i);
            autos.add(auto);
        }
        return autos;
    }

    private static Auto generateAuto(int id) {
        int parkingTime = RANDOM.nextInt(0, MAX_OF_PARKING_TIME);
        int waitingTime = RANDOM.nextInt(0, MAX_OF_WAITING_TIME);
        return new Auto(id, parkingTime, waitingTime);
    }
}
