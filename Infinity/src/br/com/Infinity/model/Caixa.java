package br.com.Infinity.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Caixa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double entradas;
	private double saidas;
	private double aPrazo;
	private double saldoCaixa;

	public Caixa(double entradas, double saidas, double aPrazo,
			double saldoCaixa) {

		this.entradas = entradas;
		this.saidas = saidas;
		this.aPrazo = aPrazo;
		this.setSaldoCaixa(saldoCaixa);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getEntradas() {
		return entradas;
	}

	public void setEntradas(double entradas) {
		this.entradas = entradas;
	}

	public double getSaidas() {
		return saidas;
	}

	public void setSaidas(double saidas) {
		this.saidas = saidas;
	}

	public double getaPrazo() {
		return aPrazo;
	}

	public void setaPrazo(double aPrazo) {
		this.aPrazo = aPrazo;
	}



	public Caixa() {

	}

	public double getSaldoCaixa() {
		return saldoCaixa;
	}

	public void setSaldoCaixa(double saldoCaixa) {
		this.saldoCaixa = saldoCaixa;
	}

}
