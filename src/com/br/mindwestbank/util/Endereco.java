package com.br.mindwestbank.util;
/**Classe para objetos do tipo Endereco.

 * @author Matheus Castro

 * @version 1.0
 */
public class Endereco {
	protected static int geraId = 0;
	protected String id;
	private String tipe = "Residencial";
	private String tipoDeLogradouro;
	private String logadouro;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	public Endereco(String tipe, String tipoDeLogradouro, String logadouro, int numero, String bairro, String cidade,
			String estado, String cep) {
		setTipe(tipe);
		setTipoDeLogradouro(tipoDeLogradouro);
		setLogadouro(logadouro);
		setNumero(numero);
		setBairro(bairro);
		setCidade(cidade);
		setEstado(estado);
		setCep(cep);
		geraId++;
		setId();
	}
	public Endereco( String tipoDeLogradouro, String logadouro, int numero, String bairro, String cidade,
			String estado, String cep) {
		setTipoDeLogradouro(tipoDeLogradouro);
		setLogadouro(logadouro);
		setNumero(numero);
		setBairro(bairro);
		setCidade(cidade);
		setEstado(estado);
		setCep(cep);
		geraId++;
		setId();
	}
	private String gerarId() {
		return this.getClass().getSimpleName()+" : "+id;
	}
	   /** M�todo para retorno do id de endereco

*   @return String - Numero do Id*/
	public String getId() {
		return id;
	}
	private void setId() {
		this.id = Integer.toString(geraId);
	}
	   /** M�todo para retorno do Tipe de endereco

*   @return String - Tipe*/
	public String getTipe() {
		return tipe;
	}
	protected void setTipe(String tipe) {
		this.tipe = tipe;
	}
	   /** M�todo para retorno do tipo de logradouro

*   @return String - Tipo deLogradouro*/
	public String getTipoDeLogradouro() {
		return tipoDeLogradouro;
	}
	protected void setTipoDeLogradouro(String tipoDeLogradouro) {
		this.tipoDeLogradouro = tipoDeLogradouro;
	}
	   /** M�todo para retorno o logradouro

*   @return String - Logradouro*/
	public String getLogadouro() {
		return logadouro;
	}
	protected void setLogadouro(String logadouro) {
		this.logadouro = logadouro;
	}
	   /** M�todo para retorno o numero de endereco

*   @return String - Numero*/
	public int getNumero() {
		return numero;
	}
	protected void setNumero(int numero) {
		this.numero = numero;
	}
	   /** M�todo para retorno do bairro

*   @return String - bairro*/
	public String getBairro() {
		return bairro;
	}
	protected void setBairro(String bairro) {
		this.bairro = bairro;
	}
	   /** M�todo para retorno a cidade

*   @return String - cidade*/
	public String getCidade() {
		return cidade;
	}
	protected void setCidade(String cidade) {
		this.cidade = cidade;
	}
	   /** M�todo para retorno o Estado

*   @return String - Estado*/
	public String getEstado() {
		return estado;
	}
	protected void setEstado(String estado) {
		this.estado = estado;
	}
	   /** M�todo para retorno do cep

*   @return String - CEP*/
	public String getCep() {
		return cep;
	}
	protected void setCep(String cep) {
		this.cep = cep;
	}
	   /** M�todo para retorno de todas as informa�oes de Endereco

*   @return String - Todas informa�oes*/
	@Override
	public String toString() {
		return "Endereco[Id: "+getId()+" Tipe:"+getTipe()+" Tipo Logadouro:"+getTipoDeLogradouro()+" Logadouro:"+getLogadouro()
						+" Numero: "+getNumero()+" Bairro: "+getBairro()+" Cidade: "+getCidade()+" Estado: "+getEstado()+" Cep: "+getCep()+"]";
	}
}
