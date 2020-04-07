package br.com.fiap.restauranteapp.vo;

public class RestauranteVO {

	private CategoriaVO categoria;
	private int idRestaurante;
	private String nome;
	private String uf;
	private int totalAvaliacao;
	private int totalPedidos;
	
	public CategoriaVO getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaVO categoria) {
		this.categoria = categoria;
	}
	public int getIdRestaurante() {
		return idRestaurante;
	}
	public void setIdRestaurante(int idRestaurante) {
		this.idRestaurante = idRestaurante;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public int getTotalAvaliacao() {
		return totalAvaliacao;
	}
	public void setTotalAvaliacao(int totalAvaliacao) {
		this.totalAvaliacao = totalAvaliacao;
	}
	public int getTotalPedidos() {
		return totalPedidos;
	}
	public void setTotalPedidos(int totalPedidos) {
		this.totalPedidos = totalPedidos;
	}
	
}
