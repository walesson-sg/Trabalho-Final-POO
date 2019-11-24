package br.com.ufc.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	
	List<Livro> livros = new ArrayList<Livro>();
	
	//METODO VISUALIZAR LIVROS DISPONÍVEIS
		public void visualizarLivro() {
			for (int i=0; i < livros.size(); i++) {
				System.out.println(livros.get(i));
			}
		}
		
		
	//METODO SOLICITAR EMPRESTIMO DE LIVRO
		public void solicitarEmprestimo() {
			
		}
		
		
	//METODO DEVOLVER LIVRO DO EMPRESTIMO
		public void devolucao() {
			
		}
		
		
	//METODO RENOVAR EMPRESTIMO
		
	//METODO PESQUISAR LIVROS
		
	//METODO VIZUALIZAR LIVROS EMPRESTADOS
		
		
}
