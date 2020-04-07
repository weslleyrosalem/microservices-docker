package br.com.fiap.restauranteapp.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.fiap.restauranteapp.factory.DAOFactory;
import br.com.fiap.restauranteapp.vo.ErrorInfo;
import br.com.fiap.restauranteapp.vo.RestauranteVO;

@Path("/")
public class RestaurantApi {
	
	private static Logger LOGGER = Logger.getLogger(RestaurantApi.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/api/listRestaurants")
	public Response listRestaurants(@Context HttpHeaders httpHeaders, @QueryParam("categoria") String categoriaEntrada) {
		
		LOGGER.info("inicio do metodo listRestaurants()");
		
		Response retorno = null;
		
		JSONObject jsonSaida = new JSONObject();
		
		List<RestauranteVO> listRestauranteVO = new ArrayList<RestauranteVO>();
		
		short categoria = -1;
		
		try {
			
			if(categoriaEntrada != null) {
			
				try {
					
					categoria = Short.parseShort(categoriaEntrada);
					
				} catch(JSONException e) {
					
					LOGGER.info("idCategoria nao informado !!");
					
				}
			}
			
			if(categoria > 0) {
			
				listRestauranteVO = DAOFactory.getRestauranteDAO().consultarRestaurante(categoria);
			
			} else {
			
				listRestauranteVO = DAOFactory.getRestauranteDAO().consultarTodosRestaurantes();
			
			}
			
			ResponseBuilder rb = Response.status(Status.OK);
			
			if(listRestauranteVO.size() > 0) {
						
				jsonSaida.put("restaurante",  new JSONArray(listRestauranteVO));
				
				rb.entity(jsonSaida.toString());
			
			} else {
				
				jsonSaida.put("descricao", "Nenhum restaurante encontrado");
				
				rb.entity(jsonSaida.toString());
				
			}
			
			retorno = rb.build();
						
		} catch(Exception e) {
			
			LOGGER.info("erro..: " + e.getMessage());
			LOGGER.error("erro..: ", e);
			
			ResponseBuilder rb = Response.status(Status.INTERNAL_SERVER_ERROR);

			ErrorInfo ei = new ErrorInfo();
			ei.setCode("6000");
			ei.setField("");
			ei.setMessage("Erro interno");
			
	        rb.entity(ei);
	        
	        retorno = rb.build();
			
		} finally {
			
			LOGGER.info("final do metodo listRestaurants()");
			
		}
		
		return retorno;
		
	}
	
}
