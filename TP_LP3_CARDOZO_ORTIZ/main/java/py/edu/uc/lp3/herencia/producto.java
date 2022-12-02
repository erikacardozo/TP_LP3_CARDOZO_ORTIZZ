package py.edu.uc.lp3.herencia;

public class producto extends itemFacturable {
	private String proveedor;
	protected long calcularPrecio() {
		return getPrecio()*2;
	}
}
