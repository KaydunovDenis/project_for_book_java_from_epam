package g12.example40;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueMain {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                    queue.put("" + i);
                    System.out.println("Element " + i + " added");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            try {
                while (true) {
                    System.out.println("Element " + queue.take() + " took");
                    TimeUnit.MILLISECONDS.sleep(5000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                while (true) {
                    System.out.println(queue.size() + " elements");
                    TimeUnit.MILLISECONDS.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

