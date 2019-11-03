package model;

import java.io.Serializable;
import java.util.Date;

import model.enums.TipoExercicio;

public class Exercicio implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Integer repeticoes;
	private Date tempo;
	private Integer tipoExercicio;
	
	public Exercicio() {}

	public Exercicio(Integer id, String nome, Integer repeticoes, Date tempo, TipoExercicio tipoExercicio) {
		super();
		this.id = id;
		this.nome = nome;
		this.repeticoes = repeticoes;
		this.tempo = tempo;
		this.tipoExercicio = tipoExercicio.getCod();
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
		return TipoExercicio.toEnum(tipoExercicio);
	}

	public void setTipoExercicio(TipoExercicio tipoExercicio) {
		this.tipoExercicio = tipoExercicio.getCod();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		return true;
	};
	
}
