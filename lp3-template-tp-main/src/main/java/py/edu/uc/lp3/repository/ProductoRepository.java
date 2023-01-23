package py.edu.uc.lp3.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import py.edu.uc.lp3.domain.Producto;


public interface ProductoRepository extends PagingAndSortingRepository<Producto, Long>{
	List <Producto> findBytipoProducto(String tipoProducto);
}
