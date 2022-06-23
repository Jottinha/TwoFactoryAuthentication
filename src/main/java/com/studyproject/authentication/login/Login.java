package com.studyproject.authentication.login;

public class Login {
	
	private String password;
	private String email;
	private boolean verification;
	
	public Login(String password, String email) {
		setPassword(password);
		setEmail(email);
		setVerification(false);
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isVerification() {
		return verification;
	}
	public void setVerification(boolean verification) {
		this.verification = verification;
	}
	
	
}
