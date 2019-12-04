package br.com.ufc.biblioteca;

public class Bibliotecaria extends Biblioteca{
	private String nome;
	private String autor; 
	private String descricao;
	private String curso;
	private String dataNascimento;
	private String cpf ;
	private String matricula ;
	private int telefone;
	private int isbn;

	//METODO VER ALUNOS CADASTRADOS
	public void alunosCadastrados() {
		for(int i = 0; i < alunos.size(); i++) {
			System.out.println("Nome: " + alunos.get(i).getNome() + "\n" + "Matrícula: " + alunos.get(i).getMatricula());
		}
	}

	//METODO EXCLUIR LIVRO
	public void excluirLivro() {
		System.out.println("Digite a ISBN do Livro: ");
		isbn = ler.nextInt();
		for(int i = 0; i < livros.size(); i++) {
			if(livros.get(i).getIsbn() == isbn) {
				livros.remove(i);
				System.out.println("Livro removido do sistema com sucesso.");
			} else System.out.println("Livro não encontrado.");
		}
	}
	
	//METODO CADASTRAR ALUNO	
	public void cadastrarAluno() {
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
		System.out.println("Aluno cadastrado com sucesso.");
	}
	
	//METODO REMOVER ALUNO
	public void removerAluno() {
		boolean alunoExiste = false;
		System.out.println("Digite a matricula do aluno: ");
		matricula = ler.nextLine();	
		for(int i = 0; i < alunos.size(); i++) {
			if(alunos.get(i).getMatricula().contains(matricula)) {
				System.out.println("Excluir o Aluno " + alunos.get(i).getNome() + "?");
				String e = ler.nextLine();
					if(e.contains("Sim") || e.contains("sim")) {
						alunos.remove(i);
						System.out.println("Aluno removido do sistema.");
						alunoExiste = true;
					}
					if(e.contains("Nao") || e.contains("nao")) {
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
	public void alunosPendentes() {
		for(int i = 0; i < emprestimo.size(); i++) {
				if(emprestimo.get(i) != null) {
					System.out.println(alunos.get(i).getNome() + "\n" + "  -> "+ emprestimo.get(i).getNome() + "\n");
				}
			}
		}

	//METODO CADASTRAR LIVRO
	public void cadastrarLivro() {
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
