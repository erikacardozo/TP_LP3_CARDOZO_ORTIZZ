package py.edu.uc.lp3.utilidades;

import com.example.restservice.localizacion;

import py.edu.uc.lp3.herencia.GPSTraceable;
import py.edu.uc.lp3.herencia.Persona;

public class Tracker {

	public static void rastrear(GPSTraceable rastreable) {
		//Acá informamos de la ubicación
		//Y se podría pintar en un mapa
		System.out.println("Ubicación: " + rastreable.getPosicion());		
		System.out.println("Mi ícono es: " + rastreable.getIcon());
		
	}

}
