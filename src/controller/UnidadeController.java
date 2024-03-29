package controller;

import java.util.Date;

import dao.FileJson;
import model.Aluno;
import model.Mensalidade;
import model.Pagamento;
import model.Unidade;
import model.enums.EstadoConta;
import model.enums.EstadoPagamento;


/**
 * 
 * 	Caso de Uso CDU4: bloquear conta
 * 
 * 	1. Verifica o pagamento de mensalidades do aluno
 *  2. Sistema n�o identifica inadimpl�ncia
 *  2a. Sistema identifica inadimpl�ncia
 *  	1.Sistema bloqueia conta do aluno.
 *  3. Repete passo 1 e 2 at� todos os alunos sejam verificados
 * 
 * */
public class UnidadeController {
	
	public UnidadeController(){}
	
	public void verificaInadimplencia (Unidade unidade)
	{
		Date dataAtual = new Date(System.currentTimeMillis());
		FileJson fileJson = new FileJson();
		Integer i = 1;
		
		for(Aluno a : unidade.getAlunos()) // Verifica cada aluno
		{
			for(Mensalidade m : a.getMensalidades()) // Verifica mensalidade
			{
				Pagamento p = m.getPagamento();
				
				if(a.getEstado() == EstadoConta.ATIVA)
				{
					if(p.getDataPagamento() == null && dataAtual.compareTo(p.getDataVencimento()) > 0) // Se n�o houver pagamento e J� tiver passado a data de vencimento
					{
						a.setEstado(EstadoConta.BLOQUEADA); // Bloqueia conta
						p.setEstado(EstadoPagamento.ATRASADO); // Pagamento est� atrasado
						System.out.println("Aluno de ID: " +a.getId()+ " Teve seu estado de conta alterado para " +a.getEstado());
						fileJson.save("Aluno"+a.getId()+".json", a.serialize(a));
					}
				}
			}
		}
		
		/*Salvando Altera��es da verifica��o do CDU4*/
		for(Aluno a : unidade.getAlunos())
		{
			fileJson.save("aluno"+i+".json", a.serialize(a));
			i++;
		}
		
	}
	
	
	
}
