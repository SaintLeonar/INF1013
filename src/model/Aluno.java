package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.enums.EstadoConta;

public class Aluno implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String email;
	private String cpf;
	private String telefone;
	private Unidade unidade;
	private Professor professor;
	private List<Mensalidade> mensalidades = new ArrayList<>();
	private List<SerieRealizada> serieRealizada = new ArrayList<>();
	private SerieEspecificada serieEspecificada;
	private Integer estado;
	
	public Aluno() {}

	public Aluno(Integer id, String nome, String email, String cpf, String telefone, Unidade unidade,
			Professor professor, SerieEspecificada serieEspecificada, EstadoConta estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
		this.unidade = unidade;
		this.professor = professor;
		this.serieEspecificada = serieEspecificada;
		this.estado = estado.getCod();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Mensalidade> getMensalidades() {
		return mensalidades;
	}

	public void setMensalidades(List<Mensalidade> mensalidades) {
		this.mensalidades = mensalidades;
	}

	public List<SerieRealizada> getSerieRealizada() {
		return serieRealizada;
	}

	public void setSerieRealizada(List<SerieRealizada> serieRealizada) {
		this.serieRealizada = serieRealizada;
	}

	public SerieEspecificada getSerieEspecificada() {
		return serieEspecificada;
	}

	public void setSerieEspecificada(SerieEspecificada serieEspecificada) {
		this.serieEspecificada = serieEspecificada;
	}
	
	public EstadoConta getEstado() {
		return EstadoConta.toEnum(estado);
	}

	public void setEstado(EstadoConta estado) {
		this.estado = estado.getCod();
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
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}