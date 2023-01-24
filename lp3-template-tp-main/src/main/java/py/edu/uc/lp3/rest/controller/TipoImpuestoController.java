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
import py.edu.uc.lp3.domain.Impuesto;
import py.edu.uc.lp3.service.TipoImpuestoService;

@RestController
@RequestMapping(ApiPaths.IMPUESTO)
public class TipoImpuestoController {
	
	@Autowired
  
	private TipoImpuestoService tipoImpuestoService;
	//Llama a la funcion para ver a todos los usuarios por metodo GET
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Impuesto> list() {
		return tipoImpuestoService.findAll();
	}
	
	//Llama a la funcion para agregar una usuarios por metodo POST
	@PostMapping()
	public Impuesto add(@RequestBody Impuesto impuesto) {
		return tipoImpuestoService.save(impuesto);
	}
	
	/*Llama a la funcion para eliminar un usuario por su numero de id 
	 *  por metodo DELETE
	 */
	@DeleteMapping("/{id}")
	public void deleteImpestoById(@PathVariable long id) {
		tipoImpuestoService.deleteImpuestoById(id);
	}
	/*Llama a la funcion para actualizar o cambiar los datos de un usuario 
	 * por su numero de id por metodo PUT
	 */
	@PutMapping("/{id}")
	  public ResponseEntity<Impuesto> updateImpuesto(@PathVariable("id") long id, @RequestBody Impuesto impuesto) {
	    return new ResponseEntity<>(tipoImpuestoService.updateImpuesto(id,impuesto),HttpStatus.OK);
	 }
		
		
		
	

}
