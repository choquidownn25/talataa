package org.exemple.utils;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
public class SendEmail {
    public static void sendEmail(String[] args) {
        final String username = "your_email@gmail.com";
        final String accessToken = "your_oauth_access_token";
        final String tokenSecret = "your_oauth_token_secret";

        // Set up OAuth properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth.mechanisms", "XOAUTH2");
        props.put("mail.smtp.auth.xoauth2.consumerKey", "");
        props.put("mail.smtp.auth.xoauth2.consumerSecret", "");
        props.put("mail.smtp.auth.xoauth2.accessToken", accessToken);
        props.put("mail.smtp.auth.xoauth2.tokenSecret", tokenSecret);

        // Create a session with OAuth
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, "");
            }
        });

        try {
            // Create a new email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("recipient_email@example.com"));
            message.setSubject("Testing XOAUTH");
            message.setText("Hello, this is a test email!");

            // Send the email
            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
