package ar.edu.unlam.pb2;

import java.util.HashMap;
import java.util.Map;

public abstract class Persona {

	private String nombre;
	private Integer id;
	private Map<Integer, MedioAsociado> medios;

	public Persona(String nombre, Integer id) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.medios = new HashMap<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void asociarMedioAPersona(Integer idPersona, MedioAsociado medio) {
		medios.put(idPersona, medio);
	}
	
	public Integer cantidadMedioAsociados() {
		return medios.size();
	}

}
