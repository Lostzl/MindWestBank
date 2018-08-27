package com.br.mindwestbank.pessoas.modelo;

import com.br.mindwestbank.pessoas.exceptions.PessoaException;
import com.br.mindwestbank.pessoas.modelo.Pessoa;
import com.br.mindwestbank.pessoas.util.Validacoes;
import com.br.mindwestbank.util.Endereco;
/**Classe para objetos do tipo Pessoa Juridica.

 * @author Matheus Castro

 * @version 1.0
 */
public class PessoaJuridica extends Pessoa {
	protected static int gerarId = 0;
	private String cnpj;
	public PessoaJuridica(String nome,Endereco endereco,String cnpj) throws PessoaException {
		super(nome,endereco);
		validaCnpj(cnpj);
		geraId++;
	}

	private void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	private boolean validaCnpj(String cnpj) throws PessoaException{
		if(!Validacoes.validaCnpj(cnpj)) {
			throw new PessoaException("cnpj invalido");
		}else {
			setCnpj(cnpj);
			return true;
		}
	}
	/** Método para retorno do cnpj de PessoaJuridica

     *   @return String - Cnpj de pessoaJuridica*/
	public String getCnpj() {
		return this.cnpj;
	}
	/** Método para retorno de todas a informaçoes sobre o objeto PessoaJuridica

     *   @return String - Todas informaçoes*/
	@Override
	public String toString() {
		return "Pessoa [Id:"+getId()+" Nome:"+getNome()+" Cnpj: "+getCnpj()+" Endereco:"+getEndereco().toString()+"]";
		
	}
	@Override
	protected String geraId() {
		return this.getClass().getSimpleName()+" "+geraId;
	}
	
}
