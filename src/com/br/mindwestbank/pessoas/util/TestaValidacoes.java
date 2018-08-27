package com.br.mindwestbank.pessoas.util;

public class TestaValidacoes {
	
	public static void main(String[] args) {
		String cnpj = "14572457000185";
		String cpf = "70389194158";
		if(Validacoes.validaCnpj(cnpj)) System.out.println("true");
		if(Validacoes.validaCpf(cpf)) System.out.println("true");
	}

}
