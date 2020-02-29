/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.FinanceOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.Resource;
import Business.WorkQueue.WorkRequest;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Skull
 */
public class emailclass {

    static Properties mailServerProperties;
    static Session getMailSession;
    static MimeMessage generateMailMessage;

    public static void main(String args[]) throws AddressException, MessagingException {
//        Date d = new Date();
//        generateAndSendEmailDonation("b", "Your donation is important to us", d);
        System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
    }

    
    
    
        
    
    public static void generateAndSendEmailDonation(String receiver,WorkRequest wr) throws AddressException, MessagingException,Exception {
        String message = wr.getMessage();
        long m = wr.getCreatedDate();
        Date d = new Date(m);
        
        // Step1
        System.out.println("\n 1st ===> setup Mail Server Properties..");
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        System.out.println("Mail Server Properties have been setup successfully..");

        // Step2
        System.out.println("\n\n 2nd ===> get Mail Session..");
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
//		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));

// String recipient1 = "sush1990@gmail.com ,sushrutt.12@gmail.com";
 String recipient1 = receiver;
String[] recipientList = recipient1.split(",");
InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
int counter = 0;
for (String recipient : recipientList) {
    recipientAddress[counter] = new InternetAddress(recipient.trim());
    counter++;
}
        generateMailMessage.setRecipients(Message.RecipientType.TO, recipientAddress);
//		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("hanan.alsalamah@gmail.com"));

        generateMailMessage.setSubject("A note of gratitude");

        String emailBody = message + " on date " + d + " Regards, NGO.APP.TEST";

        BodyPart messageBodyPart = new MimeBodyPart();

        messageBodyPart.setText(emailBody);

        Multipart multipart = new MimeMultipart();

        multipart.addBodyPart(messageBodyPart);

        messageBodyPart = new MimeBodyPart();

        DataSource source = new FileDataSource("C:\\Users\\sushr\\Desktop\\AED Final\\New folder\\updated version\\File\\thankyou.jpg");

        messageBodyPart.setDataHandler(new DataHandler(source));

        messageBodyPart.setFileName("thankyou.jpg");

        multipart.addBodyPart(messageBodyPart);

        generateMailMessage.setContent(multipart);

        System.out.println("Mail Session has been created successfully..");

        // Step3
        System.out.println("\n\n 3rd ===> Get Session and Send mail");
        Transport transport = getMailSession.getTransport("smtp");

        // Enter your correct gmail UserID and Password
        // if you have 2FA enabled then provide App Specific Password
        transport.connect("smtp.gmail.com", "ngo.app.test@gmail.com", "apptest123");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }
    
    
    public static void generateAndSendEmailEvent(String receiver,WorkRequest wr) throws AddressException, MessagingException,Exception {
        String message = wr.getMessage();
        long m = wr.getCreatedDate();
        Date d = new Date(m);
        
        // Step1
        System.out.println("\n 1st ===> setup Mail Server Properties..");
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        System.out.println("Mail Server Properties have been setup successfully..");

        // Step2
        System.out.println("\n\n 2nd ===> get Mail Session..");
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
//		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));

// String recipient1 = "sush1990@gmail.com ,sushrutt.12@gmail.com";
 String recipient1 = receiver;
String[] recipientList = recipient1.split(",");
InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
int counter = 0;
for (String recipient : recipientList) {
    recipientAddress[counter] = new InternetAddress(recipient.trim());
    counter++;
}
        generateMailMessage.setRecipients(Message.RecipientType.TO, recipientAddress);
//		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("hanan.alsalamah@gmail.com"));

        generateMailMessage.setSubject("Event");

        String emailBody = message + " on date " + d + " Regards, NGO.APP.TEST";

        BodyPart messageBodyPart = new MimeBodyPart();

        messageBodyPart.setText(emailBody);

        Multipart multipart = new MimeMultipart();

        multipart.addBodyPart(messageBodyPart);
        generateMailMessage.setContent(multipart);

        System.out.println("Mail Session has been created successfully..");

        // Step3
        System.out.println("\n\n 3rd ===> Get Session and Send mail");
        Transport transport = getMailSession.getTransport("smtp");

        // Enter your correct gmail UserID and Password
        // if you have 2FA enabled then provide App Specific Password
        transport.connect("smtp.gmail.com", "ngo.app.test@gmail.com", "apptest123");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }
    
    public static void generateAndSendEmailTargetResources(String receiver,WorkRequest wr) throws AddressException, MessagingException,Exception {
        String message = wr.getMessage();
        long m = wr.getCreatedDate();
        Date d = new Date(m);
        
        // Step1
        System.out.println("\n 1st ===> setup Mail Server Properties..");
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        System.out.println("Mail Server Properties have been setup successfully..");

        // Step2
        System.out.println("\n\n 2nd ===> get Mail Session..");
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
//		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));

// String recipient1 = "sush1990@gmail.com ,sushrutt.12@gmail.com";
 String recipient1 = receiver;
String[] recipientList = recipient1.split(",");
InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
int counter = 0;
for (String recipient : recipientList) {
    recipientAddress[counter] = new InternetAddress(recipient.trim());
    counter++;
}
        generateMailMessage.setRecipients(Message.RecipientType.TO, recipientAddress);
//		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("hanan.alsalamah@gmail.com"));

        generateMailMessage.setSubject("Resources Request");

        String emailBody = message + " on date " + d + " Regards, NGO.APP.TEST";

        BodyPart messageBodyPart = new MimeBodyPart();

        messageBodyPart.setText(emailBody);

        Multipart multipart = new MimeMultipart();

        multipart.addBodyPart(messageBodyPart);
        generateMailMessage.setContent(multipart);

        System.out.println("Mail Session has been created successfully..");

        // Step3
        System.out.println("\n\n 3rd ===> Get Session and Send mail");
        Transport transport = getMailSession.getTransport("smtp");

        // Enter your correct gmail UserID and Password
        // if you have 2FA enabled then provide App Specific Password
        transport.connect("smtp.gmail.com", "ngo.app.test@gmail.com", "apptest123");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }
    
    
    
    public static void generateAndSendEmailEventResources(String receiver,WorkRequest wr) throws AddressException, MessagingException,Exception {
        String message = wr.getMessage();
        long m = wr.getCreatedDate();
        Date d = new Date(m);
        
        // Step1
        System.out.println("\n 1st ===> setup Mail Server Properties..");
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        System.out.println("Mail Server Properties have been setup successfully..");

        // Step2
        System.out.println("\n\n 2nd ===> get Mail Session..");
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
//		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));

// String recipient1 = "sush1990@gmail.com ,sushrutt.12@gmail.com";
 String recipient1 = receiver;
String[] recipientList = recipient1.split(",");
InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
int counter = 0;
for (String recipient : recipientList) {
    recipientAddress[counter] = new InternetAddress(recipient.trim());
    counter++;
}
        generateMailMessage.setRecipients(Message.RecipientType.TO, recipientAddress);
//		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("hanan.alsalamah@gmail.com"));

        generateMailMessage.setSubject("Event Resources Request");

        String emailBody = message + " on date " + d + " Regards, NGO.APP.TEST";

        BodyPart messageBodyPart = new MimeBodyPart();

        messageBodyPart.setText(emailBody);

        Multipart multipart = new MimeMultipart();

        multipart.addBodyPart(messageBodyPart);
        generateMailMessage.setContent(multipart);

        System.out.println("Mail Session has been created successfully..");

        // Step3
        System.out.println("\n\n 3rd ===> Get Session and Send mail");
        Transport transport = getMailSession.getTransport("smtp");

        // Enter your correct gmail UserID and Password
        // if you have 2FA enabled then provide App Specific Password
        transport.connect("smtp.gmail.com", "ngo.app.test@gmail.com", "apptest123");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }
    
    
    
    
    
    
    
    
public static void generateAndSendEmailResource(String receiver,Resource r) throws AddressException, MessagingException,Exception {
        String message = "Resource quantity changed to " +r.getQuantity();
//        long m = wr.getCreatedDate();
        Date d = new Date();
        
        // Step1
        System.out.println("\n 1st ===> setup Mail Server Properties..");
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        System.out.println("Mail Server Properties have been setup successfully..");

        // Step2
        System.out.println("\n\n 2nd ===> get Mail Session..");
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
//		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));

// String recipient1 = "sush1990@gmail.com ,sushrutt.12@gmail.com";
 String recipient1 = receiver;
String[] recipientList = recipient1.split(",");
InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
int counter = 0;
for (String recipient : recipientList) {
    recipientAddress[counter] = new InternetAddress(recipient.trim());
    counter++;
}
        generateMailMessage.setRecipients(Message.RecipientType.TO, recipientAddress);
//		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("hanan.alsalamah@gmail.com"));

        generateMailMessage.setSubject("Budget change");

        String emailBody = message + " on date " + d + " Regards, NGO.APP.TEST";

        BodyPart messageBodyPart = new MimeBodyPart();

        messageBodyPart.setText(emailBody);

        Multipart multipart = new MimeMultipart();

        multipart.addBodyPart(messageBodyPart);
        generateMailMessage.setContent(multipart);

        System.out.println("Mail Session has been created successfully..");

        // Step3
        System.out.println("\n\n 3rd ===> Get Session and Send mail");
        Transport transport = getMailSession.getTransport("smtp");

        // Enter your correct gmail UserID and Password
        // if you have 2FA enabled then provide App Specific Password
        transport.connect("smtp.gmail.com", "ngo.app.test@gmail.com", "apptest123");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }



}
