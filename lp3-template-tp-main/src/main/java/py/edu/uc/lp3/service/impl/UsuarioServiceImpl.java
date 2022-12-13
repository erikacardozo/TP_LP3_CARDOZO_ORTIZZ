package py.edu.uc.lp3.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import py.edu.uc.lp3.domain.Persona;
import py.edu.uc.lp3.domain.Usuario;
import py.edu.uc.lp3.repository.UsuarioRepository;
import py.edu.uc.lp3.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Override
	public List<Usuario> findAll() {
		List<Usuario> usuarios = new ArrayList<>();
		Iterator<Usuario> iteratorPersonas = usuarioRepository.findAll().iterator();
		while (iteratorPersonas.hasNext()) {
			usuarios.add(iteratorPersonas.next());
		}
		return usuarios;
	}
	@Override
	public void save(Usuario usuarios) {
		usuarioRepository.save(usuarios);
	}
}
