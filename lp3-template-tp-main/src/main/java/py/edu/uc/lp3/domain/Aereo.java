package py.edu.uc.lp3.domain;

public class Aereo extends Transporte{
	
	public String medioAereo; //que tipo de transporte aereo es (avion, helicoptero,etc)

	public String getMedioAereo() {
		return medioAereo;
	}

	public void setMedioAereo(String medioAereo) {
		this.medioAereo = medioAereo;
	}
}
