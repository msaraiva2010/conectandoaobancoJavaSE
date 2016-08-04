package br.com.conectando.treinamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

	Connection conexao;
	
	ClienteDAO() {
		conexao = new FabricaDeConexao().getConexao();
		
	}
	
	public List<String> pesquisarTodos() {
		List<String> resultado = new ArrayList<String>();
		
		String sqlSelect = "select * from cliente order by nome";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sqlSelect);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {;
				resultado.add(rs.getInt("id") + " - " + rs.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	public List<String> pesquisarPorNome(String nome) {
		List<String> resultado = new ArrayList<String>();
		try {
			String sqlSelect = "select * from cliente where nome like ?";
			PreparedStatement ps = conexao.prepareStatement(sqlSelect);
			ps.setString(1, "%" + nome + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {;
				resultado.add(rs.getInt("id") + " - " + rs.getString("nome"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}

	public void inserirCliente(String nome, String email) {
		try {
			String sqlSelect = "insert into cliente (nome,email) values (?,?)";
			PreparedStatement ps = conexao.prepareStatement(sqlSelect);
			ps.setString(1, nome);
			ps.setString(2, email);
			ps.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Registro incluído!");
	}

	public void excluirClientePeloId(int id) {
		try {
			String sqlSelect = "delete from cliente where id = ?";
			PreparedStatement ps = conexao.prepareStatement(sqlSelect);
			ps.setInt(1,id);
			ps.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Registro excluído!");
	}

}
