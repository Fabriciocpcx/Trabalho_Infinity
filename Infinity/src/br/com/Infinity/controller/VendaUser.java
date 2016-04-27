package br.com.Infinity.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.Infinity.control.VendaControl;
import br.com.Infinity.model.Venda;

public class VendaUser implements VendaControl {

	@Override
	public boolean CadastrarVenda(Venda venda) {

		EntityManagerFactory em = Persistence
				.createEntityManagerFactory("BancoPostgres");
		EntityManager mane = em.createEntityManager();

		mane.getTransaction().begin();

		mane.persist(venda);
		mane.getTransaction().commit();
		mane.close();

		return true;
	}

	// public List<Venda> getVendas() {
	//
	// }

}
