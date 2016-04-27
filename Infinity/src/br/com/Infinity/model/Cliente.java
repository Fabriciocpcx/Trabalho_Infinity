package br.com.Infinity.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DiscriminatorFormula;

@Entity
@DiscriminatorFormula("Cliente")
public class Cliente extends Pessoa {

	@OneToMany
	private java.util.List<Venda> vendas;

	private String limite;

	public Cliente(String nome, String rg, String cpf, String endereco,
			String telefone, String limite) {
		super(nome, rg, cpf, endereco, telefone);
		vendas = new ArrayList<Venda>();
		this.setLimite(limite);

	}

	public Cliente() {
		vendas = new ArrayList<Venda>();
	}

	public java.util.List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(Venda vendas) {
		this.vendas.add(vendas);
	}

	public String getLimite() {
		return limite;
	}

	public void setLimite(String limite) {
		this.limite = limite;
	}

}
