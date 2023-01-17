package py.edu.uc.lp3.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uc.lp3.domain.Organizaciones;
import py.edu.uc.lp3.repository.OrganizacionesRepository;
import py.edu.uc.lp3.service.OrganizacionesService;
import py.edu.uc.lp3exceptions.GeneralLP3Exception;

@Service
public class OrganizacionesServiceImpl implements OrganizacionesService {
	@Autowired
	private OrganizacionesRepository organizacionesRepository;
	@Override
	/* Funcion para guardar una organizacion con persistencia
	 * Parametros: Organizaciones organizaciones : la organizacion que guardaremos  
	 * Retorno: ninguno
	 */
	public void save(Organizaciones organizaciones) {
		// TODO Auto-generated method stub
		try {
			organizacionesRepository.save(organizaciones);
		}catch(Error error) {
			System.out.println(error);
			throw new GeneralLP3Exception("Error inesperado al guardar organizaciones.");
		}
		
		
		
	}
	/*
	 * Funcion para obtener una lista de todos las organizaciones 
	 * Parametros: ninguno
	 * Retorno: List<Organizaciones> organizaciones : la lista de todos las organizaciones
	 */
	@Override
	public List<Organizaciones> findAll() {
		List<Organizaciones> organizaciones = new ArrayList<>();
		Iterator<Organizaciones> iteratorOrg = organizacionesRepository.findAll().iterator();
		while (iteratorOrg.hasNext()) {
			organizaciones.add(iteratorOrg.next());
		}
		return organizaciones;
	}

	/* Funcion para obtener una lista de todas las organizaciones de un tipo
	 * Parametros: String tipoDeOrganizacion
	 * Retorno: organizacionesRepository.findByTipoDeOrganizacion(tipoDeOrganizacion)
	 * : la lista de todos las organizaciones de ese tipo
	 */
	@Override
	public List<Organizaciones> findByTipoDeOrganizacion(String tipoDeOrganizacion) {
		// TODO Auto-generated method stub
		try {
			return organizacionesRepository.findByTipoDeOrganizacion(tipoDeOrganizacion);
		}catch(Error error){
			System.out.println(error);
			throw new GeneralLP3Exception("Error. No se encuentran ninguna organizacion de tipo" + tipoDeOrganizacion);
		}
		
	}
	/*
	 * Funcion para actualizar una organizacion con persistencia
	 * Parametros: Long IDOrganizacion : el id de la organizacion que actualizaremos
	 * Organizaciones organizaciones : es la organizacion que guardaremos 
	 * Retorno: organizacionesRepository.save(_organizaciones): guardar los nuevos datos
	 *  de la organizacion
	 */
	@Override
	public Organizaciones updateOrg(Long IDOrganizacion, Organizaciones organizaciones) {
		// TODO Auto-generated method stub
		if(organizacionesRepository.findById(IDOrganizacion).isPresent()) {
			Organizaciones _organizaciones = organizacionesRepository.findById(IDOrganizacion).get();

			_organizaciones.setTipoDeOrganizacion(organizaciones.getTipoDeOrganizacion());
			_organizaciones.setDescripcion(organizaciones.getDescripcion());
			return organizacionesRepository.save(_organizaciones);
		}else {
			throw new GeneralLP3Exception("Error inesperado al actualizar organizacion.");
		}
	}
	/* Funcion para eliminar un usuario con persistencia
	 * Parametros: Long IDOrganizacion: el id de la organizacion que eliminaremos  
	 * Retorno: ninguno
	 */
	@Override
	public void deleteOrg(Long IDOrganizacion) {
		// TODO Auto-generated method stub
		if (organizacionesRepository.existsById(IDOrganizacion)){
			organizacionesRepository.deleteById(IDOrganizacion);
		}else {
			throw new GeneralLP3Exception("Error.No se encuentran organizaciones con id: " + IDOrganizacion);
		}
		
	}

	
}
