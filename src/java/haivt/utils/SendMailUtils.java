/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.utils;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;

/**
 *
 * @author phong
 */
public class SendMailUtils {

    public static boolean sendSimpleEmail(String receiverEmail, String content, String title) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("darkblue220297@gmail.com", "ozhfgvgsmtxzuzhj");
            }
        });
        boolean isSuccess = false;
        MimeMessage msg = new MimeMessage(session);

        try {
            msg.setFrom(new InternetAddress("darkblue220297@gmail.com", false));

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiverEmail));
            msg.setSubject(title);
            msg.setSentDate(new Date());
            msg.setContent(content, "text/html");

            Transport.send(msg);
            isSuccess = true;
        } catch (MessagingException e) {
            Logger.getLogger(SendMailUtils.class.getName()).log(Level.SEVERE, null, e);
        }
        return isSuccess;
    }
}
