package com.studyproject.authentication.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.studyproject.authentication.login.Login;

public class CheckRegisteredUsers {
	
	public static boolean verifyEmail(Login login, Connection connect) {
		PreparedStatement statementSql;
		
		try {
			statementSql = connect.prepareStatement("SELECT email FROM cadastro");
			ResultSet mySqlReturn = statementSql.executeQuery();
				
			while(mySqlReturn.next()) {
				String userEmail = mySqlReturn.getString("email");
					
				if(userEmail.equals(login.getEmail())) {
					connect.close();
					return true;
				}
			}
		} catch (Exception e) {
			e.getMessage();
			e.getStackTrace();
		}
		return false;
	}
	
	public static boolean verifyPassword(Login login, Connection connect) {
		PreparedStatement statementSql;
		try {
			statementSql = connect.prepareStatement("SELECT senha FROM cadastro");
			ResultSet mySqlReturn = statementSql.executeQuery();
			
			while(mySqlReturn.next()) {
				String userPassword = mySqlReturn.getString("senha");
				
					
				if(userPassword.equals(login.getPassword())) {
					connect.close();
					return true;
				}
			}
		} catch (Exception e) {
			e.getMessage();
			e.getStackTrace();
		}
		return false;
	}
	
}
