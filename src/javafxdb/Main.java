package javafxdb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafxdb.databasestudent.Connector;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main extends Application {

    public static Stage mainStage;

    public static void main(String[] args) {
        // add user with hash password
        String name = "abc xyz";
        String email = "abcxy@gmail.com";
        String pwd = "123456";
        String salt = BCrypt.gensalt();
        // hash password
        String hashedpwd = BCrypt.hashpw(pwd, salt);
        // save to db
        String sql = "insert into users values(?,?,?,?)";
        try {
            Connection conn = Connector.getInstance().getConn();
            PreparedStatement ptt = conn.prepareStatement(sql);
            ptt.setString(1,"0");
            ptt.setString(2, name);
            ptt.setString(3, email);
            ptt.setString(4, hashedpwd);
            ptt.executeUpdate();

        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        // login
        String dbPwd = "$2a$10$no5564ZS6jWYGVXON0WWz.3ES.VDWW102XLVQVQ5gstRaKmU5z5d6";
        boolean check = BCrypt.checkpw(pwd, dbPwd);
        System.out.println(check);
        // end

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("views/home.fxml"));
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.setTitle("Create Student Demo");
        primaryStage.show();
    }
}