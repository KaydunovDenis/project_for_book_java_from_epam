package g14.example_3;

public class PriorThread extends Thread {
    public PriorThread(String name){
        super(name);
    }

    public void run(){
        for (int i = 0; i < 71; i++){
            System.out.println(getName() + " " + i);
            try {
                sleep(0);//попробовать sleep(0);
            } catch (InterruptedException e) {
                System.err.print("Error" + e);
            }
        }

    }

}
