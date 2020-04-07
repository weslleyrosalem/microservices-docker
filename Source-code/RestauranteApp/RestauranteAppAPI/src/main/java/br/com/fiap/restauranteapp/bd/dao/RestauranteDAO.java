package br.com.fiap.restauranteapp.bd.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.fiap.restauranteapp.utils.HibernateUtil;
import br.com.fiap.restauranteapp.vo.CategoriaVO;
import br.com.fiap.restauranteapp.vo.RestauranteVO;

public class RestauranteDAO extends GenericDAO {
	
	private static String queryConsultarRestauranteCategoria = new StringBuilder()
				.append("  select r.id_restaurante                 ")
				.append("        ,r.nome                           ")
				.append("        ,c.descricao                      ")
				.append("        ,r.uf                             ")
				.append("        ,r.total_avaliacao                ")
				.append("        ,r.total_pedido                   ")
				.append("    from restaurant.restaurante r         ")
				.append("        ,restaurant.categoria c           ")
				.append("   where r.id_categoria = c.id_categoria  ")
				.append("     and c.id_categoria = :idCategoria    ")
				.toString();
	
	private static String queryConsultarTodosRestauranteCategoria = new StringBuilder()
			.append("  select r.id_restaurante                 ")
			.append("        ,r.nome                           ")
			.append("        ,r.id_categoria                   ")
			.append("        ,c.descricao                      ")
			.append("        ,r.uf                             ")
			.append("        ,r.total_avaliacao                ")
			.append("        ,r.total_pedido                   ")
			.append("    from restaurant.restaurante r         ")
			.append("        ,restaurant.categoria c           ")
			.append("   where r.id_categoria = c.id_categoria  ")
			.toString();
	
	public List<RestauranteVO> consultarRestaurante(short categoria){
		
		System.out.println("Inicio do metodo consultarRestaurante - RestauranteDAO"); 
		
		List<Object[]> listQuery = new ArrayList();
		List<RestauranteVO> listRestaurante = new ArrayList();
		
		RestauranteVO restauranteVO = null;
		CategoriaVO categoriaVO = null;
		
		Session session = HibernateUtil.openSession();
		
		try {
			
			Query query = session.createSQLQuery(queryConsultarRestauranteCategoria);
			query.setParameter("idCategoria", categoria);
			
			listQuery = (List<Object[]>) query.list();
			
			for(Object object[] : listQuery) {
				
				categoriaVO = new CategoriaVO();
				
				categoriaVO.setIdCategoria(categoria);
				categoriaVO.setDescricao(object[2].toString());
				
				restauranteVO = new RestauranteVO();
				
				restauranteVO.setCategoria(categoriaVO);
				restauranteVO.setIdRestaurante((int) object[0]);
				restauranteVO.setNome(object[1].toString());
				restauranteVO.setUf(object[3].toString());
				restauranteVO.setTotalAvaliacao((int) object[4]);
				restauranteVO.setTotalPedidos((int) object[5]);
				
				listRestaurante.add(restauranteVO);
				
			}
			
		} catch(HibernateException e) {
			
			e.printStackTrace();
			System.out.println("Não foi possível listar. Erro:" + e.getMessage());
			
		} finally {
			HibernateUtil.closeSession(session);
			System.out.println("Final do metodo consultarRestaurante - RestauranteDAO");
		}
		
		return listRestaurante;
		
	}
	
	public List<RestauranteVO> consultarTodosRestaurantes(){
		
		System.out.println("Inicio do metodo consultarTodosRestaurantes - RestauranteDAO"); 
		
		List<Object[]> listQuery = new ArrayList();
		List<RestauranteVO> listRestaurante = new ArrayList();
		
		RestauranteVO restauranteVO = null;
		CategoriaVO categoriaVO = null;
		
		Session session = HibernateUtil.openSession();
		
		try {
			
			Query query = session.createSQLQuery(queryConsultarTodosRestauranteCategoria);
			
			listQuery = (List<Object[]>) query.list();
			
			for(Object object[] : listQuery) {
				
				categoriaVO = new CategoriaVO();
				
				categoriaVO.setIdCategoria(Short.parseShort(Byte.toString((byte)object[2])));
				categoriaVO.setDescricao(object[3].toString());
				
				restauranteVO = new RestauranteVO();
				
				restauranteVO.setCategoria(categoriaVO);
				restauranteVO.setIdRestaurante((int) object[0]);
				restauranteVO.setNome(object[1].toString());
				restauranteVO.setUf(object[4].toString());
				restauranteVO.setTotalAvaliacao((int) object[5]);
				restauranteVO.setTotalPedidos((int) object[6]);
				
				listRestaurante.add(restauranteVO);
				
			}
			
		} catch(HibernateException e) {
			
			e.printStackTrace();
			System.out.println("Não foi possível listar. Erro:" + e.getMessage());
			
		} finally {
			HibernateUtil.closeSession(session);
			System.out.println("Final do metodo consultarTodosRestaurantes - RestauranteDAO");
		}
		
		return listRestaurante;
		
	}
	
}
