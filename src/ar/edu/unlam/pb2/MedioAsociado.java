package ar.edu.unlam.pb2;

import java.util.Objects;

public abstract class MedioAsociado {

	private String nombre;
	private Integer id;
	private Double saldo;

	public MedioAsociado(String nombre, Integer id, Double saldo) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.saldo = saldo;
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

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		MedioAsociado other = (MedioAsociado) obj;
		return Objects.equals(id, other.id);
	}

}
