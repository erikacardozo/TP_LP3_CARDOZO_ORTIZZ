package py.edu.uc.lp3.service;

import java.util.List;

import py.edu.uc.lp3.domain.Presupuesto;

public interface GenerarPresupuestoService {


	public Presupuesto save (Long id, Presupuesto presupuesto);

	public List<Presupuesto> findAll();

	void deletePresupuestoById(Long id);

	List<Presupuesto> save1(Long id1, Long id2, Presupuesto presupuesto);

	Presupuesto updatePresu(Long id1, Presupuesto presupuesto);

	List<Presupuesto> save2(Long id1, Long id2, Long id3, Presupuesto presupuesto);


}
