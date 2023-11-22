package ar.edu.unlam.pb2;

public class CuentaBancaria extends MedioAsociado implements Transferible {

	private Integer cbu;
	private Double saldo;

	public CuentaBancaria(String nombre, Integer id, Double saldo) {
		super(nombre, id, saldo);
		// TODO Auto-generated constructor stub
		this.cbu = id;
		this.saldo = saldo;
	}

	public Integer getCbu() {
		return cbu;
	}

	public void setCbu(Integer cbu) {
		this.cbu = cbu;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public Double getSaldo() {
		// TODO Auto-generated method stub
		return saldo;
	}

	public Boolean esInsuficiente(Double importe) throws SaldoInsuficienteException {
		if (getSaldo() >= importe) {
			return false;
		}else {
		throw new SaldoInsuficienteException();
		}
	}

	@Override
	public void depositar(Double importe) throws SaldoInsuficienteException {
		// TODO Auto-generated method stub
		if (!esInsuficiente(importe)) {
			setSaldo(getSaldo() - importe);
		}
	}

	@Override
	public Boolean extraer(Double importe) {
		// TODO Auto-generated method stub
		if (getSaldo() >= importe) {
			setSaldo(getSaldo() - importe);
			return true;
		}

		return false;
	}

}
