package br.com.Infinity.control;

import br.com.Infinity.model.Cliente;
import br.com.Infinity.model.Mercadoria;

public interface PagamentoControl {
	
	public void buscarCliente(Cliente cliente);
	
	public void listarProdutos(Mercadoria mercadorias);
	
	public void pagamento(Mercadoria mercadoria);
	

}
