package org.exemple.utils;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;

public class JavaMailIMAPProtocolOutlook {

    public static void recivedEmail() throws Exception {
        String host = "imap-mail.outlook.com";
        String username = "choquidownn2255@outlook.com";
        String password = "1234hiphop";

        Properties properties = new Properties();
        properties.setProperty("mail.imap.host", host);
        properties.setProperty("mail.imap.port", "993");
        properties.setProperty("mail.imap.starttls.enable", "true");

        Session session = Session.getInstance(properties);
        Store store = session.getStore("imaps");
        store.connect(host, username, password);

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        Message[] messages = inbox.getMessages();
        // Process the messages as needed
        for (Message message : messages) {
            String subject = message.getSubject();
            String sender = message.getFrom()[0].toString();
            System.out.println("Subject: " + subject);
            System.out.println("Sender: " + sender);
        }
        inbox.close(false);
        store.close();

    }

    public static void recivedEmailPOP3() throws Exception{
        String host = "pop-mail.outlook.com";
        String username = "choquidownn2255@outlook.com";
        String password = "1234hiphop";

        Properties properties = new Properties();
        properties.setProperty("mail.pop3.host", host);
        properties.setProperty("mail.pop3.port", "995");
        properties.setProperty("mail.pop3.starttls.enable", "true");

        Session session = Session.getInstance(properties);
        Store store = session.getStore("pop3s");
        store.connect(host, username, password);

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        Message[] messages = inbox.getMessages();
        // Process the messages as needed
        for (Message message : messages) {
            String subject = message.getSubject();
            String sender = message.getFrom()[0].toString();
            System.out.println("Subject: " + subject);
            System.out.println("Sender: " + sender);
        }
        inbox.close(false);
        store.close();

    }
    public static void recivedEmailIMP() throws Exception {

        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        props.setProperty("mail.imaps.host", "outlook.office365.com");
        props.setProperty("mail.imaps.port", "993");
        props.setProperty("mail.imaps.ssl.enable", "true");

        Session session = Session.getInstance(props, null);
        Store store = session.getStore();
        store.connect("choquidownn2255@outlook.com", "1234hiphop");

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        Message[] messages = inbox.getMessages();

        for (Message message : messages) {
            // Print or process each message
            System.out.println("Subject: " + message.getSubject());
            System.out.println("From: " + message.getFrom()[0]);
            System.out.println("Text: " + message.getContent());
        }

        // Close the folder and store
        inbox.close(false);
        store.close();
    }
}
