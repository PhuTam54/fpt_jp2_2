package javafxdb.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafxdb.Main;
import javafxdb.daopattern.StudentRepository;
import javafxdb.model.Student;

import java.io.IOException;

public class EditController{
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtTel;
    public static ObservableList<Student> listStudents = FXCollections.observableArrayList();
    public void submitEdit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String telePhone = txtTel.getText();
            Student sv = new Student(name, email, telePhone);
            if(StudentRepository.getInstance().update(sv)) {
                backToList(null);
            } else {
                throw new Exception("Không thể tạo mới sinh viên");
            }
            for (Student s : listStudents) {
                if (s.getName().equals(name))
                    throw new Exception("name da ton tai"); // chi chua dc 1 dong
                if (s.getName().equals(email))
                    throw new Exception("Email da ton tai");
            }

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }

    public void backToList(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/home.fxml"));
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }
}
