package br.com.fiap.restauranteapp.bd.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class GenericDAO {

	protected void include(Object object, Session session) {
		
		try {
			session.save(object);
		} catch (HibernateException e) {
			System.out.println("Não foi possível inserir - Classe/Entity: "+ object.getClass().getName() +". Erro:" + e.getMessage());
		}
	}
	
	protected void update(Object object, Session session) {
		
		try {
			session.update(object);
		} catch (HibernateException e) {
			System.out.println("Não foi possível atualizar - Classe/Entity: "+ object.getClass().getName() +". Erro:" + e.getMessage());
		}
	}
	
	protected void delete(Object object, Session session) {
		
		try {
			session.delete(object);
		} catch (HibernateException e) {
			System.out.println("Não foi possível deletar - Classe/Entity: "+ object.getClass().getName() +". Erro:" + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	protected <T> List<T> getList(Object object, Session session) {
		
		List<T> listaObject = new ArrayList<T>();
		
		try {
			
			Query query = session.createQuery("from " + object.getClass().getName());
			
			listaObject =  query.list();
			
		} catch (HibernateException e) {
			System.out.println("Não foi possível listar. Erro:" + e.getMessage());
		} 		
		return listaObject;
	}
	
}
