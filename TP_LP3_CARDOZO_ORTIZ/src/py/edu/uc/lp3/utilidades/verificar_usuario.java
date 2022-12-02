package py.edu.uc.lp3.utilidades;

import py.edu.uc.lp3.clases.usuario;

public class verificar_usuario {
	public static  void validarNombre(usuario usuario) {
		String nombre=usuario.getNombreUser();
		if (nombre.length()<3) {
			System.out.println("El nombre del usuario es muy corto");
		}else {
			System.out.println("nombre ok");
		}
	}
	public static void main(String[] args) {
		usuario erika = new usuario();
		erika.setNombreUser("mi");
		verificar_usuario.validarNombre(erika);
	}
}
