package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dao.FileJson;
import model.Aluno;
import model.Mensalidade;
import model.Pagamento;
import model.Unidade;
import model.enums.EstadoPagamento;
import view.MenuPrincipal;

/**
 * 
 *  Caso de Uso CDU1: cobrar mensalidade e registrar pagamento
 *  
 *  1. Aluno deseja realizar pagamento
 *  2. O sistema valida dados do pagamento
 *  
 *  Extensões:
 *  3a. ID do aluno está incorreto ou não existe:
 *   	1. O sistema informa o erro e rejeita a ação
 *   	2. O sitema retorna ao passo 2
 *  3b.  ID da mensalidade está incorreto ou não existe
 *  	1. O sistema informa o erro e rejeita a ação
 *  	2. O sistema retorna ao passo2
 *  *a. A atendente efetua cancelamento:
 *   	1. O sistema finaliza o processo
 * 
 * */
public class MensalidadeController {

	public MensalidadeController() {}
	
	/**
	 * 
	 * 	Lista as Mensalidade pendentes do aluno recebido nos parametros.
	 *  
	 * 
	 * */
	public static Integer listarPendentes(Aluno aluno, Unidade unidade)
	{
		Map<Integer, Integer> map = new HashMap<>(); // mapeia: indice pendente -> indice mensalidades
		
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		FileJson fileJson = new FileJson();
		aluno.deserialize(fileJson.read("aluno"+aluno.getId()+".json"), aluno); // Irá ler as irformações do .json do aluno em questão
				
		List<Mensalidade> pendentes = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		Integer i = 0, j = 0;
		
		System.out.println("----------------------------------------------------------------------");
		for(Mensalidade m : aluno.getMensalidades())
		{
			if(m.getPagamento().getDataPagamento() == null)
			{
				pendentes.add(m);
				System.out.println("("+i+") - "+m.getData());
				map.put(i, j); // Chave: indice da mensalidade pendente ; Valor indice da mensalidade correspondente a lista de mensalidades do aluno
				i++;
			}
			j++;
		}
		System.out.println("(else) - Retornar ao Menu Principal");
		
		if(i == 0)
		{
			System.out.println("(!) Não há mensalidades para pagar!\n");
		}
		else
		{
			System.out.println("\n(?) Escolha uma das mensalidades anteriores para Pagar");
		}
		
		System.out.println("----------------------------------------------------------------------");
		
		Integer index = (int)scanner.next().charAt(0) - 48;
		
		if(index >= 0 && index < pendentes.size())
		{
			
			return map.get(index);
		}
		
		System.out.println("Retornando ao Menu Principal...\n");
		System.out.println("----------------------------------------------------------------------");
		
		return null;
	}
	
	public void pagarMensalidade(Aluno aluno, Unidade unidade)
	{
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		FileJson fileJson = new FileJson();
		Date dataAtual = new Date(System.currentTimeMillis());
		
		Integer index = MensalidadeController.listarPendentes(aluno, unidade);
		
		if(index == null)
		{
			menuPrincipal.ShowMenu(unidade);
		}
		
		aluno.getMensalidades().get(index).getPagamento().setDataPagamento(dataAtual);
		aluno.getMensalidades().get(index).getPagamento().setEstado(EstadoPagamento.QUITADO);
		
		System.out.println("(>) Pagamento Realizado!");
		
		fileJson.save("aluno"+aluno.getId()+".json", aluno.serialize(aluno));
		
		System.out.println("Retornando ao Menu Principal...\n");
		System.out.println("----------------------------------------------------------------------");
		menuPrincipal.ShowMenu(unidade);
	}
}
