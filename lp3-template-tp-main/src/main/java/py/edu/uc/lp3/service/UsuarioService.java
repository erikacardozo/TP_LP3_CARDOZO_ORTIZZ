package py.edu.uc.lp3.service;


import java.util.List;
import py.edu.uc.lp3.domain.Usuario;

public interface UsuarioService {
	
	List<Usuario> findAll();
	void save(Usuario usuarios);
	List<Usuario> findByRol(String rol); 
	void deleteUserById(Long id);
	Usuario updateUser(Long id,Usuario usuarios);
}

