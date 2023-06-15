package demo3;

public class SubThread extends Thread{
    public void run() {
        for (int i = 0; i < 7; i++) {
            System.out.println("Sub Thread i = " + i);
            try {
                Thread.sleep(1000); // 1000 milliseconds
            } catch (Exception e) {
            }
        }
    }
}
