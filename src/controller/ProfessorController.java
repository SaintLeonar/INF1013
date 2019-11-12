package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dao.FileJson;
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
	public static List<Aluno> listaAlunos(Unidade unidade)
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
	
	public static Aluno escolheAluno(List<Aluno> alunos, Scanner scanner)
	{
		Integer i = 0;
		//Scanner scanner = new Scanner(System.in);
		System.out.println("(!) Decida qual aluno abaixo receberá a nova série\n(!) Defina a série .json dela\n\n(?) Escolha o aluno que irá receber a Nova série que você especificou no .json:\n");
		for(Aluno a : alunos)
		{
			System.out.println("("+i+ ") - " +a.getNome());
			i++;
		}
		System.out.println("(else) - Cancela ação");
		
		Integer index = (int)scanner.next().charAt(0) - 48;
		scanner.nextLine(); // Limpa o buffer do scanner
		
		if(index >= 0 && index < alunos.size())
		{
			return alunos.get(index);
		}
		
		System.out.println("Você escolheu Cancelar");
		return null; 
	}
	
	public void especificaSerie(Unidade unidade)
	{
		Date dataAtual = new Date(System.currentTimeMillis());
		Scanner scanner = new Scanner(System.in);
		SerieEspecificada serieEsp = new SerieEspecificada();
		FileJson fileJson = new FileJson();
		
		Aluno al = ProfessorController.escolheAluno(ProfessorController.listaAlunos(unidade), scanner);
		System.out.println("(>) Você escolheu especificar uma nova série para: "+al.getNome()+"\n(?) Digite o path do .json que você especificou: ");
		String pathJson = scanner.nextLine();
		File file = new File(pathJson);
		
		if(!file.exists())
		{
			System.out.println("Arquivo " +pathJson+ " não existe!");
			System.exit(-1);
		}
		
		serieEsp.deserialize(fileJson.read(pathJson), serieEsp);
		serieEsp.setDataInicio(dataAtual);
		al.setSerieEspecificada(serieEsp);
		fileJson.save("aluno"+al.getId()+".json", al.serialize(al));
		System.out.println("(>) Série Especificada!");
		scanner.close();
	}
	
}
