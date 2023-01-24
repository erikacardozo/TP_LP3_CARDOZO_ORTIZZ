package py.edu.uc.lp3.service;
import java.util.List;

import py.edu.uc.lp3.domain.Impuesto;

public interface TipoImpuestoService {
	List<Impuesto> findAll();
    void deleteImpuestoById(Long id);
    Impuesto save(Impuesto impuesto);///pq retorna un impuesto, tipo de mercaderia y por id
	Impuesto updateImpuesto(long id, Impuesto impuesto);
}
