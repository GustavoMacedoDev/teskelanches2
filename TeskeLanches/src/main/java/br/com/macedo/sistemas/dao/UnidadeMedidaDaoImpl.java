package br.com.macedo.sistemas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.macedo.sistemas.domain.UnidadeMedida;

@Repository
@Transactional
public class UnidadeMedidaDaoImpl implements UnidadeMedidaDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void salvar(UnidadeMedida medida) {
		entityManager.persist(medida);
	}

	@Override
	public void editar(UnidadeMedida medida) {
		entityManager.merge(medida);
	}

	@Override
	public void excluir(Long id) {
		entityManager.remove(entityManager.getReference(UnidadeMedida.class, id));
		
	}

	@Transactional(readOnly = true)
	@Override
	public UnidadeMedida getId(Long id) {
		String jpql = "from UnidadeMedida u where u.id = :id";
        TypedQuery<UnidadeMedida> query = entityManager.createQuery(jpql, UnidadeMedida.class);
        query.setParameter("id", id);
        return query.getSingleResult();
	}

	@Override
	@Transactional(readOnly = true)
	public List<UnidadeMedida> getTodos() {
		String jpql = "from UnidadeMedida u";
		TypedQuery<UnidadeMedida> query = entityManager.createQuery(jpql, UnidadeMedida.class);
		
		return query.getResultList();
		
	}

	@Override
	public List<UnidadeMedida> getByName(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
