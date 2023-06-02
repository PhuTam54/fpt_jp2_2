package assignment2_javafx_db_class.controller;

import assignment2_javafx_db_class.model.Class;
import assignment2_javafx_db_class.Main;
import assignment2_javafx_db_class.databaseclass.Connector;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class FormController {
    public TextField txtName;
    public TextField txtRoom;
    public TextField txtCourse;

    public void submit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String room = txtRoom.getText();
            String course = txtCourse.getText();
            Class c = new Class(name, room, course);
            Connection conn = new Connector().getConn();

            String sql = "insert into classlist(name, room, course) values(?,?,?)";
            PreparedStatement stt = conn.prepareStatement(sql);
            stt.setString(1,c.getName());
            stt.setString(2,c.getRoom());
            stt.setString(3,c.getCourse());
            stt.executeUpdate();

            backToList(null);

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
            return;
        }
    }
    public void backToList(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../view/home.fxml"));
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }
}
