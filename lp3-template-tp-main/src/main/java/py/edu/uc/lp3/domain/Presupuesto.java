package py.edu.uc.lp3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="presuuNEW")
public class Presupuesto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	
	private Long id;// id presupuesto
	private Long tipoTransporte; /*precio por servicio transporte respecto a su peso y tipo de transporte*/
	private Long tipoImpuesto;//el porcentaje del impuesto (IVA,ARANCEL,IRP,ETC)
	private String origen;//origen producto
	private String destino;//destino producto
	private Long tipoAlmacenamiento;// almacenamiento, edifcio,container
	private Float TotalPresupuesto; //monto final a pagar 
	
	public Presupuesto() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Float getTotalPresupuesto() {
		return TotalPresupuesto;
	}

	public void setTotalPresupuesto(Float totalPresupuesto) {
		TotalPresupuesto = totalPresupuesto;
	}

	public Long getTipoImpuesto() {
		return tipoImpuesto;
	}

	public void setTipoImpuesto(Long tipoImpuesto) {
		this.tipoImpuesto = tipoImpuesto;
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


	public Long getTipoAlmacenamiento() {
		return tipoAlmacenamiento;
	}

	public void setTipoAlmacenamiento(Long tipoAlmacenamiento) {
		this.tipoAlmacenamiento = tipoAlmacenamiento;
	}

	public Long getTipoTransporte() {
		return tipoTransporte;
	}

	public void setTipoTransporte(Long tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	
	


	
}
