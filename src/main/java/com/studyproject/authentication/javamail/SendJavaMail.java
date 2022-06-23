package com.studyproject.authentication.javamail;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendJavaMail {
	public static boolean preparedSendEmail(String emailUser, String codeVerification) {
		
		String myAccountEmail = "seu email@gmail.com";
		new JavaMailConnect();
		Session session = JavaMailConnect.connectEmail();
		
		Message message = prepareMessage(session, myAccountEmail, emailUser, codeVerification);
		
		if(sendEmail(message)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private static Message prepareMessage (Session session, String myAccountEmail, String emailUser, String codeVerification) {
		  try {
			  Message message = new MimeMessage(session);
		      message.setFrom(new InternetAddress(myAccountEmail));
		      message.setRecipient(Message.RecipientType.TO, new InternetAddress(emailUser));
		      message.setSubject("CODIGO VERIFICAÇÃO");
		      message.setText("Olá, seu codigo de verificação é:\n" + codeVerification);
		      return message;
		  } catch(Exception ex) {
			  ex.getMessage();
			  ex.getStackTrace();
		  }
		  return null;
	  }
	
	private static boolean sendEmail(Message message) {
		try {
			Transport.send(message);
			return true;
		} catch (Exception e) {
			e.getMessage();
			e.getStackTrace();
			return false;
		}
	}
}
