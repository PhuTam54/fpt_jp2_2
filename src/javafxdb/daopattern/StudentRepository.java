package javafxdb.daopattern;

import javafxdb.databasestudent.Connector;
import javafxdb.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentRepository implements IRepository <Student>{
    // singleton pattern
    private static StudentRepository instance;
    private StudentRepository() {

    }
    public static StudentRepository getInstance() {
        if (instance == null) {
            instance = new StudentRepository();
        }
        return instance;
    }
    //
    @Override
    public ArrayList<Student> getAll() {
        ArrayList<Student> students = new ArrayList<>();

        try {
            Connection conn = Connector.getInstance().getConn();
            // query
            Statement stt = conn.createStatement();
            String sql = "select * from students";
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String tel = rs.getString("tel");
                Student s = new Student(id, name, email, tel);
                students.add(s);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }

        return students;
    }

        @Override
    public Boolean create(Student s) {
        try{
            Connection conn = Connector.getInstance().getConn();

            //query
//            c1
//            Statement stt = conn.createStatement();
//            String sql = "insert into students(name,email,tel) values('"+
//                    sv.getName()+"','"+sv.getEmail()+"','"+sv.getTel()+"')";
//            stt.executeUpdate(sql);

//            c2
            String sql = "insert into students(name, email, tel) values(?,?,?)";
            PreparedStatement stt = conn.prepareStatement(sql);
            stt.setString(1,s.getName());
            stt.setString(2,s.getEmail());
            stt.setString(3,s.getTel());
            stt.executeUpdate();
            return true;
        }catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean update(Student s) {
        try {
            Connection conn = Connector.getInstance().getConn();
            String sql = "update students set name=?, email=?, tel=? where id=?";
            PreparedStatement stt = conn.prepareStatement(sql);
            stt.setString(1,s.getName());
            stt.setString(2,s.getEmail());
            stt.setString(3,s.getTel());
            stt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean delete(Student s) {
        try {
            Connection conn = Connector.getInstance().getConn();
            String sql = "delete from students where id=?";
            PreparedStatement stt = conn.prepareStatement(sql);
            stt.setInt(1,s.getId());
            stt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return false;
    }

    @Override
    public Student find(Integer id) {
        try {
            Connection conn = Connector.getInstance().getConn();
            String sql = "select * from students where id=?";
            PreparedStatement stt = conn.prepareStatement(sql);
            stt.setInt(1, id);
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()) {
                int s_id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String tel = rs.getString("tel");
                Student s = new Student(s_id, name, email, tel);
                return s;
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return null;
    }
}
