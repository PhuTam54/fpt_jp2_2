package javafxdb.model;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;

import java.sql.Date;
import java.sql.Time;

public final class Student{
    private Integer id;
    private String name, email, tel;
    private Button edit;
    private Date birthday;
    private Time birthdayT;
    public Student(Integer id, String name, String email, String tel) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.edit = new Button("edit");
    }

    public Student(String name, String email, String tel) {
        this.name = name;
        this.email = email;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Button getEdit() {
        return edit;
    }

    @Override
    public String toString() {
        return "Name: " + name + " - Email: " + email + " - Tel: " + tel;
    }
}
