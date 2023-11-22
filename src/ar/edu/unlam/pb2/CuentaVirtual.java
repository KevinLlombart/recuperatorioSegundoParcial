package ar.edu.unlam.pb2;

public class CuentaVirtual extends MedioAsociado implements Pagadora, Transferible {

	private Integer cvu;
	private Double saldo;

	public CuentaVirtual(String nombre, Integer id, Double saldo) {
		super(nombre, id, saldo);
		// TODO Auto-generated constructor stub
		this.cvu = id;
		this.saldo = saldo;
	}

	public Integer getCvu() {
		return cvu;
	}

	public void setCvu(Integer cvu) {
		this.cvu = cvu;
	}

	public void setSaldo(Double saldo) {
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

	@Override
	public Double getSaldo() {
		// TODO Auto-generated method stub
		return saldo;
	}

	public Boolean esInsuficiente(Double importe) throws SaldoInsuficienteException {
		if (getSaldo() >= importe) {
			return false;
		} else {
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
