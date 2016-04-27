package br.com.Infinity.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mercadoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String mercadoria;
	private String fornecedor;
	private String preco;
	private String cnpj;
	private String telefone;
	private int estoque;

	public Mercadoria(String mercadoria, String fornecedor, String preco,
			String cnpj, String telefone, int estoque) {

		this.mercadoria = mercadoria;
		this.fornecedor = fornecedor;
		this.preco = preco;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.setEstoque(estoque);
		
	}

	public Mercadoria() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMercadoria() {
		return mercadoria;
	}

	public void setMercadoria(String mercadoria) {
		this.mercadoria = mercadoria;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}


		

}
