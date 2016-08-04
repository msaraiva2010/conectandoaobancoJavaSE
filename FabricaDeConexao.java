package br.com.conectando.treinamento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {

	public Connection getConexao() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/fabricaweb","root","");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
