package br.com.Infinity.control;

import br.com.Infinity.model.Mercadoria;

public interface MercadoriaControl {

	public boolean cadastrarMercadoria(Mercadoria mercadoria);

	public boolean alterarMercadoria(Mercadoria mercadoria, int id);

	public boolean excluirMercadoria(int id);
	
	public Mercadoria buscarMercadoria(int id);

}
