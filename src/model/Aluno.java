package model;

import java.io.BufferedReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

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
	private EstadoConta estadoConta;
	
	public Aluno() {}

	public Aluno(Integer id, String nome, String email, String cpf, String telefone, Unidade unidade,
			Professor professor, SerieEspecificada serieEspecificada, EstadoConta estadoConta) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
		this.unidade = unidade;
		this.professor = professor;
		this.serieEspecificada = serieEspecificada;
		this.estadoConta = estadoConta;
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
		return estadoConta;
	}

	public void setEstado(EstadoConta estadoConta) {
		this.estadoConta = estadoConta;
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
	
	public String serializeAluno(Aluno aluno)
	{
		Gson gson = new Gson();
		return gson.toJson(aluno);
	}
	
	public static void deserializeAluno(BufferedReader alunoJson, Aluno alunoNovo)
	{
		Gson gson = new Gson();
		Aluno aluno = gson.fromJson(alunoJson, Aluno.class);
		
		alunoNovo.id = aluno.id;
		alunoNovo.nome = aluno.nome;
		alunoNovo.email = aluno.email;
		alunoNovo.cpf = aluno.cpf;
		alunoNovo.telefone = aluno.telefone;
		alunoNovo.unidade = aluno.unidade;
		alunoNovo.professor = aluno.professor;
		alunoNovo.estadoConta = aluno.estadoConta;
		alunoNovo.setMensalidades(aluno.mensalidades);
		alunoNovo.setSerieEspecificada(aluno.serieEspecificada);
		alunoNovo.setSerieRealizada(aluno.serieRealizada);
	}
}