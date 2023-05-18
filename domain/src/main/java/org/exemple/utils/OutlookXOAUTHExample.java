package org.exemple.utils;

import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

public class OutlookXOAUTHExample {
    public static void main(String[] args) {
        // Configuración de propiedades
        Properties props = new Properties();
        props.put("mail.imap.ssl.enable", "true");
        props.put("mail.imap.auth.login.disable", "true");
        props.put("mail.imap.auth.plain.disable", "true");
        props.put("mail.imap.host", "outlook.office365.com");
        props.put("mail.imap.port", "993");
        props.put("mail.imap.auth.xoauth2.disable", "false");

        // Credenciales
        String username = "tu_correo@outlook.com";
        String accessToken = "tu_access_token";

        try {
            // Crear sesión
            Session session = Session.getInstance(props);

            // Establecer propiedades adicionales para autenticación XOAUTH
            props.put("mail.imap.sasl.enable", "true");
            props.put("mail.imap.sasl.mechanisms", "XOAUTH2");
            props.put("mail.imap.auth.xoauth2.clientid", "tu_client_id");
            props.put("mail.imap.auth.xoauth2.clientsecret", "tu_client_secret");
            props.put("mail.imap.auth.xoauth2.refresh", "true");
            props.put("mail.imap.auth.xoauth2.accesstoken", accessToken);

            // Obtener el objeto Store y conectar
            Store store = session.getStore("imap");
            store.connect("outlook.office365.com", username, accessToken);

            // Abrir carpeta "INBOX"
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Obtener los mensajes en la carpeta
            Message[] messages = inbox.getMessages();

            // Procesar los mensajes
            for (Message message : messages) {
                // Imprimir información del mensaje
                System.out.println("De: " + message.getFrom()[0]);
                System.out.println("Asunto: " + message.getSubject());
                System.out.println("Fecha: " + message.getSentDate());
                System.out.println("Contenido: " + message.getContent());
                System.out.println("-----------------------");
            }

            // Cerrar carpeta y almacenamiento
            inbox.close(false);
            store.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/*
Asegúrate de reemplazar los valores tu_correo@outlook.com, tu_access_token, tu_client_id y tu_client_secret
con tus propias credenciales de Outlook y los valores correspondientes para la autenticación XOAUTH.

Recuerda que para utilizar la autenticación XOAUTH es necesario obtener un token de acceso válido y configurar
las credenciales de la aplicación en el portal de desarrolladores de Microsoft (Azure).
 */
