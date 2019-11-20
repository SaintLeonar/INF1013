package view;

import java.util.Scanner;

import controller.AlunoController;
import controller.ProfessorController;
import controller.UnidadeController;
import model.Aluno;
import model.Unidade;

public class MenuPrincipal {

	public MenuPrincipal() {}
	
	public void ShowMenu(Unidade unidade)
	{
		Scanner scanner = new Scanner(System.in);
		UnidadeController unidadeCtrl = new UnidadeController();
		ProfessorController profCtrl = new ProfessorController();
		
		AlunoView alunoView = new AlunoView();
		
		System.out.println("- MENU PRINCIPAL -\n\n(1) Verificar Inadimplencias (CDU4)\n(2) Menu do Professor\n(3) Menu do Aluno\n(else) Finalizar Sistema");
		Integer escolha = (int)scanner.next().charAt(0) - 48;
		
		switch (escolha) {
		case 1:
			System.out.println("----------------------------------------------------------------------");
			System.out.println("Verificando Inadimplencias...");
			unidadeCtrl.verificaInadimplencia(unidade);
			System.out.println("\nRetornando ao Menu Principal...");
			System.out.println("----------------------------------------------------------------------");
			this.ShowMenu(unidade);
			break;
			
		case 2:
			System.out.println("----------------------------------------------------------------------");
			System.out.println("- Menu Professor -\n");
			profCtrl.especificaSerie(unidade);
			System.out.println("\nRetornando ao Menu Principal...");
			System.out.println("----------------------------------------------------------------------");
			this.ShowMenu(unidade);
			break;
			
		case 3:
			System.out.println("(?) Quem é você?\n");
			Aluno a = AlunoController.escolheAluno(unidade.getAlunos());
			alunoView.showMenu(a);
			
			break;

		default:
			
			System.out.println("Encerrando...");
			System.exit(0);
			break;
		}
	}
}
