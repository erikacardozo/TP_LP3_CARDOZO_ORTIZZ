package py.edu.uc.lp3.service;
import java.util.List;

import py.edu.uc.lp3.domain.Transporte;

public interface TransporteService {
	List<Transporte> findAll();
    void deleteTransporteById(Long id);
    Transporte save(Transporte transporte);///pq retorna un Transporte, tipo de mercaderia y por id
	Transporte updateTransporte(long id, Transporte transporte);
}
