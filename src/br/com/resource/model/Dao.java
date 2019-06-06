package br.com.resource.model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.resource.hibernate.config.HibernateConfig;

public class Dao {
	
	public static <T> void salvar(T entidade) {
		Transaction transaction = null;
		
		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			transaction = session.getTransaction();
			transaction.begin();
			
			session.save(entidade);
			
			transaction.commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> listarTodos(Class<T> entidade) {
		Transaction transaction = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()){
			List<T> entidades;
			
			transaction = session.getTransaction();
			transaction.begin();
			
			
			entidades = session.createQuery("FROM "+entidade.getName()).getResultList();
			
			transaction.commit();
			session.close();

			return entidades;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static <T> T buscarPorId(int id, Class<T> entidade) {
		Transaction transaction = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()){
			T objeto = null;
			
			transaction = session.getTransaction();
			transaction.begin();
			
			objeto = session.find(entidade, id);			
			
			transaction.commit();
			session.close();

			return objeto;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
