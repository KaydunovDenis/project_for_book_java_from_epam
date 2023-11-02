package g12.thread.task_3_parking.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Auto {
    private int id;
    private int parkingTime;
    private int waitingTime;
}
