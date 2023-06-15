package demo4;

public class Data {
    int x = 0;
    int y = 0;
    int z = 0;
    public synchronized void changeData() {
        x ++;
        y ++;
    }
    public synchronized void printData() {
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
    public void changeDataz() {
        z ++;
    }
    public void printDataz() {
        System.out.println("z = " + z);
    }
}
