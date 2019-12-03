package br.com.ufc.biblioteca;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Livro {
	SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
	String dia = (date.format(new Date()));
	
	private String nome;
	private String autor;
	private int isbn;
	private String descricao;
	private String emprestimoL = dia;
	
	
	public Livro() { }
	public Livro(String nome, String emprestimo, boolean a) {
		this.nome = nome;
		this.emprestimoL = emprestimo;
	}
	public Livro(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	public Livro(String nome, String autor, int isbn, String descricao) {
		this.nome = nome;
		this.autor = autor;
		this.isbn = isbn;
		this.descricao = descricao;
	}

	
	public String getEmprestimoL() {
		return emprestimoL;
	}
	public void setEmprestimoL(String emprestimoL) {
		this.emprestimoL = emprestimoL;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
