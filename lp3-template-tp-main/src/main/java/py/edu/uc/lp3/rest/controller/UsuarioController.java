package py.edu.uc.lp3.rest.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.uc.lp3.constants.ApiPaths;

import py.edu.uc.lp3.domain.Usuario;
import py.edu.uc.lp3.service.UsuarioService;

@RestController
@RequestMapping(ApiPaths.USUARIO)
public class UsuarioController {
	@Autowired
  
	private UsuarioService usuarioService;
	//Llama a la funcion para ver a todos los usuarios por metodo GET
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Usuario> list() {
		return usuarioService.findAll();
	}
	
	//Llama a la funcion para agregar una usuarios por metodo POST
	@PostMapping()
	public void add(@RequestBody Usuario usuarios) {
		usuarioService.save(usuarios);
	}
	
	/*Llama a la funcion para ver a todos los usuarios 
	 * de un rol(despachante,auditor,transportista)
	 */
	@RequestMapping(value = "/{rol}", method = RequestMethod.GET)
    public List<Usuario> listR(@PathVariable("rol") String rol){
        return usuarioService.findByRol(rol);
    }
	
	/*Llama a la funcion para eliminar un usuario por su numero de id 
	 *  por metodo DELETE
	 */
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable long id) {
		usuarioService.deleteUserById(id);
	}
	/*Llama a la funcion para actualizar o cambiar los datos de un usuario 
	 * por su numero de id por metodo PUT
	 */
	@PutMapping("/{id}")
	  public ResponseEntity<Usuario> updateUser(@PathVariable("id") long id, @RequestBody Usuario usuario) {
	    return new ResponseEntity<>(usuarioService.updateUser(id,usuario),HttpStatus.OK);
	  }
	
	
	
}
