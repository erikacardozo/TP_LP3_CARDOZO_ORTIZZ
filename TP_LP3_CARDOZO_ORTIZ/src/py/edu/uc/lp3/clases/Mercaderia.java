package py.edu.uc.lp3.clases;

public class Mercaderia {
	private Integer idMercaderia;
	private Integer cantidad;
	private Integer precio;
	private Float peso;
	private String tipoProducto;
	
	
	public Integer getIdMercaderia() {
		return idMercaderia;
	}
	public void setIdMercaderia(Integer idMercaderia) {
		this.idMercaderia = idMercaderia;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public Float getPeso() {
		return peso;
	}
	public void setPeso(Float peso) {
		this.peso = peso;
	}
	public String getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
}
