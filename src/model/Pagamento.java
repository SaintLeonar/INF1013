package model;

import java.util.Date;

import model.enums.EstadoPagamento;

public class Pagamento {
	
	private Integer id;
	private Date dataVencimento;
	private Date dataPagamento;
	private EstadoPagamento estado;
	
	private transient Mensalidade mensalidade;
	
	public Pagamento() {}

	public Pagamento(Integer id, EstadoPagamento estado, Date dataVencimento, Date dataPagamento, Mensalidade mensalidade) {
		super();
		this.id = id;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.estado = estado;
		this.mensalidade = mensalidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public EstadoPagamento getEstado() {
		return estado;
	}

	public void setEstado(EstadoPagamento estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	public Mensalidade getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(Mensalidade mensalidade) {
		this.mensalidade = mensalidade;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
