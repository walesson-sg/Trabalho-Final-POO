package br.com.ufc.biblioteca;

import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		Scanner ler = new Scanner(System.in);
		Biblioteca biblioteca = new Biblioteca();
		Aluno aluno = new Aluno();	
		Bibliotecaria bibliotecaria = new Bibliotecaria();
		biblioteca.livrosPadrao();
		biblioteca.umAluno();//a1, 12345

		boolean sair = false;
		boolean voltar = false;
	
		while(sair == false) 
		{	
		System.out.println("Aluno ou Bibliotecária?");
		String aux = ler.nextLine();

		do {
//USUÁRIO ALUNO	
		if(aux.contains("Aluno") || aux.contains("aluno")) 
		{
			
			if(biblioteca.loginAluno() == true) 
			{
				
				do {sair = true;	
				biblioteca.menuAluno();
				int opcao = ler.nextInt();
			
					switch (opcao) {		
						case 1:
							aluno.visualizarLivros();
							break;							
						case 2:
							aluno.solicitarEmprestimo();
							break;						
						case 3:
							aluno.vizualizarLivrosEmprestado();
							aluno.devolucao();
							break;							
						case 4:
							aluno.renovarEmprestimo();
							//TODO
							break;
						case 5:
							aluno.pesquisarLivro();
							break;							
						case 6:
							aluno.vizualizarLivrosEmprestado();
							break;							
						case 7:
							sair = false;
							voltar = true;
							break;
						
						default:
							System.out.println("Opção invalida.\n"); break;
				}			
			} while(sair == true);
		}
		}//FIM - ALUNO
		
//USUÁRIO BIBLIOTECARIA
		if(aux.contains("Bibliotecaria") || aux.contains("bibliotecaria")) 
		{
			do {sair = true;				
				biblioteca.menuBibliotecaria();
				int opcao = ler.nextInt();
				
				switch (opcao) {		
						case 1:
							bibliotecaria.visualizarLivros();
							break;								
						case 2:			
							bibliotecaria.cadastrarLivro();
							break;									
						case 3:
							bibliotecaria.excluirLivro();
							break;								
						case 4:
							bibliotecaria.alunosPendentes();
							break;
						case 5:
							bibliotecaria.cadastrarAluno();
							break;					
						case 6:
							bibliotecaria.removerAluno();
							break;								
						case 7:
							sair = false;
							voltar = true;
							break;

						default:
							System.out.println("Opção invalida."); break;
				}			
			} while(sair == true);
			}//FIM - BIBLIOTECARIA
		}while(voltar == false);
		}
		}//FIM MAIN
	}//FIM CLASS


