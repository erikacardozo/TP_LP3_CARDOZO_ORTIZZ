package py.edu.uc.lp3.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.edu.uc.lp3.domain.Almacenamiento;
import py.edu.uc.lp3.repository.AlmacenamientoRepository;
import py.edu.uc.lp3.service.AlmacenamientoService;
import py.edu.uc.lp3exceptions.GeneralLP3Exception;
@Service
public class AlmacenamientoImpl implements AlmacenamientoService{

	
	@Autowired
	private AlmacenamientoRepository almacenamientoRepository;
	
	/*listar todos los almacenamiento*/
	
	@Override
	public List<Almacenamiento> findAll() {
		List<Almacenamiento> Almacenamiento = new ArrayList<>();
		Iterator<Almacenamiento> iteratorTransporte = almacenamientoRepository.findAll().iterator();
		while (iteratorTransporte .hasNext()) {
			Almacenamiento.add(iteratorTransporte.next());
		}
		return Almacenamiento;
	}

	/*eliminar por id un almacenamiento*/
	
	@Override
	public void deleteAlmacenamientoById(Long id) {
		if (almacenamientoRepository.existsById(id)){
			almacenamientoRepository.deleteById(id);
		}else {
			throw new GeneralLP3Exception("Error.No se encuentran almacenamiento con id: " + id);
		}
		
	}

	/*guardamos almacenamiento*/
	
	@Override
	public Almacenamiento save(Almacenamiento almacenamiento) {
		try {
			return almacenamientoRepository.save(almacenamiento);
		}catch(Error error) {
			System.out.println(error);
			throw new GeneralLP3Exception("Error inesperado al guardar almacenamiento.");
		}
	}
	
	/*actualizamos almacenamiento por id en caso de que no sea null los datos agregados
	 * retona: almacenamiento actualizado*/ 
	
	@Override
	public Almacenamiento updateAlmacenamiento (long id, Almacenamiento almacenamiento) {
		if(almacenamientoRepository.findById(id).isPresent()) {
			Almacenamiento _Almacenamiento = almacenamientoRepository.findById(id).get();
			if(!almacenamiento.getTipoAlmacenamiento().isEmpty()) {
				_Almacenamiento.setTipoAlmacenamiento(almacenamiento.getTipoAlmacenamiento());
			}
			if(!almacenamiento.getCapacidad().isEmpty()) {
				_Almacenamiento.setCapacidad(almacenamiento.getCapacidad());
			}
			if(almacenamiento.getHonorarios()!=null) {
				_Almacenamiento.setHonorarios(almacenamiento.getHonorarios());
			}
			return almacenamientoRepository.save(_Almacenamiento); 
		}else {
			throw new GeneralLP3Exception("Error inesperado al actualizar almacenamiento.");
		} 
	}
	
	

}
