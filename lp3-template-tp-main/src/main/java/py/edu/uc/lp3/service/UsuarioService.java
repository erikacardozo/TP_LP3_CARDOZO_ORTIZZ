package py.edu.uc.lp3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import py.edu.uc.lp3.domain.Usuario;

public interface UsuarioService {
	List<Usuario> findAll();
	void save(Usuario usuarios);
}
