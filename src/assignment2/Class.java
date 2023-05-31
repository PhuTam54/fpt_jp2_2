package javafxdb;

import javafx.collections.ObservableList;

public final class Student{
    private String name, email, tel;
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

    @Override
    public String toString() {
        return "Name: " + name + " - Email: " + email + " - Tel: " + tel;
    }
}
