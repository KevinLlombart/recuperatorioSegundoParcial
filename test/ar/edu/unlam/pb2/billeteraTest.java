package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class billeteraTest {
	
//	queSePuedanAlmacenarLosDistintosTiposDeTransacciones
//	queSePuedanAlmacenarLosDistintosTiposDePersonas
//	queSePuedanAsociadACadaPersonaSusMedios
//	queSePuedanRealizarCompras
//	queSePuedanRealizarTransferencias
//	queSeLanceUnaExcepcionSiElSaldoDeLaTarjetaEsInsuficienteParaHacerUnaCompra
//	queSeLanceUnaExcepcionSiElSaldoDeLaCuentaVirtualEsInsuficienteParaHacerUnaCompra
//	queSeLanceUnaExcepcionSiElLimiteDeCompraDeLaTarjetaEsInsuficienteParaHacerUnaCompra
//	queSeLanceUnaExcepcionSiElSaldoDeLaCuentaEsInsuficienteParaHacerUnaTransferencia
//	queDesdeUnaCuentaCorrienteSePuedaRealizarUnaTransferenciaPorEncimaDeSuSaldo

	@Test
	public void queSePuedanAlmacenarLosDistintosTiposDeTransacciones() {
		Billetera billetera = new Billetera("wallet");
		MedioAsociado medio1 = new Credito("credito", 111, 200.00, 500.00);
		MedioAsociado medio2 = new Debito("debito", 222, 200.00);
		MedioAsociado medio3 = new CuentaVirtual("virtual", 333, 200.00);
		MedioAsociado medio4 = new CuentaBancaria("bancaria", 444, 200.00);
		
		billetera.agregarMedio(medio1);
		billetera.agregarMedio(medio2);
		billetera.agregarMedio(medio3);
		billetera.agregarMedio(medio4);
		
		Integer vo = billetera.cantidadMedios();
		
		assertEquals((Integer)4, vo);
	}
	
	@Test
	public void queSePuedanAlmacenarLosDistintosTiposDePersonas() {
		Billetera billetera = new Billetera("wallet");
		Persona persona1 = new Juridica("juridica", 15698);
		Persona persona2 = new Fisica("fisica", 16598);
		
		billetera.agregarPersona(persona1);
		billetera.agregarPersona(persona2);
		
		Integer vo = billetera.cantidadPersonas();
		
		assertEquals((Integer)2, vo);
	}
	
	@Test
	public void queSePuedanAsociadACadaPersonaSusMedios() {
		Billetera billetera = new Billetera("wallet");
		Persona persona1 = new Juridica("juridica", 15698);
		Persona persona2 = new Fisica("fisica", 16598);
		MedioAsociado medio1 = new Credito("credito", 111, 200.00, 500.00);
		MedioAsociado medio2 = new Debito("debito", 222, 200.00);
		
		billetera.agregarPersona(persona1);
		billetera.agregarPersona(persona2);
		billetera.agregarMedio(medio1);
		billetera.agregarMedio(medio2);
		persona1.asociarMedioAPersona(15698, medio1);
		persona2.asociarMedioAPersona(16598, medio2);
		
		Integer vo = persona1.cantidadMedioAsociados();
		Integer vo2 = persona2.cantidadMedioAsociados();
		
		assertEquals((Integer)1, vo);
		assertEquals((Integer)1, vo2);
	}
	
	@Test
	public void queSePuedanRealizarCompras() throws ExcedeLimiteDeCompraException, SaldoInsuficienteException {
		Billetera billetera = new Billetera("wallet");
		Persona persona1 = new Juridica("juridica", 15698);
		Persona persona2 = new Fisica("fisica", 16598);
		Pagadora medio1 = new Credito("credito", 111, 200.00, 500.00);
		Pagadora medio2 = new Debito("debito", 222, 200.00);
		
		billetera.agregarPersona(persona1);
		billetera.agregarPersona(persona2);
		billetera.agregarMedio((MedioAsociado) medio1);
		billetera.agregarMedio((MedioAsociado) medio2);
		persona1.asociarMedioAPersona(15698, (MedioAsociado) medio1);
		persona2.asociarMedioAPersona(16598, (MedioAsociado) medio2);
		
		Boolean resultado = medio1.pagar(persona1, 200.00);
		Boolean resultado2 = medio2.pagar(persona1, 200.00);
		
		assertTrue(resultado);
		assertTrue(resultado2);
	}
	
	@Test
	public void queSePuedanRealizarTransferencias() throws ExcedeLimiteDeCompraException, SaldoInsuficienteException {
		Billetera billetera = new Billetera("wallet");
		Persona persona1 = new Juridica("juridica", 15698);
		Persona persona2 = new Fisica("fisica", 16598);
		Transferible medio1 = new CuentaBancaria("bancaria", 111, 500.00);
		
		billetera.agregarPersona(persona1);
		billetera.agregarPersona(persona2);
		billetera.agregarMedio((MedioAsociado) medio1);
		persona1.asociarMedioAPersona(15698, (MedioAsociado) medio1);
		
		medio1.depositar(200.00);
		
		Double vo = medio1.getSaldo();
		assertEquals(300.00, vo, 0.01);
	}
	
	@Test(expected = SaldoInsuficienteException.class)
	public void queSeLanceUnaExcepcionSiElSaldoDeLaTarjetaEsInsuficienteParaHacerUnaCompra() throws SaldoInsuficienteException, ExcedeLimiteDeCompraException {
		Billetera billetera = new Billetera("wallet");
		Persona persona1 = new Juridica("juridica", 15698);
		Persona persona2 = new Fisica("fisica", 16598);
		Pagadora medio1 = new Debito("debito", 222, 200.00);
		
		billetera.agregarPersona(persona1);
		billetera.agregarPersona(persona2);
		billetera.agregarMedio((MedioAsociado) medio1);
		persona1.asociarMedioAPersona(15698, (MedioAsociado) medio1);
		
		medio1.pagar(persona1, 500.00);
		
	}
	
	@Test(expected = SaldoInsuficienteException.class)
	public void queSeLanceUnaExcepcionSiElSaldoDeLaCuentaVirtualEsInsuficienteParaHacerUnaCompra() throws SaldoInsuficienteException, ExcedeLimiteDeCompraException {
		Billetera billetera = new Billetera("wallet");
		Persona persona1 = new Juridica("juridica", 15698);
		Persona persona2 = new Fisica("fisica", 16598);
		Pagadora medio1 = new CuentaVirtual("virtual", 222, 200.00);
		
		billetera.agregarPersona(persona1);
		billetera.agregarPersona(persona2);
		billetera.agregarMedio((MedioAsociado) medio1);
		persona1.asociarMedioAPersona(16598, (MedioAsociado) medio1);
		
		medio1.pagar(persona1, 500.00);
	}
	
	@Test(expected = ExcedeLimiteDeCompraException.class)
	public void queSeLanceUnaExcepcionSiElLimiteDeCompraDeLaTarjetaEsInsuficienteParaHacerUnaCompra() throws SaldoInsuficienteException, ExcedeLimiteDeCompraException {
		Billetera billetera = new Billetera("wallet");
		Persona persona1 = new Juridica("juridica", 15698);
		Persona persona2 = new Fisica("fisica", 16598);
		Pagadora medio1 = new Credito("credito", 222, 600.00, 500.00);
		
		billetera.agregarPersona(persona1);
		billetera.agregarPersona(persona2);
		billetera.agregarMedio((MedioAsociado) medio1);
		persona1.asociarMedioAPersona(15698, (MedioAsociado) medio1);
		
		medio1.pagar(persona1, 600.00);
	}
	
	@Test(expected = SaldoInsuficienteException.class)
	public void queSeLanceUnaExcepcionSiElSaldoDeLaCuentaEsInsuficienteParaHacerUnaTransferencia() throws SaldoInsuficienteException, ExcedeLimiteDeCompraException {
		Billetera billetera = new Billetera("wallet");
		Persona persona1 = new Juridica("juridica", 15698);
		Persona persona2 = new Fisica("fisica", 16598);
		Transferible medio1 = new CuentaVirtual("virtual", 222, 200.00);
		
		billetera.agregarPersona(persona1);
		billetera.agregarPersona(persona2);
		billetera.agregarMedio((MedioAsociado) medio1);
		persona1.asociarMedioAPersona(16598, (MedioAsociado) medio1);
		
		medio1.depositar(300.00);
	}
	
	@Test
	public void queDesdeUnaCuentaCorrienteSePuedaRealizarUnaTransferenciaPorEncimaDeSuSaldo() throws SaldoInsuficienteException, ExcedeLimiteDeCompraException {
		Billetera billetera = new Billetera("wallet");
		Persona persona1 = new Juridica("juridica", 15698);
		Persona persona2 = new Fisica("fisica", 16598);
		Transferible medio1 = new CuentaCorriente("corriente", 222, 200.00);
		
		billetera.agregarPersona(persona1);
		billetera.agregarPersona(persona2);
		billetera.agregarMedio((MedioAsociado) medio1);
		persona1.asociarMedioAPersona(16598, (MedioAsociado) medio1);
		
		medio1.depositar(300.00);
	}
}
