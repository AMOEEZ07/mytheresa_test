package com.utilities;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author User
 */

public class GmailSmtpService {

	private static final String SMTP_HOST_NAME = "smtp.1and1.com";
	private static final String DELIMETER = ",";

	private static final String SMTP_AUTH_USER = "noreply@dvsum.com";
	private static final String SMTP_AUTH_PWD = "Winter2014";
	private static final String FROM_ADDRESS = "support@lexstep.com";
	private static final String FROM_NAME = "LexStep Automation Test Script";


	protected void sendExcelAsAttachment(ByteArrayOutputStream outputStream , String subject, String message, String mailSubject, String[] toList, String cc, String bcc, String fromName, String fileName)
			throws MessagingException, UnsupportedEncodingException{

		Message msg = mailMessage(subject, message, mailSubject, toList, cc, bcc, fromName);

		Multipart mp = new javax.mail.internet.MimeMultipart();
        javax.mail.internet.MimeBodyPart htmlPart = new javax.mail.internet.MimeBodyPart ();

        
        javax.mail.internet.MimeBodyPart attachment = new javax.mail.internet.MimeBodyPart ();    
        if(message != null){
            attachment.setFileName(fileName);
        }else{
            attachment.setFileName(fileName);
        }
        htmlPart.setContent(message, "text/html");

        DataSource src = new ByteArrayDataSource(outputStream.toByteArray(), "application/vnd.ms-excel");
        attachment.setDataHandler(new DataHandler(src));
        
        mp.addBodyPart(htmlPart);
        //attachment.setContent(outputStream.toByteArray(), "application/vnd.ms-excel");
        mp.addBodyPart(attachment);
		// Setting the Subject and Content Type
		msg.setSubject(subject);
		msg.setContent(mp);
		Transport.send(msg);

	}
	
	protected void sendHTMLAsAttachment(String filePath, String subject, String message, String mailSubject, String[] toList, String cc, String bcc, String fromName, String fileName)
			throws MessagingException, UnsupportedEncodingException{

		Message msg = mailMessage(subject, message, mailSubject, toList, cc, bcc, fromName);

		Multipart mp = new javax.mail.internet.MimeMultipart();
        javax.mail.internet.MimeBodyPart htmlPart = new javax.mail.internet.MimeBodyPart ();

        
        javax.mail.internet.MimeBodyPart attachment = new javax.mail.internet.MimeBodyPart ();   
        
        try {
            attachment.attachFile(filePath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        htmlPart.setContent(message, "text/html");

        mp.addBodyPart(htmlPart);
        //attachment.setContent(outputStream.toByteArray(), "application/vnd.ms-excel");
        mp.addBodyPart(attachment);
		// Setting the Subject and Content Type
		msg.setSubject(subject);
		msg.setContent(mp);
		Transport.send(msg);

	}
	
	protected boolean sendEmail(String subject, String message, String mailSubject, String[] toList, String cc, String bcc, String fromName)
			throws MessagingException, UnsupportedEncodingException {

		Message msg = mailMessage(subject, message, mailSubject, toList, cc, bcc, fromName);
		// Setting the Subject and Content Type
		msg.setSubject(subject);
		msg.setContent(message, "text/html; charset=UTF-8");
		Transport.send(msg);
		return true;
	}

	protected Message mailMessage(String subject, String message, String mailSubject, String[] toList, String cc, String bcc, String fromName) throws MessagingException, UnsupportedEncodingException {
		boolean debug = false;

		// Set the host smtp address
		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.starttls.enable", "true");
		//props.put("mail.smtp.starttls.required", "true");
		//props.put("mail.debug", "true");
		props.put("mail.smtp.ssl.trust", SMTP_HOST_NAME);
		
		Authenticator auth = new SMTPAuthenticator();
		Session session = Session.getInstance(props, auth);

		session.setDebug(debug);

		// create a message
		Message msg = new MimeMessage(session);


		// set the from and to address
		InternetAddress addressFrom = new InternetAddress();
		addressFrom.setAddress(FROM_ADDRESS);
		if(fromName == null){
			addressFrom.setPersonal(mailSubject);
		} else {
			addressFrom.setPersonal(fromName);
		}
		msg.setFrom(addressFrom);

		InternetAddress[] addressTo = new InternetAddress[toList.length];
		for (int i = 0; i < toList.length; i++)
		{
			addressTo[i] = new InternetAddress(toList[i]);
		}
		msg.setRecipients(Message.RecipientType.TO, addressTo);

		if(!Util.isNullOrEmptyTrimmed(cc)) {
			String[] ccList = StringUtils.split(cc, DELIMETER);

			InternetAddress[] addressCC = new InternetAddress[ccList.length];
			for (int i = 0; i < ccList.length; i++)
			{
				addressCC[i] = new InternetAddress(ccList[i]);
			}

			msg.setRecipients(Message.RecipientType.CC, addressCC);
		}
		if(!Util.isNullOrEmptyTrimmed(bcc)) {
			String[] bccList = StringUtils.split(bcc, DELIMETER);

			InternetAddress[] addressBCC = new InternetAddress[bccList.length];
			for (int i = 0; i < bccList.length; i++)
			{
				addressBCC[i] = new InternetAddress(bccList[i]);
			}

			msg.setRecipients(Message.RecipientType.BCC, addressBCC);
		}
		return msg;
	}

	/**
	 * SimpleAuthenticator is used to do simple authentication when the SMTP
	 * server requires it.
	 */
	private class SMTPAuthenticator extends javax.mail.Authenticator {

		@Override
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(SMTP_AUTH_USER, SMTP_AUTH_PWD);
		}
	}

}
