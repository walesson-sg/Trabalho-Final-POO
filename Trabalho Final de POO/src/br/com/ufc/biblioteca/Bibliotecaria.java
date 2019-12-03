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
			System.out.println("Nome: " + alunos.get(i).getNome() + "\n" + "Matr�cula: " + alunos.get(i).getMatricula());
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
			} else System.out.println("Livro n�o encontrado.");
		}
	}
	
	//METODO CADASTRAR ALUNO	
	public void cadastrarAluno() {
		System.out.println("Digite o nome do Aluno:");
		nome = ler.nextLine();
		
		System.out.println("Digite o curso do Aluno:");
		curso = ler.nextLine();		
		
		System.out.println("Digite a data de nascimento do Aluno:");
		dataNascimento = ler.nextLine();	
		
		System.out.println("Digite o CPF do Aluno:");
		cpf = ler.nextLine();
		
		System.out.println("Digite a Matricula do Aluno:");
		matricula = ler.nextLine();	
		
		System.out.println("Digite o n�mero do telefone do Aluno:");
		telefone = ler.nextInt();
		
		Aluno aluno = new Aluno(nome, curso, dataNascimento, cpf, matricula, telefone);
		alunos.add(aluno);
		System.out.println("Aluno cadastrado com sucesso.");
	}
	
	//METODO REMOVER ALUNO
	public void removerAluno() {
		System.out.println("Digite a matricula do aluno: ");
		matricula = ler.nextLine();	
		for(int i = 0; i < alunos.size(); i++) {
			if(alunos.get(i).getMatricula().contains(matricula)) {
				alunos.remove(i);
				System.out.println("Aluno removido do sistema.");
			} else System.out.println("Aluno n�o encontrado.");
		}
	}

	//METODO VER ALUNOS COM PENDECIAS
	public void alunosPendentes() {
		for(int i = 0; i < emprestimo.size(); i++) {
				if(emprestimo.get(i) != null) {
					System.out.println(emprestimo.get(i).getNome() + "\n" + "          -> "+ emprestimo.get(i).getNome() + "\n");
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
		System.out.println("Digite a descri��o do Livro");
		descricao = ler.nextLine();
		descricao = ler.nextLine();						
		Livro livro = new Livro(nome, autor, isbn, descricao);
		livros.add(livro);

		System.out.println("Livro adicionado ao sistema com sucesso.");
	}
}
