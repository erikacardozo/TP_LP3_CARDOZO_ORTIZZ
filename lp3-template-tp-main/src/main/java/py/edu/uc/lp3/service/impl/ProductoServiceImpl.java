package py.edu.uc.lp3.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uc.lp3.domain.Producto;
import py.edu.uc.lp3.repository.ProductoRepository;
import py.edu.uc.lp3.service.ProductoService;
import py.edu.uc.lp3exceptions.GeneralLP3Exception;

@Service
public class ProductoServiceImpl implements ProductoService{
	@Autowired
	private ProductoRepository productoRepository;

	/*
	 * Funcion para obtener una lista de todos los productos 
	 * Parametros: ninguno
	 * Retorno: List<Producto> : la lista de todos los productos
	 */
	
	@Override
	public List<Producto> findAllProducts() {
		// TODO Auto-generated method stub
		
		List<Producto> productos = new ArrayList<>();
		Iterator<Producto> iteratorProducto = productoRepository.findAll().iterator();
		while (iteratorProducto.hasNext()) {
			productos.add(iteratorProducto.next());
		}
		return productos;
	}

	/* Funcion para guardar un producto
	 * Parametros: Producto producto : el producto que guardaremos  
	 * Retorno: producto guardado
	 */
	
	@Override
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		try {
			return productoRepository.save(producto);
			
		}catch(Error error) {
			System.out.println(error);
			throw new GeneralLP3Exception("Error inesperado al guardar producto.");
		}
	}

	/* Funcion para eliminar un producto
	 * Parametros: Long id: el id del producto que eliminaremos  
	 * Retorno: ninguno
	 */
	
	@Override
	public void deleteProductById(Long id) {
		// TODO Auto-generated method stub
		if (productoRepository.existsById(id)){
			productoRepository.deleteById(id);
		}else {
			throw new GeneralLP3Exception("Error.No se encuentran productos con id: " + id);
		}
	}
	
	/*
	 * Funcion para actualizar un producto 
	 * Parametros: Long id : el id del producto que actualizaremos
	 * Retorno: productoRepository.save(Existente) : guardar los nuevos datos
	 *  del producto
	 */
	@Override
	public Producto updateProducto(Long id,Producto productos) {
		/// TODO Auto-generated method stub
		//if(productos.getId() != null && productoRepository.existsById(productos.getId())) {
		if(productoRepository.findById(id).isPresent()) {
			Producto Existente = productoRepository.findById(id).get();

			if(productos.getCantidad()!=null) {
				Existente.setCantidad(productos.getCantidad());
			}
			if(productos.getPrecio()!=null) {
				Existente.setPrecio(productos.getPrecio());	
			}
			if(productos.getPeso()!=null) {
				Existente.setPeso(productos.getPeso());
			}
			if(!productos.getTipoProducto().isEmpty()) {
				Existente.setTipoProducto(productos.getTipoProducto());
			}
			if(!productos.getOrigen().isEmpty()) {
				Existente.setOrigen(productos.getOrigen());
			}
			if(!productos.getDestino().isEmpty()) {
				Existente.setDestino(productos.getDestino());
			}
	
			return productoRepository.save(Existente);
		}else {
			throw new GeneralLP3Exception("Error inesperado al actualizar producto.");
		}
	}

	/* listar por tipo producto
	 * parametro: string tipoProducto
	 * retorna: lista de esos tipo de producto */
	
	@Override
	public List<Producto> findBytipoProducto(String tipoProducto) {
		// TODO Auto-generated method stub
		try {
			return productoRepository.findBytipoProducto(tipoProducto);
		}catch(Error error){
			System.out.println(error);
			throw new GeneralLP3Exception("Error. No se encuentran productos con este tipoProducto" + tipoProducto);
		}
	}

}
