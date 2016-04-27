package br.com.Infinity.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.Infinity.control.FuncionarioControl;
import br.com.Infinity.model.Cliente;
import br.com.Infinity.model.Funcionario;

public class FuncionarioUser implements FuncionarioControl {

	@Override
	public boolean cadastrarFuncionario(Funcionario funcionario) {
		EntityManagerFactory em = Persistence
				.createEntityManagerFactory("BancoPostgres");
		EntityManager mane = em.createEntityManager();

		mane.getTransaction().begin();

		mane.persist(funcionario);
		mane.getTransaction().commit();
		mane.close();
		return true;
	}

	@Override
	public boolean alterarFuncionario(Funcionario funcionario, int id) {
		EntityManagerFactory em = Persistence
				.createEntityManagerFactory("BancoPostgres");
		EntityManager mane = em.createEntityManager();

		mane.getTransaction().begin();

		Funcionario aux = mane.find(Funcionario.class, id);

		aux.setNome(funcionario.getNome());
		aux.setRg(funcionario.getRg());
		aux.setCpf(funcionario.getCpf());
		aux.setEndereco(funcionario.getEndereco());
		aux.setTelefone(funcionario.getTelefone());
		aux.setSalario(funcionario.getSalario());

		mane.getTransaction().commit();

		return true;

	}

	@Override
	public boolean excluirFuncionario(int id) {
		EntityManagerFactory em = Persistence
				.createEntityManagerFactory("BancoPostgres");
		EntityManager mane = em.createEntityManager();

		Funcionario temp = mane.getReference(Funcionario.class, id);
		mane.getTransaction().begin();

		mane.remove(temp);
		mane.getTransaction().commit();
		mane.close();

		return true;

	}

	@Override
	public Funcionario buscarFuncionario(int id) {
		EntityManagerFactory em = Persistence
				.createEntityManagerFactory("BancoPostgres");
		EntityManager mane = em.createEntityManager();

		mane.getTransaction().begin();

		Funcionario temp = mane.find(Funcionario.class, id);

		mane.getTransaction().commit();
		mane.close();
		return temp;

	}

}
