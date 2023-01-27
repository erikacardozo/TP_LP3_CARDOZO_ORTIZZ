package py.edu.uc.lp3.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import py.edu.uc.lp3.domain.Producto;


public interface ProductoService {
	List<Producto> findAllProducts();
	Producto save(Producto productos);
	List <Producto> findBytipoProducto(String tipoProducto);
	void deleteProductById(Long id);
	//Producto updateProducto(Long id,Producto productos);
	
	//Producto updateProducto(Long id, Producto productos);
	Producto updateProducto(Producto productos);
	
	
}
