//TODO O PROGRAMADA ESTA FUNCIOANNDO, AGORA SO MELHORAR MEU MAIN

package com.studyproject.authentication.mysql;

import java.sql.Connection;

import com.studyproject.authentication.cadastro.Cadastro;
import com.studyproject.authentication.login.Login;

public class RunSql {

	public static boolean sqlOperationNewUser(int programInstructions, Cadastro newCadastro) {
		
		int loginVerification = 1, createLoginData = 2;
		
		new MySqlConnection();
		Connection connect = MySqlConnection.connectMySql(); //here i connect if my SQL
		
		if(programInstructions == createLoginData) {
			new CrudMySql();
			connect = CrudMySql.createLoginData(connect, newCadastro);
			closeSql(connect);
			return true;
			
		}else if(programInstructions == loginVerification) {
			new CheckNewUser();
			
			if(!CheckNewUser.verifyNewUserName(newCadastro, connect)) {
				closeSql(connect);
				connect = MySqlConnection.connectMySql();
				
				if(!CheckNewUser.verifyNewUserEmail(newCadastro, connect)) {
					closeSql(connect);
					return false;
				}
			}
			return true;
			
		}else {
			System.out.println("Instrução para o programa invalida!");
			return false;
		}
	}
	
	public static boolean sqlOperationRegisteredUser(Login login) {
		
		new MySqlConnection();
		Connection connect = MySqlConnection.connectMySql(); //here i connect if my SQL
		
		new CheckRegisteredUsers();
		new CrudMySql();
		if(CheckRegisteredUsers.verifyEmail(login, connect)) {
			closeSql(connect);
			connect = MySqlConnection.connectMySql();//connect again to make a new consult
			
			if(CheckRegisteredUsers.verifyPassword(login, connect)) { 
				closeSql(connect);
				return true;
			}
		}
		
		return false;
	}
	
	public static void closeSql(Connection connect) {
		try {
			connect.close();
		} catch (Exception e) {
			e.getMessage();
			e.getStackTrace();	
		}
	}
	
}
