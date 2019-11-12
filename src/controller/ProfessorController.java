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
 *  Caso de Uso CDU2: especificar uma s�rie
 *  
 *  1. O professor solicita no sistema
 *  2. O sistema lista os Alunos, com estado da conta ATIVA, que tem sua s�rie fora da validade
 *  3. O professor escolhe um aluno e especifica uma nova s�rie.
 *  4. O sistema registra a nova s�rie
 *  Extens�es:
 *  3. O professor decide cancelar a opera��o:
 *   	1. O sistema finaliza o procedimento
 * 
 * */
public class ProfessorController {
	
	/**
	 * 
	 * 	Retorna uma lista de alunos que est�o com a conta Ativa E com s�rie Especificada fora da validade
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
		System.out.println("(!) Decida qual aluno abaixo receber� a nova s�rie\n(!) Defina a s�rie .json dela\n\n(?) Escolha o aluno que ir� receber a Nova s�rie que voc� especificou no .json:\n");
		for(Aluno a : alunos)
		{
			System.out.println("("+i+ ") - " +a.getNome());
			i++;
		}
		System.out.println("(else) - Cancela a��o");
		
		Integer index = (int)scanner.next().charAt(0) - 48;
		scanner.nextLine(); // Limpa o buffer do scanner
		
		if(index >= 0 && index < alunos.size())
		{
			return alunos.get(index);
		}
		
		System.out.println("Voc� escolheu Cancelar");
		return null; 
	}
	
	public void especificaSerie(Unidade unidade)
	{
		Date dataAtual = new Date(System.currentTimeMillis());
		Scanner scanner = new Scanner(System.in);
		SerieEspecificada serieEsp = new SerieEspecificada();
		FileJson fileJson = new FileJson();
		
		Aluno al = ProfessorController.escolheAluno(ProfessorController.listaAlunos(unidade), scanner);
		System.out.println("(>) Voc� escolheu especificar uma nova s�rie para: "+al.getNome()+"\n(?) Digite o path do .json que voc� especificou: ");
		String pathJson = scanner.nextLine();
		File file = new File(pathJson);
		
		if(!file.exists())
		{
			System.out.println("Arquivo " +pathJson+ " n�o existe!");
			System.exit(-1);
		}
		
		serieEsp.deserialize(fileJson.read(pathJson), serieEsp);
		serieEsp.setDataInicio(dataAtual);
		al.setSerieEspecificada(serieEsp);
		fileJson.save("aluno"+al.getId()+".json", al.serialize(al));
		System.out.println("(>) S�rie Especificada!");
		scanner.close();
	}
	
}
