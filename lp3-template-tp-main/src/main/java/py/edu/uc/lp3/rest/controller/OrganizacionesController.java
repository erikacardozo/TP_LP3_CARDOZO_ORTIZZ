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
import py.edu.uc.lp3.domain.Organizaciones;
import py.edu.uc.lp3.service.OrganizacionesService;

@RestController
@RequestMapping(ApiPaths.ORGANIZACIONES)
public class OrganizacionesController {
	@Autowired
	private OrganizacionesService organizacionesService;
	
	@PostMapping
	public void add(@RequestBody Organizaciones organizaciones) { //envia organizacion a save para guardar
		organizacionesService.save(organizaciones);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)//para listar todas las organizaciones
	public List<Organizaciones> list() {
		return organizacionesService.findAll();
	}
	
	@RequestMapping(value = "/{tipo}", method = RequestMethod.GET) //para listar organizacion por tipo
    public List<Organizaciones> listO(@PathVariable("tipo") String tipoDeOrganizacion){
        return organizacionesService.findByTipoDeOrganizacion(tipoDeOrganizacion);
    }
	/* para eliminar una organizacion por su numero de id 
	 *  por metodo DELETE
	 */
	@DeleteMapping("/{idOrg}")
	public void deleteUserById(@PathVariable Long IDOrg) {
			organizacionesService.deleteOrg(IDOrg);
	}
	/*Llama a la funcion para actualizar o cambiar los datos de una organizacion
	 * por su numero de id por metodo PUT
	 */
	@PutMapping("/{idOrg}")
	  public ResponseEntity<Organizaciones> updateOrg(@PathVariable("idOrg") Long IDOrg, @RequestBody Organizaciones organizaciones) {
	    return new ResponseEntity<>(organizacionesService.updateOrg(IDOrg, organizaciones),HttpStatus.OK);
	  }
	
}
