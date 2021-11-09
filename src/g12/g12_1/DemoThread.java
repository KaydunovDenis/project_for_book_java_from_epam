package g12.g12_1;

public class DemoThread extends Thread {
    private Paint paint;

    public DemoThread(Paint paint) {
        this.paint = paint;
    }

    @Override
    public void run() {
        try {
            while (true) {
                sleep(1000);
                paint.drawLines();
                System.out.println("Thread draw Lines");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
