package py.edu.uc.lp3.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uc.lp3.domain.Despachante;
import py.edu.uc.lp3.domain.Impuesto;
import py.edu.uc.lp3.domain.Presupuesto;
import py.edu.uc.lp3.domain.Producto;
import py.edu.uc.lp3.repository.GenerarPresupuestoRepository;
import py.edu.uc.lp3.repository.ProductoRepository;
import py.edu.uc.lp3.service.GenerarPresupuestoService;
import py.edu.uc.lp3.utilidades.calcularPresupuesto;
import py.edu.uc.lp3.utilidades.verificarUsuario;
import py.edu.uc.lp3exceptions.GeneralLP3Exception;


@Service
public class GenerarPresupuestoImpl implements GenerarPresupuestoService{
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private GenerarPresupuestoRepository generarPresupuestoRepository;

	
	/*@Autowired
	private TransporteRepository transporteRepository;
	
	//@Autowired
	private TipoImpuestoRepository tipoImpuestoRepository;*/
	
	//private Presupuesto presupuesto;
	//private Long id=(long)0;
	@Override
	public Presupuesto save (Long id1, Presupuesto presupuesto) {
		
		//Presupuesto presupuesto = new Presupuesto();
		Despachante despachante = new Despachante();
		Producto produ = null;
		Optional<Producto> produFromBD = productoRepository.findById(id1);
		if (produFromBD.isPresent()) {
			produ = produFromBD.get();
				Long precio=produ.getPrecio();
				Long cantidad=produ.getCantidad();//precioTotal
				Float imp=presupuesto.getTipoImpuestoPorcentaje();// impuesto
				Long Honorarios=despachante.getHonorarios();//total honorarios
				Long Honorarios1=presupuesto.getHonorariosTransporte();
			//	Float subtotal = resul+imp;//total+impuesto
				Float TOTAL=(calcularPresupuesto.generarPresupuesto(precio,cantidad,imp,Honorarios,Honorarios1));
				presupuesto.setFinall(TOTAL); //total
				return generarPresupuestoRepository.save(presupuesto);
			//calcularPresupuesto.generarPresupuesto(Despachante despachante,produ.getPrecio(),produ.getCantidad());
		}else {
			throw new GeneralLP3Exception("Error inesperado al generar presupuesto.");
		}
		
	}
	
	@Override
	public List<Presupuesto> save1 (Long id1, Long id2, Presupuesto presupuesto) {
		
		//Presupuesto presupuesto = new Presupuesto();
		Despachante despachante = new Despachante();
		Producto produ = null;
		Optional<Producto> produFromBD = productoRepository.findById(id1);
		List<Presupuesto> presupuestoList = new ArrayList<>();
		if (produFromBD.isPresent()) {
			produ = produFromBD.get();
				Long resul=(produ.getPrecio()*produ.getCantidad());//precioTotal
				Float imp=resul*presupuesto.getTipoImpuestoPorcentaje();// impuesto
				Long sumaHonorarios=despachante.getHonorarios()+presupuesto.getHonorariosTransporte();//total honorarios
				Float subtotal = resul+imp;//total+impuesto
				presupuesto.setFinall(sumaHonorarios+subtotal); //total
				presupuestoList.add(presupuesto);
		
		}
		Presupuesto presupuesto1 = new Presupuesto();
		Producto produ1 = null;
		Optional<Producto> produFromBD1 = productoRepository.findById(id2);
		//List<Presupuesto> presupuestoList = new ArrayList<>();
		if (produFromBD1.isPresent()) {
			produ1 = produFromBD1.get();
				Long resul=(produ1.getPrecio()*produ1.getCantidad());//precioTotal
				Float imp=resul*presupuesto.getTipoImpuestoPorcentaje();// impuesto
				Long sumaHonorarios=despachante.getHonorarios()+presupuesto.getHonorariosTransporte();//total honorarios
				Float subtotal = resul+imp;//total+impuesto
				presupuesto1.setTipoImpuestoPorcentaje(presupuesto.getTipoImpuestoPorcentaje());
				presupuesto1.setHonorariosTransporte(presupuesto.getHonorariosTransporte());
				presupuesto1.setFinall(sumaHonorarios+subtotal); //total
				presupuestoList.add(presupuesto1);
		return (List<Presupuesto>) generarPresupuestoRepository.saveAll(presupuestoList);
			//calcularPresupuesto.generarPresupuesto(Despachante despachante,produ.getPrecio(),produ.getCantidad());
		}else {
			throw new GeneralLP3Exception("Error inesperado al generar presupuesto.");
		}
		
	}
	
	@Override
	public List<Presupuesto> findAll() {
		List<Presupuesto> presupuesto = new ArrayList<>();
		Iterator<Presupuesto> iteratorPersonas = generarPresupuestoRepository.findAll().iterator();
		while (iteratorPersonas.hasNext()) {
			presupuesto.add(iteratorPersonas.next());
		}
		return presupuesto;
	}
	
	
	@Override
	public void deletePresupuestoById(Long id) {
		// TODO Auto-generated method stub
		if (generarPresupuestoRepository.existsById(id)){
			generarPresupuestoRepository.deleteById(id);
		}else {
			throw new GeneralLP3Exception("Error.No se encuentran presupuestos con id: " + id);
		}
	}

	/*@Override
	public Producto findById(Long id) {
		Producto producto = null;
		Optional<Producto> personaFromBD = productoRepository.findById(id);
		if (personaFromBD.isPresent()) {
			producto = personaFromBD.get();
		} else {
			throw new GeneralLP3Exception("No se encontró producto con id: " + id);
		}
		return producto;
	}
	@Override
	public Transporte find(Long id) {
		Transporte transporte = null;
		Optional<Transporte> personaFromBD = transporteRepository.findById(id);
		if (personaFromBD.isPresent()) {
			transporte = personaFromBD.get();
		} else {
			throw new GeneralLP3Exception("No se encontró transporte con id: " + id);
		}
		return transporte;
	}*/
	
	
	
}
