package br.com.ufc.biblioteca;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Aluno extends Biblioteca 
{
	private String nome;
	private String curso;
	private String dataNascimento;
	private String cpf;
	private String matricula;
	private int telefone;

	
	public Aluno() {}
	public Aluno(String nome, String curso, String dataNascimento, String cpf,  String matricula, int telefone) {
		super();
		this.nome = nome;
		this.curso = curso;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.telefone = telefone;
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	

			
	//METODO DEVOLVER LIVRO DO EMPRESTIMO
		public void devolucao() 
		{
			System.out.println("Digite o nome do livro...");
			nome = ler.nextLine();
			Emprestimo pr = null;
			if(alunosEmprestimo.get(this) != null) {
				for(Emprestimo emprestimo: alunosEmprestimo.get(this)) {
					if(emprestimo.getLi().getNome().toLowerCase().equals(nome.toLowerCase())) {
						livros.add(emprestimo.getLi());
						emprestimos.remove(emprestimo);
						pr = emprestimo;
					}
				}
				if(pr != null) 
					alunosEmprestimo.get(this).remove(pr);
			}
		}		

	//METODO VIZUALIZAR LIVROS EMPRESTADOS
		public void vizualizarLivrosEmprestado() 
		{
			alunosEmprestimo.get(this).forEach(emprestimo->{
				System.out.println(emprestimo.getDataEmprestimo() + " - " + emprestimo.getLi().getNome());
				System.out.println("     Devolução: " + emprestimo.getDataD());
			});
		}
				
	//METODO PESQUISAR LIVROS
		public void pesquisarLivro() 
		{
			boolean livroEncontrado = false;
			System.out.println("Qual livro você está procurando? ");
			String nome = ler.nextLine();
				for(int i = 0; i < livros.size(); i++) 
				{
					if(livros.get(i).getNome().toLowerCase().contains(nome.toLowerCase())) 
					{
					System.out.println("\n|X| Título: " + livros.get(i).getNome() + "\n|X| Autor: " + livros.get(i).getAutor() + "\n|X| " + livros.get(i).getDescricao()+ "\n");
					livroEncontrado = true;
					}
				}
				if(livroEncontrado == false) 
				{
					System.out.println("Livro não encontrado.");
				}
		}
		
		//METODO SOLICITAR EMPRESTIMO DE LIVRO
		public void solicitarEmprestimo() 
		{
			System.out.print("Digite o nome do livro...");
			nome = ler.nextLine();	
			for(int i = 0 ; i < livros.size(); i++) 
			{
				if(livros.get(i).getNome().toLowerCase().equals(nome.toLowerCase())) 
				{	
					System.out.print("Digite sua matricula:");
					matricula = ler.nextLine();
					for(Aluno aluno:alunos) 
					{
						if(aluno.getMatricula().equals(matricula)) 
						{
							LocalDateTime dataR = LocalDateTime.now();
							
							LocalDateTime dataDevolucao = dataR.plusDays(15);
							Emprestimo emp = new Emprestimo();
							emp.setAluno(this);
							emp.setDataEmprestimo(dataR.format(DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy")));
							emp.setLi(livros.get(i));
							emp.setDataD(dataDevolucao.format(DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy")));
							if(alunosEmprestimo.get(this) == null) 
							{
								alunosEmprestimo.put(this, new ArrayList<Emprestimo>());
							}
							alunosEmprestimo.get(this).add(emp);
							emprestimos.add(emp);
							livros.remove(i);
							System.out.println("Emprestimo realizado com sucesso.");
				
						}
					}
				}
			}
			
		}
		
	//METODO RENOVAR EMPRESTIMO
	public void renovarEmprestimo() {
		System.out.println("Qual livro você deseja renovar?");
		Scanner sc = new Scanner(System.in);
		String aux = sc.nextLine();
		for(Emprestimo emp: emprestimos) {
			
			if(emp.getLi().getNome().toLowerCase().equals(aux.toLowerCase())) {
				if(emp.isRenovado()) {
					System.out.println("Este livro já foi renovado.");
					return;
				}else {
					LocalDateTime dataDevolucao = LocalDateTime.parse(emp.getDataD(), DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy"));
					dataDevolucao = dataDevolucao.plusDays(7);
					emp.setDataD(dataDevolucao.format(DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy")));
					System.out.println("Livro renovado com sucesso.");
					emp.setRenovado(true);
					return;
					
				}
			}
		}	
	}				
}
