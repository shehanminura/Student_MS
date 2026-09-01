/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dto;

/**
 *
 * @author User
 */
public class StudentDto {
    private String id;
    private String name;
    private String birthday;
    private String stuClass;
    private String contactNumber;
    private String email;
    private String address;
    private String gender;
    private String password;

    public StudentDto(String id, String name, String birthday, String stuClass, String contactNumber, String email, String address, String gender, String password) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.stuClass = stuClass;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.password = password;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getBirthday() { return birthday; }
    public String getStuClass() { return stuClass; }
    public String getContactNumber() { return contactNumber; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public String getGender() { return gender; }
    public String getPassword() { return password; }
}
