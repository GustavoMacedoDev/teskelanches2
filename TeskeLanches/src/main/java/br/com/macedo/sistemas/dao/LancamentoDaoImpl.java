package br.com.macedo.sistemas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.macedo.sistemas.domain.Lancamento;
import br.com.macedo.sistemas.domain.Mesa;

@Repository
@Transactional
public class LancamentoDaoImpl implements LancamentoDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void salvar(Lancamento lancamento) {
		entityManager.persist(lancamento);
		
	}

	@Override
	public void editar(Lancamento lancamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inativa(Long id) {
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
	@Transactional(readOnly = true)
	public List<Lancamento> getByMesa(Long id) {
		String jpql = "select l from Lancamento l where l.mesa.id = :id";
		TypedQuery<Lancamento> query = entityManager.createQuery(jpql, Lancamento.class);
		query.setParameter("id", id);
		return query.getResultList();
	}

}
