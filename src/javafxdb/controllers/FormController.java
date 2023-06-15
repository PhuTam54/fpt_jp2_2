package javafxdb.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafxdb.daopattern.StudentRepository;
import javafxdb.Main;
import javafxdb.enums.RepositoryType;
import javafxdb.factory.RepositoryFactory;
import javafxdb.model.Student;
public class FormController {
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtTel;

    public void submit(ActionEvent actionEvent){
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String tel = txtTel.getText();
            Student sv = new Student(name, email, tel);
            // add to db
            if(RepositoryFactory.createRepositoryInstance(RepositoryType.STUDENT).create(sv)) {
                backToList(null);
            } else {
                throw new Exception("Không thể tạo mới sinh viên");
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
