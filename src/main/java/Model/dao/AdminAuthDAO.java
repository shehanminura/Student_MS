package Model.dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import DBConnection.DBConnection;
import Model.dto.AdminLoginDto;
import Model.entity.AdminEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author User
 */
public class AdminAuthDAO {
    public AdminEntity loginAdmin(AdminLoginDto loginData) {
        String sql = "SELECT * FROM admin WHERE email = ? AND password = ?";
        
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, loginData.getEmail());
            pst.setString(2, loginData.getPassword());
            
            ResultSet rs = pst.executeQuery();
            
            // දත්ත තිබේ නම්, සම්පූර්ණ Entity එකක් හදලා යවනවා
            if (rs.next()) {
                return new AdminEntity(
                    rs.getString("admin_id"),
                    rs.getString("name"),
                    rs.getString("birthday"),
                    rs.getString("contact_number"),
                    rs.getString("email"),
                    rs.getString("address"),
                    rs.getString("gender")
                );
            }
        } catch (Exception e) {
            System.out.println("Admin DB Error: " + e.getMessage());
        }
        
        return null; // දත්ත නැත්නම් හෝ වැරදි නම් null යවනවා
    }
}
