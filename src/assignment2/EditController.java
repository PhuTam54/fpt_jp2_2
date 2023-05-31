package assignment2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class EditController{
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtTel;
    public ListView<Class> listView;
    public static Class editClass;
    public static ObservableList<Class> listClasses = FXCollections.observableArrayList();
    public void submitEdit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String telePhone = txtTel.getText();
            if (editClass != null) {
                editClass.setName(name);
                editClass.setEmail(email);
                editClass.setTel(telePhone);

                listView.setItems(listClasses);
                listView.refresh();
                editClass = null;
                backToList(null);
            }
            for (Class s : listClasses) {
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
        editClass = listView.getSelectionModel().getSelectedItem();
        if (editClass != null) {
            txtName.setText(editClass.getName());
            txtEmail.setText(editClass.getEmail());
            txtTel.setText(editClass.getTel());
        }
    }

    public void backToList(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }
}
