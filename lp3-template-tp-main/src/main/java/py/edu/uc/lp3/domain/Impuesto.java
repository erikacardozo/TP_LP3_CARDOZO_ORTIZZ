package py.edu.uc.lp3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Impuesto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	public Long id; 
	private String nombre;
	public Float porcentaje;
	
	
	public Impuesto() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Float getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(Float porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	
	
}
