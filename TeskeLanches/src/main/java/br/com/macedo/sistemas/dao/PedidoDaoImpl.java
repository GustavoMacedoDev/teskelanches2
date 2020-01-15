package br.com.macedo.sistemas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.macedo.sistemas.domain.Pedido;
@Repository
@Transactional
public class PedidoDaoImpl implements PedidoDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void salvar(Pedido pedido) {
		entityManager.persist(pedido);
		
	}

	@Override
	public void editar(Pedido pedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inativa(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pedido getId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> getTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
