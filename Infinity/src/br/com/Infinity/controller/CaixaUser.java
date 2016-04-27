package br.com.Infinity.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.Infinity.control.CaixaControl;
import br.com.Infinity.model.Caixa;

public class CaixaUser implements CaixaControl {

	@Override
	public boolean alterarCaixa(Caixa caixa) {

		EntityManagerFactory em = Persistence
				.createEntityManagerFactory("BancoPostgres");
		EntityManager mane = em.createEntityManager();

		mane.getTransaction().begin();

		Caixa aux = mane.find(Caixa.class, 1);

		aux.setEntradas(caixa.getEntradas());
		aux.setSaidas(caixa.getSaidas());
		aux.setaPrazo(caixa.getaPrazo());
		aux.setSaldoCaixa(caixa.getSaldoCaixa());

		mane.getTransaction().commit();
		return true;

	}

	@Override
	public boolean iniciarCaixa(Caixa caixa) {

		EntityManagerFactory em = Persistence
				.createEntityManagerFactory("BancoPostgres");
		EntityManager mane = em.createEntityManager();

		mane.getTransaction().begin();

		mane.persist(caixa);
		mane.getTransaction().commit();
		mane.close();
		return true;

	}

	@Override
	public Caixa buscarCaixa(int id) {

		EntityManagerFactory em = Persistence
				.createEntityManagerFactory("BancoPostgres");
		EntityManager mane = em.createEntityManager();

		mane.getTransaction().begin();

		Caixa aux = mane.find(Caixa.class, id);

		mane.getTransaction().commit();
		mane.close();
		return aux;

	}

	@Override
	public boolean buscarInicializar(int id) {

		EntityManagerFactory em = Persistence
				.createEntityManagerFactory("BancoPostgres");
		EntityManager mane = em.createEntityManager();

		mane.getTransaction().begin();

		Caixa aux = mane.find(Caixa.class, id);

		mane.getTransaction().commit();
		mane.close();

		return true;
	}

}
