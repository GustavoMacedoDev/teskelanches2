package br.com.macedo.sistemas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.macedo.sistemas.domain.ItensPedido;


@Repository
@Transactional
public class ItensPedidoDaoImpl implements ItensPedidoDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void salvar(ItensPedido itensPedido) {
		entityManager.persist(itensPedido);
		
	}

	@Override
	public void editar(ItensPedido itensPedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inativa(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ItensPedido getId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItensPedido> getTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
