package br.com.sisbrava.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sisbrava.bean.Cargo;
import br.com.sisbrava.interfaces.crud.ICrud;
import br.com.sisbrava.utilidades.JPAUtilMySql;

public class CargoRepository implements ICrud {
	
	public static CargoRepository instance;

	public static CargoRepository getInstance() {
		if (CargoRepository.instance == null)
			CargoRepository.instance = new CargoRepository();
		return CargoRepository.instance;
	}
	
	@Override
	public void insert(Object object) {

		Cargo cargo = (Cargo) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.persist(cargo);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void update(Object object) {

		Cargo cargo = (Cargo) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.merge(cargo);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void delete(Object object) {

		Cargo cargo = (Cargo) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.remove(em.getReference(Cargo.class, cargo.getId()));
		em.getTransaction().commit();
		em.close();

	}
	
	public Object getSelectOneObject(Integer id) {
		
		Cargo cargo = new Cargo();
		
		try {
			EntityManager em = new JPAUtilMySql().getEntityManager();
			em.getTransaction().begin();
			cargo = em.find(Cargo.class, id);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return cargo;
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
