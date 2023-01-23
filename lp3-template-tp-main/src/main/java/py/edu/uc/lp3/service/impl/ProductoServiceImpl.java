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

	@Override
	public Producto save(Producto productos) {
		// TODO Auto-generated method stub
		try {
			return productoRepository.save(productos);
		}catch(Error error) {
			System.out.println(error);
			throw new GeneralLP3Exception("Error inesperado al guardar usuario.");
		}
	}


	@Override
	public void deleteProductById(Long id) {
		// TODO Auto-generated method stub
		if (productoRepository.existsById(id)){
			productoRepository.deleteById(id);
		}else {
			throw new GeneralLP3Exception("Error.No se encuentran usuarios con id: " + id);
		}
	}
	

	@Override
	public Producto updateProducto(Long id, Producto productos) {
		// TODO Auto-generated method stub
		if(productoRepository.findById(id).isPresent()) {
			Producto _producto = productoRepository.findById(id).get();
			_producto.setCantidad(_producto.getCantidad());
			_producto.setPrecio(_producto.getPrecio());
			_producto.setPeso(_producto.getPeso());
			_producto.setTipoProducto(_producto.getTipoProducto());
			_producto.setOrigen(_producto.getOrigen());
			_producto.setDestino(_producto.getDestino());
			return productoRepository.save(_producto);
		}else {
			throw new GeneralLP3Exception("Error inesperado al actualizar usuario.");
		}
	}

	@Override
	public List<Producto> findBytipoProducto(String tipoProducto) {
		// TODO Auto-generated method stub
		try {
			return productoRepository.findBytipoProducto(tipoProducto);
		}catch(Error error){
			System.out.println(error);
			throw new GeneralLP3Exception("Error. No se encuentran usuarios con este rol" + tipoProducto);
		}
	}

}
