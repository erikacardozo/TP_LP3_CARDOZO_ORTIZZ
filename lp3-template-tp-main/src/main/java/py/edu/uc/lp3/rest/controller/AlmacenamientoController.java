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
import py.edu.uc.lp3.domain.Almacenamiento;
import py.edu.uc.lp3.service.AlmacenamientoService;


@RestController
@RequestMapping(ApiPaths.ALMACENAMIENTO)
public class AlmacenamientoController {
	
	@Autowired
  
	private AlmacenamientoService almacenamientoService;
	
	//Llama a la funcion para ver a todos los almacenamientos por metodo GET
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Almacenamiento> list() {
		return almacenamientoService.findAll();
	}
	
	
	//Llama a la funcion para agregar almacenamiento por metodo POST
	
	@PostMapping()
	public Almacenamiento add(@RequestBody Almacenamiento almacenamiento) {
		return almacenamientoService.save(almacenamiento);
	}
	
	/*Llama a la funcion para eliminar un almacenamiento por su numero de id 
	 *  por metodo DELETE
	 */
	@DeleteMapping("/{id}")
	public void deleteAlmacById(@PathVariable long id) {
		almacenamientoService.deleteAlmacenamientoById(id);
	}
	/*Llama a la funcion para actualizar los datos de un almacenamiento 
	 * por su numero de id por metodo PUT
	 */
	@PutMapping("/{id}")
	  public ResponseEntity<Almacenamiento> updateAlmacenamiento (@PathVariable("id") long id, @RequestBody Almacenamiento almacenamiento) {
	    return new ResponseEntity<>(almacenamientoService.updateAlmacenamiento(id,almacenamiento),HttpStatus.OK);
	 }	
	

}
