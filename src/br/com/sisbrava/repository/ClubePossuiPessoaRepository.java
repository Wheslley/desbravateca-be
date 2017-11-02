package br.com.sisbrava.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sisbrava.bean.ClubePossuiPessoa;
import br.com.sisbrava.interfaces.crud.ICrud;
import br.com.sisbrava.utilidades.JPAUtilMySql;

public class ClubePossuiPessoaRepository implements ICrud {
	
	public static ClubePossuiPessoaRepository instance;

	public static ClubePossuiPessoaRepository getInstance() {
		if (ClubePossuiPessoaRepository.instance == null)
			ClubePossuiPessoaRepository.instance = new ClubePossuiPessoaRepository();
		return ClubePossuiPessoaRepository.instance;
	}
	
	@Override
	public void insert(Object object) {

		ClubePossuiPessoa cppessoa = (ClubePossuiPessoa) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.persist(cppessoa);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void update(Object object) {

		ClubePossuiPessoa cppessoa = (ClubePossuiPessoa) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.merge(cppessoa);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void delete(Object object) {

		ClubePossuiPessoa cppessoa = (ClubePossuiPessoa) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.remove(em.getReference(ClubePossuiPessoa.class, cppessoa.getId()));
		em.getTransaction().commit();
		em.close();

	}
	
	public Object getSelectOneObject(Integer id) {
		
		ClubePossuiPessoa cppessoa = new ClubePossuiPessoa();
		
		try {
			EntityManager em = new JPAUtilMySql().getEntityManager();
			em.getTransaction().begin();
			cppessoa = em.find(ClubePossuiPessoa.class, id);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return cppessoa;
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
