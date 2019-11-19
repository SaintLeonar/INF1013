package controller;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

import dao.FileJson;
import model.Aluno;
import model.SerieRealizada;

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
		aluno.addSerieRealizada(serieRea);
		
		/*
		Integer numExSE = aluno.getExerciciosSEsp().size();
		Integer numExRE = aluno.getSerieRealizada().get(aluno.getSerieRealizada().size()-1).getExercicios().size();
		
		for(Integer i = 0 ; i < numExSE ; i++)
		{
			System.out.println(aluno.getExerciciosSEsp().get(i));
			System.out.println();
		}
		*/
		
		scanner.close();
	}
}
