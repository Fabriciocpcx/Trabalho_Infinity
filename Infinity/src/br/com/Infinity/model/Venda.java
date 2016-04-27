package br.com.Infinity.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public Venda(String data, int valor, int quantidade, Cliente cliente,
			Mercadoria mercadoria, boolean prazo) {
		this.setPrazo(prazo);
		this.data = data;
		this.valor = valor;
		this.quantidade = quantidade;
		this.cliente = cliente;
		this.mercadoria = mercadoria;

	}

	private int quantidade;
	private int valor;
	private String data;
	private boolean prazo;

	@OneToOne
	private Mercadoria mercadoria;

	@ManyToOne
	private Cliente cliente;

	// @OneToOne
	// private Funcionario funcionario;

	public Venda() {

	}

	public Mercadoria getMercadoria() {
		return mercadoria;
	}

	public void setMercadoria(Mercadoria mercadoria) {
		this.mercadoria = mercadoria;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isPrazo() {
		return prazo;
	}

	public void setPrazo(boolean prazo) {
		this.prazo = prazo;
	}

}
