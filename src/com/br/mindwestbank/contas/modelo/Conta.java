package com.br.mindwestbank.contas.modelo;


import javax.swing.JOptionPane;

import com.br.mindwestbank.contas.exceptions.ContaException;
import com.br.mindwestbank.pessoas.modelo.Pessoa;

public abstract class Conta {
	protected static int geraNumero = 5000; //convenção escolhida pelo grupo
	private int numero;
	private double saldo = 0;
	private Pessoa cliente;
	
	public Conta() {
		geraNumero++;
		setNumero(geraNumero);
		JOptionPane.showMessageDialog(null, "Número da conta: "+this.getNumero(), "", JOptionPane.INFORMATION_MESSAGE);
	}
	protected int geraNumero() {
		return this.geraNumero;
	}
	private void setNumero(int n) {
		this.numero = n;
	}
	public int getNumero() {
		return this.numero;
	}
	public double getSaldo() {
		return this.saldo;
	}
	public void deposito(double n) {
		setSaldo(n);
	}
	public Pessoa getCliente() {
		return this.cliente;
	}
	protected void setCliente(Pessoa c) {
		this.cliente = c;
	}
	public abstract void saque(double n) throws ContaException;
	
	protected void setSaldo(double n) {  
		this.saldo = n;
	}
	public String getTipo() {
		return this.getClass().getSimpleName();
	}
}
