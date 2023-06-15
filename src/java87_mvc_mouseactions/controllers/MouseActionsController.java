package java87_mvc_mouseactions.controllers;

import java87_mvc_mouseactions.model.MouseActionsModel;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class MouseActionsController {
    public Label valueX;
    public Label valueY;
    public Label valueCount;
    public Label valueIsIn;
    MouseActionsModel ma = new MouseActionsModel();

    public void click(MouseEvent mouseEvent) {
        ma.addClick();
        this.valueCount.setText(ma.getCount()+"");
    }

    public void entered(MouseEvent mouseEvent) {
        ma.enter();
        this.valueIsIn.setText(ma.getIsIn());
    }

    public void exited(MouseEvent mouseEvent) {
        ma.exit();
        this.valueIsIn.setText(ma.getIsIn());
    }

    public void moved(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        ma.updatePos(x, y);
        this.valueX.setText("x: " + ma.getX());
        this.valueY.setText("y: " + ma.getY());
    }
}
