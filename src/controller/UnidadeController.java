package controller;

import java.util.Date;

import model.Aluno;
import model.Mensalidade;
import model.Pagamento;
import model.Unidade;
import model.enums.EstadoConta;
import model.enums.EstadoPagamento;

public class UnidadeController {
	
	public UnidadeController(){}
	
	/**
	 * 
	 * 	Caso de Uso CDU4: bloquear conta
	 * 
	 * 	1. Verifica o pagamento de mensalidades do aluno
	 *  2. Sistema não identifica inadimplência
	 *  2a. Sistema identifica inadimplência
	 *  	1.Sistema bloqueia conta do aluno.
	 *  3. Repete passo 1 e 2 até todos os alunos sejam verificados
	 * 
	 * */
	public void verificaInadimplencia (Unidade unidade)
	{
		Date dataAtual = new Date(System.currentTimeMillis());
		
		for(Aluno a : unidade.getAlunos()) // Verifica cada aluno
		{
			for(Mensalidade m : a.getMensalidades()) // Verifica mensalidade
			{
				Pagamento p = m.getPagamento();
				
				if(a.getEstado() == EstadoConta.ATIVA)
				{
					if(p.getDataPagamento() == null && dataAtual.compareTo(p.getDataVencimento()) > 0) // Se não houver pagamento e Já tiver passado a data de vencimento
					{
						a.setEstado(EstadoConta.BLOQUEADA); // Bloqueia conta
						p.setEstado(EstadoPagamento.ATRASADO); // Pagamento está atrasado
						System.out.println("Aluno de ID: " +a.getId()+ " Teve seu estado de conta alterado para " +a.getEstado());
					}
				}
			}
		}
		
	}
	
	
	
}
