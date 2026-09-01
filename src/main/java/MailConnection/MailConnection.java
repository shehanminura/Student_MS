/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MailConnection;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class MailConnection {
    
    private static MailConnection instance;
    private Session session;
    
    // ඔයාගේ Email එක සහ App Password එක මෙතැන දෙන්න
    private final String myEmail = "oop2group@gmail.com"; 
    private final String myPassword = "mvefxkrozzbgdwqt"; 

    // Make Constructor private (Singleton)
    private MailConnection() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com"); 
        props.put("mail.smtp.port", "587"); 
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        this.session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myEmail, myPassword);
            }
        });
    }

    // Get Instance 
    public static MailConnection getInstance() {
        if (instance == null) {
            instance = new MailConnection();
        }
        return instance;
    }

    // Session එක ලබාගන්නා Method එක
    public Session getSession() {
        return session;
    }
    
    // යවන කෙනාගේ Email එක ලබාගන්න (EmailService එකට පාවිච්චි කරන්න ලේසි වෙන්න)
    public String getSenderEmail() {
        return myEmail;
    }
}