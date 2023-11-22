package ar.edu.unlam.pb2;

import java.util.Objects;

public abstract class Tarjeta extends MedioAsociado {

	private String nombre;
	private Integer numero;
	private Double saldo;

	public Tarjeta(String nombre, Integer id, Double saldo) {
		super(nombre, id, saldo);
		// TODO Auto-generated constructor stub
		this.numero = id;
		this.nombre = nombre;
		this.saldo = saldo;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(nombre);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		Tarjeta other = (Tarjeta) obj;
		return Objects.equals(nombre, other.nombre);
	}

}
