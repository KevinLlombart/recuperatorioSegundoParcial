package ar.edu.unlam.pb2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Billetera {

	private String nombre;
	private Set<MedioAsociado>medios;
	private Set<Persona>personas;
	private Map<String, Persona>mediosAsociados;

	public Billetera(String nombre) {
		super();
		this.nombre = nombre;
		this.mediosAsociados = new HashMap<String, Persona>();
		this.medios = new HashSet<MedioAsociado>();
		this.personas = new HashSet<Persona>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregarPersona(Persona persona) {
		personas.add(persona);
	}
	
	public void agregarMedio(MedioAsociado medio) {
		medios.add(medio);
	}
	
	public Integer cantidadMedioAsociados() {
		return medios.size();
	}

	
	public MedioAsociado buscarMedio(String nombreMedio) {
		for (MedioAsociado medioAsociado : medios) {
			if (medioAsociado.getNombre().equals(nombreMedio)) {
				return medioAsociado;
			}
		}
		return null;
	}
	
	public Integer cantidadMedios() {
		return medios.size();
	}
	
	public Integer cantidadPersonas() {
		return personas.size();
	}
}
