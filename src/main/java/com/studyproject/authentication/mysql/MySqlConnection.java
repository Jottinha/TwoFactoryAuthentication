package com.studyproject.authentication.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	public static Connection connectMySql(){
		
		Connection connect = null;
		String url = "jdbc:mysql://localhost:(SeuLocalHost)/usuario?user=(SEU USUARIO)&password=(SUASENHA)";
		
		try {
			connect = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		return connect;
	}
}
