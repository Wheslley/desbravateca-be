package br.com.sisbrava.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sisbrava.bean.Especialidades;
import br.com.sisbrava.interfaces.crud.ICrud;
import br.com.sisbrava.utilidades.JPAUtilMySql;

public class EspecialidadesRepository implements ICrud{

	public static EspecialidadesRepository instance;

	public static EspecialidadesRepository getInstance() {
		if (EspecialidadesRepository.instance == null)
			EspecialidadesRepository.instance = new EspecialidadesRepository();
		return EspecialidadesRepository.instance;
	}
	
	@Override
	public void insert(Object object) {

		Especialidades especialidade = (Especialidades) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.persist(especialidade);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void update(Object object) {

		Especialidades especialidade = (Especialidades) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.merge(especialidade);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void delete(Object object) {

		Especialidades especialidade = (Especialidades) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.remove(em.getReference(Especialidades.class, especialidade.getId()));
		em.getTransaction().commit();
		em.close();

	}
	
	public Object getSelectOneObject(Integer id) {
		
		Especialidades especialidade = new Especialidades();
		
		try {
			EntityManager em = new JPAUtilMySql().getEntityManager();
			em.getTransaction().begin();
			especialidade = em.find(Especialidades.class, id);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return especialidade;
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
