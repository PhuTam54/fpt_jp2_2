package demo4;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 2; i++) {
                System.out.println("T1: " + i);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("T2: " + i);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
            }
        });
        t2.setDaemon(true);
        t1.start();
        t2.start();
    }
}
