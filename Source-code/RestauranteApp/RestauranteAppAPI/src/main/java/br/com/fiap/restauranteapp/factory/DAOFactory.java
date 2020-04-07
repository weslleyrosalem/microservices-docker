package br.com.fiap.restauranteapp.factory;

import br.com.fiap.restauranteapp.bd.dao.RestauranteDAO;

public class DAOFactory {

	private static RestauranteDAO restauranteDAO;
	
	public static RestauranteDAO getRestauranteDAO() {
		
		if(restauranteDAO == null){
			restauranteDAO = new RestauranteDAO(); 
		}
		
		return restauranteDAO;
	}
}
