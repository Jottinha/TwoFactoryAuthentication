package com.studyproject.authentication.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.studyproject.authentication.cadastro.Cadastro;

public class CheckNewUser {
	
	public static boolean verifyNewUserName(Cadastro newCadastro, Connection connect) {
		PreparedStatement statementSql;
		
		try {
			statementSql = connect.prepareStatement("SELECT login FROM cadastro");
			ResultSet mySqlReturn = statementSql.executeQuery();
				
			while(mySqlReturn.next()) {
				String userLogin = mySqlReturn.getString("login");
					
				if(userLogin.equals(newCadastro.getLogin())) {
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
	
	public static boolean verifyNewUserEmail(Cadastro newCadastro, Connection connect) {
		PreparedStatement statementSql;
		
		try {
			statementSql = connect.prepareStatement("SELECT email FROM cadastro");
			ResultSet mySqlReturn = statementSql.executeQuery();
				
			while(mySqlReturn.next()) {
				String userEmail = mySqlReturn.getString("email");
					
				if(userEmail.equals(newCadastro.getEmail())) {
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
