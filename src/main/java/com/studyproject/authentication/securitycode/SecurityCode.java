package com.studyproject.authentication.securitycode;

import java.util.Random;

public class SecurityCode {
	
	public static String newSecurityCode() {
		
		Random seed = new Random();
		
		int code = seed.nextInt(9999);
		String newCode = String.valueOf(code);
		return newCode;
	}
	
	public static boolean verifySecurityCode(String correctCode, String verifyCode) {
		
		if(correctCode.equals(verifyCode)) {
			return true;
		}
		return false;
	}
}
