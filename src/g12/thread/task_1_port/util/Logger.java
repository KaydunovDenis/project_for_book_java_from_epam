package g12.thread.task_1_port.util;

import g12.thread.task_1_port.model.Port;

public class Logger {

    public static final int TIME_OUT = 500;

    public static void startLogger(Port port) {
        Thread logger = new Thread(() -> {
            while (true) {
                System.out.println(port);
                try {
                    Thread.sleep(TIME_OUT);
                } catch (InterruptedException e) {
                    throw new RuntimeException("Logger", e);
                }
            }
        });
        logger.setDaemon(true);
        logger.start();
    }
}
