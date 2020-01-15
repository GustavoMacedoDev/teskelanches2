package br.com.macedo.sistemas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.macedo.sistemas.domain.Produto;
import br.com.macedo.sistemas.domain.Produto.Categoria;

@Repository
@Transactional
public class ProdutoDaoImpl implements ProdutoDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void salvar(Produto produto) {
		entityManager.persist(produto);
		
	}

	@Override
	public void editar(Produto produto) {
		entityManager.merge(produto);
		
	}

	@Override
	public void inativa(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Transactional(readOnly = true)
	@Override
	public Produto getId(Long id) {
		String jpql = "from Produto p where p.id = :id";
        TypedQuery<Produto> query = entityManager.createQuery(jpql, Produto.class);
        query.setParameter("id", id);
        return query.getSingleResult();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Produto> getTodos() {
		String jpql = "from Produto p order by id asc";
		TypedQuery<Produto> query = entityManager.createQuery(jpql, Produto.class);
		return query.getResultList();
	}


	@Override
	public List<Produto> getByCategoria(Categoria categoria) {
		String jpql = "select p from Produto p where p.categoria = :categoria";
		TypedQuery<Produto> query = entityManager.createQuery(jpql, Produto.class);
		query.setParameter("categoria", categoria);
		return query.getResultList();
	}

}
