package assignment2_javafx_db_class.daopattern;

import assignment2_javafx_db_class.databaseclass.Connector;
import assignment2_javafx_db_class.model.Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ClassRepository implements IRepository <Class>{
    // single pattern
    private static ClassRepository instance;
    private ClassRepository() {

    }
    public static ClassRepository getInstance() {
        if (instance == null) {
            instance = new ClassRepository();
        }
        return instance;
    }
    //
    @Override
    public ArrayList<Class> getAll() {
        ArrayList<Class> classes = new ArrayList<>();

        try {
            Connection conn = Connector.getInstance().getConn();
            // query
            Statement stt = conn.createStatement();
            String sql = "select * from classlist";
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String room = rs.getString("room");
                String course = rs.getString("course");
                Class c = new Class(id, name, room, course);
                classes.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        return classes;
    }

    @Override
    public Boolean create(Class c) {
        try{
            Connection conn = Connector.getInstance().getConn();

            //query
            String sql = "insert into classlist(name, room, course) values(?,?,?)";
            PreparedStatement stt = conn.prepareStatement(sql);
            stt.setString(1,c.getName());
            stt.setString(2,c.getRoom());
            stt.setString(3,c.getCourse());
            stt.executeUpdate();
            return true;
        }catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean update(Class c) {
        try {
            Connection conn = Connector.getInstance().getConn();
            String sql = "update students set name=?, room=?, course=? where id=?";
            PreparedStatement stt = conn.prepareStatement(sql);
            stt.setString(1,c.getName());
            stt.setString(2,c.getRoom());
            stt.setString(3,c.getCourse());
            stt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean delete(Class c) {
        try {
            Connection conn = Connector.getInstance().getConn();
            String sql = "delete from students where id=?";
            PreparedStatement stt = conn.prepareStatement(sql);
            stt.setInt(1,c.getId());
            stt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return false;
    }

    @Override
    public Class find(Integer id) {
        try {
            Connection conn = Connector.getInstance().getConn();
            String sql = "select * from students where id=?";
            PreparedStatement stt = conn.prepareStatement(sql);
            stt.setInt(1, id);
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()) {
                int c_id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String tel = rs.getString("tel");
                Class c = new Class(c_id, name, email, tel);
                return c;
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return null;
    }
}
