package model.enums;

public enum TipoExercicio {

	COSTAS(1, "Costas"),
	BICEPS(2, "Bíceps"),
	TRICEPS(3, "Tríceps"),
	PEITORAIS(4, "Peitorais"),
	PERNAS(5, "Pernas"),
	OMBROS(6, "Ombros"),
	ABDOMEM(7, "Abdómem"),
	CARDIO(8, "Cardiovascular");
	
	private Integer cod;
	private String descricao;
	
	private TipoExercicio() {};
	
	private TipoExercicio(Integer cod, String descricao)
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
	
	public static TipoExercicio toEnum(Integer cod)
	{
		if(cod == null)
		{
			return null;
		}
		
		for(TipoExercicio x : TipoExercicio.values())
		{
			if(cod.equals(x.getCod()))
			{
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
