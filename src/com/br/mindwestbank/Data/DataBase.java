package com.br.mindwestbank.Data;

import java.util.HashMap;
import java.util.Hashtable;

import com.br.mindwestbank.contas.modelo.Conta;
import com.br.mindwestbank.pessoas.modelo.Pessoa;

/**Classe para persistência dos dados.

 * @author Matheus Castro

 * @version 1.0
 */
public class DataBase {
	
	private static HashMap<Integer,Conta> contas = new HashMap<>();
	
	
	   /** Método para salvar contas
		* @param  conta - Objeto conta
		* @throws DataBaseException - Conta ja registrada*/
	public static void salvaConta(Conta conta) throws DataBaseException {
		if(contas.containsKey(conta.getNumero())) {
			throw new DataBaseException("Conta ja registrada");
		}else {
			contas.put(conta.getNumero(), conta);
		}
	}
	   /** Método para buscar contas
		* @param numero  - Numero da conta
		*  @throws DataBaseException - Conta nao encontrada*/
	public static Conta getConta(int numero) throws DataBaseException {
		if(contas.containsKey(numero)) {
			return contas.get(numero);
		}else {
			throw new DataBaseException("Conta não encontrada");
		}
	}

}
