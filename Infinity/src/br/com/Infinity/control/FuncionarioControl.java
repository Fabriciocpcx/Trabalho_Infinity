package br.com.Infinity.control;

import br.com.Infinity.model.Cliente;
import br.com.Infinity.model.Funcionario;

public interface FuncionarioControl {

	public boolean cadastrarFuncionario(Funcionario funcionario);

	public boolean alterarFuncionario(Funcionario funcionario, int id);

	public boolean excluirFuncionario(int id);
	
	public Funcionario buscarFuncionario(int id);
	
	

}
