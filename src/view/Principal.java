package view;

import java.util.Arrays;

import model.Aluno;
import model.Professor;
import model.Unidade;
import model.enums.EstadoConta;

public class Principal {

	public static void main(String[] args) {
		Unidade unidade1 = new Unidade(1, "Unidade Gávea");
		
		Professor professor1 = new Professor(1, "Paulo Silva", "Paulo@gmail.com", "11100011100");
		Professor professor2 = new Professor(2, "Fernanda Santos", "Fernanda@gmail.com", "11100011122");
		
		Aluno aluno1 = new Aluno(1, "João", "Joao@gmail.com", "00000000000", "552100000000", unidade1, professor1, null, EstadoConta.ATIVA);
		Aluno aluno2 = new Aluno(2, "Leonardo", "Leonardo@gmail.com", "00000000001", "552100000001", unidade1, professor2, null, EstadoConta.ATIVA);
		Aluno aluno3 = new Aluno(3, "Patrícia", "Pat@gmail.com", "00000000002", "552100000002", unidade1, professor1, null, EstadoConta.BLOQUEADA);
		Aluno aluno4 = new Aluno(4, "Lucas", "Lucas@gmail.com", "00000000003", "552100000003", unidade1, professor2, null, EstadoConta.ATIVA);
		Aluno aluno5 = new Aluno(5, "Maria", "Maria@gmail.com", "00000000004", "552100000004", unidade1, professor1, null, EstadoConta.ATIVA);
		Aluno aluno6 = new Aluno(6, "Ana", "Ana@gmail.com", "00000000005", "552100000005", unidade1, professor2, null, EstadoConta.BLOQUEADA);
		
		unidade1.getAlunos().addAll(Arrays.asList(aluno1, aluno2, aluno3, aluno4, aluno5, aluno6));
		unidade1.getProfessores().addAll(Arrays.asList(professor1, professor2));
		
		for(Aluno x : unidade1.getAlunos())
		{
			System.out.println(x.toJson());
		}
	}

}
