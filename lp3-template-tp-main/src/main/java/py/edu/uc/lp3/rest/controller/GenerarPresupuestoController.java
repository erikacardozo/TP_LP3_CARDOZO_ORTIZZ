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
import py.edu.uc.lp3.domain.Presupuesto;
import py.edu.uc.lp3.service.GenerarPresupuestoService;
import py.edu.uc.lp3exceptions.ExceptionText;

@RestController
@RequestMapping(ApiPaths.PRESUPUESTO)
public class GenerarPresupuestoController {
	@Autowired
	private GenerarPresupuestoService generarPresupuestoService;
	
	
	@PostMapping("/producto/{id}") // agregar un presupuesto, necesita 1 IDproducto y 2 datos de presupuesto
	public Presupuesto add(@PathVariable("id") Long id, @RequestBody Presupuesto presupuesto) throws ExceptionText {
		return generarPresupuestoService.save(id,presupuesto);
	}
	
	@PostMapping("/producto/{id1}/{id2}")// agregar 2 presupuesto, necesita 2 IDproducto y 2 datos de presupuesto
	public List<Presupuesto> add(@PathVariable("id1") Long id1,@PathVariable("id2") Long id2, @RequestBody Presupuesto presupuesto) throws ExceptionText {
		return generarPresupuestoService.save1(id1,id2,presupuesto);
	}
	
	@PostMapping("/producto/{id1}/{id2}/{id3}")// agregar 3 presupuesto, necesita 3 IDproducto y 2 datos de presupuesto
	public List<Presupuesto> add(@PathVariable("id1") Long id1,@PathVariable("id2") Long id2,@PathVariable("id3") Long id3 ,@RequestBody Presupuesto presupuesto) throws ExceptionText {
		return generarPresupuestoService.save2(id1,id2,id3,presupuesto);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET) // para listar todos los presupuestos
	public List<Presupuesto> list() {
		return generarPresupuestoService.findAll();
	}
	
	@DeleteMapping("/{id}")// para eliminar presupuesto por id
	public void deletePresupuestoById(@PathVariable long id) {
		generarPresupuestoService.deletePresupuestoById(id);
	}
	
	@PutMapping("/producto/{id1}")// para actualizar presupuesto 
	public ResponseEntity<Presupuesto> updatePresu(@PathVariable long id1, @RequestBody Presupuesto presupuestos) throws ExceptionText {
		return new ResponseEntity<>(generarPresupuestoService.updatePresu(id1,presupuestos),HttpStatus.OK);
	}
}
