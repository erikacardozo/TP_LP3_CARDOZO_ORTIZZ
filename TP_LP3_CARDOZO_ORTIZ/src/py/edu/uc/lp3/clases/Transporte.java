package py.edu.uc.lp3.clases;

public class Transporte {
	private Integer cantidadTransportada;
	private String tipoTransporte; //si es de tipo Areo, Maritimo o Terrestre
	private Float capacidadTransporteKG;
	private Float capacidadTransportadaKG;
	
	public Integer getCantidadTransportada() {
		return cantidadTransportada;
	}
	public void setCantidadTransportada(Integer cantidadTransportada) {
		this.cantidadTransportada = cantidadTransportada;
	}
	public String getTipoTransporte() {
		return tipoTransporte;
	}
	public void setTipoTransporte(String tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}
	public Float getCapacidadTransporteKG() {
		return capacidadTransporteKG;
	}
	public void setCapacidadTransporteKG(Float capacidadTransporteKG) {
		this.capacidadTransporteKG = capacidadTransporteKG;
	}
	public Float getCapacidadTransportadaKG() {
		return capacidadTransportadaKG;
	}
	public void setCapacidadTransportadaKG(Float capacidadTransportadaKG) {
		this.capacidadTransportadaKG = capacidadTransportadaKG;
	}
	
	
}
