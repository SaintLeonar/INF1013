package model;

import java.io.Serializable;
import java.util.Date;

public class Mensalidade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date data;
	private Float valor;
	
	private transient Aluno aluno;
	private Pagamento pagamento;
	
	public Mensalidade() {}

	public Mensalidade(Integer id, Date data, Float valor, Aluno aluno, Pagamento pagamento) {
		super();
		this.id = id;
		this.data = data;
		this.valor = valor;
		this.aluno = aluno;
		this.pagamento = pagamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getMes() {
		return data;
	}

	public void setMes(Date data) {
		this.data = data;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
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
		Mensalidade other = (Mensalidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
