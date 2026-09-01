/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.entity;

/**
 *
 * @author User
 */
public class AdminEntity {
    private String adminId;
    private String name;
    private String birthday;
    private String contactNumber;
    private String email;
    private String address;
    private String gender;

    public AdminEntity(String adminId, String name, String birthday, String contactNumber, String email, String address, String gender) {
        this.adminId = adminId;
        this.name = name;
        this.birthday = birthday;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
        this.gender = gender;
    }

    public String getAdminId() { return adminId; }
    public String getName() { return name; }
    public String getBirthday() { return birthday; }
    public String getContactNumber() { return contactNumber; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public String getGender() { return gender; }
}
