package java87_mvc_mouseactions;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage mainStage;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("views/mouseactions.fxml"));
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.setTitle("Mouse actions");
        primaryStage.show();
    }
}
