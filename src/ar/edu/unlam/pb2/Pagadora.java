package ar.edu.unlam.pb2;

public interface Pagadora {

	Boolean pagar(Persona vendedor, Double importe) throws ExcedeLimiteDeCompraException, SaldoInsuficienteException;
}
