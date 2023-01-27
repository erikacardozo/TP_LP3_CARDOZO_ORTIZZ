package py.edu.uc.lp3.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uc.lp3.domain.Usuario;
import py.edu.uc.lp3.repository.UsuarioRepository;
import py.edu.uc.lp3.service.UsuarioService;
import py.edu.uc.lp3.utilidades.verificarUsuario;
import py.edu.uc.lp3exceptions.ExceptionText;
import py.edu.uc.lp3exceptions.GeneralLP3Exception;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	/*
	 * Funcion para obtener una lista de todos los personas 
	 * Parametros: ninguno
	 * Retorno: List<Persona> personas : la lista de todos los personas
	 */
	@Override
	public List<Usuario> findAll() {
		List<Usuario> usuarios = new ArrayList<>();
		Iterator<Usuario> iteratorUsuarios = usuarioRepository.findAll().iterator();
		while (iteratorUsuarios .hasNext()) {
			usuarios.add(iteratorUsuarios.next());
		}
		return usuarios;
	}
	
	
	/* Funcion para guardar un usuario con persistencia
	 * Parametros: Usuario usuarios : el usuario que guardaremos  
	 * Retorno: usuario guardado
	 */
	@Override
	public Usuario save(Usuario usuarios) throws ExceptionText {
		try {
			verificarUsuario.validarNombre(usuarios);
			return usuarioRepository.save(usuarios);
		}catch(Error error) {
			System.out.println(error);
			throw new GeneralLP3Exception("Error inesperado al guardar usuario.");
		}
		
	}
	
	
	/* Funcion para obtener una lista de todos los usuarios con ese rol
	 * Parametros: String rol
	 * Retorno: usuarioRepository.findByRol(rol): la lista de todos los usuarios con ese rol
	 */
	@Override
	public List<Usuario> findByRol(String rol) {
		// TODO Auto-generated method stub
		try {
			return usuarioRepository.findByRol(rol);
		}catch(Error error){
			System.out.println(error);
			throw new GeneralLP3Exception("Error. No se encuentran usuarios con este rol" + rol);
		}
		
	}

	/* Funcion para eliminar un usuario con persistencia
	 * Parametros: Long id: el id del usuario que eliminaremos  
	 * Retorno: ninguno
	 */
	@Override
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		if (usuarioRepository.existsById(id)){
			usuarioRepository.deleteById(id);
		}else {
			throw new GeneralLP3Exception("Error.No se encuentran usuarios con id: " + id);
		}
	}

	/*
	 * Funcion para actualizar un usuario con persistencia
	 * Parametros: Long id : el id del usuario que actualizaremos
	 * Usuario usuarios : el usuario que guardaremos 
	 * Retorno: usuarioRepository.save(_usuarios): guardar los nuevos datos del usuario
	 */
	@Override
	public Usuario updateUser(Long id,Usuario usuarios) throws ExceptionText {
		// TODO Auto-generated method stub 
		 if(usuarioRepository.findById(id).isPresent()) {
			Usuario _usuarios = usuarioRepository.findById(id).get();
			if(!usuarios.getUserName().isEmpty()) {
				_usuarios.setUserName(usuarios.getUserName());
			}
			if(!usuarios.getRol().isEmpty()) {
				_usuarios.setRol(usuarios.getRol());
			}
			if(!usuarios.getEmail().isEmpty()) {
				_usuarios.setEmail(usuarios.getEmail());
			}
			if(!usuarios.getPasswd().isEmpty()) {
				_usuarios.setPasswd(usuarios.getPasswd());
		 	}
			verificarUsuario.validarNombre(_usuarios);
			return usuarioRepository.save(_usuarios); 
		}else {
			throw new GeneralLP3Exception("Error inesperado al actualizar usuario.");
		} 
		
	 }
	
	
	

	
}
