package com.br.mindwestbank.pessoas.exceptions;

public class PessoaException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5097085297175815136L;

	public PessoaException(String msg) {
		super(msg);
	}
	public PessoaException(String msg,Throwable cause) {
		super(msg,cause);
	}
}
