package py.edu.uc.lp3.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Organizaciones {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long IDOrg;
	private String tipoDeOrganizacion;
	private String descripcion;
	public Organizaciones() {
		// TODO Auto-generated constructor stub
	}
	
	public Organizaciones(String tipoDeOrganizacion, String descripcion) {
		super();
		this.tipoDeOrganizacion=tipoDeOrganizacion;
		this.descripcion=descripcion;
	}
	
	public Long getIDOrg() {
		return IDOrg;
	}
	public void setIDOrg(Long iDOrg) {
		IDOrg = iDOrg;
	}
	public String getTipoDeOrganizacion() {
		return tipoDeOrganizacion;
	}
	public void setTipoDeOrganizacion(String tipoDeOrganizacion) {
		this.tipoDeOrganizacion = tipoDeOrganizacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
