package br.ufpa.poo.sistema;

import java.util.ArrayList;
import java.util.List;

import br.ufpa.poo.exceptions.ElementCanNotAcessObjectException;
import br.ufpa.poo.exceptions.ElementDoesNotBelongToListException;

public class Professor extends Usuario {

	private List<Turma> turmas;
	
	public Professor (String nome, int id) {
		super (nome, id);
		this.turmas = new ArrayList<>();
	}
	
	public void registrar (Turma turma) {
		this.turmas.add(turma);
	}
	
	public Tarefa criarTarefa (Turma turma, String descricao) throws ElementCanNotAcessObjectException {
		Tarefa tarefa = null;
		
		try {
			tarefa = turma.novaTarefa(descricao, this);
		}
		catch (ElementCanNotAcessObjectException e) {
			e.getMessage();
		}
		
		return tarefa;
	}
	
	public void avaliarAluno (Aluno aluno, Turma turma, double nota, int avaliacao) throws ElementDoesNotBelongToListException {
		try {
			turma.avaliar(aluno, nota, avaliacao);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			e.getMessage();
		}
		catch (IllegalArgumentException e) {
			e.getMessage();
		}
		catch (ElementDoesNotBelongToListException e) {
			e.getMessage();
		}
		
	}
	
}
