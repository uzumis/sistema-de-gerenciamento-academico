package br.ufpa.poo.sistema;

import java.util.List;

import br.ufpa.poo.exceptions.ListAlreadyContainsElementException;

import java.util.ArrayList;

public class Aluno extends Usuario {

	private Historico historico;
	
	public Aluno (String nome, int id) {
		super (nome, id);
		this.historico = new Historico();
	}
	
	public void matricular (Turma turma) {
		try {
			historico.registrar(turma.getDisciplina());
			turma.matricular(this);
		}
		catch (ListAlreadyContainsElementException e) {
			System.out.println("O aluno " + this.nome + " já está matriculado em " + turma.getDisciplina().getNome());
		}
	}
	
	public void submeterTarefa (Turma turma, Tarefa tarefa) {
		turma.registrarTarefa(this, tarefa);
	}
	
	public void consolidarNota (Disciplina disciplina, Character conceito) {
		this.historico.consolidar(disciplina, conceito);
	}
	
	public Historico getHistorico () {
		return this.historico;
	}
}
