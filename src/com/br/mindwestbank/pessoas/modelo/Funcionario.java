package com.br.mindwestbank.pessoas.modelo;

import com.br.mindwestbank.pessoas.exceptions.PessoaException;
import com.br.mindwestbank.util.Endereco;
/**Classe para objetos do tipo Funcionários, onde serão contidos, valores e métodos para o mesmo.

 * @author Matheus Castro

 * @version 1.0
 */
public class Funcionario extends PessoaFisica {
	protected static int geraId = 0;
	private String cargo;
	public Funcionario(String nome, Endereco endereco, String cpf,String cargo) throws PessoaException {
		super(nome, endereco, cpf);
		setCargo(cargo);
		geraId++;
		
	}
	  /** Método para retorno do cargo de funcionario

     *   @return String - Cargo de Funcionario*/
	public String getCargo() {
		return this.cargo;
	}
	private void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
