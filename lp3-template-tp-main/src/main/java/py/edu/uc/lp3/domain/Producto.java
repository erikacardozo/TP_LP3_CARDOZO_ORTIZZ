package py.edu.uc.lp3.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name="tablaProducto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long id; 
	private Long cantidad; //cantidad del producto
	private Long precio; //precio por unidad del producto
	private Float peso; //peso en kg de los productos
	private String tipoProducto; //tipo de producto (IMPRESO,TEXTIL,MATERIALES PARA IMPRESION,ETC)
	private String origen; // donde se creo, asi se sabe a que convenio pertenece
	private String destino; //a donde va, asi se sabe a que convenio pertenece
	
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(Long id, Long cantidad, Long precio, Float peso, String tipoProducto, String origen, String destino) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.precio = precio;
		this.peso = peso;
		this.tipoProducto = tipoProducto;
		this.origen = origen;
		this.destino = destino;
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







}
