package br.com.Infinity.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.Infinity.control.MercadoriaControl;
import br.com.Infinity.model.Mercadoria;

public class MercadoriaUser implements MercadoriaControl {

	@Override
	public boolean cadastrarMercadoria(Mercadoria mercadoria) {

		EntityManagerFactory em = Persistence.createEntityManagerFactory("BancoPostgres");
		EntityManager mane = em.createEntityManager();

		mane.getTransaction().begin();

		mane.persist(mercadoria);
		mane.getTransaction().commit();
		mane.close();
		return true;
	}

	@Override
	public boolean alterarMercadoria(Mercadoria mercadoria, int id) {
		EntityManagerFactory em = Persistence
				.createEntityManagerFactory("BancoPostgres");
		EntityManager mane = em.createEntityManager();

		mane.getTransaction().begin();

		Mercadoria aux = mane.find(Mercadoria.class, id);


		aux.setMercadoria(mercadoria.getMercadoria());
		aux.setFornecedor(mercadoria.getFornecedor());
		aux.setCnpj(mercadoria.getCnpj());
		aux.setPreco(mercadoria.getPreco());
		aux.setTelefone(mercadoria.getTelefone());
		aux.setEstoque(mercadoria.getEstoque());

		mane.getTransaction().commit();
		return true;

	}

	@Override
	public boolean excluirMercadoria(int id) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("BancoPostgres");
		EntityManager mane = em.createEntityManager();
		
		Mercadoria temp  = mane.getReference(Mercadoria.class, id);
		mane.getTransaction().begin();

		
		mane.remove(temp);
		mane.getTransaction().commit();
		mane.close();
		
		return true;
		

	}

	@Override
	public Mercadoria buscarMercadoria(int id) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("BancoPostgres");
		EntityManager mane = em.createEntityManager();
		
		mane.getTransaction().begin();
		
		Mercadoria temp = mane.find(Mercadoria.class, id);
		
		mane.getTransaction().commit();
		mane.close();
		
		return temp;

	}

}
