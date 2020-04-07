package br.com.fiap.restauranteapp.bd.connection;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateConnection {

	private static final SessionFactory sessionFactory = realizarConnection();
	
	private static SessionFactory realizarConnection() throws HibernateException{ 
		
		try{
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			return cfg.buildSessionFactory();
			
		} catch (HibernateException e){
			System.out.println("Erro de conexão ao banco:" + e);
			throw e;
		}
	}

	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
}
