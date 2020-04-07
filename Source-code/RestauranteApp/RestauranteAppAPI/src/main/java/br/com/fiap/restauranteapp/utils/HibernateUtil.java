package br.com.fiap.restauranteapp.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.fiap.restauranteapp.bd.connection.HibernateConnection;

public class HibernateUtil {

	public static Session openSession() throws HibernateException {

		Session session = null;

		try {
			session = HibernateConnection.getSessionFactory().openSession();
		} catch (HibernateException e) {
			System.out.println("Houve erro ao recuperar session. Erro: " + e.getMessage());
		}

		return session;
	}

	public static void closeSession(Session session) {

		try {
			if (session.isOpen()) {
				session.close();
			}
		} catch (Throwable e) {
			System.out.println("Erro ao fechar a operação. Mensagem:" + e.getMessage());
		}

	}

	public static Transaction initTransaction(Session session) {
		return session.beginTransaction();
	}

	public static void commitTransaction(Transaction transaction) {
		transaction.commit();
	}

	public static void rollbackTransaction(Transaction transaction) {
		transaction.rollback();
	}

}
