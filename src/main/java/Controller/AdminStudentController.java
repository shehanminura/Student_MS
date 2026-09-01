/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.dao.AdminStudentDAO;
import Model.dto.StudentDto;
import Model.entity.StudentEntity;
import View.AdminAddStuPanel;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author User
 */
public class AdminStudentController {
    
    private AdminAddStuPanel view;
    private AdminStudentDAO dao;

   public AdminStudentController(AdminAddStuPanel view) {
        this.view = view;
        
        // this use catch Database error using try-catch එකක් දැම්මා
        try {
            this.dao = new AdminStudentDAO();
            loadTableData(); 
        } catch (Exception e) {
            System.out.println("Controller Load Error: " + e.getMessage());
        }
    }

    public void addStudent() {
        StudentDto dto = view.getStudentData();
        StudentEntity entity = new StudentEntity(
            dto.getId(), dto.getName(), dto.getBirthday(), dto.getStuClass(),
            dto.getContactNumber(), dto.getEmail(), dto.getAddress(), dto.getGender(), dto.getPassword()
        );
        
        if (dao.addStudent(entity)) {
            JOptionPane.showMessageDialog(view, "Student Added Successfully!");
            view.clearFields();
            loadTableData();
        } else {
            JOptionPane.showMessageDialog(view, "Failed to Add Student!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateStudent() {
        StudentDto dto = view.getStudentData();
        StudentEntity entity = new StudentEntity(
            dto.getId(), dto.getName(), dto.getBirthday(), dto.getStuClass(),
            dto.getContactNumber(), dto.getEmail(), dto.getAddress(), dto.getGender(), dto.getPassword()
        );
        
        if (dao.updateStudent(entity)) {
            JOptionPane.showMessageDialog(view, "Student Updated Successfully!");
            view.clearFields();
            loadTableData();
        } else {
            JOptionPane.showMessageDialog(view, "Failed to Update!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteStudent() {
        String id = view.getStudentId();
        if (dao.deleteStudent(id)) {
            JOptionPane.showMessageDialog(view, "Student Deleted!");
            view.clearFields();
            loadTableData();
        } else {
            JOptionPane.showMessageDialog(view, "Failed to Delete!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void searchStudent() {
        String id = view.getStudentId();
        StudentEntity entity = dao.searchStudent(id);
        
        if (entity != null) {
            StudentDto dto = new StudentDto(
                entity.getId(), entity.getName(), entity.getBirthday(), entity.getStuClass(),
                entity.getContactNumber(), entity.getEmail(), entity.getAddress(), entity.getGender(), entity.getPassword()
            );
            view.setStudentData(dto);
        } else {
            JOptionPane.showMessageDialog(view, "Student Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
            view.clearFields();
        }
    }

    public void loadTableData() {
        List<StudentEntity> students = dao.getAllStudents();
        DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
        model.setRowCount(0); 
        
        for (StudentEntity s : students) {
            model.addRow(new Object[]{
                s.getId(), s.getName(), s.getStuClass(), s.getContactNumber(), s.getEmail(), s.getGender()
            });
        }
    }
}
