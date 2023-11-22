package ar.edu.unlam.pb2;

public class CuentaCorriente extends CuentaBancaria implements Transferible {
	
	private Double saldo;

	public CuentaCorriente(String nombre, Integer id, Double saldo) {
		super(nombre, id, saldo);
		// TODO Auto-generated constructor stub
		this.saldo = saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public Double getSaldo() {
		// TODO Auto-generated method stub
		return saldo;
	}

	@Override
	public void depositar(Double importe) {
		setSaldo(getSaldo() - importe);
	}

	@Override
	public Boolean extraer(Double importe) {
		// TODO Auto-generated method stub
		setSaldo(getSaldo() - importe);
		return true;
	}

}
