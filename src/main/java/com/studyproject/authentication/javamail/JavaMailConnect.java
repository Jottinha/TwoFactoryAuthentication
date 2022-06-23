package com.studyproject.authentication.javamail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class JavaMailConnect {
	public static Session connectEmail() {
		  
		  Properties properties = new Properties();
		  
		  properties.put("mail.smtp.auth", "true");
		  properties.put("mail.smtp.starttls.enable", "true");
		  properties.put("mail.smtp.host", "smtp.gmail.com");
		  properties.put("mail.smtp.port", "587");
		  
		  final String myAccountEmail = "seu email@gmail.com";
		  final String password = "sua senha(precisa ser a senha adicionada para apps menos seguros)";
		  
		  Session session = Session.getInstance(properties, new Authenticator(){
			 
			  @Override
			  protected PasswordAuthentication getPasswordAuthentication()
	           {
	                 return new PasswordAuthentication(myAccountEmail, password);
	           }
		  });
		  
		  return session;
	}
}
