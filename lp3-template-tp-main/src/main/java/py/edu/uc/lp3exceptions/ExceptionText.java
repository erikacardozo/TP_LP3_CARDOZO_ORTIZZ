package py.edu.uc.lp3exceptions;

public class ExceptionText extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensaje;

	public ExceptionText(String mensaje) {
		super();
		this.setMensaje(mensaje);
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	@Override
	public String toString() {
		return "ExceptionText [mensaje=" + mensaje + "]";
	}
}
