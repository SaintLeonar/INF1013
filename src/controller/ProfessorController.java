package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Aluno;
import model.SerieEspecificada;
import model.Unidade;
import model.enums.EstadoConta;

/**
 * 
 *  Caso de Uso CDU2: especificar uma série
 *  
 *  1. O professor solicita no sistema
 *  2. O sistema lista os Alunos, com estado da conta ATIVA, que tem sua série fora da validade
 *  3. O professor escolhe um aluno e especifica uma nova série.
 *  4. O sistema registra a nova série
 *  Extensões:
 *  3. O professor decide cancelar a operação:
 *   	1. O sistema finaliza o procedimento
 * 
 * */
public class ProfessorController {
	
	/**
	 * 
	 * 	Retorna uma lista de alunos que estão com a conta Ativa E com série Especificada fora da validade
	 * 
	 * */
	public List<Aluno> listaAlunos(Unidade unidade)
	{
		Date dataAtual = new Date(System.currentTimeMillis());
		List<Aluno> alunos = new ArrayList<>();
		
		for(Aluno a : unidade.getAlunos())
		{
			SerieEspecificada sE = a.getSerieEspecificada();
			if(a.getEstado() == EstadoConta.ATIVA && dataAtual.compareTo(sE.getDataFim()) > 0)
			{
				alunos.add(a);
			}
		}
		return alunos;
	}
	
	
}
