package javafxdb.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafxdb.daopattern.StudentRepository;
import javafxdb.Main;
import javafxdb.enums.RepositoryType;
import javafxdb.factory.RepositoryFactory;
import javafxdb.model.Student;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    public static Student editStudent;
    public TableView<Student> tbv;
    public TableColumn<Student, Integer> tcID;
    public TableColumn<Student, String> tcName;
    public TableColumn<Student, String> tcEmail;
    public TableColumn<Student, String> tcTel;
    public TableColumn<Student, Button> tcAction;
    public Text txtMin;
    public Text txtSec;
    public Text txtDate;
    public Text txtHours;
    public Text txtDay;
    public Text txtMonth;
    public Text txtYear;
    private LocalDateTime dateTime = LocalDateTime.now();
    int day = dateTime.getDayOfMonth();
    int month = dateTime.getMonthValue();
    int year = dateTime.getYear();
    int hours = dateTime.getHour();
    int minute = dateTime.getMinute();
    int second = dateTime.getSecond();

    public void goToForm(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../views/form.fxml"));
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
            ObservableList<Student> list = FXCollections.observableArrayList();
            // query
//            list.addAll(StudentRepository.getInstance().getAll());   // DAO pattern
            list.addAll(RepositoryFactory.createRepositoryInstance(RepositoryType.STUDENT).getAll());  // Factory pattern
            tbv.setItems(list);

        }catch (Exception e){
            System.out.println("error:"+e.getMessage());
        }


        new Thread(()-> {
            boolean flag = true;
            while (flag) {
                txtDay.setText(String.valueOf(day));
                txtMonth.setText(String.valueOf(month));
                txtYear.setText(String.valueOf(year));
                txtHours.setText(String.valueOf(hours));
                txtMin.setText(String.valueOf(minute));
                txtSec.setText(String.valueOf(second));
                second ++;
                if (second > 59) {
                    second = 0;
                    minute++;
                }if(minute > 59) {
                    minute = 0;
                    hours ++;
                }if (hours > 23) {
                    flag = false;
                }
                try {
                    Thread.sleep(1000); // 1000 milliseconds
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }).start();
    }

    public void goToEditStudent(MouseEvent mouseEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../views/editform.fxml"));
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }
}