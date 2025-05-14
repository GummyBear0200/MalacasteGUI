package config;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {

    public static void sendEmail(String toEmail, String otp) {
        final String fromEmail = "malacastec123@gmail.com"; 
        final String appPassword = "lrtp csmu gjal hfsy";

        
       
        Properties props = new Properties();
props.put("mail.smtp.host", "smtp.gmail.com");
props.put("mail.smtp.port", "465");
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.ssl.enable", "true");

        
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, appPassword);
            }
        });

        try {
           
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Your OTP Code");
            message.setText("Your OTP is: " + otp);

           
            Transport.send(message);
            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace(); 
        }
    }
}