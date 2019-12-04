package br.com.ufc.biblioteca;

public class Livro {
	private String nome;
	private String autor;
	private int isbn;
	private String descricao;
	
	
	public Livro() { }

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
