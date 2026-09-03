package Model.entity;

public class TeacherEntity {
    private String teacherId;
    private String name;
    private String birthday; // New
    private String contactNumber;
    private String email;
    private String gender;
    private String address;
    private String nic;
    private String password;

    public TeacherEntity(String teacherId, String name, String birthday, String contactNumber, String email, String gender, String address, String nic, String password) {
        this.teacherId = teacherId;
        this.name = name;
        this.birthday = birthday;
        this.contactNumber = contactNumber;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.nic = nic;
        this.password = password;
    }

    public String getTeacherId() { return teacherId; }
    public String getName() { return name; }
    public String getBirthday() { return birthday; } // New
    public String getContactNumber() { return contactNumber; }
    public String getEmail() { return email; }
    public String getGender() { return gender; }
    public String getAddress() { return address; }
    public String getNic() { return nic; }
    public String getPassword() { return password; }
}