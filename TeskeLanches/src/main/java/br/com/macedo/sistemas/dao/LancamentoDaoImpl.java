package br.com.macedo.sistemas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.macedo.sistemas.domain.Lancamento;

@Repository
@Transactional
public class LancamentoDaoImpl implements LancamentoDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void salvar(Lancamento lancamento) {
		entityManager.merge(lancamento);
	}

	@Override
	public void editar(Lancamento lancamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Lancamento getId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lancamento> getTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lancamento> getByName(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
