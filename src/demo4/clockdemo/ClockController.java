package demo4.clockdemo;

import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ClockController implements Initializable{
    public Text txtMin;
    public Text txtSec;
    int min = 30;
    int sec = 0;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        txtMin.setText(min + ":");
//        txtSec.setText(String.valueOf(sec));
        new Thread(()-> {
            boolean flag = true;
            while (flag) {
                txtMin.setText(min + ":");
                txtSec.setText(String.valueOf(sec));
                sec--;
                if (sec < 0) {
                    sec = 59;
                    min --;
                }
                if (min < 0) {
                    flag = false;
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("Thread: " + e.getMessage());
                }
            }
        }).start();

        new Thread(()-> {
            boolean flag = true;

        }).start();
    }

    // method


    // mouse event
    public synchronized void start(MouseEvent mouseEvent) {
        try {
            System.out.println("START");
            notify();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public synchronized void pause(MouseEvent mouseEvent) {
        try {
            System.out.println("PAUSE");
            wait();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public synchronized void stop(MouseEvent mouseEvent) {
        try {
            System.out.println("STOP");
            txtMin.setText(30 + ":");
            txtSec.setText("00");
            wait();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
