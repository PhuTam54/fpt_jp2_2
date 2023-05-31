package javafxdb;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FormController {
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtTel;

    public void submit(ActionEvent actionEvent) {
        String name = txtName.getText();
        String email = txtEmail.getText();
        String tel = txtTel.getText();
        try {
            for (Student s: HomeController.listStudents) {
                if (s.getName().equals(name))
                    throw new Exception("Ten sv da ton tai");
                if (s.getEmail().equals(email))
                    throw new Exception("Email da ton tai");
            }
            Student sv = new Student(name, email, tel);
            HomeController.listStudents.add(sv);
            backToList(null);

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
            return;
        }
    }
    public void backToList(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }
}
