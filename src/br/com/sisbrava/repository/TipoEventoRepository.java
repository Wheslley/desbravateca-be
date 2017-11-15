package br.com.sisbrava.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sisbrava.bean.TipoEvento;
import br.com.sisbrava.interfaces.crud.ICrud;
import br.com.sisbrava.utilidades.JPAUtilMySql;

public class TipoEventoRepository implements ICrud {

	public static TipoEventoRepository instance;

	public static TipoEventoRepository getInstance() {
		if (TipoEventoRepository.instance == null)
			TipoEventoRepository.instance = new TipoEventoRepository();
		return TipoEventoRepository.instance;
	}
	
	@Override
	public void insert(Object object) {

		TipoEvento tipoEvento = (TipoEvento) object;	
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.persist(tipoEvento);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void update(Object object) {

		TipoEvento tipoEvento = (TipoEvento) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.merge(tipoEvento);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void delete(Object object) {

		TipoEvento tipoEvento = (TipoEvento) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.remove(em.getReference(TipoEvento.class, tipoEvento.getId()));
		em.getTransaction().commit();
		em.close();

	}
	
	public Object getSelectOneObject(Integer id) {
		
		TipoEvento tipoEvento = new TipoEvento();
		
		try {
			EntityManager em = new JPAUtilMySql().getEntityManager();
			em.getTransaction().begin();
			tipoEvento = em.find(TipoEvento.class, id);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return tipoEvento;
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
