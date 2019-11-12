package model;

import java.io.BufferedReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

public class SerieEspecificada implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date dataInicio;
	private Date dataFim;
	
	private transient Aluno aluno;
	private Professor professor;
	
	private transient List<SerieRealizada> seriesRealizadas = new ArrayList<>();
	private List<Exercicio> exercicios = new ArrayList<>(); 
	
	public SerieEspecificada() {}

	public SerieEspecificada(Integer id, Date dataInicio, Date dataFim, Aluno aluno, Professor professor) {
		super();
		this.id = id;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.aluno = aluno;
		this.professor = professor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<SerieRealizada> getSeriesRealizadas() {
		return seriesRealizadas;
	}

	public void setSeriesRealizadas(List<SerieRealizada> seriesRealizadas) {
		this.seriesRealizadas = seriesRealizadas;
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
		SerieEspecificada other = (SerieEspecificada) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public void deserialize(BufferedReader exJson, SerieEspecificada seNovo)
	{
		Gson gson = new Gson();
		SerieEspecificada se = gson.fromJson(exJson, SerieEspecificada.class);
		
		seNovo.id = se.id;
		seNovo.dataInicio = se.dataInicio;
		seNovo.dataFim = se.dataFim;
		seNovo.professor = se.professor;
		seNovo.setExercicios(se.exercicios);
		seNovo.setSeriesRealizadas(se.seriesRealizadas);
	}
}
