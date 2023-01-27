package py.edu.uc.lp3.domain;

public class Terrestre extends Transporte{
	public String medioTerrestre; //tipo de transporte terreste (camion, auto, moto ,etc)

	public String getMedioTerrestre() {
		return medioTerrestre;
	}

	public void setMedioTerrestre(String medioTerrestre) {
		this.medioTerrestre = medioTerrestre;
	}

}
