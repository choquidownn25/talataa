package org.exemple.utils;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
public class OutlookEmailSender {
    public static void outlookEmailSender() throws Exception {
        // Set up OAuth2 properties
        String clientId = "YOUR_CLIENT_ID";
        String clientSecret = "YOUR_CLIENT_SECRET";
        String refreshToken = "YOUR_REFRESH_TOKEN";
        String accessTokenUrl = "https://login.microsoftonline.com/common/oauth2/v2.0/token";

        // Set up JavaMail properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.port", "587");

        // Create a Session with OAuth2 authentication
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(null, refreshToken);
            }
        });

        // Get the access token
        URLName unusedUrlName = null;
        Store store = session.getStore(new URLName("smtp", "smtp.office365.com", 587, null, null, null));
        store.connect();

        String accessToken = store.getURLName().getPassword();

        // Create the message
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("your-email@example.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("recipient@example.com"));
        message.setSubject("Hello from JavaMail");
        message.setText("This is a test email from JavaMail.");

        // Send the message
        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.office365.com", 587, clientId, clientSecret);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();

        System.out.println("Email sent successfully!");
    }
}
