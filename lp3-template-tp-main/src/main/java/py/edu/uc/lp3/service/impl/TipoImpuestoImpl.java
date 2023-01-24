package py.edu.uc.lp3.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uc.lp3.domain.Impuesto;
import py.edu.uc.lp3.domain.Usuario;
import py.edu.uc.lp3.repository.TipoImpuestoRepository;
import py.edu.uc.lp3.service.TipoImpuestoService;
import py.edu.uc.lp3exceptions.GeneralLP3Exception;
@Service
public class TipoImpuestoImpl implements TipoImpuestoService{

	
	@Autowired
	private TipoImpuestoRepository tipoImpuestoRepository;
	
	@Override
	public List<Impuesto> findAll() {
		List<Impuesto> impuestos = new ArrayList<>();
		Iterator<Impuesto> iteratorImpuesto = tipoImpuestoRepository.findAll().iterator();
		while (iteratorImpuesto .hasNext()) {
			impuestos.add(iteratorImpuesto.next());
		}
		return impuestos;
	}

	@Override
	public void deleteImpuestoById(Long id) {
		if (tipoImpuestoRepository.existsById(id)){
			tipoImpuestoRepository.deleteById(id);
		}else {
			throw new GeneralLP3Exception("Error.No se encuentran impuestos con id: " + id);
		}
		
	}

	@Override
	public Impuesto save(Impuesto impuesto) {
		try {
			return tipoImpuestoRepository.save(impuesto);
			//return impuesto;
		}catch(Error error) {
			System.out.println(error);
			throw new GeneralLP3Exception("Error inesperado al guardar impuesto.");
		}
	}


	@Override
	public Impuesto updateImpuesto (long id, Impuesto impuesto) {
		if(tipoImpuestoRepository.findById(id).isPresent()) {
			Impuesto _impuesto = tipoImpuestoRepository.findById(id).get();
			_impuesto.setNombre(impuesto.getNombre());
			_impuesto.setPorcentaje(impuesto.getPorcentaje());	
			return tipoImpuestoRepository.save(_impuesto); 
		}else {
			throw new GeneralLP3Exception("Error inesperado al actualizar impuesto.");
		} 
	}
	
	

}
