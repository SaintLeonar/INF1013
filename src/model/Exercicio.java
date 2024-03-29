package model;

import java.io.BufferedReader;
import java.io.Serializable;
import java.util.Date;

import com.google.gson.Gson;

import model.enums.TipoExercicio;

public class Exercicio implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Integer repeticoes;
	private Date tempo;
	private TipoExercicio tipoExercicio;
	private Aparelho aparelho;
	
	public Exercicio() {}

	public Exercicio(Integer id, String nome, Integer repeticoes, Date tempo, TipoExercicio tipoExercicio, Aparelho aparelho) {
		super();
		this.id = id;
		this.nome = nome;
		this.repeticoes = repeticoes;
		this.tempo = tempo;
		this.tipoExercicio = tipoExercicio;
		this.aparelho = aparelho;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getRepeticoes() {
		return repeticoes;
	}

	public void setRepeticoes(Integer repeticoes) {
		this.repeticoes = repeticoes;
	}

	public Date getTempo() {
		return tempo;
	}

	public void setTempo(Date tempo) {
		this.tempo = tempo;
	}
	
	public TipoExercicio getTipoExercicio() {
		return tipoExercicio;
	}

	public void setTipoExercicio(TipoExercicio tipoExercicio) {
		this.tipoExercicio = tipoExercicio;
	}

	public Aparelho getAparelho() {
		return aparelho;
	}

	public void setAparelho(Aparelho aparelho) {
		this.aparelho = aparelho;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((repeticoes == null) ? 0 : repeticoes.hashCode());
		result = prime * result + ((tempo == null) ? 0 : tempo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exercicio other = (Exercicio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (repeticoes == null) {
			if (other.repeticoes != null)
				return false;
		} else if (!repeticoes.equals(other.repeticoes))
			return false;
		if (tempo == null) {
			if (other.tempo != null)
				return false;
		} else if (!tempo.equals(other.tempo))
			return false;
		return true;
	}

	public static void deserialize(BufferedReader exJson, Exercicio exNovo)
	{
		Gson gson = new Gson();
		Exercicio ex = gson.fromJson(exJson, Exercicio.class);
		
		exNovo.id = ex.id;
		exNovo.nome = ex.nome;
		exNovo.repeticoes = ex.repeticoes;
		exNovo.tempo = ex.tempo;
		exNovo.tipoExercicio = ex.tipoExercicio;
		exNovo.aparelho = ex.aparelho;
	}
}
