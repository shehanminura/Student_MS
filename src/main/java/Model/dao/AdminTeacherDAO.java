package Model.dao;

import DBConnection.DBConnection;
import Model.entity.TeacherEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminTeacherDAO {
    
    private Connection conn;

    public AdminTeacherDAO() throws SQLException {
        this.conn = DBConnection.getInstance().getConnection();
    }

    public boolean addTeacher(TeacherEntity teacher) {
        String sql = "INSERT INTO teacher (teacher_id, name, birthday, contact_number, email, gender, address, NIC, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, teacher.getTeacherId());
            pst.setString(2, teacher.getName());
            pst.setString(3, teacher.getBirthday()); // New
            pst.setString(4, teacher.getContactNumber());
            pst.setString(5, teacher.getEmail());
            pst.setString(6, teacher.getGender());
            pst.setString(7, teacher.getAddress());
            pst.setString(8, teacher.getNic());
            pst.setString(9, teacher.getPassword());
            
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Add Teacher Error: " + e.getMessage()); 
            return false;
        }
    }

    public boolean updateTeacher(TeacherEntity teacher) {
        String sql = "UPDATE teacher SET name=?, birthday=?, contact_number=?, email=?, gender=?, address=?, NIC=?, password=? WHERE teacher_id=?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, teacher.getName());
            pst.setString(2, teacher.getBirthday()); // New
            pst.setString(3, teacher.getContactNumber());
            pst.setString(4, teacher.getEmail());
            pst.setString(5, teacher.getGender());
            pst.setString(6, teacher.getAddress());
            pst.setString(7, teacher.getNic());
            pst.setString(8, teacher.getPassword());
            pst.setString(9, teacher.getTeacherId());
            
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Update Teacher Error: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteTeacher(String teacherId) {
        String sql = "DELETE FROM teacher WHERE teacher_id=?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, teacherId);
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Delete Teacher Error: " + e.getMessage());
            return false;
        }
    }

    public TeacherEntity searchTeacher(String teacherId) {
        String sql = "SELECT * FROM teacher WHERE teacher_id=?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, teacherId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new TeacherEntity(
                    rs.getString("teacher_id"), rs.getString("name"), rs.getString("birthday"), // New
                    rs.getString("contact_number"), rs.getString("email"), rs.getString("gender"), 
                    rs.getString("address"), rs.getString("NIC"), rs.getString("password")
                );
            }
        } catch (Exception e) {
            System.out.println("Search Teacher Error: " + e.getMessage());
        }
        return null;
    }

    public List<TeacherEntity> getAllTeachers() {
        List<TeacherEntity> list = new ArrayList<>();
        String sql = "SELECT * FROM teacher";
        try (PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                list.add(new TeacherEntity(
                    rs.getString("teacher_id"), rs.getString("name"), rs.getString("birthday"), // New
                    rs.getString("contact_number"), rs.getString("email"), rs.getString("gender"), 
                    rs.getString("address"), rs.getString("NIC"), rs.getString("password")
                ));
            }
        } catch (Exception e) {
            System.out.println("Load Table Error (Teacher): " + e.getMessage());
        }
        return list;
    }
}