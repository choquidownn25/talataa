package org.exemple.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import com.sun.mail.imap.IMAPStore;
import com.sun.mail.util.BASE64EncoderStream;

public class OutlookXOAuthReceiver {
    public static void mainOutlookXOAuthReceiver() {
        // Configuración de autenticación XOAUTH
        String consumerKey = "tu-consumer-key";
        String consumerSecret = "tu-consumer-secret";
        String accessToken = "tu-access-token";
        String accessTokenSecret = "tu-access-token-secret";
        String username = "tu-direccion-de-correo";
        String base64ConsumerSecret = new String(BASE64EncoderStream.encode(consumerSecret.getBytes()));
        String base64AccessTokenSecret = new String(BASE64EncoderStream.encode(accessTokenSecret.getBytes()));

        // Propiedades de conexión
        Properties props = new Properties();
        props.setProperty("mail.imaps.ssl.enable", "true");
        props.setProperty("mail.imaps.sasl.enable", "true");
        props.setProperty("mail.imaps.sasl.mechanisms", "XOAUTH2");
        props.setProperty("mail.imaps.auth.login.disable", "true");
        props.setProperty("mail.imaps.auth.plain.disable", "true");

        // Autenticador personalizado para XOAUTH
        Authenticator auth = new Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(username, accessToken);
            }
        };

        try {
            // Establecer la sesión de correo
            Session session = Session.getDefaultInstance(props, auth);

            // Obtener el objeto Store y conectar al servidor IMAP
            Store store = session.getStore("imaps");
            store.connect("imap-mail.outlook.com", 993, username, accessToken);

            // Obtener la carpeta de entrada (inbox)
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Leer los mensajes
            Message[] messages = inbox.getMessages();
            for (Message message : messages) {
                System.out.println("De: " + message.getFrom()[0]);
                System.out.println("Asunto: " + message.getSubject());
                System.out.println("Contenido: " + message.getContent().toString());
            }

            // Cerrar la carpeta y desconectar del servidor
            inbox.close(false);
            store.close();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void OutlookXOAuthReceiverMain( ) throws Exception {
        // Configurar las propiedades de conexión
        Properties props = new Properties();
        props.put("mail.imap.host", "outlook.office365.com");
        props.put("mail.imap.port", "993");
        props.put("mail.imap.ssl.enable", "true");

        // Configurar la autenticación XOAUTH
        props.put("mail.imap.auth.xoauth2.clientid", "TU_CLIENT_ID");
        props.put("mail.imap.auth.xoauth2.clientsecret", "TU_CLIENT_SECRET");
        props.put("mail.imap.auth.xoauth2.token", "TU_TOKEN_DE_ACCESO");
        props.put("mail.imap.auth.xoauth2.disable", "false");

        // Crear la sesión de correo
        Session session = Session.getDefaultInstance(props);

        // Obtener el almacén de correo IMAP
        Store store = session.getStore("imap");
        store.connect();

        // Abrir la carpeta de bandeja de entrada
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        // Obtener los mensajes de correo
        Message[] messages = inbox.getMessages();

        // Procesar los mensajes
        for (Message message : messages) {
            // Obtener los detalles del mensaje
            String subject = message.getSubject();
            String from = message.getFrom()[0].toString();
            String content = message.getContent().toString();

            System.out.println("Asunto: " + subject);
            System.out.println("De: " + from);
            System.out.println("Contenido: " + content);
        }

        // Cerrar la conexión
        inbox.close(false);
        store.close();
    }
}
/*
Asegúrate de reemplazar "TU_CLIENT_ID", "TU_CLIENT_SECRET" y "TU_TOKEN_DE_ACCESO" con los valores
correspondientes proporcionados por Microsoft Azure para la autenticación XOAUTH.

Este código utiliza la biblioteca JavaMail para interactuar con el servidor de correo.
Asegúrate de incluir las dependencias necesarias en tu proyecto.
 */
