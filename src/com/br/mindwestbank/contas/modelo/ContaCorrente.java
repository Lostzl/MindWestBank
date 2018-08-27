package com.br.mindwestbank.contas.modelo;

import com.br.mindwestbank.contas.exceptions.ContaException;
import com.br.mindwestbank.pessoas.modelo.Pessoa;

public class ContaCorrente extends Conta {
	private double limite = 0;
	private Poupanca contaPoupanca;

	public ContaCorrente(Pessoa cliente) {
		super();
		setCliente(cliente);
		setLimite(100);
	}
	public void setLimite(double n) {
		this.limite = n;
	}
	public double getLimite() {
		return this.limite;
	}
	@Override
	  /** Método para retorno do nome de pessoa.
	   * A cada deposito e incrementado ao limite da conta corrente

     *   */
	public void deposito(double dinheiro) {
		setSaldo(getSaldo()+dinheiro);
		this.setLimite(getLimite() + getSaldo());
	}

	@Override
	  /** Método para saque de dinheiro da classe conta.
	   * Saque so e permitido se valor e ser sacado seja
	   * igual a soma do saldo e do limite da conta.

     *   */
	public void saque(double dinheiro) throws ContaException{
		if((getSaldo()+ getLimite()) < dinheiro) {
			throw new ContaException("Saldo Insuficiente!!");
		}else {
			setSaldo(getSaldo() - dinheiro);
		}
	}

}
