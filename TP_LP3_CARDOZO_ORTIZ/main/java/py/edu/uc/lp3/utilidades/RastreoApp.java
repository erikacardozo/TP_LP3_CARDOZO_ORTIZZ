package py.edu.uc.lp3.utilidades;

import py.edu.uc.lp3.herencia.Profesor;
import py.edu.uc.lp3.interfaces.Avatar;
import py.edu.uc.lp3.interfaces.Superman;

public class RastreoApp {
	public static void main(String[] args) {
		Avatar ale = new Avatar();
	    Superman clark = new Superman();
	    Profesor  luca = new Profesor();
	    clark.setNombre("Clark");
	    clark.setApellido("Kent");
	    // TODO Auto-generated method stub
	    Tracker.rastrear(clark);
	    Vigilante.notificarExcepcion(luca);

	}

}
