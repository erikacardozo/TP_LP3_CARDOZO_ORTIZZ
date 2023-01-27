package py.edu.uc.lp3.domain;

public class Transportista extends Usuario{
	private Long numLicConducir;
	/*datos para informar su ubicacion*/
	private Double latitud;
	private Double longitud;
	
	public Long getNumLicConducir() {
		return numLicConducir;
	}

	public void setNumLicConducir(Long numLicConducir) {
		this.numLicConducir = numLicConducir;
	}
	public Transportista() {
		/*recibe un pedido de transporte e informa de su ubicación 
		 * y la lista de materiales con sus cantidades que está transportando*/
		// TODO Auto-generated constructor stub
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public String Ubicacion() {
		return "Ubicacion [latitud=" + latitud + ", longitud=" + longitud + "]";
	}
}
