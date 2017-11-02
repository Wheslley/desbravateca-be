package br.com.sisbrava.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sisbrava.bean.PessoaPossuiEspecialidade;
import br.com.sisbrava.interfaces.crud.ICrud;
import br.com.sisbrava.utilidades.JPAUtilMySql;

public class PessoaPossuiEspecialidadeRepository implements ICrud{
	
	public static PessoaPossuiEspecialidadeRepository instance;

	public static PessoaPossuiEspecialidadeRepository getInstance() {
		if (PessoaPossuiEspecialidadeRepository.instance == null)
			PessoaPossuiEspecialidadeRepository.instance = new PessoaPossuiEspecialidadeRepository();
		return PessoaPossuiEspecialidadeRepository.instance;
	}
	
	@Override
	public void insert(Object object) {

		PessoaPossuiEspecialidade ppespecialidade = (PessoaPossuiEspecialidade) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.persist(ppespecialidade);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void update(Object object) {

		PessoaPossuiEspecialidade ppespecialidade = (PessoaPossuiEspecialidade) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.merge(ppespecialidade);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void delete(Object object) {

		PessoaPossuiEspecialidade ppespecialidade = (PessoaPossuiEspecialidade) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.remove(em.getReference(PessoaPossuiEspecialidade.class, ppespecialidade.getId()));
		em.getTransaction().commit();
		em.close();

	}
	
	public Object getSelectOneObject(Integer id) {
		
		PessoaPossuiEspecialidade ppespecialidade = new PessoaPossuiEspecialidade();
		
		try {
			EntityManager em = new JPAUtilMySql().getEntityManager();
			em.getTransaction().begin();
			ppespecialidade = em.find(PessoaPossuiEspecialidade.class, id);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return ppespecialidade;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> selectMultiplusObjects(String table) {

		String strQuery = "SELECT u FROM " + table + " u";

		EntityManager em = new JPAUtilMySql().getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		Query query = em.createQuery(strQuery);

		List<Object> objetos = query.getResultList();

		tx.commit();

		return objetos;

	}
}
