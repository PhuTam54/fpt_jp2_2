package javafxdb.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafxdb.databasestudent.Connector;
import javafxdb.Main;
import javafxdb.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class FormController {
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtTel;

    public void submit(ActionEvent actionEvent){
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String tel = txtTel.getText();
//            for (Student s: HomeController.listStudents) {
//                if (s.getName().equals(name))
//                    throw new Exception("Ten sv da ton tai");
//                if (s.getEmail().equals(email))
//                    throw new Exception("Email da ton tai");
//            }
            Student sv = new Student(name, email, tel);
//            HomeController.listStudents.add(sv);
            Connection conn = new Connector().getConn();

            //query
//            c1
//            Statement stt = conn.createStatement();
//            String sql = "insert into students(name,email,tel) values('"+
//                    sv.getName()+"','"+sv.getEmail()+"','"+sv.getTel()+"')";
//            stt.executeUpdate(sql);

//            c2
            String sql = "insert into students(name, email, tel) values(?,?,?)";
            PreparedStatement stt = conn.prepareStatement(sql);
            stt.setString(1,sv.getName());
            stt.setString(2,sv.getEmail());
            stt.setString(3,sv.getTel());
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
