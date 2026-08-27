package db; // ඔබේ package නම මෙතැනට දෙන්න

import DBConnection.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;

public class TestDB {
    public static void main(String[] args) {
        try {
            // Test DBConnection
            Connection conn = DBConnection.getInstance().getConnection();
            
            if (conn != null) {
                System.out.println("Connection Successful!");
            } else {
                System.out.println("Connection Failed!.");
            }
            
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
}
