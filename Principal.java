package br.com.conectando.treinamento;

import java.util.List;

public class Principal {

	public static void main(String[] args) {

		ClienteDAO cliente = new ClienteDAO();
//		for (String lista: cliente.pesquisarTodos()) {
//			System.out.println(lista.toString());
//		}
		//cliente.inserirCliente("Eliane DOS SANTOS","eliane.santos@gmail.com");
		//cliente.excluirClientePeloId(11007);
		//System.out.println(cliente.pesquisarTodos());
		System.out.println(cliente.pesquisarPorNome("Saraiva"));
	}

}
