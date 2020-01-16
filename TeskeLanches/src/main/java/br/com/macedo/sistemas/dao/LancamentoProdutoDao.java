package br.com.macedo.sistemas.dao;

import java.util.List;

import br.com.macedo.sistemas.domain.LancamentoProduto;

public interface LancamentoProdutoDao {

	void salvar(LancamentoProduto lancamentoProduto);
	
	void editar(LancamentoProduto lancamentoProduto);
	
	void inativa(Long id);
	
	LancamentoProduto getId(Long id);
	
	List<LancamentoProduto> getTodos();
	
}
