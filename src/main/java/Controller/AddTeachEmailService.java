package Controller;

import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;
import MailConnection.MailConnection; 
import Model.dto.TeacherDto;

public class AddTeachEmailService {
    
    // 1. Add Teacher
    public static void sendWelcomeEmail(TeacherDto teacher) {
        try {
            Session session = MailConnection.getInstance().getSession();
            String senderEmail = MailConnection.getInstance().getSenderEmail();
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(teacher.getEmail()));
            
            // Official Subject
            message.setSubject("Official Notice: Staff Registration Successful - Central College Anuradhapura");
            
            String emailBody = "Dear " + teacher.getName() + ",\n\n"
                             + "We are pleased to inform you that your staff registration with the Central College Anuradhapura School Management System has been successfully completed.\n\n"
                             + "Below are your official registration details and system login credentials:\n\n"
                             + "------------------------------------------------------\n"
                             + "  Teacher ID       : " + teacher.getTeacherId() + "\n"
                             + "  Full Name        : " + teacher.getName() + "\n"
                             + "  NIC Number       : " + teacher.getNic() + "\n"
                             + "  Date of Birth    : " + teacher.getBirthday() + "\n"
                             + "  Gender           : " + teacher.getGender() + "\n"
                             + "  Address          : " + teacher.getAddress() + "\n"
                             + "  Contact Number   : " + teacher.getContactNumber() + "\n"
                             + "  Registered Email : " + teacher.getEmail() + "\n"
                             + "  System Password  : " + teacher.getPassword() + "\n"
                             + "------------------------------------------------------\n\n"
                             + "Please keep your login credentials secure and do not share your password with anyone. If you notice any discrepancies in the above details, please notify the IT administration desk immediately.\n\n"
                             + "We wish you a successful academic year!\n\n"
                             + "Sincerely,\n"
                             + "The Administration,\n"
                             + "Central College Anuradhapura.";
            
            message.setText(emailBody);
            Transport.send(message);
            System.out.println("Teacher Welcome Email Sent Successfully to: " + teacher.getEmail());
            
        } catch (Exception e) {
            System.out.println("Teacher Welcome Email Sending Failed: " + e.getMessage());
        }
    }

    // 2. Update Teacher
    public static void sendUpdateEmail(TeacherDto teacher) {
        try {
            Session session = MailConnection.getInstance().getSession();
            String senderEmail = MailConnection.getInstance().getSenderEmail();
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(teacher.getEmail()));
            
            message.setSubject("Official Notice: Staff Profile Update Successful - Central College Anuradhapura");
            
            String emailBody = "Dear " + teacher.getName() + ",\n\n"
                             + "This is an official notification to inform you that your staff profile details have been successfully updated in the Central College Anuradhapura School Management System.\n\n"
                             + "Below are your currently active registration details after the update:\n\n"
                             + "------------------------------------------------------\n"
                             + "  Teacher ID       : " + teacher.getTeacherId() + "\n"
                             + "  Full Name        : " + teacher.getName() + "\n"
                             + "  NIC Number       : " + teacher.getNic() + "\n"
                             + "  Date of Birth    : " + teacher.getBirthday() + "\n"
                             + "  Gender           : " + teacher.getGender() + "\n"
                             + "  Address          : " + teacher.getAddress() + "\n"
                             + "  Contact Number   : " + teacher.getContactNumber() + "\n"
                             + "  Registered Email : " + teacher.getEmail() + "\n"
                             + "  System Password  : " + teacher.getPassword() + "\n"
                             + "------------------------------------------------------\n\n"
                             + "If you did not authorize or request these changes, please contact the IT administration desk immediately to secure your account.\n\n"
                             + "Sincerely,\n"
                             + "The Administration,\n"
                             + "Central College Anuradhapura.";
            
            message.setText(emailBody);
            Transport.send(message);
            System.out.println("Teacher Update Email Sent Successfully to: " + teacher.getEmail());
            
        } catch (Exception e) {
            System.out.println("Teacher Update Email Sending Failed: " + e.getMessage());
        }
    }

    // 3. Delete Teacher 
    public static void sendDeleteEmail(TeacherDto teacher) {
        try {
            Session session = MailConnection.getInstance().getSession();
            String senderEmail = MailConnection.getInstance().getSenderEmail();
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(teacher.getEmail()));
            
            message.setSubject("Official Notice: Staff Account Deactivation - Central College Anuradhapura");
            
            String emailBody = "Dear " + teacher.getName() + ",\n\n"
                             + "This is an official notification to inform you that your staff account has been completely removed from the Central College Anuradhapura School Management System.\n\n"
                             + "Deactivated Account Details:\n"
                             + "------------------------------------------------------\n"
                             + "  Teacher ID       : " + teacher.getTeacherId() + "\n"
                             + "  Registered Email : " + teacher.getEmail() + "\n"
                             + "------------------------------------------------------\n\n"
                             + "Please note that all your system access privileges have been revoked with immediate effect. If you believe this action was taken in error, or if you require any further clarification regarding this account deactivation, please contact the school office or the IT administration desk immediately.\n\n"
                             + "Sincerely,\n"
                             + "The Administration,\n"
                             + "Central College Anuradhapura.";
            
            message.setText(emailBody);
            Transport.send(message);
            System.out.println("Teacher Delete Email Sent Successfully to: " + teacher.getEmail());
            
        } catch (Exception e) {
            System.out.println("Teacher Delete Email Sending Failed: " + e.getMessage());
        }
    }
}