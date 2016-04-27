package br.com.Infinity.model;

import javax.persistence.Entity;

import org.hibernate.annotations.DiscriminatorFormula;

@Entity
@DiscriminatorFormula("Funcionario")
public class Funcionario extends Pessoa {

	public Funcionario(double salario, String nome, String rg, String cpf,
			String endereco, String telefone) {

		super(nome, rg, cpf, endereco, telefone);

		this.salario = salario;
	}

	public Funcionario() {

	}

	private double salario;

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
