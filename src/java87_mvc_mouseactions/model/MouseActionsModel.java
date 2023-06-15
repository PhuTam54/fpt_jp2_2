package java87_mvc_mouseactions.model;

public class MouseActionsModel {
    private double x, y;
    private int count;
    private String isIn; // yes, no

    public MouseActionsModel() {
        this.x = 0;
        this.y = 0;
        this.count = 0;
        this.isIn = "no";
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getIsIn() {
        return isIn;
    }

    public void setIsIn(String isIn) {
        this.isIn = isIn;
    }

    public void addClick() {
        this.count++;
    }

    public void enter() {
        this.isIn = "Yes";
    }
    public void exit() {
        this.isIn = "No";
    }
    public void updatePos(double x, double y) {
        this.setX(x);
        this.setY(y);
    }
}
