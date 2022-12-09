package py.edu.uc.lp3.clases;

public class Impuestos {
	public Long idImpuesto;
	public Float IVA;
	public Float arancel;
	
	public Float getIVA() {
		return IVA;
	}

	public void setIVA(Float iVA) {
		IVA = iVA;
	}
	
	public Float getArancel() {
		return arancel;
	}

	public void setArancel(Float arancel) {
		this.arancel = arancel;
	}

	public Long getIdImpuesto() {
		return idImpuesto;
	}

	public void setIdImpuesto(Long idImpuesto) {
		this.idImpuesto = idImpuesto;
	}

	

	

	public void calcularImpuesto(String tipoProducto) {
		//para calcular impuesto, dsp podemos retornar el impuesto
		
	}
}
