package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;

public class Debito extends Tarjeta implements Pagadora {

	private Double saldo;

	public Debito(String nombre, Integer id, Double saldo) {
		super(nombre, id, saldo);
		// TODO Auto-generated constructor stub
		this.saldo = saldo;
	}

	@Override
	public Boolean pagar(Persona vendedor, Double importe) throws SaldoInsuficienteException {
		// TODO Auto-generated method stub
		if (vendedor != null && getSaldo() >= importe) {
			return true;
		}
		throw new SaldoInsuficienteException();
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}
