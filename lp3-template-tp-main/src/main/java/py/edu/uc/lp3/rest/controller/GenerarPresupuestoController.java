package py.edu.uc.lp3.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.uc.lp3.constants.ApiPaths;
import py.edu.uc.lp3.domain.Presupuesto;
import py.edu.uc.lp3.domain.Producto;
import py.edu.uc.lp3.repository.GenerarPresupuestoRepository;
import py.edu.uc.lp3.service.GenerarPresupuestoService;

@RestController
@RequestMapping(ApiPaths.PRESUPUESTO)
public class GenerarPresupuestoController {
	@Autowired
	private GenerarPresupuestoService generarPresupuestoService;
	
	/*public GenerarPresupuestoController(GenerarPresupuestoService generarPresupuestoService) {
        this.generarPresupuestoService = generarPresupuestoService;
    }*/ 
	
	@PostMapping("/{id}")
	public Presupuesto add(@PathVariable("id") Long id, @RequestBody Presupuesto presupuesto) {
		return generarPresupuestoService.save(id,presupuesto);
	}
	
	@PostMapping("/{id1}/{id2}")
	public List<Presupuesto> add(@PathVariable("id1") Long id1,@PathVariable("id2") Long id2, @RequestBody Presupuesto presupuesto) {
		return generarPresupuestoService.save1(id1,id2,presupuesto);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Presupuesto> list() {
		return generarPresupuestoService.findAll();
	}
	
	@DeleteMapping("/{id}")
	public void deletePresupuestoById(@PathVariable long id) {
		generarPresupuestoService.deletePresupuestoById(id);
	}
}
