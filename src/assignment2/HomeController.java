package assignment2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    public static ObservableList<Class> listClasses = FXCollections.observableArrayList();
    public ListView<Class> listView;
    public static Class editClass;

    private final static String connectionString = "jdbc:mysql://localhost:3306/classlist";
    private final static String user = "root";
    private final static String pwd = "";// xampp: ""  mamp: "root"
    public void goToForm(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("form.fxml"));
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        listView.setItems(listStudents);
        try{
            java.lang.Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionString,user,pwd);

            // query
            Statement stt = conn.createStatement();
            String sql = "select * from students";
            ResultSet rs = stt.executeQuery(sql);
            ObservableList<Class> list = FXCollections.observableArrayList();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String tel = rs.getString("tel");
//                System.out.println(id+"-"+name+"-"+email+"-"+tel);
                Class s = new Class(name, email, tel);
                list.add(s);
            }
            listView.setItems(list);
            listView.refresh();
        }catch (Exception e){
            System.out.println("error:"+e.getMessage());
        }
    }

    public void goToEditStudent(MouseEvent mouseEvent) throws Exception {
        editClass = listView.getSelectionModel().getSelectedItem();
        Parent root = FXMLLoader.load(getClass().getResource("editform.fxml"));
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }

}