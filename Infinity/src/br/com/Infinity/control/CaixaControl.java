package br.com.Infinity.control;

import br.com.Infinity.model.Caixa;

public interface CaixaControl {

	public boolean alterarCaixa(Caixa caixa);
	public boolean iniciarCaixa(Caixa caixa);
	public Caixa buscarCaixa(int id);
	public boolean buscarInicializar(int id);
	
}
