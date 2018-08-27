package com.br.mindwestbank.pessoas.modelo;

import com.br.mindwestbank.util.Endereco;
/**Classe abstrata para base de criaçao de pessoas.

 * @author Matheus Castro

 * @version 1.0

 */
public abstract  class Pessoa {
	protected static int geraId = 0;
	protected String id;
	protected String nome;
	private Endereco endereco;
	
	public Pessoa(String nome,Endereco endereco) {
		setEndereco(endereco);
		setNome(nome);
		geraId++;
	}
	protected abstract String geraId();
	  /** Método para retorno do nome de pessoa.

     *   @return String - Nome de pessoa*/
	public String getNome() {
		return this.nome;
	}
	  /** Método para retorno do id de pessoa.

     *   @return String - Numero do id*/
	public String getId() {
		return this.id;
	}
	private void setEndereco(Endereco endereco) {
		this.endereco =endereco;
	}
	private void setNome(String n) {
		this.nome = n;
	}
	  /** Método para retorno do Endereco de pessoa.

     *   @return Endereco - Objeto Endereco*/
	public Endereco getEndereco() {
		return this.endereco;
	}
	  /** Método para retorno do toString.

     *   @return String - Todas as informacoes de pessoa*/
	public String toString() {
		return "Pessoa [Id:"+getId()+" Nome:"+getNome()+" Endereco:"+getEndereco().toString()+"]";
	}
}
