package ar.edu.unlam.pb2;

public class Fisica extends Persona {

	private Integer cuil;

	public Fisica(String nombre, Integer id) {
		super(nombre, id);
		// TODO Auto-generated constructor stub
		this.cuil = id;
	}

	public Integer getCuil() {
		return cuil;
	}

	public void setCuil(Integer cuil) {
		this.cuil = cuil;
	}

}
