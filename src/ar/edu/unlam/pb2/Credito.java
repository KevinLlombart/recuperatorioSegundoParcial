package ar.edu.unlam.pb2;

public class Credito extends Tarjeta implements Pagadora {

	private Double limiteSaldo;
	private Double saldo;

	public Credito(String nombre, Integer id, Double saldo, Double limiteSaldo) {
		super(nombre, id, saldo);
		// TODO Auto-generated constructor stub
		this.saldo = saldo;
		this.limiteSaldo = limiteSaldo;
	}

	@Override
	public Boolean pagar(Persona vendedor, Double importe) throws ExcedeLimiteDeCompraException {
		// TODO Auto-generated method stub
		if (importe <= limiteSaldo) {
			return true;
		}
		throw new ExcedeLimiteDeCompraException();
	}

	public Double getLimiteSaldo() {
		return limiteSaldo;
	}

	public void setLimiteSaldo(Double limiteSaldo) {
		this.limiteSaldo = limiteSaldo;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}
