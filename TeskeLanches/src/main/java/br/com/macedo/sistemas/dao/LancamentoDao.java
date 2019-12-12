package br.com.macedo.sistemas.dao;

import java.util.List;

import br.com.macedo.sistemas.domain.Lancamento;

public interface LancamentoDao {

	void salvar(Lancamento lancamento);
	
	void editar(Lancamento lancamento);
	
	void excluir(Long id);
	
	Lancamento getId(Long id);
	
	List<Lancamento> getTodos();
	
	List<Lancamento> getByName(String nome);
	
	List<Lancamento> getByMesa(Long id);
	
	List<Lancamento> getByBebida(Long id);
}
