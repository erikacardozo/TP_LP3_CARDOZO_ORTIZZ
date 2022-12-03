package py.edu.uc.lp3.utilidades;

import py.edu.uc.lp3.clases.Usuario;

public class verificar_usuario {
	public static  void validarNombre(Usuario usuario) {
		String nombre=usuario.getNombreUser();
		if (nombre.length()<3) {
			System.out.println("El nombre del usuario es muy corto");
		}else {
			System.out.println("nombre ok");
		}
	}
	public static void validarCorreo(String email, String mensaje) {
		System.out.println("enviado al correo: " + email);
		System.out.println("mensaje: " + mensaje);
	}
	public static void main(String[] args) {
		Usuario erika = new Usuario();
		erika.setNombreUser("mi");
		verificar_usuario.validarNombre(erika);
		System.out.println("enviado al correo: " ); // verifica si es el correo correcto
	}
	
	
}

