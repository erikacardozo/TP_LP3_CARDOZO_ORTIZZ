package py.edu.uc.lp3.service;


import java.util.List;
import py.edu.uc.lp3.domain.Usuario;
import py.edu.uc.lp3exceptions.ExceptionText;
import py.edu.uc.lp3exceptions.InscripcionException;

public interface UsuarioService {
	
	List<Usuario> findAll();
	Usuario save(Usuario usuarios) throws ExceptionText;
	List<Usuario> findByRol(String rol); 
	void deleteUserById(Long id);
	Usuario updateUser(Long id,Usuario usuarios) throws ExceptionText;
}

