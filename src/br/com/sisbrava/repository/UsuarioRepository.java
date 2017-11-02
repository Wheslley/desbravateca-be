package br.com.sisbrava.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sisbrava.bean.Usuario;
import br.com.sisbrava.interfaces.crud.ICrud;
import br.com.sisbrava.utilidades.JPAUtilMySql;

public class UsuarioRepository implements ICrud {

	public static UsuarioRepository instance;

	public static UsuarioRepository getInstance() {
		if (UsuarioRepository.instance == null)
			UsuarioRepository.instance = new UsuarioRepository();
		return UsuarioRepository.instance;
	}
	
	@Override
	public void insert(Object object) {

		Usuario usuario = (Usuario) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void update(Object object) {

		Usuario usuario = (Usuario) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void delete(Object object) {

		Usuario usuario = (Usuario) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.remove(em.getReference(Usuario.class, usuario.getId()));
		em.getTransaction().commit();
		em.close();

	}
	
	public Object getSelectOneObject(Integer id) {
		
		Usuario usuario = new Usuario();
		
		try {
			EntityManager em = new JPAUtilMySql().getEntityManager();
			em.getTransaction().begin();
			usuario = em.find(Usuario.class, id);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return usuario;
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
	
	@SuppressWarnings("unchecked")
	public boolean validateUsernamePassword(String usuario, String senha) {

		String strQuery = "SELECT u FROM Usuario u WHERE u.usuario = '" + usuario + "' AND u.senha = '" + senha + "'";

		EntityManager em = new JPAUtilMySql().getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		Query query = em.createQuery(strQuery);

		List<Object> objetos = query.getResultList();

		tx.commit();

		if (objetos.size() > 0)
			return true;
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Object> selectOneObjectPermissao(Integer permissao) {

		String strQuery = "SELECT u FROM Usuario u WHERE u.id_permissao = " + permissao;
		
		EntityManager em = new JPAUtilMySql().getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		Query query = em.createQuery(strQuery);

		List<Object> objetos = query.getResultList();

		tx.commit();

		return objetos;
		
	}

	public boolean deleteAll(String table) {

		EntityManager em = new JPAUtilMySql().getEntityManager();
		List<Object> lista = selectMultiplusObjects(table);

		try {

			for (Object o : lista) {
				Usuario usuario = (Usuario) o;
				em.getTransaction().begin();
				em.remove(em.getReference(Usuario.class, usuario.getId()));
				em.getTransaction().commit();
			}

			return true;

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		} finally {
			em.close();
		}

	}

}
