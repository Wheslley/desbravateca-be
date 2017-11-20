package br.com.sisbrava.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sisbrava.bean.PessoaPossuiClasse;
import br.com.sisbrava.interfaces.crud.ICrud;
import br.com.sisbrava.utilidades.JPAUtilMySql;

public class PessoaPossuiClasseRepository implements ICrud {
	
	public static PessoaPossuiClasseRepository instance;

	public static PessoaPossuiClasseRepository getInstance() {
		if (PessoaPossuiClasseRepository.instance == null)
			PessoaPossuiClasseRepository.instance = new PessoaPossuiClasseRepository();
		return PessoaPossuiClasseRepository.instance;
	}
	
	@Override
	public void insert(Object object) {

		PessoaPossuiClasse ppclasse = (PessoaPossuiClasse) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.persist(ppclasse);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void update(Object object) {

		PessoaPossuiClasse ppclasse = (PessoaPossuiClasse) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.merge(ppclasse);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void delete(Object object) {

		PessoaPossuiClasse ppclasse = (PessoaPossuiClasse) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.remove(em.getReference(PessoaPossuiClasse.class, ppclasse.getId()));
		em.getTransaction().commit();
		em.close();

	}
	
	public Object getSelectOneObject(Integer id) {
		
		PessoaPossuiClasse ppclasse = new PessoaPossuiClasse();
		
		try {
			EntityManager em = new JPAUtilMySql().getEntityManager();
			em.getTransaction().begin();
			ppclasse = em.find(PessoaPossuiClasse.class, id);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return ppclasse;
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
