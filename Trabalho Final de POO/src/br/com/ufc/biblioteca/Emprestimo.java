//NÃO IMPLEMENTADA
package br.com.ufc.biblioteca;

import java.util.ArrayList;

public class Emprestimo
{
	private Aluno aluno;
	private String dataEmprestimo;
	private Livro li;	
	private String dataD;
	private boolean renovado=false;
	static private ArrayList<String> emprestimo1 = new ArrayList<String>();

	public Emprestimo() {}
	public String getDataEmprestimo() {	return dataEmprestimo;}
	public void setDataEmprestimo(String dataEmprestimo) {this.dataEmprestimo = dataEmprestimo;}

	public Livro getLi() {
		return li;
	}
	public void setLi(Livro li) {
		this.li = li;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public String getDataD() {
		return dataD;
	}
	public void setDataD(String dataD) {
		this.dataD = dataD;
	}
	public boolean isRenovado() {
		return renovado;
	}
	public void setRenovado(boolean renovado) {
		this.renovado = renovado;
	}

}
