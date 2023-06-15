package demo4.clockdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClockMain extends Application {
    public static void main(String[] args) {
        launch(args);
        ClockController cl = new ClockController();
        Thread t1 = new Thread(()->{
        });
    }
    public static Stage mainStage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("clock.fxml"));
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.setTitle("Clock");
        primaryStage.show();
    }
}
