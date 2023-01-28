package py.edu.uc.lp3.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uc.lp3.domain.Almacenamiento;
import py.edu.uc.lp3.domain.Despachante;
import py.edu.uc.lp3.domain.Impuesto;
import py.edu.uc.lp3.domain.Presupuesto;
import py.edu.uc.lp3.domain.Producto;
import py.edu.uc.lp3.domain.Transporte;
import py.edu.uc.lp3.repository.AlmacenamientoRepository;
import py.edu.uc.lp3.repository.GenerarPresupuestoRepository;
import py.edu.uc.lp3.repository.ProductoRepository;
import py.edu.uc.lp3.repository.TipoImpuestoRepository;
import py.edu.uc.lp3.repository.TransporteRepository;
import py.edu.uc.lp3.service.GenerarPresupuestoService;
import py.edu.uc.lp3.utilidades.calcularPresupuesto;
import py.edu.uc.lp3exceptions.ExceptionText;
import py.edu.uc.lp3exceptions.GeneralLP3Exception;


@Service
public class GenerarPresupuestoImpl implements GenerarPresupuestoService{
	@Autowired
	private ProductoRepository productoRepository; /* para obtener productos por id*/
	
	@Autowired
	private GenerarPresupuestoRepository generarPresupuestoRepository; /* repo para los crud correspondientes*/

	
	@Autowired
	private TipoImpuestoRepository tipoImpuestoRepository; /*repo para los tipo impuesto*/
	
	@Autowired
	private TransporteRepository transporteRepository;/*repo para transporte*/

	@Autowired
	private AlmacenamientoRepository almacenamientoRepository;/*repo para almacenamiento*/
	
	

	//////////////////////////////
	///presupuesto1//////////////
	////////////////////////////
	
	
	@Override
	public Presupuesto save (Long id1, Presupuesto presupuesto) throws ExceptionText {
		
		/// variables para enviar a nuestra utilidad
		Float imp=(float) 0.0;
		Long Honorarios1=(long)0;
		Integer mercosurr=0;
		Long HonorariosA=(long)0;
		
		/*guardamos presupuesto de 1 producto*/
		Despachante despachante = new Despachante(); /* para obtener productos dato despachante*/
		Producto produ = null;
		Optional<Producto> produFromBD = productoRepository.findById(id1); /* para obtener los datos de id1*/
		if (produFromBD.isPresent()) {
			produ = produFromBD.get();
			System.out.println("entrando1");
			Long precio=produ.getPrecio();//precio unitario
			Long cantidad=produ.getCantidad();//cantidad
			//Float imp=presupuesto.getTipoImpuestoPorcentaje();
			//Long Honorarios1=presupuesto.getHonorariosTransporte();
			Long idImp=presupuesto.getTipoImpuesto();// impuesto
			Long Honorarios=despachante.getHonorarios();// honorarios despachante
			Long HonorariosId=presupuesto.getTipoTransporte();//honorarios transporte
			Long HonorariosAa=presupuesto.getTipoAlmacenamiento();//honorarios almacenamiento
			
			if(tipoImpuestoRepository.existsById(idImp)==true) { //verificar que el impuesto exista
				Optional<Impuesto> recuperarImp = tipoImpuestoRepository.findById(idImp);
				Impuesto impExistente = recuperarImp.get();
				imp=impExistente.getPorcentaje();
				System.out.println("entrando2");
			}else {
				throw new ExceptionText(String.format("El impuesto no existe, vuelva a intentar con uno diferente"));
			}
			if(transporteRepository.existsById(HonorariosId)==true) { //verificar que el transporte exista
				Optional<Transporte> recuperarTra = transporteRepository.findById(HonorariosId);
				Transporte traExistente = recuperarTra.get();
				Honorarios1=traExistente.getHonorarios();
				System.out.println("entrando3");
			}else {
				throw new ExceptionText(String.format("El servicio de AgenteTransporte no existe, vuelva a intentar con uno diferente"));
			}
			
			if(almacenamientoRepository.existsById(HonorariosAa)==true) {//verificar que almacenamiento exista
				Optional<Almacenamiento> recuperarImp = almacenamientoRepository.findById(HonorariosAa);
				Almacenamiento impExistente = recuperarImp.get();
				HonorariosA=impExistente.getHonorarios();
				System.out.println("entrando2");
			}else {
				throw new ExceptionText(String.format("El almacenamiento no existe, vuelva a intentar con uno diferente"));
			}
			
			mercosurr = (verProcedencia(presupuesto.getOrigen()));
			
			if (mercosurr==1) {
				System.out.println("El origen pertenece al mercosur");
			}
			// calcular presupuesto
			Float TOTAL=(calcularPresupuesto.generarPresupuesto(precio,cantidad,imp,Honorarios,Honorarios1,HonorariosA));//utilidad generarPresu
			presupuesto.setTotalPresupuesto(TOTAL); //total
			return generarPresupuestoRepository.save(presupuesto); //guardamos
		}else {
			throw new GeneralLP3Exception("Error inesperado al generar presupuesto."); //si no existe el producto
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	////////////////////////
	//crear 2 presupuestos//
	////////////////////////
	
	
	/*guardamos presupuesto de 2 producto*/
	
	/*verificamos que existan los productos o lanzamos Excepcion.
	 * En caso de que exista; guardamos en variables los datos, 
	 * generamos presupuesto de cada producto con la utilidad y agregamos a una lista para luego guardar.*/
	
	@Override
	public List<Presupuesto> save1 (Long id1, Long id2, Presupuesto presupuesto) throws ExceptionText {
		Float imp=(float) 0.0;
		Long HonorariosT=(long)0;
		Float imp1=(float) 0.0;
		Long HonorariosT1=(long)0;
		Long HonorariosA=(long)0;
		Long HonorariosA1=(long)0; 
		
		// presupuesto para 1 producto
		Despachante despachante = new Despachante();
		Producto produ = null;
		// verificamos si los id de productos existen o mandamos excepcion
		Optional<Producto> produFromBD = productoRepository.findById(id1);
		Optional<Producto> produFromBD1 = productoRepository.findById(id2);
		List<Presupuesto> presupuestoList = new ArrayList<>();
		if (produFromBD.isPresent() && produFromBD1.isPresent()) { //si existen guardamos sus datos
			produ = produFromBD.get();
			Long precio=produ.getPrecio();//precio producto
			Long cantidad=produ.getCantidad();//cantidad producto
			Long idImp=presupuesto.getTipoImpuesto();
			Long Honorarios=despachante.getHonorarios();// honorarios despachante
			Long HonorariosId=presupuesto.getTipoTransporte();
			Long HonorariosAa=presupuesto.getTipoAlmacenamiento();

			if(tipoImpuestoRepository.existsById(idImp)) {// verificar existencia de impuesto
				Optional<Impuesto> recuperarImp = tipoImpuestoRepository.findById(idImp);
				Impuesto impExistente = recuperarImp.get();
				imp=impExistente.getPorcentaje();
			}else {
				throw new ExceptionText(String.format("El impuesto no existe, vuelva a intentar con uno diferente"));
			}
			if(transporteRepository.existsById(HonorariosId)) {// verificar existencia de transporte
				Optional<Transporte> recuperarTra = transporteRepository.findById(HonorariosId);
				Transporte traExistente = recuperarTra.get();
				HonorariosT=traExistente.getHonorarios();
			}else {
				throw new ExceptionText(String.format("El servicio de AgenteTransporte no existe, vuelva a intentar con uno diferente"));
			}
			
			if(almacenamientoRepository.existsById(HonorariosAa)==true) {// verificar existencia de almacenamiento
				Optional<Almacenamiento> recuperarImp = almacenamientoRepository.findById(HonorariosAa);
				Almacenamiento impExistente = recuperarImp.get();
				HonorariosA=impExistente.getHonorarios();
				System.out.println("entrando2");
			}else {
				throw new ExceptionText(String.format("El almacenamiento no existe, vuelva a intentar con uno diferente"));
			}
			//enviamos a utilidad generar presupuesto
			Float TOTAL=(calcularPresupuesto.generarPresupuesto(precio,cantidad,imp,Honorarios,HonorariosT,HonorariosA)); //calculo presupuesto con utilidad
			presupuesto.setTotalPresupuesto(TOTAL); //total
			presupuestoList.add(presupuesto); // agregamos a la lista
			
			// 2do producto
			
			Presupuesto presupuesto1 = new Presupuesto();
			Producto produ1 = null;
			//guardamos datos para el calculo
			produ1 = produFromBD1.get();
			Long precio1=produ1.getPrecio();
			Long cantidad1=produ1.getCantidad();//precioTotal
			Long idImp1=presupuesto.getTipoImpuesto();
			Long HonorariosD=despachante.getHonorarios();// honorarios despachante
			Long HonorariosId1=presupuesto.getTipoTransporte();
			Long HonorariosAa1=presupuesto.getTipoAlmacenamiento();

			//verificamos existencia de los datos del json
			if(tipoImpuestoRepository.existsById(idImp1)) {
				Optional<Impuesto> recuperarImp1 = tipoImpuestoRepository.findById(idImp1);
				Impuesto impExistente1 = recuperarImp1.get();
				imp1=impExistente1.getPorcentaje();
			}else {
				throw new ExceptionText(String.format("El impuesto no existe, vuelva a intentar con uno diferente"));
			}
			if(transporteRepository.existsById(HonorariosId1)) {
				Optional<Transporte> recuperarTra1 = transporteRepository.findById(HonorariosId1);
				Transporte traExistente1 = recuperarTra1.get();
				HonorariosT1=traExistente1.getHonorarios();
			}else {
				throw new ExceptionText(String.format("El servicio de AgenteTransporte no existe, vuelva a intentar con uno diferente"));
			}
			
			if(almacenamientoRepository.existsById(HonorariosAa1)==true) {
				Optional<Almacenamiento> recuperarImp = almacenamientoRepository.findById(HonorariosAa1);
				Almacenamiento impExistente = recuperarImp.get();
				HonorariosA1=impExistente.getHonorarios();
				System.out.println("entrando2");
			}else {
				throw new ExceptionText(String.format("El almacenamiento no existe, vuelva a intentar con uno diferente"));
			}
			//guardamos en la lista y en total para generar presupuesto
			Float TOTAL1=(calcularPresupuesto.generarPresupuesto(precio1,cantidad1,imp1,HonorariosD,HonorariosT1,HonorariosA1));
			presupuesto1.setTotalPresupuesto(TOTAL1); //total
			presupuesto1.setTipoImpuesto(presupuesto.getTipoImpuesto());
			presupuesto1.setTipoTransporte(presupuesto.getTipoTransporte());
			presupuesto1.setOrigen(presupuesto.getOrigen());
			presupuesto1.setDestino(presupuesto.getDestino());
			presupuesto1.setTipoAlmacenamiento(presupuesto.getTipoAlmacenamiento());
			presupuestoList.add(presupuesto1);
			return (List<Presupuesto>) generarPresupuestoRepository.saveAll(presupuestoList);
			
		}else {
			throw new GeneralLP3Exception("Error inesperado al generar presupuesto.");
		}
	}
	
	
	
	
	
	
	
	
	
	
	///////////////////////////
	//generar 3 presupuestos///
	//////////////////////////
	
	@Override
	public List<Presupuesto> save2 (Long id1, Long id2, Long id3, Presupuesto presupuesto) throws ExceptionText {
		
		/*guardamos presupuesto de 3 productos*/
		/*verificamos que existan los productos o lanzamos Excepcion.
		 * En caso de que existan; guardamos en variables los datos, 
		 * generamos presupuesto de cada producto con la utilidad y agregamos a una lista para luego guardar.
		 * 
		 * LOS DATOS AGREGADOS EN JSON BODY SON EL MISMO PARA LOS 3*/
		Float imp=(float) 0.0;
		Long HonorariosT=(long)0;
		Float imp1=(float) 0.0;
		Long HonorariosT1=(long)0;
		Float imp2=(float) 0.0;
		Long HonorariosT2=(long)0;
		Long HonorariosA=(long)0;
		Long HonorariosA1=(long)0;
		Long HonorariosA2=(long)0;
		
		
		Despachante despachante = new Despachante();
		Producto produ = null;
		Optional<Producto> produFromBD = productoRepository.findById(id1);
		Optional<Producto> produFromBD1 = productoRepository.findById(id2);
		Optional<Producto> produFromBD2 = productoRepository.findById(id3);
		List<Presupuesto> presupuestoList = new ArrayList<>();
		if (produFromBD.isPresent() && produFromBD1.isPresent() && produFromBD2.isPresent()) {
			produ = produFromBD.get();
			Long precio=produ.getPrecio();//precio producto
			Long cantidad=produ.getCantidad();//cantidad producto
			Long idImp=presupuesto.getTipoImpuesto();
			Long Honorarios=despachante.getHonorarios();// honorarios despachante
			Long HonorariosId=presupuesto.getTipoTransporte();
			Long HonorariosAa=presupuesto.getTipoAlmacenamiento();
			
	
			if(tipoImpuestoRepository.existsById(idImp)) {
				Optional<Impuesto> recuperarImp = tipoImpuestoRepository.findById(idImp);
				Impuesto impExistente = recuperarImp.get();
				imp=impExistente.getPorcentaje();
			}else {
				throw new ExceptionText(String.format("El impuesto no existe, vuelva a intentar con uno diferente"));
			}
			if(transporteRepository.existsById(HonorariosId)) {
				Optional<Transporte> recuperarTra = transporteRepository.findById(HonorariosId);
				Transporte traExistente = recuperarTra.get();
				HonorariosT=traExistente.getHonorarios();
			}else {
				throw new ExceptionText(String.format("El servicio de AgenteTransporte no existe, vuelva a intentar con uno diferente"));
			}
			
			
			if(almacenamientoRepository.existsById(HonorariosAa)==true) {
				Optional<Almacenamiento> recuperarImp = almacenamientoRepository.findById(HonorariosAa);
				Almacenamiento impExistente = recuperarImp.get();
				HonorariosA=impExistente.getHonorarios();
				System.out.println("entrando2");
			}else {
				throw new ExceptionText(String.format("El almacenamiento no existe, vuelva a intentar con uno diferente"));
			}
			
			Float TOTAL=(calcularPresupuesto.generarPresupuesto(precio,cantidad,imp,Honorarios,HonorariosT,HonorariosA)); //calculo presupuesto con utilidad
			presupuesto.setTotalPresupuesto(TOTAL); //total
			presupuestoList.add(presupuesto); // agregamos a la lista
			
			// presupuesto 2
			
			Presupuesto presupuesto1 = new Presupuesto();
			Producto produ1 = null;
	
			produ1 = produFromBD1.get();
			Long precio1=produ1.getPrecio();
			Long cantidad1=produ1.getCantidad();//precioTotal
			Long idImp1=presupuesto.getTipoImpuesto();
			Long HonorariosD=despachante.getHonorarios();// honorarios despachante
			Long HonorariosId1=presupuesto.getTipoTransporte();
			Long HonorariosAa1=presupuesto.getTipoAlmacenamiento();
			
			
			if(tipoImpuestoRepository.existsById(idImp1)) {
				Optional<Impuesto> recuperarImp1 = tipoImpuestoRepository.findById(idImp1);
				Impuesto impExistente1 = recuperarImp1.get();
				imp1=impExistente1.getPorcentaje();
			}else {
				throw new ExceptionText(String.format("El impuesto no existe, vuelva a intentar con uno diferente"));
			}
			if(transporteRepository.existsById(HonorariosId1)) {
				Optional<Transporte> recuperarTra1 = transporteRepository.findById(HonorariosId1);
				Transporte traExistente1 = recuperarTra1.get();
				HonorariosT1=traExistente1.getHonorarios();
			}else {
				throw new ExceptionText(String.format("El servicio de AgenteTransporte no existe, vuelva a intentar con uno diferente"));
			}
			
			if(almacenamientoRepository.existsById(HonorariosAa1)==true) {
				Optional<Almacenamiento> recuperarImp = almacenamientoRepository.findById(HonorariosAa1);
				Almacenamiento impExistente = recuperarImp.get();
				HonorariosA1=impExistente.getHonorarios();
				System.out.println("entrando2");
			}else {
				throw new ExceptionText(String.format("El almacenamiento no existe, vuelva a intentar con uno diferente"));
			}
			
			Float TOTAL1=(calcularPresupuesto.generarPresupuesto(precio1,cantidad1,imp1,HonorariosD,HonorariosT1,HonorariosA1));
			presupuesto1.setTotalPresupuesto(TOTAL1); //total
			presupuesto1.setTipoImpuesto(presupuesto.getTipoImpuesto());
			presupuesto1.setTipoTransporte(presupuesto.getTipoTransporte());
			presupuesto1.setOrigen(presupuesto.getOrigen());
			presupuesto1.setDestino(presupuesto.getDestino());
			presupuesto1.setTipoAlmacenamiento(presupuesto.getTipoAlmacenamiento());
			presupuestoList.add(presupuesto1);
			
			// presupuesto 3
		
			
			Presupuesto presupuesto2 = new Presupuesto();
			Producto produ2 = null;
	
			produ2 = produFromBD2.get();
			Long precio2=produ2.getPrecio();
			Long cantidad2=produ2.getCantidad();//precioTotal
			Long idImp2=presupuesto.getTipoImpuesto();
			Long HonorariosD2=despachante.getHonorarios();// honorarios despachante
			Long HonorariosId2=presupuesto.getTipoTransporte();
			Long HonorariosAa2=presupuesto.getTipoAlmacenamiento();
			
			
			if(tipoImpuestoRepository.existsById(idImp2)) {
				Optional<Impuesto> recuperarImp2 = tipoImpuestoRepository.findById(idImp2);
				Impuesto impExistente2 = recuperarImp2.get();
				imp2=impExistente2.getPorcentaje();
			}else {
				throw new ExceptionText(String.format("El impuesto no existe, vuelva a intentar con uno diferente"));
			}
			if(transporteRepository.existsById(HonorariosId1)) {
				Optional<Transporte> recuperarTra2 = transporteRepository.findById(HonorariosId2);
				Transporte traExistente2 = recuperarTra2.get();
				HonorariosT2=traExistente2.getHonorarios();
			}else {
				throw new ExceptionText(String.format("El servicio de AgenteTransporte no existe, vuelva a intentar con uno diferente"));
			}
			
			if(almacenamientoRepository.existsById(HonorariosAa2)==true) {
				Optional<Almacenamiento> recuperarImp = almacenamientoRepository.findById(HonorariosAa2);
				Almacenamiento impExistente = recuperarImp.get();
				HonorariosA2=impExistente.getHonorarios();
				System.out.println("entrando2");
			}else {
				throw new ExceptionText(String.format("El almacenamiento no existe, vuelva a intentar con uno diferente"));
			}
			
			Float TOTAL2=(calcularPresupuesto.generarPresupuesto(precio2,cantidad2,imp2,HonorariosD2,HonorariosT2,HonorariosA2));
			presupuesto2.setTotalPresupuesto(TOTAL2); //total
			presupuesto2.setTipoImpuesto(idImp2);
			presupuesto2.setTipoTransporte(HonorariosId2);
			presupuesto2.setOrigen(presupuesto.getOrigen());
			presupuesto2.setDestino(presupuesto.getDestino());
			presupuesto2.setTipoAlmacenamiento(presupuesto.getTipoAlmacenamiento());
			presupuestoList.add(presupuesto2);
			return (List<Presupuesto>) generarPresupuestoRepository.saveAll(presupuestoList);
			
		}else {
			throw new GeneralLP3Exception("Error inesperado al generar presupuesto.");
		}
		
	}
	
	/*
	 * Funcion para obtener una lista de todos los presupuestos Parametros: ninguno
	 * Retorno: List<Presupuesto> presupuesto : la lista de todos los presupuestos
	 */
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
	 * id enviado en el path ES de PRODUCTO
	 * 
	 * ID enviado en jsonBody el presupuestos a actualizar*/
	
	@Override
	public Presupuesto updatePresu(Long id1,Presupuesto presupuesto) throws ExceptionText {
		Long id2=presupuesto.getId(); // id de presupuesto a actualizar
		Float imp=(float) 0.0;
		Long HonorariosT=(long)0;
		Long HonorariosT1=(long)0;
		//buscamos si existe el el id presupuesto a actualizar
		
		if(generarPresupuestoRepository.findById(id2).isPresent()) { // verficamos que exista presupuesto con id
			
			Optional<Presupuesto> recuperarPresu = generarPresupuestoRepository.findById(presupuesto.getId());
			Presupuesto Existente = (Presupuesto) recuperarPresu.get(); //obtener presupuesto con id
			//actualizar datos siempre que no sea null
			if(presupuesto.getOrigen()!=null) {
				Existente.setOrigen(presupuesto.getOrigen());
			}
			if(presupuesto.getDestino()!=null) {
				Existente.setDestino(presupuesto.getDestino());
			}
			//actualizar datos siempre que no sea null
			if(presupuesto.getTipoTransporte()!=null) {
				Long Honorarios1=presupuesto.getTipoTransporte();
				if(transporteRepository.existsById(Honorarios1)) {
					System.out.println("ENTRANDOOOOOOOOOOOOOOO");
					Optional<Transporte> recuperarTra = transporteRepository.findById(Honorarios1);
					Transporte traExistente = recuperarTra.get();
					HonorariosT=traExistente.getHonorarios();
					Existente.setTipoTransporte(Honorarios1);
				}else {
					throw new ExceptionText(String.format("El servicio de AgenteTransporte no existe, vuelva a intentar con uno diferente"));
				}	
			}
			
			//actualizar datos siempre que no sea null
			if(presupuesto.getTipoImpuesto()!=null) {
				Long imp1=presupuesto.getTipoImpuesto();
				if(tipoImpuestoRepository.existsById(imp1)) {
					Optional<Impuesto> recuperarImp1 = tipoImpuestoRepository.findById(imp1);
					Impuesto impExistente1 = recuperarImp1.get();
					imp=impExistente1.getPorcentaje();
					Existente.setTipoImpuesto(imp1);
				}else {
					throw new ExceptionText(String.format("El impuesto no existe, vuelva a intentar con uno diferente"));
				}	
			}
			
			
			//actualizar datos siempre que no sea null
			if(presupuesto.getTipoAlmacenamiento()!=null) {
				Long Honorarios2=presupuesto.getTipoAlmacenamiento();
				if(almacenamientoRepository.existsById(Honorarios2)) {
					Optional<Almacenamiento> recuperarTra1 = almacenamientoRepository.findById(Honorarios2);
					Almacenamiento traExistente1 = recuperarTra1.get();
					HonorariosT1=traExistente1.getHonorarios();
					Existente.setTipoAlmacenamiento(Honorarios2);
				}else {
					throw new ExceptionText(String.format("El servicio de almacenamiento no existe, vuelva a intentar con uno diferente"));
				}	
			}
			
			
			// generar presu de producto modificado 
			Despachante despachante = new Despachante();
			Producto produ = null;
			Optional<Producto> produFromBD = productoRepository.findById(id1); //id1 producto
			if (produFromBD.isPresent()) {
				produ = produFromBD.get();
					Long precio=produ.getPrecio();
					Long cantidad=produ.getCantidad();
					Long Honorarios=despachante.getHonorarios();
					Float TOTAL=(calcularPresupuesto.generarPresupuesto(precio,cantidad,imp,Honorarios,HonorariosT,HonorariosT1));
					Existente.setTotalPresupuesto(TOTAL); //total
					return generarPresupuestoRepository.save(Existente);
			}else {
				throw new GeneralLP3Exception("Error inesperado al actualizar presupuesto.");
			}
		}else {
			throw new GeneralLP3Exception("Error inesperado al actualizar presupuesto.");
		}
	}
	Integer verProcedencia (String o) {
		Integer flag=0 ;
		String[] mercosur= {"Argentina", "Paraguay", "Brasil", "Bolivia","Venezuela","Uruguay"};
		for(int i=0;i<5;i++) {
			if (o==mercosur[i]) {
				flag=1;
			}
		}
		return flag;
		
	}
	
}
