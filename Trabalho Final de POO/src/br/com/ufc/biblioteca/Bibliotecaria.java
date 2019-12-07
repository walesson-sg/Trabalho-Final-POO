package br.com.ufc.biblioteca;

import java.util.ArrayList;


public class Bibliotecaria extends Biblioteca
{
	private String nome;
	private String autor; 
	private String descricao;
	private String curso;
	private String dataNascimento;
	private String cpf ;
	private String matricula ;
	private int telefone;
	private int isbn;
	public static String nomeLogin="";

	//METODO VER ALUNOS CADASTRADOS
	public void alunosCadastrados() 
	{
		for(int i = 0; i < alunos.size(); i++) 
		{
			System.out.println("Nome: " + alunos.get(i).getNome() + "\n" + "Matrícula: " + alunos.get(i).getMatricula());
		}
	}

	//METODO EXCLUIR LIVRO
	public void excluirLivro() {
		System.out.println("Digite a ISBN do Livro: ");
		isbn = ler.nextInt();
		for(int i = 0; i < livros.size(); i++) 
		{
			if(livros.get(i).getIsbn() == isbn) 
			{
				livros.remove(i);
				System.out.println("Livro removido do sistema com sucesso.");
				
				alunosEmprestimo.forEach((aluno,emprestimos) ->{
					Emprestimo e = null;
					for(Emprestimo empr: emprestimos) {
						if(empr.getLi().getIsbn()==isbn) {
							e = empr;	
						}
					}
					if(e != null) {
						emprestimos.remove(e);
					}
				});
				Emprestimo e = null;
				for(Emprestimo empr: emprestimos) {
					if(empr.getLi().getIsbn()==isbn) {
						e = empr;				
					}
				}
				if(e != null) {
					emprestimos.remove(e);
				}
				return;
			}
		}
		System.out.println("Livro não encontrado.");
	}
	
	//METODO CADASTRAR ALUNO	
	public void cadastrarAluno() 
	{
		System.out.print("Digite o nome do Aluno: ");
		nome = ler.nextLine();
		
		System.out.print("Digite o curso do Aluno: ");
		curso = ler.nextLine();		
		
		System.out.print("Digite a data de nascimento do Aluno ");
		dataNascimento = ler.nextLine();	
		
		System.out.print("Digite o CPF do Aluno: ");
		cpf = ler.nextLine();
		
		System.out.print("Digite a Matricula do Aluno: ");
		matricula = ler.nextLine();	
		
		System.out.print("Digite o número do telefone do Aluno: ");
		telefone = ler.nextInt();
		
		Aluno aluno = new Aluno(nome, curso, dataNascimento, cpf, matricula, telefone);
		alunos.add(aluno);
		alunosEmprestimo.put(aluno, new ArrayList<Emprestimo>());
		System.out.println("Aluno cadastrado com sucesso.");
	}
	
	//METODO REMOVER ALUNO
	public void removerAluno() 
	{
		boolean alunoExiste = false;
		System.out.println("Digite a matricula do aluno: ");
		matricula = ler.nextLine();	
		for(int i = 0; i < alunos.size(); i++) 
		{
			if(alunos.get(i).getMatricula().contains(matricula)) 
			{
				System.out.println("Excluir o Aluno " + alunos.get(i).getNome() + "?");
				String e = ler.nextLine();
					if(e.toLowerCase().contains("Sim".toLowerCase())) 
					{
						alunosEmprestimo.remove(alunos.get(i));
						alunos.remove(i);
						System.out.println("Aluno removido do sistema.");
						alunoExiste = true;
					}
					if(e.toLowerCase().contains("Nao".toLowerCase())) 
					{
						alunoExiste = true;
						break;
					}
			}
		} 
		if(alunoExiste == false) {
			System.out.println("Aluno não encontrado.");
		}
	}
	
	//METODO VER ALUNOS COM PENDECIAS
	public void alunosPendentes() 
	{
		for(Emprestimo emprestimo: emprestimos) {
			System.out.println(emprestimo.getAluno().getNome() + "\n     Matricula:  "  + emprestimo.getAluno().getMatricula() + "\n     " + emprestimo.getDataEmprestimo() + " - " + emprestimo.getLi().getNome());
			System.out.println("     Devolução: " + emprestimo.getDataD());
		}
	}

	//METODO CADASTRAR LIVRO
	public void cadastrarLivro() 
	{
		System.out.println("Digite o nome do Livro ");
		nome = ler.nextLine();
		System.out.println("Digite o nome do Autor do Livro: ");
		autor = ler.nextLine();
		System.out.println("Digite a ISBN do Livro: ");
		isbn = ler.nextInt();
		System.out.println("Digite a descrição do Livro");
		descricao = ler.nextLine();
		descricao = ler.nextLine();						
		Livro livro = new Livro(nome, autor, isbn, descricao);
		livros.add(livro);

		System.out.println("Livro adicionado ao sistema com sucesso.");
	}
}
