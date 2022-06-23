package com.studyproject.authentication.javamail;

public class RunJavaMail {
	public static boolean sendingCodeByEmail(String emailUser, String codeVerification) {
		new SendJavaMail();
		boolean verifica = SendJavaMail.preparedSendEmail(emailUser, codeVerification);
		
		return verifica;
	}
}
