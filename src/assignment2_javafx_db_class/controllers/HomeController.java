package assignment2_javafx_db_class.controllers;

import assignment2_javafx_db_class.daopattern.ClassRepository;
import assignment2_javafx_db_class.model.Class;
import assignment2_javafx_db_class.Main;
import assignment2_javafx_db_class.databaseclass.Connector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

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

    public void goToForm(MouseEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../views/form.fxml"));
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
            ObservableList<Class> list = FXCollections.observableArrayList();
            // query
            list.addAll(ClassRepository.getInstance().getAll());  // DAO pattern
            tbv.setItems(list);
        }catch (Exception e){
            System.out.println("error:"+e.getMessage());
        }
    }

    public void edit(TableColumn.CellEditEvent<Class, Button> classButtonCellEditEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/editform.fxml"));
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }

//    public void goToEditStudent(MouseEvent mouseEvent) throws Exception {
//        editClass = listView.getSelectionModel().getSelectedItem();
//        Parent root = FXMLLoader.load(getClass().getResource("editform.fxml"));
//        Main.mainStage.setScene(new Scene(root, 600, 400));
//    }
}