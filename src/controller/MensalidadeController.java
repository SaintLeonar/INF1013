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
 *  Extens�es:
 *  3a. ID do aluno est� incorreto ou n�o existe:
 *   	1. O sistema informa o erro e rejeita a a��o
 *   	2. O sitema retorna ao passo 2
 *  3b.  ID da mensalidade est� incorreto ou n�o existe
 *  	1. O sistema informa o erro e rejeita a a��o
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
