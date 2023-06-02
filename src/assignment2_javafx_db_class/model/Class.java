package assignment2_javafx_db_class.model;

import javafx.scene.control.Button;

public final class Class {
    private Integer id;
    private Button edit;
    private String name, room, course;
    public Class(String name, String room, String course) {
        this.name = name;
        this.room = room;
        this.course = course;
    }

    public Class(Integer id, String name, String room, String course) {
        this.id = id;
        this.edit = new Button("edit");
        this.name = name;
        this.room = room;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getId() {
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
        return "Name: " + name + " - Email: " + room + " - Tel: " + course;
    }
}
