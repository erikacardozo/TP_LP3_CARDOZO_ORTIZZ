package py.edu.uc.lp3.clases;

public class Despachante extends Usuario {
	private Long numLicencia; // es la licencia del Despachante
	private Integer honorariosDespachante;

	public Long getNumLicencia() {
		return numLicencia;
	}

	public void setNumLicencia(Long numLicencia) {
		this.numLicencia = numLicencia; 
	}
	public Despachante() {
		/*
		 * Se encarga de generar el presupuesto*/
		// TODO Auto-generated constructor stub
	}

	public Integer getHonorariosDespachante() {
		return honorariosDespachante;
	}

	public void setHonorariosDespachante(Integer honorariosDespachante) {
		this.honorariosDespachante = honorariosDespachante;
	}
	
	
}
