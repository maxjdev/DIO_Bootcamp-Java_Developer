package testando;

import lombok.Getter;

@Getter
public abstract class Conta implements IConta{
	
	private static final int AGENCIA_PADRAO = 001;
	
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	
	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}
	
	@Override
	public void sacar(double valor) {
		if (verificaSaldo(valor)) this.saldo -= valor;
	}
	@Override
	public void depositar(double valor) {
		this.saldo += valor;
	}
	@Override
	public void transferir(double valor, IConta contaDestino) {
		if (verificaSaldo(valor)) {
			this.sacar(valor);
			contaDestino.depositar(valor);
		}
	}

	private boolean verificaSaldo(double valor) {
		if (valor > this.saldo) {
			System.out.println("Saldo insuficiente !");
			return false;
		} else if (valor <= 0) {
			System.out.println("Valor Invalido !");
			return false;
		}else return true;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
