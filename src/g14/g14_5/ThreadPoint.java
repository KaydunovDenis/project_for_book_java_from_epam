package g14.g14_5;

public class ThreadPoint extends Thread {
    private long time0;
    public long time;
    double X, Y, preX, preY;


    public ThreadPoint() {
        time0 = System.currentTimeMillis();
    }

    @Override
    public void run() {
        while (this.isAlive()) {
            double t = this.getTime();//time
            X = MovingPoint.radius * Math.cos(MovingPoint.w * t) + MovingPoint.circleX + MovingPoint.radius;
            Y = MovingPoint.radius * Math.sin(MovingPoint.w * t) + MovingPoint.circleY + MovingPoint.radius;
            preX = X;
            preY = Y;
            try {
                Thread.sleep(1000/24);
            } catch (InterruptedException e) {
                System.out.println("Прерывание ThradPoint in paint()");
                e.printStackTrace();
            }
        }
    }

    public long getTime() {
        return time = System.currentTimeMillis() - time0;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public double getPreX() {
        return preX;
    }

    public double getPreY() {
        return preY;
    }
}
