package br.com.fiap.restauranteapp.api;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

public class Servico extends Application {

	private Set<Object> singletons = new HashSet<Object>();

	private Set<Class<?>> empty = new HashSet<Class<?>>();

	public Servico() {
		singletons.add(new RestaurantApi());
	}

	public Set<Object> getSingletons() {
		return singletons;
	}

	public Set<Class<?>> getEmpty() {
		return empty;
	}

}