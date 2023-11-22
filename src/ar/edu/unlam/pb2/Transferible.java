package ar.edu.unlam.pb2;

public interface Transferible {
	
	Double getSaldo();
	void depositar(Double importe) throws SaldoInsuficienteException; 
	Boolean extraer(Double importe);
}
