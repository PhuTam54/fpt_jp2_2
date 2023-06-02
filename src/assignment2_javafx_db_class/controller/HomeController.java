package assignment2_javafx_db_class.controller;

import assignment2_javafx_db_class.model.Class;
import assignment2_javafx_db_class.Main;
import assignment2_javafx_db_class.databaseclass.Connector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    public static Class editClass;
    public TableView<Class> tbv;
    public TableColumn<Class, Integer> tcID;
    public TableColumn<Class, String> tcName;
    public TableColumn<Class, String> tcRoom;
    public TableColumn<Class, String> tcCourse;
    public TableColumn<Class, Button> tcAction;

    public void goToForm(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../view/form.fxml"));
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tcID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tcRoom.setCellValueFactory(new PropertyValueFactory<>("room"));
        tcCourse.setCellValueFactory(new PropertyValueFactory<>("course"));
        tcAction.setCellValueFactory(new PropertyValueFactory<>("edit"));
        try{
            Connection conn = new Connector().getConn();
            // query
            Statement stt = conn.createStatement();
            String sql = "select * from classlist";
            ResultSet rs = stt.executeQuery(sql);
            ObservableList<Class> list = FXCollections.observableArrayList();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("room");
                String tel = rs.getString("course");
                Class s = new Class(id, name, email, tel);
                list.add(s);
            }
            tbv.setItems(list);
        }catch (Exception e){
            System.out.println("error:"+e.getMessage());
        }
    }

    public void edit(TableColumn.CellEditEvent<Class, Button> classButtonCellEditEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../view/editform.fxml"));
        Main.mainStage.setScene(new Scene(root, 600, 400));
        editClass = tbv.getSelectionModel().getSelectedItem();
    }

//    public void goToEditStudent(MouseEvent mouseEvent) throws Exception {
//        editClass = listView.getSelectionModel().getSelectedItem();
//        Parent root = FXMLLoader.load(getClass().getResource("editform.fxml"));
//        Main.mainStage.setScene(new Scene(root, 600, 400));
//    }
}