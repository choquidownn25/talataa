package org.exemple.utils;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.*;

public class XOauthEmailReceiver {
    public static void xOauthEmailReceiver() {
        try {
            // Configuración de propiedades
            Properties props = new Properties();
            props.setProperty("mail.store.protocol", "imaps");
            props.setProperty("mail.imaps.host", "imap.outlook.com"); // Cambiar por el servidor IMAP adecuado
            props.setProperty("mail.imaps.port", "993");
            props.setProperty("mail.imaps.ssl.enable", "true");

            // Obtener la sesión de correo
            Session session = Session.getInstance(props);

            // Crear el objeto Store y conectarlo al servidor IMAP
            Store store = session.getStore("imaps");
            store.connect("imap.outlook.com", "choquidownn2255@outlook.com", "1234hiphop"); // Cambiar por tu información de inicio de sesión

            // Abrir la carpeta de entrada
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Obtener los mensajes de correo
            Message[] messages = inbox.getMessages();

            // Recorrer los mensajes y mostrar información
            for (Message message : messages) {
                System.out.println("De: " + message.getFrom()[0]);
                System.out.println("Asunto: " + message.getSubject());
                System.out.println("Contenido: " + message.getContent());
                System.out.println("-----------------------------");
            }

            // Cerrar la carpeta y desconectar el Store
            inbox.close(false);
            store.close();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void mainEmailReceiver() {
        // Configuración de propiedades
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        props.setProperty("mail.imaps.host", "imap.outlook.com");
        props.setProperty("mail.imaps.port", "993");

        try {
            // Crear una sesión
            Session session = Session.getInstance(props);

            // Crear el objeto Store y conectarse al servidor IMAP
            Store store = session.getStore("imaps");
            store.connect("imap.outlook.com", "choquidownn2255@outlook.com", "1234hiphop");

            // Abrir la carpeta INBOX
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Obtener los mensajes
            Message[] messages = inbox.getMessages();

            // Procesar los mensajes
            for (Message message : messages) {
                // Aquí puedes hacer algo con cada mensaje recibido
                System.out.println("Asunto: " + message.getSubject());
                System.out.println("Remitente: " + message.getFrom()[0]);
                System.out.println("Contenido: " + message.getContent());
            }

            // Cerrar la carpeta y desconectarse del servidor
            inbox.close(false);
            store.close();

        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void EmailReceiverMain() {
        // Configuración de propiedades
        Properties props = new Properties();
        props.put("mail.imap.host", "imap-mail.outlook.com");
        props.put("mail.imap.port", "993");
        props.put("mail.imap.ssl.enable", "true");
        props.put("mail.imap.auth.mechanisms", "XOAUTH2");

        // Datos de autenticación
        String username = "choquidownn2255@outlook.com";
        String accessToken = "tu_token_de_acceso";

        // Creación de la sesión
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, accessToken);
            }
        });

        try {
            // Conexión al servidor de correo IMAP
            Store store = session.getStore("imap");
            store.connect();

            // Carpeta de bandeja de entrada
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Obtener los mensajes
            Message[] messages = inbox.getMessages();
            System.out.println("Total de mensajes: " + messages.length);

            // Imprimir información de los mensajes
            for (Message message : messages) {
                System.out.println("De: " + message.getFrom()[0]);
                System.out.println("Asunto: " + message.getSubject());
                System.out.println("Contenido: " + message.getContent());
            }

            // Cerrar la conexión
            inbox.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
