/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.dao.StuAuthDAO;
import Model.dto.StuLogindto;
import Model.entity.StudentEntity;
import View.Loginviewstudent;
import View.DashbordStudent;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StuLoginController {
    private Loginviewstudent view;
    private StuAuthDAO model;

    public StuLoginController(Loginviewstudent view, StuAuthDAO model) {
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

            // 1. DTO එකක් හැදීම (ඔබේ අලුත් නමට අනුව)
            StuLogindto loginDTO = new StuLogindto(email, password);
            
            // 2. DAO හරහා ඩේටාබේස් එක චෙක් කර Entity එකක් ලබාගැනීම
            StudentEntity loggedInStudent = model.loginStudent(loginDTO);

            // 3. ලොගින් එක සාර්ථක නම් (Entity එකක් ලැබුණා නම්)
            if (loggedInStudent != null) {
                // ඩේටාබේස් එකෙන් ගෙනාපු ළමයාගේ නම පෙන්වීම
                JOptionPane.showMessageDialog(view, "Welcome, " + loggedInStudent.getName() + "!");
                view.dispose(); 
                
                // Dashboard එක ඕපන් කිරීම
                DashbordStudent dash = new DashbordStudent();
                dash.setVisible(true); 
                
            } else {
                JOptionPane.showMessageDialog(view, "Invalid Email or Password!", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}