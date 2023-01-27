package py.edu.uc.lp3.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import py.edu.uc.lp3.repository.ProductoRepository;

@Entity
@Table(name="tablaProducto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long id; //cod que tienen las mercaderias
	private Long cantidad;
	private Long precio;
	private Float peso;
	private String tipoProducto;
	private String origen; // donde se creo, asi se sabe a que convenio pertenece
	private String destino;
	
	/*@OneToMany
	@PrimaryKeyJoinColumn(referencedColumnName = "id")
	public List<Impuesto> impuestoo;
	
	@OneToMany
	@PrimaryKeyJoinColumn(referencedColumnName = "id")
	private List<Transporte> transportee;
	
	

	public List<Transporte> getTransportee() {
		return transportee;
	}


	public void setTransportee(List<Transporte> transportee) {
		this.transportee = transportee;
	}


	public List<Impuesto> getImpuestoo() {
		return impuestoo;
	}


	public void setImpuestoo(List<Impuesto> impuestoo) {
		this.impuestoo = impuestoo;
		//System.out.printf("nombre ok %f",impuestoo.porcentaje);
	}*/
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	/*public Producto(Long id, Long cantidad, Long precio, Float peso, String tipoProducto, String origen, String destino,
			float impuestoo) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.precio = precio;
		this.peso = peso;
		this.tipoProducto = tipoProducto;
		this.origen = origen;
		this.destino = destino;
		this.impuestoo = impuestoo;
	}*/

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
