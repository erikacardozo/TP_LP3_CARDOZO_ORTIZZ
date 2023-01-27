package py.edu.uc.lp3.domain;

public class Maritimo extends Transporte{
	public String medioMaritimo; //tipo de transporte maritimo (barco, bote, etc)

	public String getMedioMaritimo() {
		return medioMaritimo;
	}

	public void setMedioMaritimo(String medioMaritimo) {
		this.medioMaritimo = medioMaritimo;
	}
}
