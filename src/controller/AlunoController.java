package controller;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

import dao.FileJson;
import model.Aluno;
import model.SerieRealizada;

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
