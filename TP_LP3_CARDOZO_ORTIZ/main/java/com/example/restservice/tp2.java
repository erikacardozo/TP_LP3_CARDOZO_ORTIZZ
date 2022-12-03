package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import py.edu.uc.lp3.herencia.Persona;
import py.edu.uc.lp3.utilidades.Tracker;

@RestController
public class tp2 {

	//private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/primero")
	public datosPersonales datosP(@RequestParam(value = "rol") String rol, @RequestParam(value = "numeroLicencia") String numeroLicencia, @RequestParam(value = "ci") long  ci, @RequestParam(value = "empresa") String empresa) {
		datosPersonales datosP = new datosPersonales(counter.incrementAndGet(),rol, numeroLicencia, ci, empresa);
		System.out.println(datosP);
		return datosP;
	}
	
	@GetMapping("/segundo")
	public localizacion datos2(@RequestBody localizacion buscar) {
		return new localizacion (counter.incrementAndGet(),buscar.getTipo(),buscar.getNombre());
	}
	/* ver!! como hacer post
	@GetMapping("/tercero")
	public transporte datos3(@RequestMapping transporte buscarr) {
		return new transporte (buscarr.getCantidad(),buscarr.getTipo(),counter.incrementAndGet());
	} 
	public void printlnt(Object object) {
		object.toString();
	}*/
	

}
