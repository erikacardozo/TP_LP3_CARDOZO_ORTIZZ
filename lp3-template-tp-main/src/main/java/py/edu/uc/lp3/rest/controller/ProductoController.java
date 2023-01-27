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
import py.edu.uc.lp3.domain.Producto;
import py.edu.uc.lp3.service.ProductoService;


@RestController
@RequestMapping(ApiPaths.PRODUCTO)
public class ProductoController {
	@Autowired
	  
	private ProductoService productoService;
	//Llama a la funcion para ver a todos los productos por metodo GET
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Producto> list() {
		return productoService.findAllProducts();
	}
	
	//Llama a la funcion para agregar una productos por metodo POST
	@PostMapping()
	public Producto add(@RequestBody Producto producto) {
		return productoService.save(producto);
	}
	/*Llama a la funcion para ver a todos los tipos de productos diferentes
	 */
	@RequestMapping(value = "/{tipoProducto}", method = RequestMethod.GET)
	public List<Producto> listProducts(@PathVariable("tipoProducto") String tipoProducto){
		return productoService.findBytipoProducto(tipoProducto);
	}
	/*Llama a la funcion para eliminar un producto por su numero de id 
	 *  por metodo DELETE
	 */
	@DeleteMapping("/{id}")
	public void deleteProductById(@PathVariable long id) {
		productoService.deleteProductById(id);
	}

	/*Llama a la funcion para actualizar o cambiar los datos de un producto
	 * por su numero de id por metodo PUT
	 */
	@PutMapping()
	public ResponseEntity<Producto> updateProduct(@RequestBody Producto productos) {
		return new ResponseEntity<>(productoService.updateProducto(productos),HttpStatus.OK);
	}
}
