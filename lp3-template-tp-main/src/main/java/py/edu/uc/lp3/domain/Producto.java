package py.edu.uc.lp3.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long id; //cod que tienen las mercaderias
	private Long cantidad;
	private Long precio;
	private Float peso;
	private String tipoProducto;
	protected String origen; // donde se creo, asi se sabe a que convenio pertenece
	protected String destino;
	


	public Producto(Long id, Long cantidad, Long precio, Float peso, String tipoProducto, String origen,
			String destino) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.precio = precio;
		this.peso = peso;
		this.tipoProducto = tipoProducto;
		this.origen = origen;
		this.destino = destino;
	}



	public Producto() {
		// TODO Auto-generated constructor stub
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getCantidad() {
		return cantidad;
	}



	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}



	public Long getPrecio() {
		return precio;
	}



	public void setPrecio(Long precio) {
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



	public static long getSerialversionuid() {
		return serialVersionUID;
	}




}
