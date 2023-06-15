package demo3;

public class Main {
    public static void main(String[] args) {
        // Sub Thread
        SubThread st1 = new SubThread();
        st1.start();

        // Sub Runable
        SubRun sr1 = new SubRun();
        Thread st2 = new Thread(sr1);
        st2.start();

        // 1 line
        new SubThread();

        // functional interface --> lambda expression
//        c1
        Runnable r1 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Main i = " + i);
                try {
                    Thread.sleep(1000); // 1000 milliseconds
                } catch (Exception e) {
                }
            }
        };

//        c2
        new Thread(()-> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Main i = " + i);
                try {
                    Thread.sleep(1000); // 1000 milliseconds
                } catch (Exception e) {
                }
            }
        }).start();

        for (int i = 0; i < 5; i++) {
            System.out.println("lambda expression i = " + i);
            try {
                Thread.sleep(1000); // 1000 milliseconds
            } catch (Exception e) {
            }
        }
    }
}
