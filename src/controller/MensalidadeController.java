package controller;

import java.util.Date;
import java.util.Scanner;

import model.Aluno;
import model.Mensalidade;
import model.Pagamento;
import model.enums.EstadoPagamento;

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
	
	public void pagarMensalidade()
	{
		
	}
}
