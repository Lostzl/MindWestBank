package com.br.mindwestbank.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.br.mindwestbank.pessoas.exceptions.PessoaException;
import com.br.mindwestbank.pessoas.modelo.Funcionario;
import com.br.mindwestbank.pessoas.modelo.Pessoa;
import com.br.mindwestbank.util.Endereco;
import com.br.mindwestbank.pessoas.util.Validacoes;
import com.br.mindwestbank.Data.DataBase;
import com.br.mindwestbank.Data.DataBaseException;
import com.br.mindwestbank.UI.*;
import com.br.mindwestbank.contas.modelo.Conta;
import com.br.mindwestbank.contas.modelo.ContaCorrente;
import com.br.mindwestbank.contas.modelo.Poupanca;

public class CadastroFuncionario implements ActionListener {
	private JFrame janela1;
	private JButton botao1;
	private JPanel painel;
	private JLabel lbl1;
	private JTextField txtCargo;
	private String cargo;

	private Funcionario funcionario;

	private String nome;
	private Endereco endereco;
	private String cpf;

	private Boolean contaPoupanca;
	private Boolean contaCorrente;
	private DataBase DataBase = new DataBase();

	private Conta conta;

	private Pessoa pessoa;

	public CadastroFuncionario(String nome, Endereco endereco, String cpf, Boolean contaPoupanca, Boolean contaCorrente)
			throws PessoaException {
		validaCpf(cpf);

		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;

		this.contaCorrente = contaCorrente;
		this.contaPoupanca = contaPoupanca;

		janela1 = new JFrame("Cadastro do funcionário");
		botao1 = new JButton("Cadastrar");
		painel = new JPanel();

		lbl1 = new JLabel("Cargo:");
		txtCargo = new JTextField("", 15);

		painel.add(lbl1);
		painel.add(txtCargo);
		painel.add(botao1);

		janela1.add(painel);

		janela1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela1.setResizable(false);// não permite redimensionamento
		janela1.setBounds(0, 0, 280, 110);
		janela1.setLocationRelativeTo(null);// centro da tela
		janela1.setVisible(true);

		botao1.addActionListener(this);
	}

	private boolean validaCpf(String cpf) throws PessoaException {
		if (!Validacoes.validaCpf(cpf)) {
			throw new PessoaException("cpf invalido");
		} else {
			return true;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botao1) {
			try {
				funcionario = new Funcionario(nome, endereco, cpf, txtCargo.getText());
				cadastraConta();
				janela1.dispose();

			} catch (PessoaException e1) {
				JOptionPane.showMessageDialog(null, "Erro desconhecido!", "Atenção", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	public void cadastraConta() {
		if (contaPoupanca) {
			conta = new Poupanca(funcionario);
			try {
				DataBase.salvaConta(conta);
			} catch (DataBaseException e) {
				JOptionPane.showMessageDialog(null, "Conta já existente!", "Atenção", JOptionPane.ERROR_MESSAGE);
			}
		} else if (contaCorrente) {
			conta = new ContaCorrente(funcionario);
			try {
				DataBase.salvaConta(conta);
				JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (DataBaseException e) {
				JOptionPane.showMessageDialog(null, "Conta já existente!", "Atenção", JOptionPane.ERROR_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Por favor, escolha entre Conta Corrente ou Poupança", "Atenção",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
