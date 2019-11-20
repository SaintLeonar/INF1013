package view;

import java.util.Scanner;

import model.Aluno;
import model.Unidade;
import model.enums.EstadoConta;

public class AlunoView {
	
	public AlunoView() {}

	public void showMenu(Aluno aluno) {
		
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		Scanner scanner = new Scanner(System.in);
		Integer escolha;
		
		System.out.println("----------------------------------------------------------------------");
		System.out.println("Aluno(a): " +aluno.getNome()+ "\n");
		
		if(aluno.getEstado() == EstadoConta.BLOQUEADA)
		{
			System.out.println("Sua Conta está BLOQUEADA!\n\n(0) Pagar Conta (Não Implementado)\n(else) - Retornar ao Menu Principal");
			escolha = (int)scanner.next().charAt(0) - 48;
			
			switch (escolha) {
			case 0:
				// PAGAR CONTA
				break;

			default:
				System.out.println("Retornando ao Menu Principal...\n");
				System.out.println("----------------------------------------------------------------------");
				menuPrincipal.ShowMenu(aluno.getUnidade());
				break;
			}
		}
		else
		{
			System.out.println("Sua Conta está ATIVA!\n\n(0) Pagar Conta (Não Implementado)\n(1) Realizar Série (Não Implementado)\n(else) - Retornar ao Menu Principal");
			escolha = (int)scanner.next().charAt(0) - 48;
			
			switch (escolha) {
			case 0:
				// PAGAR CONTA
				break;

			case 1:
				// REALIZAR SÉRIE
				break;	
				
			default:
				System.out.println("Retornando ao Menu Principal...\n");
				System.out.println("----------------------------------------------------------------------");
				menuPrincipal.ShowMenu(aluno.getUnidade());
				break;
			}
			
		}
	}
}
