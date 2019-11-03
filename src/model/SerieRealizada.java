package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.enums.EstadoRealizacao;

public class SerieRealizada implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date dataDeRealizacao;
	private Integer estado;
	private SerieEspecificada serieEspecificada;
	private List<Exercicio> exercicios = new ArrayList<>();
	
	public SerieRealizada() {};
	
	public SerieRealizada(Integer id, Date dataDeRealizacao, EstadoRealizacao estado, SerieEspecificada serieEspecificada) {
		super();
		this.id = id;
		this.dataDeRealizacao = dataDeRealizacao;
		this.estado = estado.getCod();
		this.serieEspecificada = serieEspecificada;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDataDeRealizacao() {
		return dataDeRealizacao;
	}
	public void setDataDeRealizacao(Date dataDeRealizacao) {
		this.dataDeRealizacao = dataDeRealizacao;
	}
	public EstadoRealizacao getEstado() {
		return EstadoRealizacao.toEnum(estado);
	}
	public void setEstado(EstadoRealizacao estado) {
		this.estado = estado.getCod();
	}
	public SerieEspecificada getSerieEspecificada() {
		return serieEspecificada;
	}
	public void setSerieEspecificada(SerieEspecificada serieEspecificada) {
		this.serieEspecificada = serieEspecificada;
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
		SerieRealizada other = (SerieRealizada) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
