package py.edu.uc.lp3.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uc.lp3.domain.Transporte;
import py.edu.uc.lp3.repository.TransporteRepository;
import py.edu.uc.lp3.service.TransporteService;
import py.edu.uc.lp3exceptions.GeneralLP3Exception;
@Service
public class TransporteImpl implements TransporteService{

	
	@Autowired
	private TransporteRepository transporteRepository;
	
	@Override
	public List<Transporte> findAll() {
		List<Transporte> Transportes = new ArrayList<>();
		Iterator<Transporte> iteratorTransporte = transporteRepository.findAll().iterator();
		while (iteratorTransporte .hasNext()) {
			Transportes.add(iteratorTransporte.next());
		}
		return Transportes;
	}

	@Override
	public void deleteTransporteById(Long id) {
		if (transporteRepository.existsById(id)){
			transporteRepository.deleteById(id);
		}else {
			throw new GeneralLP3Exception("Error.No se encuentran Transportes con id: " + id);
		}
		
	}

	@Override
	public Transporte save(Transporte transporte) {
		try {
			return transporteRepository.save(transporte);
			//return Transporte;
		}catch(Error error) {
			System.out.println(error);
			throw new GeneralLP3Exception("Error inesperado al guardar Transporte.");
		}
	}


	@Override
	public Transporte updateTransporte (long id, Transporte transporte) {
		if(transporteRepository.findById(id).isPresent()) {
			Transporte _Transporte = transporteRepository.findById(id).get();
			_Transporte.setTipoTransporte(transporte.getTipoTransporte());
			_Transporte.setCapacidad(transporte.getCapacidad());
			_Transporte.setHonorarios(transporte.getHonorarios());
			return transporteRepository.save(_Transporte); 
		}else {
			throw new GeneralLP3Exception("Error inesperado al actualizar Transporte.");
		} 
	}
	
	

}
