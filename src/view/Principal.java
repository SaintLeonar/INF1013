package view;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

import controller.ProfessorController;
import controller.UnidadeController;
import dao.FileJson;
import model.Aluno;
import model.Exercicio;
import model.Mensalidade;
import model.Pagamento;
import model.Professor;
import model.SerieEspecificada;
import model.Unidade;
import model.enums.EstadoConta;
import model.enums.EstadoPagamento;

public class Principal {

	public static void main(String[] args) throws Exception {
		

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Responsável pelas informações de data
		Scanner scanner = new Scanner(System.in);
		FileJson fileJson = new FileJson();
		
		// Cria Unidade
		Unidade unidade1 = new Unidade(1, "Unidade Gávea");
		
		// Cria Professores
		Professor professor1 = new Professor(1, "Paulo Silva", "Paulo@gmail.com", "11100011100");
		Professor professor2 = new Professor(2, "Fernanda Santos", "Fernanda@gmail.com", "11100011122");
		professor1.getUnidades().addAll(Arrays.asList(unidade1));
		professor2.getUnidades().addAll(Arrays.asList(unidade1));
		
		// Cria Exercicios
		Exercicio ex1 = new Exercicio();
		Exercicio ex2 = new Exercicio();
		Exercicio ex3 = new Exercicio();
		Exercicio ex4 = new Exercicio();
		Exercicio ex5 = new Exercicio();
		Exercicio ex6 = new Exercicio();
		
		Exercicio.deserialize(fileJson.read("exercicio1.json"), ex1);
		Exercicio.deserialize(fileJson.read("exercicio2.json"), ex2);
		Exercicio.deserialize(fileJson.read("exercicio3.json"), ex3);
		Exercicio.deserialize(fileJson.read("exercicio4.json"), ex4);
		Exercicio.deserialize(fileJson.read("exercicio5.json"), ex5);
		Exercicio.deserialize(fileJson.read("exercicio6.json"), ex6);
		
		// Cria Alunos
		Aluno aluno1 = new Aluno(1, "João", "Joao@gmail.com", "00000000000", "552100000000", unidade1, professor1, null, EstadoConta.ATIVA);
		Aluno aluno2 = new Aluno(2, "Leonardo", "Leonardo@gmail.com", "00000000001", "552100000001", unidade1, professor2, null, EstadoConta.ATIVA);
		Aluno aluno3 = new Aluno(3, "Patrícia", "Pat@gmail.com", "00000000002", "552100000002", unidade1, professor1, null, EstadoConta.BLOQUEADA);
		Aluno aluno4 = new Aluno(4, "Lucas", "Lucas@gmail.com", "00000000003", "552100000003", unidade1, professor2, null, EstadoConta.ATIVA);
		Aluno aluno5 = new Aluno(5, "Maria", "Maria@gmail.com", "00000000004", "552100000004", unidade1, professor1, null, EstadoConta.ATIVA);
		Aluno aluno6 = new Aluno(6, "Ana", "Ana@gmail.com", "00000000005", "552100000005", unidade1, professor2, null, EstadoConta.ATIVA);
		
		// Cria Pagamento e Mensalidade
		Mensalidade mensalidade1 = new Mensalidade(1, sdf.parse("03/10/2019"), (float) 99.00, null, null);
		Mensalidade mensalidade2 = new Mensalidade(2, sdf.parse("03/10/2019"), (float) 99.00, null, null);
		Mensalidade mensalidade3 = new Mensalidade(3, sdf.parse("03/10/2019"), (float) 99.00, null, null);
		Mensalidade mensalidade4 = new Mensalidade(4, sdf.parse("03/10/2019"), (float) 99.00, null, null);
		Mensalidade mensalidade5 = new Mensalidade(5, sdf.parse("03/10/2019"), (float) 99.00, null, null);
		Mensalidade mensalidade6 = new Mensalidade(6, sdf.parse("03/10/2019"), (float) 99.00, null, null);
		
		// Cada mensalidade tem um aluno, por isso criar uma mensalidade para cada aluno
		// Mesmo que sejam mensalidades do mesmo mes
		mensalidade1.setAluno(aluno1);
		mensalidade2.setAluno(aluno2);
		mensalidade3.setAluno(aluno3);
		mensalidade4.setAluno(aluno4);
		mensalidade5.setAluno(aluno5);
		mensalidade6.setAluno(aluno6);
		
		// Se o parametro dataPagamento for null -> não consta pagamento até o momento
		Pagamento pagamento1 = new Pagamento(1, EstadoPagamento.QUITADO, sdf.parse("03/11/2019"), sdf.parse("25/10/2019"), null);
		Pagamento pagamento2 = new Pagamento(2, EstadoPagamento.QUITADO, sdf.parse("03/11/2019"), null, null);
		Pagamento pagamento3 = new Pagamento(3, EstadoPagamento.ATRASADO, sdf.parse("03/11/2019"), null, null);
		Pagamento pagamento4 = new Pagamento(4, EstadoPagamento.QUITADO, sdf.parse("03/11/2019"), sdf.parse("30/10/2019"), null);
		Pagamento pagamento5 = new Pagamento(5, EstadoPagamento.QUITADO, sdf.parse("03/11/2019"), sdf.parse("25/10/2019"), null);
		Pagamento pagamento6 = new Pagamento(6, EstadoPagamento.QUITADO, sdf.parse("03/11/2019"), sdf.parse("25/10/2019"), null);
		//                                                                        Data Validade            Data Pagamento
		
		mensalidade1.setPagamento(pagamento1);
		pagamento1.setMensalidade(mensalidade1);
		mensalidade2.setPagamento(pagamento2);
		pagamento2.setMensalidade(mensalidade2);
		mensalidade3.setPagamento(pagamento3);
		pagamento3.setMensalidade(mensalidade3);
		mensalidade4.setPagamento(pagamento4);
		pagamento4.setMensalidade(mensalidade4);
		mensalidade5.setPagamento(pagamento5);
		pagamento5.setMensalidade(mensalidade5);
		mensalidade6.setPagamento(pagamento6);
		pagamento6.setMensalidade(mensalidade6);
		
		aluno1.getMensalidades().addAll(Arrays.asList(mensalidade1));
		aluno2.getMensalidades().addAll(Arrays.asList(mensalidade2));
		aluno3.getMensalidades().addAll(Arrays.asList(mensalidade3));
		aluno4.getMensalidades().addAll(Arrays.asList(mensalidade4));
		aluno5.getMensalidades().addAll(Arrays.asList(mensalidade5));
		aluno6.getMensalidades().addAll(Arrays.asList(mensalidade6));
		
		// Cria Serie Realizada e Especificada
		SerieEspecificada serieEsp1 = new SerieEspecificada(1, sdf.parse("09/10/2019"), sdf.parse("09/12/2019"), aluno1, professor1);
		SerieEspecificada serieEsp2 = new SerieEspecificada(2, sdf.parse("09/10/2019"), sdf.parse("09/12/2019"), aluno2, professor2);
		SerieEspecificada serieEsp3 = new SerieEspecificada(3, sdf.parse("09/10/2019"), sdf.parse("09/12/2019"), aluno3, professor1);
		SerieEspecificada serieEsp4 = new SerieEspecificada(4, sdf.parse("09/10/2019"), sdf.parse("09/12/2019"), aluno4, professor2);
		SerieEspecificada serieEsp5 = new SerieEspecificada(5, sdf.parse("09/10/2019"), sdf.parse("03/11/2019"), aluno5, professor1);
		SerieEspecificada serieEsp6 = new SerieEspecificada(6, sdf.parse("09/10/2019"), sdf.parse("09/11/2019"), aluno6, professor2);
		//                                                                Data Inicio               Data Fim
		
		serieEsp1.getExercicios().addAll(Arrays.asList(ex1, ex2));
		serieEsp2.getExercicios().addAll(Arrays.asList(ex1, ex2));
		serieEsp3.getExercicios().addAll(Arrays.asList(ex3, ex4));
		serieEsp4.getExercicios().addAll(Arrays.asList(ex3, ex4));
		serieEsp5.getExercicios().addAll(Arrays.asList(ex5, ex6));
		serieEsp6.getExercicios().addAll(Arrays.asList(ex5, ex6));
		
		aluno1.setSerieEspecificada(serieEsp1);
		aluno2.setSerieEspecificada(serieEsp2);
		aluno3.setSerieEspecificada(serieEsp3);
		aluno4.setSerieEspecificada(serieEsp4);
		aluno5.setSerieEspecificada(serieEsp5);
		aluno6.setSerieEspecificada(serieEsp6);
		
		unidade1.getAlunos().addAll(Arrays.asList(aluno1, aluno2, aluno3, aluno4, aluno5, aluno6));
		unidade1.getProfessores().addAll(Arrays.asList(professor1, professor2));
		
		
		/* Chamadas de Casos de Uso */

		
		/* Caso de Uso CDU4: bloquear conta ***********************************************************************************/
		UnidadeController unidadeCtrl = new UnidadeController();
		unidadeCtrl.verificaInadimplencia(unidade1);
		/* Fim Caso de Uso CDU4: bloquear conta ******************************************************************************/
		System.out.println("\n\n\n");
		
		
		/* Caso de Uso CDU2: especificar uma nova série ***********************************************************************************/
		ProfessorController profCtrl = new ProfessorController();
		profCtrl.especificaSerie(unidade1);
		/* Fim Caso de Uso CDU2: especificar uma nova série ******************************************************************************/
		
		scanner.close();
	}

}
