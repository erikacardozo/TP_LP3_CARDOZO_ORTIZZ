package py.edu.uc.lp3.utilidades;

import py.edu.uc.lp3.domain.Usuario;
import py.edu.uc.lp3exceptions.ExceptionText;


public class verificarUsuario {
	public static void validarNombre(Usuario usuario) throws ExceptionText { //tirar una exception
		String nombre=usuario.getUserName();
		if (nombre.length()<3) {
			System.out.println("El nombre del usuario es muy corto");
			throw new ExceptionText(String.format("El nombre del usuario es muy corto: %s ", nombre));
		}else {
			System.out.println("nombre ok");
		}
	}
}
