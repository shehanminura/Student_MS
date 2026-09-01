/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.dao.AdminAuthDAO;
import Model.dto.AdminLoginDto;
import Model.entity.AdminEntity;
import View.Loginviewadmin; // ඔයාගේ Admin Login View ෆයිල් එකේ නම
import View.DashbordAdmin;  // ඔයාගේ Admin Dashboard ෆයිල් එකේ නම
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author User
 */
public class AdminLoginController {
    private Loginviewadmin view;
    private AdminAuthDAO model;

    public AdminLoginController(Loginviewadmin view, AdminAuthDAO model) {
        this.view = view;
        this.model = model;
        
        // View එකේ බට්න් එක ක්ලික් කිරීම අල්ලගැනීම
        this.view.addLoginListener(new LoginListener());
    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = view.getEmail();
            String password = view.getPassword();

            // 1. DTO එකක් හැදීම
            AdminLoginDto loginDTO = new AdminLoginDto(email, password);
            
            // 2. DAO හරහා ඩේටාබේස් එක චෙක් කර Entity එකක් ලබාගැනීම
            AdminEntity loggedInAdmin = model.loginAdmin(loginDTO);

            // 3. ලොගින් එක සාර්ථක නම් 
            if (loggedInAdmin != null) {
                JOptionPane.showMessageDialog(view, "Welcome Admin, " + loggedInAdmin.getName() + "!");
                view.dispose(); 
                
                // Dashboard එක ඕපන් කිරීම
                DashbordAdmin dash = new DashbordAdmin();
                dash.setVisible(true); 
                
            } else {
                JOptionPane.showMessageDialog(view, "Invalid Email or Password!", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
