package org.exemple.utils;
import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.pop3.POP3Store;
import com.sun.mail.smtp.SMTPTransport;
public class XOAuthEmailSender {

    public static void xOAuthEmailSender() {
        // Sender's email address and password
        final String username = "choquidownn2255@outlook.com";
        final String password = "1234hiphop";

        // Recipient's email address
        String toEmail = "jose_sarria2003@yahoo.com.mx";

        // SMTP server configuration
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        //props.put("mail.smtp.host", "smtp.gmail.com");

        props.put("mail.smtp.host", "smtp-mail.outlook.com");
        props.put("mail.smtp.port", "587");

        // OAuth authentication configuration
        props.put("mail.smtp.sasl.enable", "true");
        props.put("mail.smtp.sasl.mechanisms", "XOAUTH2");
        props.put("mail.smtp.auth.login.disable", "true");
        props.put("mail.smtp.auth.plain.disable", "true");

        // Create a session with OAuth2 authenticator
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Testing XOAUTH Email");
            message.setText("This is a test email sent using XOAUTH authentication.");

            // Send the message using SMTP transport
            SMTPTransport transport = (SMTPTransport) session.getTransport("smtp");
            //transport.connect("smtp.gmail.com", username, password);

            transport.connect("smtp-mail.outlook.com", username, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

            System.out.println("Email sent successfully.");
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void receiveEmail(String pop3Host, String storeType,
                                    String user, String password) {
        try {
            //1) get the session object
            Properties properties = new Properties();
            properties.put("mail.pop3.host", pop3Host);
            Session emailSession = Session.getDefaultInstance(properties);

            //2) create the POP3 store object and connect with the pop server
            POP3Store emailStore = (POP3Store) emailSession.getStore(storeType);
            emailStore.connect(user, password);

            //3) create the folder object and open it
            Folder emailFolder = emailStore.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            //4) retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            for (int i = 0; i < messages.length; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Text: " + message.getContent().toString());
            }

            //5) close the store and folder objects
            emailFolder.close(false);
            emailStore.close();

        } catch (NoSuchProviderException e) {
            System.out.println("Error : " + e.getMessage());
            e.printStackTrace();
        }
        catch (MessagingException e) {
            System.out.println("Error : " + e.getMessage());
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
            e.printStackTrace();
        }
    }

}
