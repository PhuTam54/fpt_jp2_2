package demo3;

public class SubRun implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 8; i++) {
            System.out.println("Sub Runable i = " + i);
            try {
                Thread.sleep(1000); // 1000 milliseconds
            } catch (Exception e) {
            }
        }
    }
}
