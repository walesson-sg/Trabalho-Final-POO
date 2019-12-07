package br.com.ufc.biblioteca;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Biblioteca 
{
	static ArrayList<Livro> livros = new ArrayList<Livro>();
	static ArrayList<Livro> emprestimo = new ArrayList<Livro>(1);
	static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	static ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
	static HashMap<Aluno, ArrayList<Emprestimo>> alunosEmprestimo = new HashMap<Aluno, ArrayList<Emprestimo>>();
	Scanner ler = new Scanner(System.in);

	private String nome;
	private String autor; 
	private String descricao;
	private String curso;
	private String dataNascimento;
	private String cpf ;
	private String matricula ;
	private int telefone;
	private int isbn;
	private String dataEmprestimo;
	
	public String getDataEmprestimo() {return dataEmprestimo;}
	public void setDataEmprestimo(String dataEmprestimo) {this.dataEmprestimo = dataEmprestimo;}
	public String getCurso() {return curso;}
	public void setCurso(String curso) {this.curso = curso;}
	public String getDataNascimento() {	return dataNascimento;}
	public void setDataNascimento(String dataNascimento) {this.dataNascimento = dataNascimento;}
	public String getCpf() {return cpf;}
	public void setCpf(String cpf) {this.cpf = cpf;}
	public String getMatricula() {return matricula;	}
	public void setMatricula(String matricula) {this.matricula = matricula;}
	public int getTelefone() {return telefone;}
	public void setTelefone(int telefone) {this.telefone = telefone;}
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;	}
	public String getAutor() {return autor;}
	public void setAutor(String autor) {this.autor = autor;}
	public int getIsbn() {return isbn;}
	public void setIsbn(int isbn) {	this.isbn = isbn;}
	public String getDescricao() {return descricao;	}
	public void setDescricao(String descricao) {this.descricao = descricao;	}

	//DATE
	SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
	String dia = (date.format(new Date()));
			
		public void visualizarLivros() 
		{
				for (int i = 0; i < livros.size(); i++) {
					System.out.println("|X| " + livros.get(i).getNome()+ "\n|X|" + livros.get(i).getDescricao() + "\n|X|" + livros.get(i).getIsbn() + "\n");
				}
		}	

		public void livrosPadrao() 
		{	
			livros.add(new Livro("Harry Potter", "J. K. Rowling", 784515444, "É uma série de sete romances de fantasia escrita pela autora britânica J. K. Rowling. "));
			livros.add(new Livro("Percy Jackson", "Rick Riordan", 645665565, "É uma série literária composta por cinco livros de aventura e fantasia, escritos pelo estadunidense Rick Riordan, que retrata a mitologia grega no século XXI."));
			livros.add(new Livro("Bird Box", "Josh Malerman", 564646465, "É um romance pós-apocalíptico escrito por Josh Malerman, o livro foi publicado pela primeira vez no Reino Unido em 27 de março de 2014, através da Harper Voyager e nos Estados Unidos em 13 de maio de 2014, através da Ecco Press.")); 
			livros.add(new Livro("Arroz", "Inext", 15, "É uma ficção sem sentido e sem sem historia fixa."));
			livros.add(new Livro("Arroz 2", "Inext", 25645454,"Continuação de Arroz, contando a historia do passado do Arroiz "));
		}
		
		public void menuBibliotecaria() 
		{
			System.out.println("|X|--------------------------------------|X|");
			System.out.println("|X| 1: Visualizar livros disponíveis     |X|");
			System.out.println("|X| 2: Cadastrar Livro                   |X|");
			System.out.println("|X| 3: Excluir livro do Sistema          |X|");
			System.out.println("|X| 4: Vizualizar alunos com pendencia   |X|");
			System.out.println("|X| 5: Cadastrar aluno                   |X|");
			System.out.println("|X| 6: Excluir aluno                     |X|");
			System.out.println("|X| 7: Sair                              |X|");	
			System.out.println("|X|--------------------------------------|X|");
		}

		public void menuAluno() 
		{
			System.out.println("|X|--------------------------------------|X|");
			System.out.println("|X| 1: Visualizar livros disponíveis     |X|");
			System.out.println("|X| 2: Solicitar empréstimo de livro     |X|");
			System.out.println("|X| 3: Devolver livros do empréstimo     |X|");
			System.out.println("|X| 4: Renovar empréstimo                |X|");
			System.out.println("|X| 5: Pesquisar livros                  |X|");
			System.out.println("|X| 6: Visualizar livros emprestados     |X|");
			System.out.println("|X| 7: Sair                              |X|");	
			System.out.println("|X|--------------------------------------|X|");
}
	
		public boolean loginAluno() 
		{
			boolean confirm = false;
			System.out.println("Insira seu nome: ");
			nome = ler.nextLine();
			Bibliotecaria.nomeLogin = nome;
			System.out.println("Insira sua matricula: ");
			matricula = ler.nextLine();	
			for(int i = 0; i < alunos.size(); i++) 
			{
				if(alunos.get(i).getNome().contains(nome) && alunos.get(i).getMatricula().contains(matricula)) 
				{
					confirm = true;
				}else System.out.println("Nome ou Matricula incorretos");
			}
			return confirm; 
		}

		public void umAluno() 
		{
			Aluno aluno = new Aluno("a1", "ES", "14/22/2222", "123.123.123-32", "12345", 12345678);
			alunos.add(aluno);
			alunosEmprestimo.put(aluno, new ArrayList<Emprestimo>());
		}
}//FIM CLASS
