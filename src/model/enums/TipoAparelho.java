package model.enums;

public enum TipoAparelho {
	
	AEROBICO(1, "Aer�bico"),
	MUSCULACAO(2, "Muscula��o");
	
	private Integer cod;
	private String descricao;
	
	private TipoAparelho() {};
	
	private TipoAparelho(Integer cod, String descricao)
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
	
	public static TipoAparelho toEnum(Integer cod)
	{
		if(cod == null)
		{
			return null;
		}
		
		for(TipoAparelho x : TipoAparelho.values())
		{
			if(cod.equals(x.getCod()))
			{
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inv�lido: " + cod);
	}
}
