package model.enums;

public enum EstadoRealizacao {
	
	COMPLETO(1, "Completo"),
	IMCOMPLETO(2, "Imcompleto");
	
	private Integer cod;
	private String descricao;
	
	private EstadoRealizacao() {};
	
	private EstadoRealizacao(Integer cod, String descricao)
	{
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public Integer getCod()
	{
		return cod;
	}
	
	public String getDescricao()
	{
		return descricao;
	}
	
	public static EstadoRealizacao toEnum(Integer cod)
	{
		if(cod == null)
		{
			return null;
		}
		
		for(EstadoRealizacao x : EstadoRealizacao.values())
		{
			if(cod.equals(x.getCod()))
			{
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
