package py.edu.uc.lp3.interfaces;

import java.util.ArrayList;

import py.edu.uc.lp3.clases.Usuario;

public interface ServicioUsuario {
    public void agregarUsuario(Integer IDuser, String nombreUser, String rol, String email, String passwd);
    public ArrayList<Usuario> listarUusuario(Integer IDuser);
    public ArrayList<Usuario> listarUusuario(String rol);
    public Usuario actualizar_usuario(Usuario IDuser);
    public void eliminar_usuario(int IDuser);

}
