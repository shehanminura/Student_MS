package Controller;

import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;
import MailConnection.MailConnection; 
import Model.dto.StudentDto;

public class AddStuEmailService {
    
    public static void sendWelcomeEmail(StudentDto student) {
        try {
            // 1. Singleton ක්ලාස් එකෙන් Email Session එක සහ Sender Email එක ලබාගැනීම
            Session session = MailConnection.getInstance().getSession();
            String senderEmail = MailConnection.getInstance().getSenderEmail();
            
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(student.getEmail()));
        // Subject
            message.setSubject("Official Student Registration - Central College Anuradhapura");
            
            // Add Student Email Body
            String emailBody = "Dear " + student.getName() + ",\n\n"
                             + "We are pleased to inform you that your registration with the Central College Anuradhapura Student Management System has been successfully completed.\n\n"
                             + "Below are your official registration details and system login credentials:\n\n"
                             + "------------------------------------------------------\n"
                             + "  Student ID       : " + student.getId() + "\n"
                             + "  Full Name        : " + student.getName() + "\n"
                             + "  Date of Birth    : " + student.getBirthday() + "\n"
                             + "  Gender           : " + student.getGender() + "\n"
                             + "  Address          : " + student.getAddress() + "\n"
                             + "  Assigned Class   : " + student.getStuClass() + "\n"
                             + "  Contact Number   : " + student.getContactNumber() + "\n"
                             + "  Registered Email : " + student.getEmail() + "\n"
                             + "  System Password  : " + student.getPassword() + "\n"
                             + "------------------------------------------------------\n\n"
                             + "Please keep your login credentials secure and do not share your password with anyone. If you notice any discrepancies in the above details, please notify the class teacher or the IT administration desk immediately.\n\n"
                             + "We wish you a successful academic year!\n\n"
                             + "Sincerely,\n"
                             + "The Administration,\n"
                             + "Central College Anuradhapura.";
            
            message.setText(emailBody);
            Transport.send(message);
            
          
            System.out.println("Bug Testing");
            System.out.println(emailBody);
            
            // 4. ඊමේල් එක යැවීම
            Transport.send(message);
            System.out.println("Email Sent Successfully to: " + student.getEmail());
            
        } catch (Exception e) {
            System.out.println("Email Sending Failed: " + e.getMessage());
        }
    }
    // 2. Update Student Student send email
    public static void sendUpdateEmail(StudentDto student) {
        try {
            Session session = MailConnection.getInstance().getSession();
            String senderEmail = MailConnection.getInstance().getSenderEmail();
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(student.getEmail()));
           // Subject
            message.setSubject("Official Notice: Profile Update Successful - Central College Anuradhapura");
            
            // Update Student Email Body 
            String emailBody = "Dear " + student.getName() + ",\n\n"
                             + "This is an official notification to inform you that your student profile details have been successfully updated in the Central College Anuradhapura Student Management System.\n\n"
                             + "Below are your currently active registration details after the update:\n\n"
                             + "------------------------------------------------------\n"
                             + "  Student ID       : " + student.getId() + "\n"
                             + "  Full Name        : " + student.getName() + "\n"
                             + "  Date of Birth    : " + student.getBirthday() + "\n"
                             + "  Gender           : " + student.getGender() + "\n"
                             + "  Address          : " + student.getAddress() + "\n"
                             + "  Assigned Class   : " + student.getStuClass() + "\n"
                             + "  Contact Number   : " + student.getContactNumber() + "\n"
                             + "  Registered Email : " + student.getEmail() + "\n"
                             + "  System Password  : " + student.getPassword() + "\n"
                             + "------------------------------------------------------\n\n"
                             + "If you did not request these changes, please contact the class teacher or the IT administration desk immediately to secure your account.\n\n"
                             + "Sincerely,\n"
                             + "The Administration,\n"
                             + "Central College Anuradhapura.";
            
            message.setText(emailBody);
            Transport.send(message);
            System.out.println("Update Email Sent Successfully to: " + student.getEmail());
            
        } catch (Exception e) {
            System.out.println("Update Email Sending Failed: " + e.getMessage());
        }
    }

    // 3. Delete Student send email
    public static void sendDeleteEmail(StudentDto student) {
        try {
            Session session = MailConnection.getInstance().getSession();
            String senderEmail = MailConnection.getInstance().getSenderEmail();
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(student.getEmail()));
           // Subject 
            message.setSubject("Official Notice: Student Account Deactivation - Central College Anuradhapura");
            
            // Delete Student Email Body (Professional)
            String emailBody = "Dear " + student.getName() + ",\n\n"
                             + "This is an official notification to inform you that your student account has been completely removed from the Central College Anuradhapura Student Management System.\n\n"
                             + "Deactivated Account Details:\n"
                             + "------------------------------------------------------\n"
                             + "  Student ID       : " + student.getId() + "\n"
                             + "  Registered Email : " + student.getEmail() + "\n"
                             + "------------------------------------------------------\n\n"
                             + "Please note that all your system access privileges have been revoked with immediate effect. If you believe this action was taken in error, or if you require any further clarification regarding this account deactivation, please contact the school office or the IT administration desk immediately.\n\n"
                             + "Sincerely,\n"
                             + "The Administration,\n"
                             + "Central College Anuradhapura.";
            
            message.setText(emailBody);
            Transport.send(message);
            System.out.println("Delete Email Sent Successfully to: " + student.getEmail());
            
        } catch (Exception e) {
            System.out.println("Delete Email Sending Failed: " + e.getMessage());
        }
    }

}