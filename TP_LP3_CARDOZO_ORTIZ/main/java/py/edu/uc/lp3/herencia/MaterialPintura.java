package py.edu.uc.lp3.herencia;

public class MaterialPintura extends producto {
	String unidadMedida;
	Double cantidadMaterial;
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public Double getCantidadMaterial() {
		return cantidadMaterial;
	}
	public void setCantidadMaterial(Double cantidadMaterial) {
		this.cantidadMaterial = cantidadMaterial;
	}

}
