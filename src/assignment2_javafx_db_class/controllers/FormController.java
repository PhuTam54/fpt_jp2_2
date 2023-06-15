package assignment2_javafx_db_class.controllers;

import assignment2_javafx_db_class.daopattern.ClassRepository;
import assignment2_javafx_db_class.model.Class;
import assignment2_javafx_db_class.Main;
import assignment2_javafx_db_class.databaseclass.Connector;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafxdb.daopattern.StudentRepository;

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
            if(ClassRepository.getInstance().create(c)) {
                backToList(null);
            } else {
                throw new Exception("Không thể tạo mới class");
            }

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
            return;
        }
    }
    public void backToList(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../views/home.fxml"));
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }
}
