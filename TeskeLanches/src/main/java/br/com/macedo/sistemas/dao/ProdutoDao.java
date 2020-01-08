package br.com.macedo.sistemas.dao;

import java.util.List;

import br.com.macedo.sistemas.domain.Produto;


public interface ProdutoDao {

	void salvar(Produto produto);
	
	void editar(Produto produto);
	
	void inativa(Long id);
	
	Produto getId(Long id);
	
	List<Produto> getTodos();
	
}
