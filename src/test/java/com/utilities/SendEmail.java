package com.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.utilities.Driver;
public class SendEmail {
	public static void email() {

		String reportFileName = "AutomationReport.html", bodyName = "", subject = "";
		
		if(Driver.properties.getTestUrl().contains("http://localhost:3000/signin"))
		{
			reportFileName = "AutomationReport.html";
			bodyName = "PFA Automation Test Report for Local-Host";
			subject = "LexStep Automation Test Script- Local-Host IP";
		}
		
		else if(Driver.properties.getTestUrl().contains("https://staging.lexstep.com"))
		{
			reportFileName = "AutomationReport.html";
			bodyName = "PFA Automation Test Report for Stage";
			subject = "LexStep Automation Test Script- Stage Server";
		}
		else if(Driver.properties.getTestUrl().contains("https://lexstep.com")) {
			reportFileName = "AutomationReport.html";
			bodyName = "PFA Automation Test Report for Prod.";
			subject = "LexStep Automation Test Script- Production Server";
		}
		
		GmailSmtpService mailerService = new GmailSmtpService();
		String[] recipientList = {"jawad.butt@emumba.com"};
	
		String directoryName = "Report";
		
		String extentReportPath = directoryName + File.separator + reportFileName;

		File extentReportFile = new File(extentReportPath);

		if (!extentReportFile.exists() || extentReportFile.isDirectory()) {
			extentReportFile.getParentFile().mkdirs();
			try {
				extentReportFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace(System.out);
			}
		}

		try {
			mailerService.sendHTMLAsAttachment(extentReportPath, Driver.properties.getExtentRptSubject(), bodyName, subject, recipientList, null, null, null, "test");
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
		
/*		// Create object of Property file
		Properties props = new Properties();

		// this will set host of server- you can change based on your requirement
		props.put("mail.smtp.host", "smtp.gmail.com");

		// set the port of socket factory
		props.put("mail.smtp.socketFactory.port", "465");

		// set socket factory
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		// set the authentication to true
		props.put("mail.smtp.auth", "true");

		// set the port of SMTP server
		props.put("mail.smtp.port", "465");

		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Driver.properties.getExtentRptAuthId(),
						Driver.properties.getExtentRptAuthPwd());
			}
		});

		try {
			// Create object of MimeMessage class
			Message message = new MimeMessage(session);

			// Set the from address
			message.setFrom(new InternetAddress("raihan.usmani@emumba.com"));

			// Set the recipient address
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(Driver.properties.getExtentRptSendTO()));
			message.setRecipients(Message.RecipientType.CC,
					InternetAddress.parse(Driver.properties.getExtentRptSendCc()));

			// Add the subject link
			message.setSubject(Driver.properties.getExtentRptSubject());

			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();

			// Set the body of email
			messageBodyPart1.setText(Driver.properties.getExtentRptMailBody());

			// Create another object to add another content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

			// Mention the file which you want to send
			String directoryName = "Report";
			String reportFileName = "AutomationReport.html";
			String extentReportPath = directoryName + File.separator + reportFileName;

			File extentReportFile = new File(extentReportPath);

			if (!extentReportFile.exists() || extentReportFile.isDirectory()) {
				extentReportFile.getParentFile().mkdirs();
				try {
					extentReportFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace(System.out);
				}
			}

			// Create data source and pass the filename

			DataSource source = new FileDataSource(extentReportPath);

			// set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source));

			// set the file
			messageBodyPart2.setFileName(extentReportPath);

			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();

			// add body part 1
			multipart.addBodyPart(messageBodyPart2);

			// add body part 2
			multipart.addBodyPart(messageBodyPart1);

			// set the content
			message.setContent(multipart);

			// finally send the email
//			Transport.send(message);

//			System.out.println("=====Email Sent=====");

		} catch (MessagingException e) {

			throw new RuntimeException(e);
		}*/
	}
}
