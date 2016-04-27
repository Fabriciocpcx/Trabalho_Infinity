package br.com.Infinity.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.Infinity.control.ClienteControl;
import br.com.Infinity.model.Cliente;

public class ClienteUser implements ClienteControl {

	@Override
	public boolean cadastrarCliente(Cliente cliente) {
	
		EntityManagerFactory em = Persistence.createEntityManagerFactory("BancoPostgres");
		EntityManager mane = em.createEntityManager();
		
		mane.getTransaction().begin();
		
		
//		for(int i = 0 ; i < cliente.getVendas().size(); i++){
//			mane.persist(cliente.getVendas().get(i));
//		}
		
		mane.persist(cliente);
		mane.getTransaction().commit();
		mane.close();
		return true;
	}

	@Override
	public boolean alterarCliente(Cliente cliente, int id) {

		EntityManagerFactory em = Persistence.createEntityManagerFactory("BancoPostgres");
		EntityManager mane = em.createEntityManager();
		
		mane.getTransaction().begin();

		Cliente aux = mane.find(Cliente.class, id);
    	    	
		
		aux.setNome(cliente.getNome());
		aux.setRg(cliente.getRg());
		aux.setCpf(cliente.getCpf());
		aux.setEndereco(cliente.getEndereco());
		aux.setTelefone(cliente.getTelefone());
		aux.setLimite(cliente.getLimite());	
				
		mane.getTransaction().commit();
		return true;

	}

	@Override
	public boolean excluirCliente(int id) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("BancoPostgres");
		EntityManager mane = em.createEntityManager();
		
		Cliente temp  = mane.getReference(Cliente.class, id);
		mane.getTransaction().begin();

		
		mane.remove(temp);
		mane.getTransaction().commit();
		mane.close();
		
		return true;

	}

	@Override
	public Cliente buscarCliente(int id) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("BancoPostgres");
		EntityManager mane = em.createEntityManager();
		
		mane.getTransaction().begin();
		
		Cliente temp = mane.find(Cliente.class, id);
		
		mane.getTransaction().commit();
		mane.close();
		return temp;
		
	}

}
