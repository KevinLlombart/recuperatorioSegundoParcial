package ar.edu.unlam.pb2;

public class Juridica extends Persona {

	private Integer cuit;
	private Boolean codigoQr;

	public Juridica(String nombre, Integer id) {
		super(nombre, id);
		// TODO Auto-generated constructor stub
		this.cuit = id;
		this.codigoQr = false;
	}

	public Integer getCuit() {
		return cuit;
	}

	public void setCuit(Integer cuit) {
		this.cuit = cuit;
	}

	public Boolean getCodigoQr() {
		return codigoQr;
	}

	public void setCodigoQr(Boolean codigoQr) {
		this.codigoQr = codigoQr;
	}

}