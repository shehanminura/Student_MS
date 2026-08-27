/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

/**
 *
 * @author User
 */
import DBConnection.DBConnection;
import Model.dto.StuLogindto;
import Model.entity.StudentEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StuAuthDAO {
    
    // මෙතැනදී LoginDTO එක ඇතුළට අරන්, StudentEntity එකක් එළියට දෙනවා
    public StudentEntity loginStudent(StuLogindto loginData) {
        String sql = "SELECT * FROM student WHERE email = ? AND password = ?";
        
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, loginData.getEmail());
            pst.setString(2, loginData.getPassword());
            
            ResultSet rs = pst.executeQuery();
            
            // දත්ත තිබේ නම්, සම්පූර්ණ Entity එකක් හදලා යවනවා
            if (rs.next()) {
                return new StudentEntity(
                    rs.getInt("stu_id"),
                    rs.getString("name"),
                    rs.getString("birthday"),
                    rs.getString("class"),
                    rs.getString("contact_number"),
                    rs.getString("email"),
                    rs.getString("address"),
                    rs.getString("gender")
                );
            }
        } catch (Exception e) {
            System.out.println("DB Error: " + e.getMessage());
        }
        
        return null; // දත්ත නැත්නම් හෝ වැරදි නම් null යවනවා
    }
}
