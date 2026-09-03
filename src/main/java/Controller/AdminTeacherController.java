package Controller;

import Model.dao.AdminTeacherDAO;
import Model.dto.TeacherDto;
import Model.entity.TeacherEntity;
import View.AdminAddTeachPanel;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminTeacherController {
    
    private AdminAddTeachPanel view;
    private AdminTeacherDAO dao;

    public AdminTeacherController(AdminAddTeachPanel view) {
        this.view = view;
        try {
            this.dao = new AdminTeacherDAO();
            loadTableData(); 
        } catch (Exception e) {
            System.out.println("Teacher Controller Load Error: " + e.getMessage());
        }
    }

  

    public void addTeacher() {
        TeacherDto dto = view.getTeacherData();
        TeacherEntity entity = new TeacherEntity(
            dto.getTeacherId(), dto.getName(), dto.getBirthday(), dto.getContactNumber(), // Added Birthday
            dto.getEmail(), dto.getGender(), dto.getAddress(), dto.getNic(), dto.getPassword()
        );
        
        if (dao.addTeacher(entity)) {
            JOptionPane.showMessageDialog(view, "Teacher Added Successfully!");
            view.clearFields();
            loadTableData();
        } else {
            JOptionPane.showMessageDialog(view, "Failed to Add Teacher!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateTeacher() {
        TeacherDto dto = view.getTeacherData();
        TeacherEntity entity = new TeacherEntity(
            dto.getTeacherId(), dto.getName(), dto.getBirthday(), dto.getContactNumber(), // Added Birthday
            dto.getEmail(), dto.getGender(), dto.getAddress(), dto.getNic(), dto.getPassword()
        );
        
        if (dao.updateTeacher(entity)) {
            JOptionPane.showMessageDialog(view, "Teacher Updated Successfully!");
            view.clearFields();
            loadTableData();
        } else {
            JOptionPane.showMessageDialog(view, "Failed to Update Teacher!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteTeacher() {
        String id = view.getTeachertId();
        if (dao.deleteTeacher(id)) {
            JOptionPane.showMessageDialog(view, "Teacher Deleted!");
            view.clearFields();
            loadTableData();
        } else {
            JOptionPane.showMessageDialog(view, "Failed to Delete Teacher!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void searchTeacher() {
        String id = view.getTeachertId();
        TeacherEntity entity = dao.searchTeacher(id);
        
        if (entity != null) {
            TeacherDto dto = new TeacherDto(
                entity.getTeacherId(), entity.getName(), entity.getBirthday(), entity.getContactNumber(), // Added Birthday
                entity.getEmail(), entity.getGender(), entity.getAddress(), entity.getNic(), entity.getPassword()
            );
            view.setTeacherData(dto);
        } else {
            JOptionPane.showMessageDialog(view, "Teacher Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
            view.clearFields();
        }
    }

    public void loadTableData() {
        List<TeacherEntity> teachers = dao.getAllTeachers();
        DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
        model.setRowCount(0); 
        
        for (TeacherEntity t : teachers) {
            model.addRow(new Object[]{
                t.getTeacherId(), t.getName(), t.getBirthday(), t.getNic(), t.getContactNumber(), t.getEmail(), t.getGender() // Added Birthday to JTable
            });
        }
    }
}