package py.edu.uc.lp3.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uc.lp3.domain.Despachante;
import py.edu.uc.lp3.domain.Presupuesto;
import py.edu.uc.lp3.domain.Producto;
import py.edu.uc.lp3.repository.GenerarPresupuestoRepository;
import py.edu.uc.lp3.repository.ProductoRepository;
import py.edu.uc.lp3.service.GenerarPresupuestoService;
import py.edu.uc.lp3.utilidades.calcularPresupuesto;
import py.edu.uc.lp3exceptions.GeneralLP3Exception;


@Service
public class GenerarPresupuestoImpl implements GenerarPresupuestoService{
	@Autowired
	private ProductoRepository productoRepository; /* para obtener productos por id*/
	
	@Autowired
	private GenerarPresupuestoRepository generarPresupuestoRepository; /* repo para los crud correspondientes*/

	@Override
	public Presupuesto save (Long id1, Presupuesto presupuesto) {
		
		/*guardamos presupuesto de 1 producto*/
		Despachante despachante = new Despachante(); /* para obtener productos dato despachante*/
		Producto produ = null;
		Optional<Producto> produFromBD = productoRepository.findById(id1); /* para obtener los datos de id1*/
		if (produFromBD.isPresent()) {
			produ = produFromBD.get();
			// guardamos en variables los datos
			Long precio=produ.getPrecio();//precio unitario
			Long cantidad=produ.getCantidad();//cantidad
			Float imp=presupuesto.getTipoImpuestoPorcentaje();// impuesto
			Long Honorarios=despachante.getHonorarios();// honorarios despachante
			Long Honorarios1=presupuesto.getHonorariosTransporte();//honorarios transporte
			Float TOTAL=(calcularPresupuesto.generarPresupuesto(precio,cantidad,imp,Honorarios,Honorarios1));//utilidad generarPresu
			presupuesto.setFinall(TOTAL); //total
			return generarPresupuestoRepository.save(presupuesto); //guardamos
		}else {
			throw new GeneralLP3Exception("Error inesperado al generar presupuesto."); //si no existe el producto
		}
		
	}
	
	@Override
	public List<Presupuesto> save1 (Long id1, Long id2, Presupuesto presupuesto) {
		//Presupuesto presupuesto = new Presupuesto();
		
		/*guardamos presupuesto de 2 producto*/
		
		/*verificamos que existan los productos o lanzamos Excepcion.
		 * En caso de que exista; guardamos en variables los datos, 
		 * generamos presupuesto de cada producto con la utilidad y agregamos a una lista para luego guardar.*/
		
		Despachante despachante = new Despachante();
		Producto produ = null;
		Optional<Producto> produFromBD = productoRepository.findById(id1);
		Optional<Producto> produFromBD1 = productoRepository.findById(id2);
		List<Presupuesto> presupuestoList = new ArrayList<>();
		if (produFromBD.isPresent() && produFromBD1.isPresent()) {
			produ = produFromBD.get();
			Long precio=produ.getPrecio();//precio producto
			Long cantidad=produ.getCantidad();//cantidad producto
			Float imp=presupuesto.getTipoImpuestoPorcentaje();// impuesto
			Long Honorarios=despachante.getHonorarios();//total honorarios despachante
			Long Honorarios1=presupuesto.getHonorariosTransporte(); //honorario transporte
			Float TOTAL=(calcularPresupuesto.generarPresupuesto(precio,cantidad,imp,Honorarios,Honorarios1)); //calculo presupuesto con utilidad
			presupuesto.setFinall(TOTAL); //total
			presupuestoList.add(presupuesto); // agregamos a la lista
			
			Presupuesto presupuesto1 = new Presupuesto();
			Producto produ1 = null;
		//List<Presupuesto> presupuestoList = new ArrayList<>();
			produ1 = produFromBD1.get();
			Long precio1=produ1.getPrecio();
			Long cantidad1=produ1.getCantidad();//precioTotal
			Float imp1=presupuesto.getTipoImpuestoPorcentaje();// impuesto
			Long Honorarios2=despachante.getHonorarios();//total honorarios
			Long Honorarios3=presupuesto.getHonorariosTransporte();
			Float TOTAL1=(calcularPresupuesto.generarPresupuesto(precio1,cantidad1,imp1,Honorarios2,Honorarios3));
			presupuesto1.setFinall(TOTAL1); //total
			presupuesto1.setTipoImpuestoPorcentaje(presupuesto.getTipoImpuestoPorcentaje());
			presupuesto1.setHonorariosTransporte(presupuesto.getHonorariosTransporte());
			presupuestoList.add(presupuesto1);
			return (List<Presupuesto>) generarPresupuestoRepository.saveAll(presupuestoList);
		}else {
			throw new GeneralLP3Exception("Error inesperado al generar presupuesto.");
		}
			//calcularPresupuesto.generarPresupuesto(Despachante despachante,produ.getPrecio(),produ.getCantidad());
	}
	
	
	@Override
	public List<Presupuesto> save2 (Long id1, Long id2, Long id3, Presupuesto presupuesto) {
		
		/*guardamos presupuesto de 3 productos*/
		/*verificamos que existan los productos o lanzamos Excepcion.
		 * En caso de que existan; guardamos en variables los datos, 
		 * generamos presupuesto de cada producto con la utilidad y agregamos a una lista para luego guardar.
		 * 
		 * LOS DATOS AGREGADOS EN JSON BODY SON EL MISMO PARA LOS 3*/
		
		//Presupuesto presupuesto = new Presupuesto();
		
		Despachante despachante = new Despachante();
		Producto produ = null;
		Optional<Producto> produFromBD = productoRepository.findById(id1);
		Optional<Producto> produFromBD1 = productoRepository.findById(id2);
		Optional<Producto> produFromBD2 = productoRepository.findById(id3);
		List<Presupuesto> presupuestoList = new ArrayList<>();
		
		if (produFromBD.isPresent() && produFromBD1.isPresent() && produFromBD2.isPresent()) {
			produ = produFromBD.get();
			//guardamos datos en variables
			Long precio=produ.getPrecio();
			Long cantidad=produ.getCantidad();
			Float imp=presupuesto.getTipoImpuestoPorcentaje();
			Long Honorarios=despachante.getHonorarios();
			Long Honorarios1=presupuesto.getHonorariosTransporte();
			Float TOTAL=(calcularPresupuesto.generarPresupuesto(precio,cantidad,imp,Honorarios,Honorarios1));
			presupuesto.setFinall(TOTAL); //total
			presupuestoList.add(presupuesto); //agregamos primer presupuesto a la lista
		
			Presupuesto presupuesto1 = new Presupuesto();
			Producto produ1 = null;
			produ1 = produFromBD1.get();
			//guardamos datos en variables
			Long precio1=produ1.getPrecio();
			Long cantidad1=produ1.getCantidad();//precioTotal
			Float imp1=presupuesto.getTipoImpuestoPorcentaje();// impuesto
			Long Honorarios2=despachante.getHonorarios();//total honorarios
			Long Honorarios3=presupuesto.getHonorariosTransporte();
		//	Float subtotal = resul+imp;//total+impuesto
			Float TOTAL1=(calcularPresupuesto.generarPresupuesto(precio1,cantidad1,imp1,Honorarios2,Honorarios3));
			presupuesto1.setFinall(TOTAL1); //total
			presupuesto1.setTipoImpuestoPorcentaje(presupuesto.getTipoImpuestoPorcentaje());
			presupuesto1.setHonorariosTransporte(presupuesto.getHonorariosTransporte());
			presupuestoList.add(presupuesto1);//agregamos segundo presupuesto a la lista

			Presupuesto presupuesto2 = new Presupuesto();
			Producto produ2 = null;
			produ2 = produFromBD2.get();
			//guardamos datos en variables
			Long precio2=produ2.getPrecio();
			Long cantidad2=produ2.getCantidad();
			Float imp2=presupuesto.getTipoImpuestoPorcentaje();
			Long Honorarios4=despachante.getHonorarios();
			Long Honorarios5=presupuesto.getHonorariosTransporte();
			Float TOTAL2=(calcularPresupuesto.generarPresupuesto(precio2,cantidad2,imp2,Honorarios4,Honorarios5));
			presupuesto2.setFinall(TOTAL2); //total
			presupuesto2.setTipoImpuestoPorcentaje(presupuesto.getTipoImpuestoPorcentaje());
			presupuesto2.setHonorariosTransporte(presupuesto.getHonorariosTransporte());
			presupuestoList.add(presupuesto2);	//agregamos tercer presupuesto a la lista
		
			return (List<Presupuesto>) generarPresupuestoRepository.saveAll(presupuestoList); //guardamos lista de presupuestos
		}else {
			throw new GeneralLP3Exception("Error inesperado al generar presupuesto.");
		}
		
		
	}
	
	/*para listar los presupuestos*/
	@Override
	public List<Presupuesto> findAll() {
		List<Presupuesto> presupuesto = new ArrayList<>();
		Iterator<Presupuesto> iteratorPersonas = generarPresupuestoRepository.findAll().iterator();
		while (iteratorPersonas.hasNext()) {
			presupuesto.add(iteratorPersonas.next());
		}
		return presupuesto;
	}
	
	/*para eliminar los presupuestos por id*/
	@Override
	public void deletePresupuestoById(Long id) {
		// TODO Auto-generated method stub
		if (generarPresupuestoRepository.existsById(id)){
			generarPresupuestoRepository.deleteById(id);
		}else {
			throw new GeneralLP3Exception("Error.No se encuentran presupuestos con id: " + id);
		}
	}

	/*para actualizar un presupuesto y genere uno nuevo
	 * 
	 * id enviado en el path ES PRODUCTO
	 * 
	 * ID enviado en jsonBody el presupuestos a actualizar*/
	
	@Override
	public Presupuesto updatePresu(Long id1,Presupuesto presupuesto) {
		Long id2=presupuesto.getId(); // id de presupuesto a actualizar
		if(generarPresupuestoRepository.findById(id2).isPresent()) { // verficamos que exista presupuesto con id
			
			Optional<Presupuesto> recuperarPresu = generarPresupuestoRepository.findById(presupuesto.getId());
			Presupuesto Existente = (Presupuesto) recuperarPresu.get(); //obtener presupuesto con id
			
			//actualizar datos siempre que no sea null
			if(presupuesto.getTipoImpuestoPorcentaje()!=null) {
				Existente.setTipoImpuestoPorcentaje(presupuesto.getTipoImpuestoPorcentaje());
			}
			if(presupuesto.getHonorariosTransporte()!=null) {
				Existente.setHonorariosTransporte(presupuesto.getHonorariosTransporte());	
			}
			// generar presu de producto modificado 
			Despachante despachante = new Despachante();
			Producto produ = null;
			Optional<Producto> produFromBD = productoRepository.findById(id1); //id1 producto
			if (produFromBD.isPresent()) {
				produ = produFromBD.get();
					Long precio=produ.getPrecio();
					Long cantidad=produ.getCantidad();
					Float imp=presupuesto.getTipoImpuestoPorcentaje();
					Long Honorarios=despachante.getHonorarios();
					Long Honorarios1=presupuesto.getHonorariosTransporte();
					Float TOTAL=(calcularPresupuesto.generarPresupuesto(precio,cantidad,imp,Honorarios,Honorarios1));
					Existente.setFinall(TOTAL); //total
					return generarPresupuestoRepository.save(Existente);
			}else {
				throw new GeneralLP3Exception("Error inesperado al actualizar presupuesto.");
			}
			/*if(!productos.getOrigen().isEmpty()) {
				Existente.setOrigen(productos.getOrigen());
			}*/
		}else {
			throw new GeneralLP3Exception("Error inesperado al actualizar presupuesto.");
		}
	}
	
	
}
