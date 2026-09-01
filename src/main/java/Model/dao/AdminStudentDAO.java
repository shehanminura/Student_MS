package Model.dao;

import DBConnection.DBConnection;
import Model.entity.StudentEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminStudentDAO {
    
    // 1. ක්ලාස් එක පුරාම පාවිච්චි කරන්න පුළුවන් වෙන්න Connection එක උඩින්ම හදාගන්නවා
    private Connection conn;

    // 2. Constructor එකක් හදලා, මේ DAO එක ලෝඩ් වෙද්දිම කනෙක්ෂන් එක අරන් තියාගන්නවා
    public AdminStudentDAO() throws SQLException {
        this.conn = DBConnection.getInstance().getConnection();
    }

    public boolean addStudent(StudentEntity student) {
        String sql = "INSERT INTO student (stu_id, name, birthday, `class`, contact_number, email, address, gender, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        // දැන් අලුතින් Connection එක ගන්න ඕනේ නැහැ, උඩ තියෙන 'conn' එක කෙළින්ම පාවිච්චි කරනවා
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, student.getId());
            pst.setString(2, student.getName());
            pst.setString(3, student.getBirthday());
            pst.setString(4, student.getStuClass());
            pst.setString(5, student.getContactNumber());
            pst.setString(6, student.getEmail());
            pst.setString(7, student.getAddress());
            pst.setString(8, student.getGender());
            pst.setString(9, student.getPassword());
            
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Add Student Error: " + e.getMessage()); 
            return false;
        }
    }

    public boolean updateStudent(StudentEntity student) {
        String sql = "UPDATE student SET name=?, birthday=?, `class`=?, contact_number=?, email=?, address=?, gender=?, password=? WHERE stu_id=?";
        
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, student.getName());
            pst.setString(2, student.getBirthday());
            pst.setString(3, student.getStuClass());
            pst.setString(4, student.getContactNumber());
            pst.setString(5, student.getEmail());
            pst.setString(6, student.getAddress());
            pst.setString(7, student.getGender());
            pst.setString(8, student.getPassword());
            pst.setString(9, student.getId());
            
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Update Student Error: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteStudent(String stuId) {
        String sql = "DELETE FROM student WHERE stu_id=?";
        
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, stuId);
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Delete Student Error: " + e.getMessage());
            return false;
        }
    }

    public StudentEntity searchStudent(String stuId) {
        String sql = "SELECT * FROM student WHERE stu_id=?";
        
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, stuId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new StudentEntity(
                    rs.getString("stu_id"), rs.getString("name"), rs.getString("birthday"),
                    rs.getString("class"), rs.getString("contact_number"), rs.getString("email"),
                    rs.getString("address"), rs.getString("gender"), rs.getString("password")
                );
            }
        } catch (Exception e) {
            System.out.println("Search Student Error: " + e.getMessage());
        }
        return null;
    }

    public List<StudentEntity> getAllStudents() {
        List<StudentEntity> list = new ArrayList<>();
        String sql = "SELECT * FROM student";
        
        try (PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                list.add(new StudentEntity(
                    rs.getString("stu_id"), rs.getString("name"), rs.getString("birthday"),
                    rs.getString("class"), rs.getString("contact_number"), rs.getString("email"),
                    rs.getString("address"), rs.getString("gender"), rs.getString("password")
                ));
            }
        } catch (Exception e) {
            System.out.println("Load Table Error: " + e.getMessage());
        }
        return list;
    }
}