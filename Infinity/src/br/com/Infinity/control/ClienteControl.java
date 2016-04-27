package br.com.Infinity.control;

import br.com.Infinity.model.Cliente;

public interface ClienteControl {

	public boolean cadastrarCliente(Cliente cliente);

	public boolean alterarCliente(Cliente cliente, int id);

	public boolean excluirCliente(int id);
	
	public Cliente buscarCliente(int id);

}
