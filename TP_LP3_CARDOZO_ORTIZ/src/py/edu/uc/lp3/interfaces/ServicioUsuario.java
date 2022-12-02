package py.edu.uc.lp3.interfaces;

import java.util.ArrayList;

import py.edu.uc.lp3.clases.usuario;

public interface ServicioUsuario {
	public usuario agregarUsuario(Integer IDuser, String nombreUser,Long ci, String rol, String email, String passwd);
	public ArrayList<usuario> listarUusuario(Integer IDuser);
	public ArrayList<usuario> listarUusuario(String rol);
	public usuario actualizar_usuario(usuario IDuser);
	public void eliminar_usuario(int IDuser);
	
}
