package com.studyproject.authentication.mysql;

import com.studyproject.authentication.cadastro.Cadastro;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CrudMySql {
		
	public static Connection createLoginData(Connection connect, Cadastro newCadastro) {
		String sqlCommand = "INSERT INTO Cadastro(login, senha, email) VALUES (?, ?, ?)";
		try {
			PreparedStatement newData = connect.prepareStatement(sqlCommand);
			
			newData.setString(1, newCadastro.getLogin());
			newData.setString(2, newCadastro.getPassword());
			newData.setString(3, newCadastro.getEmail());
			
			newData.executeUpdate();
			newData.close();
			
		} catch (Exception e) {
			e.getMessage();
			e.getStackTrace();
		}
		return connect;
	}
	
}
