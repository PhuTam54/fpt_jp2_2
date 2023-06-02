package javafxdb.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafxdb.databasestudent.Connector;
import javafxdb.Main;
import javafxdb.model.Student;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    public static Student editStudent;
    public TableView<Student> tbv;
    public TableColumn<Student, Integer> tcID;
    public TableColumn<Student, String> tcName;
    public TableColumn<Student, String> tcEmail;
    public TableColumn<Student, String> tcTel;
    public TableColumn<Student, Button> tcAction;

    public void goToForm(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../view/form.fxml"));
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tcID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tcTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        tcAction.setCellValueFactory(new PropertyValueFactory<>("edit"));
        try{
            Connection conn = new Connector().getConn();

            // query
            Statement stt = conn.createStatement();
            String sql = "select * from students";
            ResultSet rs = stt.executeQuery(sql);
            ObservableList<Student> list = FXCollections.observableArrayList();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String tel = rs.getString("tel");
//                Button edit = rs.getEdit("edit");
                Student s = new Student(id, name, email, tel);
                list.add(s);
            }
            tbv.setItems(list);

        }catch (Exception e){
            System.out.println("error:"+e.getMessage());
        }
    }

//    public void goToEditStudent(MouseEvent mouseEvent) throws Exception {
//        editStudent = listView.getSelectionModel().getSelectedItem();
//        Parent root = FXMLLoader.load(getClass().getResource("editform.fxml"));
//        Main.mainStage.setScene(new Scene(root, 600, 400));
//    }
}