package py.edu.uc.lp3.service;

import java.util.List;

import py.edu.uc.lp3.domain.Presupuesto;
import py.edu.uc.lp3.domain.Producto;
import py.edu.uc.lp3.domain.Transporte;

public interface GenerarPresupuestoService {

	//Producto findById(Long id);

	//Transporte find(Long id);


	//Long save(Long id);

	//Long save(Long id, Long presupuesto);

	//Presupuesto save(Long id, long presupuesto);

	public Presupuesto save (Long id, Presupuesto presupuesto);

	public List<Presupuesto> findAll();

	void deletePresupuestoById(Long id);

	List<Presupuesto> save1(Long id1, Long id2, Presupuesto presupuesto);

	

//	Presupuesto save(Long id, Presupuesto presupuesto);

	//Long save(Presupuesto presupuesto);

	//Presupuesto save(Presupuesto presupuesto);


}
