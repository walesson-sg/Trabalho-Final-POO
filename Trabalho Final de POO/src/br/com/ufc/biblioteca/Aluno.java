package br.com.ufc.biblioteca;

public class Aluno extends Biblioteca {
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
	
	//METODO SOLICITAR EMPRESTIMO DE LIVRO
		public void solicitarEmprestimo() {
			System.out.println("Digite o nome do livro...");
			nome = ler.nextLine();	
			for(int i = 0 ; i < livros.size(); i++) {
				if(livros.get(i).getNome().contains(nome)) {						
						emprestimo.add(livros.get(i));	
						livros.remove(i);
						System.out.println("Emprestimo realizado com sucesso em " + dia);
				}
				
			}
		}
			
	//METODO DEVOLVER LIVRO DO EMPRESTIMO
		public void devolucao() {
			System.out.println("Digite o nome do livro...");
			nome = ler.nextLine();
			for(int i = 0; i < emprestimo.size(); i++) {
				if(emprestimo.get(i).getNome().contains(nome)) {
					livros.add(emprestimo.get(i));
					emprestimo.remove(i);
				}
			}
				}		

	//METODO VIZUALIZAR LIVROS EMPRESTADOS
		public void vizualizarLivrosEmprestado() {
			for(int i = 0; i < emprestimo.size(); i++) {
					System.out.println("\n|X|" + emprestimo.get(i).getNome() + "\n");
			}
		}
				
	//METODO PESQUISAR LIVROS
		public void pesquisarLivro(String nome) {
				for(int i = 0; i < livros.size(); i++) {
					if(livros.get(i).getNome().contains(nome)) {
					System.out.println("Título: " + livros.get(i).getNome() + "\nAutor: " + livros.get(i).getAutor() + "\n" + livros.get(i).getDescricao());
					} else System.out.println("Livro não encontrado.");
				}
		}
		
	//METODO RENOVAR EMPRESTIMO
		public void renovarEmprestimo() {
			
		}						
		
}
