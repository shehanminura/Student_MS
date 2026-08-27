/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.entity;

/**
 *
 * @author User
 */
public class StudentEntity {
    private int stuId;
    private String name;
    private String birthday;
    private String studentClass;
    private String contactNumber;
    private String email;
    private String address;
    private String gender;

    public StudentEntity(int stuId, String name, String birthday, String studentClass, String contactNumber, String email, String address, String gender) {
        this.stuId = stuId;
        this.name = name;
        this.birthday = birthday;
        this.studentClass = studentClass;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
        this.gender = gender;
    }

    
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getStudentClass() { return studentClass; }
}
