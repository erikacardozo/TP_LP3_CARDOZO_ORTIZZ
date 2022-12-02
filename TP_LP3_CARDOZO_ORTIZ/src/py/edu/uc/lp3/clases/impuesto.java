package py.edu.uc.lp3.clases;

public class impuesto {
	public Long idImpuesto;
	public Integer iva;
	public Integer irp;
	
	public Long getIdImpuesto() {
		return idImpuesto;
	}

	public void setIdImpuesto(Long idImpuesto) {
		this.idImpuesto = idImpuesto;
	}

	public Integer getIva() {
		return iva;
	}

	public void setIva(Integer iva) {
		this.iva = iva;
	}

	public Integer getIrp() {
		return irp;
	}

	public void setIrp(Integer irp) {
		this.irp = irp;
	}

	public void calcularImpuesto(String tipoProducto) {
		//para calcular impuesto, dsp podemos retornar el impuesto
		
	}
}
