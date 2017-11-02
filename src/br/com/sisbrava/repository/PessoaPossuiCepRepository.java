package br.com.sisbrava.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sisbrava.bean.PessoaPossuiCep;
import br.com.sisbrava.interfaces.crud.ICrud;
import br.com.sisbrava.utilidades.JPAUtilMySql;

public class PessoaPossuiCepRepository implements ICrud{
	
	public static PessoaPossuiCepRepository instance;

	public static PessoaPossuiCepRepository getInstance() {
		if (PessoaPossuiCepRepository.instance == null)
			PessoaPossuiCepRepository.instance = new PessoaPossuiCepRepository();
		return PessoaPossuiCepRepository.instance;
	}
	
	@Override
	public void insert(Object object) {

		PessoaPossuiCep ppCep = (PessoaPossuiCep) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.persist(ppCep);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void update(Object object) {

		PessoaPossuiCep ppCep = (PessoaPossuiCep) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.merge(ppCep);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void delete(Object object) {

		PessoaPossuiCep ppCep = (PessoaPossuiCep) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.remove(em.getReference(PessoaPossuiCep.class, ppCep.getId()));
		em.getTransaction().commit();
		em.close();

	}
	
	public Object getSelectOneObject(Integer id) {
		
		PessoaPossuiCep ppCep = new PessoaPossuiCep();
		
		try {
			EntityManager em = new JPAUtilMySql().getEntityManager();
			em.getTransaction().begin();
			ppCep = em.find(PessoaPossuiCep.class, id);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return ppCep;
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
