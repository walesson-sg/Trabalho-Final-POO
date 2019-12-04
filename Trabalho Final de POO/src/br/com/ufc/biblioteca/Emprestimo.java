//NÃO IMPLEMENTADA
package br.com.ufc.biblioteca;

import java.util.ArrayList;

public class Emprestimo {
	private String nome;
	private String dataEmprestimo;
	ArrayList<Livro> emprestimo = new ArrayList<Livro>();
	
	public Emprestimo() {}
	public void emprestimoL(String nome, String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
		this.nome = nome;
	}
	
	
	public String getDataEmprestimo() {	return dataEmprestimo;}
	public void setDataEmprestimo(String dataEmprestimo) {this.dataEmprestimo = dataEmprestimo;}
	public String getNome() {return nome;}
	public void setNome(String aluno) {this.nome = nome;}

}
