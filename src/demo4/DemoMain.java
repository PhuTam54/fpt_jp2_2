package demo4;
public class DemoMain {
    public static void main(String[] args) {
        Data d = new Data();
        Runnable r = () -> {
            for (int i = 0; i < 20; i++) {
//                synchronized (d) {
                    d.changeData();
                    d.printData();
//                }
                try {
                    Thread.sleep(1000);
                } catch (Exception e){

                }
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
    }
}
