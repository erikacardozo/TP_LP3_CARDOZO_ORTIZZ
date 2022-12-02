package py.edu.uc.lp3.herencia;

public class servicio extends itemFacturable {
	private String encargado;
	protected long calcularPrecio() {
		return getPrecio()*3;
	}
}
