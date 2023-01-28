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
import py.edu.uc.lp3.domain.Transporte;
import py.edu.uc.lp3.service.TransporteService;

@RestController
@RequestMapping(ApiPaths.TRANSPORTE)
public class TransporteController {
	
	@Autowired
  
	private TransporteService transporteService;
	
	//Llama a la funcion para ver a todos los transportes por metodo GET
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Transporte> list() {
		return transporteService.findAll();
	}
	
	
	//Llama a la funcion para agregar transporte por metodo POST
	
	@PostMapping()
	public Transporte add(@RequestBody Transporte transporte) {
		return transporteService.save(transporte);
	}
	
	/*Llama a la funcion para eliminar un transporte por su numero de id 
	 *  por metodo DELETE
	 */
	@DeleteMapping("/{id}")
	public void deleteTransportById(@PathVariable long id) {
		transporteService.deleteTransporteById(id);
	}
	/*Llama a la funcion para actualizar los datos de un transporte 
	 * por su numero de id por metodo PUT
	 */
	@PutMapping("/{id}")
	  public ResponseEntity<Transporte> updateTransporte(@PathVariable("id") long id, @RequestBody Transporte Transporte) {
	    return new ResponseEntity<>(transporteService.updateTransporte(id,Transporte),HttpStatus.OK);
	 }
		
		
		
	

}
