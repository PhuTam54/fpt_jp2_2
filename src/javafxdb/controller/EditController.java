package javafxdb.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafxdb.Main;
import javafxdb.model.Student;

import java.io.IOException;

public class EditController{
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtTel;
    public ListView<Student> listView;
    public static Student editStudent;
    public static ObservableList<Student> listStudents = FXCollections.observableArrayList();
    public void submitEdit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String telePhone = txtTel.getText();
            if (editStudent != null) {
                editStudent.setName(name);
                editStudent.setEmail(email);
                editStudent.setTel(telePhone);

                listView.setItems(listStudents);
                listView.refresh();
                editStudent = null;
                backToList(null);
            }
            for (Student s : listStudents) {
                if (s.getName().equals(name))
                    throw new Exception("name da ton tai"); // chi chua dc 1 dong
//              throw new Exception("name da ton tai"); // nam ngoai cua if neu muon cho vao trong thif them {}
                if (s.getName().equals(email))
                    throw new Exception("Email da ton tai");

            }

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
    public void editStudent(ActionEvent actionEvent) {
        editStudent = listView.getSelectionModel().getSelectedItem();
        if (editStudent != null) {
            txtName.setText(editStudent.getName());
            txtEmail.setText(editStudent.getEmail());
            txtTel.setText(editStudent.getTel());
        }
    }

    public void backToList(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../view/home.fxml"));
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }
}
