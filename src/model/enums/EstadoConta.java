package model.enums;

public enum EstadoConta {
	
	ATIVA(1, "Ativa"),
	BLOQUEADA(2, "Bloqueada");
	
	private Integer cod;
	private String descricao;
	
	private EstadoConta() {};
	
	private EstadoConta(Integer cod, String descricao)
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
	
	public static EstadoConta toEnum(Integer cod)
	{
		if(cod == null)
		{
			return null;
		}
		
		for(EstadoConta x : EstadoConta.values())
		{
			if(cod.equals(x.getCod()))
			{
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
