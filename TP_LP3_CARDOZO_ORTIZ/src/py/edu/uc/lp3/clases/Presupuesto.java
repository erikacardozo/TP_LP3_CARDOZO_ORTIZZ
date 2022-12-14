package py.edu.uc.lp3.clases;

public class Presupuesto {
	private Integer honorariosDespachante;
	private String Servicio; //para saber si es exportacion o importacion
	private Integer tipoImpuesto;
	private Integer tipoArancel;
	private Integer precioTotal;
	public Integer getHonorariosDespachante() {
		return honorariosDespachante;
	}
	public void setHonorariosDespachante(Integer honorariosDespachante) {
		this.honorariosDespachante = honorariosDespachante;
	}
	public Integer getTipoImpuesto() {
		return tipoImpuesto;
	}
	public void setTipoImpuesto(Integer tipoImpuesto) {
		this.tipoImpuesto = tipoImpuesto;
	}
	public Integer getTipoArancel() {
		return tipoArancel;
	}
	public void setTipoArancel(Integer tipoArancel) {
		this.tipoArancel = tipoArancel;
	}
	public Integer getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(Integer precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	public void calcularTotal() {
		
	}
	public String getServicio() {
		return Servicio;
	}
	public void setServicio(String servicio) {
		Servicio = servicio;
	}
}
