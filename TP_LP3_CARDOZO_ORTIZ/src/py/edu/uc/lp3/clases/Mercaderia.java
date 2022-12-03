package py.edu.uc.lp3.clases;

public class Mercaderia {
	/*Datos basicos y necesarios,como una descripcion, de las mercaderias */
	public Integer idMercaderia; //cod que tienen las mercaderias
	public Integer cantidad;
	public Integer precio;
	public Float peso;
	public String tipoMercaderia;
	public String origen; // donde se creo, asi se sabe a que convenio pertenece
	public String destino;
	
	
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
	public String getTipoMercaderia() {
		return tipoMercaderia;
	}
	public void setTipoMercaderia(String tipoMercaderia) {
		this.tipoMercaderia = tipoMercaderia;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
}
