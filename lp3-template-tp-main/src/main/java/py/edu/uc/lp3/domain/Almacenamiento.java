package py.edu.uc.lp3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="almaceNEW")
public class Almacenamiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long id; // id almacenamiento
	private String tipoAlmacenamiento;// tipo de almacenamiento
	private String capacidad;//capacidad maxima
	private Long honorarios;//honorario
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipoAlmacenamiento() {
		return tipoAlmacenamiento;
	}
	public void setTipoAlmacenamiento(String tipoTransporte) {
		this.tipoAlmacenamiento = tipoTransporte;
	}
	public String getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}
	public Long getHonorarios() {
		return honorarios;
	}
	public void setHonorarios(Long honorarios) {
		this.honorarios = honorarios;
	}

}
