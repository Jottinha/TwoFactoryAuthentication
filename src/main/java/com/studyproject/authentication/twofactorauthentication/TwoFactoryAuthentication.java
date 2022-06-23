package com.studyproject.authentication.twofactorauthentication;

import java.util.Scanner;

import com.studyproject.authentication.cadastro.Cadastro;
import com.studyproject.authentication.javamail.SendJavaMail;
import com.studyproject.authentication.login.Login;
import com.studyproject.authentication.mysql.RunSql;
import com.studyproject.authentication.securitycode.SecurityCode;

public class TwoFactoryAuthentication {
	
	public static void main(String[] args) {
		
		int answerUser;
		
		do {
			answerUser = menu();
			
			switch(answerUser) {
				case 1:
					loginUser();
					break;
				case 2:
					newUser();
					break;
				case 3:
					break;
			}
		}while(answerUser != 3);
		
	}
	
	public static int menu() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("(1)Login\n(2)Registro\n(3)Sair");
		int answer = input.nextInt();
		
		return answer;	
	}
	
	public static void loginUser() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o email cadastrado: ");
		String email = input.next();
		
		System.out.println("Digite a senha: ");
		String senha = input.next();
		
		Login login = new Login(senha, email);
		
		new RunSql();
		new SecurityCode();
		
		if(RunSql.sqlOperationRegisteredUser(login)) {
			String codeVerification = SecurityCode.newSecurityCode();
			System.out.println("Um codigo de verificação está sendo enviado ao seu email!");
			sendCodeEmail(login, codeVerification);
			
			if(verifyCode(codeVerification)) {
				System.out.println("Usuario logado com sucesso!");
			}else {
				System.out.println("Codigo invalido! Falha ao se conectar");
			}

		}else {
			System.out.println("Email ou senha invalidos");
		}
	}
	
	public static void sendCodeEmail(Login login, String code) {
		new SendJavaMail();
		
		if(SendJavaMail.preparedSendEmail(login.getEmail(), code)) {
			System.out.println("Verifique o email enviado ao seu email cadastrado\n\n");
		}else {
			System.out.println("Um erro inesperado ocorreu no envio do codigo ao email");
		}
	}
	
	public static boolean verifyCode(String code) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o codigo enviado ao seu email: ");
		String userCodeType = input.next();
		
		new SecurityCode();
		if(SecurityCode.verifySecurityCode(code, userCodeType)) {
			return true;
		}
		return false;
	}
	
	public static void newUser() {
		Scanner input = new Scanner(System.in);
		Cadastro newCadastro;
		
		new RunSql();
		
		int verifyNewUser = 1, newUser = 2;
		do {
			System.out.println("Digite um nome de usuario: ");
			String nome = input.next();
			System.out.println("Digite uma senha: ");
			String senha = input.next();
			System.out.println("Digite um email: ");
			String email = input.next();
			
			newCadastro = new Cadastro(nome, senha, email);
			
			if(!RunSql.sqlOperationNewUser(verifyNewUser, newCadastro)) {
				if(RunSql.sqlOperationNewUser(newUser, newCadastro)) {
					System.out.println("Usuario cadastrado");
				}
				break;
			}
			System.out.println("Usuario ou email invalidos!");
		}while(true);
		
	}
}
