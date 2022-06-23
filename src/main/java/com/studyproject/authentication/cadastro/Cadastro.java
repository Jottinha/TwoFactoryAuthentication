package com.studyproject.authentication.cadastro;

public class Cadastro {
	private String login;
	private String password;
	private String email;
	private String codeVerification;
	
	
	public Cadastro(String login, String password, String email) {
		setLogin(login);
		setPassword(password);
		setEmail(email);
	}
	
	@Override
	public String toString() {
		return "Cadastro \nLogin= " + login + "\nPassword= " + password + "\nEmail=" + email;
	}
	
	public String getCodeVerification() {
		return codeVerification;
	}

	public void setCodeVerification(String codeVerification) {
		this.codeVerification = codeVerification;
	}

	public String getLogin() {
		return login;
	}
	private void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	private void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	private void setEmail(String email) {
		this.email = email;
	}
}
