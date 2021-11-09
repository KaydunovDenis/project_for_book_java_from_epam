package g14.g14v1;

public class Quest1 {
    public static void main(String[] args) {
        Thread t1=new Thread();
        t1.setPriority(7);
        ThreadGroup tg=new ThreadGroup("TG");
        tg.setMaxPriority(8);
        Thread t2=new Thread(tg,"t2");
        Thread t3 = new Thread(tg, "t3");
        t3.setPriority(9);

        System.out.println(t2.getThreadGroup());
        System.out.println("приоритет t1="
                + t1.getPriority());
        System.out.println(", приоритет t2="
                + t2.getPriority());
        System.out.println("priority t3=" + t3.getPriority());
    }
}