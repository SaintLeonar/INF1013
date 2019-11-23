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
 * 	Caso de Uso CDU3: realizar série
 * 
 * 	1a. O Aluno registra no sistema a série realizada do aluno
 *  2a. O Sistema registra série realizada
 *  3a. O sistema compara a série realizada com a série especificada do aluno
 *  4a. O sistema registra o estado realização como COMPLETO
 *  5a. O sistema alerta caso a série especificada esteja fora da validade
 *  
 *  Fluxo alternativo:
 *  1a. Série diferente da especificada e considerada substituta
 *  	1. Substituição é especificada
 *  	2. O sistema registra o estado de realização como COMPLETO
 *  2a. Aluno inadiimplente
 *  	1. Sistema informa que aluno não pode realizar série
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
	 * 	Retorna TRUE se a série realizada for identica a série especificada
	 *  Senão, retorna FALSE
	 * 
	 * */
	public boolean avaliaSerie(SerieEspecificada serieEsp, SerieRealizada serieRea)
	{
		// Se as séries de inicio já não tiverem o mesmo tamanho ja é FALSO
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
	 *  Realiza uma série do aluno recebido nos parâmetros
	 * 
	 * */
	public void realizaSerie(Aluno aluno)
	{
		Date dataAtual = new Date(System.currentTimeMillis());
		Scanner scanner = new Scanner(System.in);
		FileJson fileJson = new FileJson();
		
		System.out.println("(!) Registre sua série no .json\n(?) Digite o path do .json que você registrou: ");
		String pathJson = scanner.nextLine();
		
		File file = new File(pathJson);
		
		if(!file.exists())
		{
			System.out.println("Arquivo " +pathJson+ " não existe!");
			System.exit(-1);
		}
		
		SerieRealizada serieRea = new SerieRealizada();
		SerieRealizada.deserialize(fileJson.read(pathJson), serieRea);
		serieRea.setDataDeRealizacao(dataAtual);
		serieRea.setSerieEspecificada(aluno.getSerieEspecificada());
		
		if(!this.avaliaSerie(aluno.getSerieEspecificada(), serieRea))
		{
			System.out.println("(!) Você realizou sua série incompletamente!\n(?) Deseja declarar como substituta?\n\n(0) Sim (COMPLETO)\n(else) Não (INCOMPLETA)\n");
			Integer escolha = (int)scanner.next().charAt(0) - 48;
			
			if(escolha == 0)
			{
				serieRea.setEstado(EstadoRealizacao.COMPLETO); // Substituta
			}
			else
			{
				serieRea.setEstado(EstadoRealizacao.IMCOMPLETO); // Não-Substituta
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
