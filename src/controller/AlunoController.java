package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dao.FileJson;
import model.Aluno;
import model.SerieEspecificada;
import model.SerieRealizada;
import model.Unidade;
import model.enums.EstadoConta;
import model.enums.EstadoRealizacao;
import view.MenuPrincipal;

/**
 * 
 * 	Caso de Uso CDU3: realizar s�rie
 * 
 * 	1a. O Aluno registra no sistema a s�rie realizada do aluno
 *  2a. O Sistema registra s�rie realizada
 *  3a. O sistema compara a s�rie realizada com a s�rie especificada do aluno
 *  4a. O sistema registra o estado realiza��o como COMPLETO
 *  5a. O sistema alerta caso a s�rie especificada esteja fora da validade
 *  
 *  Fluxo alternativo:
 *  1a. S�rie diferente da especificada e considerada substituta
 *  	1. Substitui��o � especificada
 *  	2. O sistema registra o estado de realiza��o como COMPLETO
 *  2a. Aluno inadiimplente
 *  	1. Sistema informa que aluno n�o pode realizar s�rie
 *   	2. Sistema finaliza
 * 
 * */
public class AlunoController {
	
	public AlunoController() {}
	
	/**
	 * 
	 * 	Lista alunos e retorna um Aluno da lista escolhido via input
	 * 
	 * */
	public static Aluno escolheAluno(List<Aluno> alunos)
	{
		Integer i = 0;
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		Scanner scanner = new Scanner(System.in);
		
		for(Aluno a : alunos)
		{
			System.out.println("("+i+ ") - " +a.getNome());
			i++;
		}
		System.out.println("(else) - Retornar ao Menu Principal");
		
		Integer index = (int)scanner.next().charAt(0) - 48;
		scanner.nextLine(); // Limpa o buffer do scanner
		
		if(index >= 0 && index < alunos.size())
		{
			return alunos.get(index);
		}
		
		System.out.println("Retornando ao Menu Principal...\n");
		System.out.println("----------------------------------------------------------------------");
		menuPrincipal.ShowMenu(alunos.get(0).getUnidade());
		return null; 
	}
	
	/**
	 * 
	 * 	Retorna TRUE se a s�rie realizada for identica a s�rie especificada
	 *  Sen�o, retorna FALSE
	 * 
	 * */
	public boolean avaliaSerie(SerieEspecificada serieEsp, SerieRealizada serieRea)
	{
		// Se as s�ries de inicio j� n�o tiverem o mesmo tamanho ja � FALSO
		if(serieRea.getExercicios().size() != serieEsp.getExercicios().size())
		{
			System.out.println(serieEsp.getExercicios().size()+" "+serieRea.getExercicios().size());
			return false;
		}
		
		for(Integer i = 0 ; i < serieEsp.getExercicios().size() ; i++)
		{
			if(!serieRea.getExercicios().get(i).equals(serieEsp.getExercicios().get(i)))
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 *  Realiza uma s�rie do aluno recebido nos par�metros
	 * 
	 * */
	public void realizaSerie(Aluno aluno)
	{
		Date dataAtual = new Date(System.currentTimeMillis());
		Scanner scanner = new Scanner(System.in);
		FileJson fileJson = new FileJson();
		
		System.out.println("(!) Registre sua s�rie no .json\n(?) Digite o path do .json que voc� registrou: ");
		String pathJson = scanner.nextLine();
		
		File file = new File(pathJson);
		
		if(!file.exists())
		{
			System.out.println("Arquivo " +pathJson+ " n�o existe!");
			System.exit(-1);
		}
		
		SerieRealizada serieRea = new SerieRealizada();
		SerieRealizada.deserialize(fileJson.read(pathJson), serieRea);
		serieRea.setDataDeRealizacao(dataAtual);
		serieRea.setSerieEspecificada(aluno.getSerieEspecificada());
		
		if(!this.avaliaSerie(aluno.getSerieEspecificada(), serieRea))
		{
			System.out.println("(!) Voc� realizou sua s�rie incompletamente!\n(?) Deseja declarar como substituta?\n\n(0) Sim (COMPLETO)\n(else) N�o (INCOMPLETA)\n");
			Integer escolha = (int)scanner.next().charAt(0) - 48;
			
			if(escolha == 0)
			{
				serieRea.setEstado(EstadoRealizacao.COMPLETO); // Substituta
			}
			else
			{
				serieRea.setEstado(EstadoRealizacao.IMCOMPLETO); // N�o-Substituta
			}
			
		}
		else
		{
			serieRea.setEstado(EstadoRealizacao.COMPLETO); // Completo
		}
		
		aluno.addSerieRealizada(serieRea);
		
		fileJson.save("aluno"+aluno.getId()+".json", aluno.serialize(aluno));
		
	}
	
}
