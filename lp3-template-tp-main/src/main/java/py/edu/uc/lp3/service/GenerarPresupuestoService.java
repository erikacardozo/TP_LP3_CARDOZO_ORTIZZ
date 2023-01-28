package py.edu.uc.lp3.service;

import java.util.List;

import py.edu.uc.lp3.domain.Presupuesto;
import py.edu.uc.lp3exceptions.ExceptionText;

public interface GenerarPresupuestoService {


	public Presupuesto save (Long id, Presupuesto presupuesto)throws ExceptionText;

	public List<Presupuesto> findAll();

	void deletePresupuestoById(Long id);

	List<Presupuesto> save1(Long id1, Long id2, Presupuesto presupuesto) throws ExceptionText;

	Presupuesto updatePresu(Long id1, Presupuesto presupuesto) throws ExceptionText;

	List<Presupuesto> save2(Long id1, Long id2, Long id3, Presupuesto presupuesto) throws ExceptionText;


}
