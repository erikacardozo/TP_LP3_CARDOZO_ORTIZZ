package py.edu.uc.lp3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="presu")
public class Presupuesto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	
	private Long id;
	private Long honorariosTransporte; /*precio por servicio transporte respecto a su peso
	y tipo de transporte*/
	private Float tipoImpuestoPorcentaje;//el porcentaje del impuesto (IVA,ARANCEL,IRP,ETC)
	private Float finall; //monto final a pagar 
	
	public Presupuesto() {
		// TODO Auto-generated constructor stub
	}


	public Long getHonorariosTransporte() {
		return honorariosTransporte;
	}


	public void setHonorariosTransporte(Long honorariosTransporte) {
		this.honorariosTransporte = honorariosTransporte;
	}


	public Float getTipoImpuestoPorcentaje() {
		return tipoImpuestoPorcentaje;
	}


	public void setTipoImpuestoPorcentaje(Float tipoImpuestoPorcentaje) {
		this.tipoImpuestoPorcentaje = tipoImpuestoPorcentaje;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getFinall() {
		return finall;
	}

	public void setFinall(Float finall) {
		this.finall = finall;
	}
	
	
	
}
