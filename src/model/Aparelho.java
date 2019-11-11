package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.enums.TipoAparelho;
import model.enums.TipoExercicio;

public class Aparelho implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private TipoAparelho tipoAparelho;
	private TipoExercicio tipoExercicio;
	
	private transient List<Exercicio> exercicios = new ArrayList<>();
	
	public Aparelho() {}

	public Aparelho(Integer id, String nome, TipoAparelho tipoAparelho, TipoExercicio tipoExercicio) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipoAparelho = tipoAparelho;
		this.tipoExercicio = tipoExercicio;
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

	public TipoAparelho getTipoAparelho() {
		return tipoAparelho;
	}

	public void setTipoAparelho(TipoAparelho tipoAparelho) {
		this.tipoAparelho = tipoAparelho;
	}

	public TipoExercicio getTipoExercicio() {
		return tipoExercicio;
	}

	public void setTipoExercicio(TipoExercicio tipoExercicio) {
		this.tipoExercicio = tipoExercicio;
	}

	public List<Exercicio> getExercicios() {
		return exercicios;
	}

	public void setExercicios(List<Exercicio> exercicios) {
		this.exercicios = exercicios;
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
		Aparelho other = (Aparelho) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
