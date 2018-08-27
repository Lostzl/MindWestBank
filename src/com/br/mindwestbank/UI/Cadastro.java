
package com.br.mindwestbank.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

import com.br.mindwestbank.Data.DataBase;
import com.br.mindwestbank.Data.DataBaseException;
import com.br.mindwestbank.contas.modelo.*;
import com.br.mindwestbank.pessoas.exceptions.PessoaException;
import com.br.mindwestbank.pessoas.modelo.*;
import com.br.mindwestbank.util.Endereco;

/**
 * Classe para montagem da tela de cadastro, onde deve ser informado nome,
 * endereço, cpf/cnpj.
 * 
 * @author Joao Vitor / Lucas Vitor.
 * @version 1.0
 * 
 * 
 */
public class Cadastro implements ActionListener, Runnable {
	public void run() {
		while (true) {
			data = new Date();
			hms = Integer.toString(this.data.getHours()) + ":" + Integer.toString(this.data.getMinutes()) + ":"
					+ Integer.toString(this.data.getSeconds());

			horario.setText(hms);

			try {
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private JLabel horario;
	private Date data;
	private String hms;// hora_minuto_segundo
	private JFrame janela1;
	private JButton botao1;
	private JPanel painel;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lbl7;
	private JLabel lbl8;
	private JLabel lbl9;
	private JLabel lbl10;
	private JLabel lbl11;
	private JLabel lbl12;
	private JTextField txtNome;
	private JTextField txt2;
	private JTextField txtCPFCNPJ;
	private JTextField txtTipe;
	private JTextField txttipoDeLogradouro;
	private JTextField txtlogradouro;
	private JTextField txtnumero;
	private JTextField txtbairro;
	private JTextField txtcidade;
	private JTextField txtestado;
	private JTextField txtcep;
	private JRadioButton radioFisica;
	private JRadioButton radioJuridica;
	private JCheckBox checkFuncionario;
	private CadastroFuncionario janelaFuncionario;
	private Pessoa pessoa; // polimorfismo
	private Endereco endereco;
	private Conta conta;

	private JRadioButton contaCorrente;
	private JRadioButton contaPoupanca;

	/** Método construtor da tela */

	public Cadastro() {
		Thread contaHora = new Thread(this);
		contaHora.start();
		horario = new JLabel("00:00:00");
		horario.setBounds(345, 655, 59, 14);
		
		
		janela1 = new JFrame("Cadastro");
		lbl1 = new JLabel("Para realiza\u00E7\u00E3o do cadastro, precisaremos dos seguintes dados:");
		lbl1.setBounds(19, 11, 375, 14);
		lbl2 = new JLabel("Nome:");
		lbl2.setBounds(118, 48, 94, 14);
		txtNome = new JTextField(20);
		txtNome.setBounds(118, 65, 166, 25);
		lbl3 = new JLabel("Endereço:");
		txt2 = new JTextField(20);
		lbl4 = new JLabel("CPF/CNPJ:");
		lbl4.setBounds(118, 93, 126, 14);
		txtCPFCNPJ = new JTextField(20);
		txtCPFCNPJ.setBounds(118, 114, 166, 25);
		////

		lbl5 = new JLabel("Tipo:");
		lbl5.setBounds(118, 141, 94, 14);
		txtTipe = new JTextField(20);
		txtTipe.setBounds(118, 161, 166, 25);
		lbl6 = new JLabel("Tipo de logradouro:");
		lbl6.setBounds(118, 189, 154, 14);
		txttipoDeLogradouro = new JTextField(10);
		txttipoDeLogradouro.setBounds(118, 210, 166, 25);
		lbl7 = new JLabel("Logradouro:");
		lbl7.setBounds(118, 237, 154, 14);
		txtlogradouro = new JTextField(15);
		txtlogradouro.setBounds(118, 257, 166, 25);
		lbl8 = new JLabel("Número:");
		lbl8.setBounds(118, 286, 141, 14);
		txtnumero = new JTextField("0", 20);
		txtnumero.setBounds(118, 310, 166, 25);
		lbl9 = new JLabel("Bairro:");
		lbl9.setBounds(118, 336, 141, 14);
		txtbairro = new JTextField(20);
		txtbairro.setBounds(118, 360, 166, 25);
		lbl10 = new JLabel("Cidade:");
		lbl10.setBounds(118, 388, 141, 14);
		txtcidade = new JTextField(20);
		txtcidade.setBounds(118, 410, 166, 25);
		lbl11 = new JLabel("Estado:");
		lbl11.setBounds(118, 437, 154, 14);
		txtestado = new JTextField(20);
		txtestado.setBounds(118, 459, 166, 25);
		lbl12 = new JLabel("CEP:");
		lbl12.setBounds(118, 485, 154, 14);
		txtcep = new JTextField(20);
		txtcep.setBounds(118, 505, 166, 25);

		////
		radioFisica = new JRadioButton("Pessoa Física");
		radioFisica.setBounds(83, 543, 116, 23);
		radioJuridica = new JRadioButton("Pessoa Jurídica");
		radioJuridica.setBounds(205, 543, 141, 23);
		botao1 = new JButton("Cadastrar");
		botao1.setBounds(150, 630, 109, 23);

		radioFisica.addActionListener(this);
		radioJuridica.addActionListener(this);
		botao1.addActionListener(this);

		checkFuncionario = new JCheckBox("Funcionário");
		checkFuncionario.setBounds(83, 563, 103, 23);
		checkFuncionario.setEnabled(false);

		contaCorrente = new JRadioButton("Conta Corrente");
		contaCorrente.setBounds(205, 589, 141, 23);
		contaPoupanca = new JRadioButton("Conta Poupança");
		contaPoupanca.setBounds(83, 589, 116, 23);

		painel = new JPanel();
		painel.setLayout(null);
		painel.add(horario);
		painel.add(lbl1);
		painel.add(lbl2);
		painel.add(txtNome);

		painel.add(lbl4);
		painel.add(txtCPFCNPJ);
		painel.add(lbl5);
		painel.add(txtTipe);
		painel.add(lbl6);
		painel.add(txttipoDeLogradouro);
		painel.add(lbl7);
		painel.add(txtlogradouro);
		painel.add(lbl8);
		painel.add(txtnumero);
		painel.add(lbl9);
		painel.add(txtbairro);
		painel.add(lbl10);
		painel.add(txtcidade);
		painel.add(lbl11);
		painel.add(txtestado);
		painel.add(lbl12);
		painel.add(txtcep);

		painel.add(radioFisica);
		painel.add(radioJuridica);
		painel.add(checkFuncionario);
		painel.add(contaCorrente);
		painel.add(contaPoupanca);

		contaCorrente.addActionListener(this);
		contaPoupanca.addActionListener(this);

		painel.add(botao1);

		janela1.getContentPane().add(painel);
		janela1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela1.setResizable(false);// não permite redimensionamento
		janela1.setBounds(0, 0, 420, 720);
		janela1.setLocationRelativeTo(null);// centro da tela
		janela1.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == radioFisica) {
			radioJuridica.setSelected(false);
			radioFisica.setSelected(true);
			checkFuncionario.setEnabled(true);
		} else if (e.getSource() == radioJuridica) {
			radioFisica.setSelected(false);
			radioJuridica.setSelected(true);
			checkFuncionario.setEnabled(false);
		}
		if (e.getSource() == contaCorrente) {
			contaPoupanca.setSelected(false);
			contaCorrente.setSelected(true);
		} else if (e.getSource() == contaPoupanca) {
			contaCorrente.setSelected(false);
			contaPoupanca.setSelected(true);
		} else if (e.getSource() == botao1) {
			if((this.data.getHours() >= 10 && this.data.getHours() <= 14)
					|| (this.data.getHours() == 15 && this.data.getMinutes() == 0)) {
				if (radioFisica.isSelected()) {
					this.cadastraEndereco();
					if (checkFuncionario.isSelected()) {

						try {
							if (contaPoupanca.isSelected() || contaCorrente.isSelected()) {
								janelaFuncionario = new CadastroFuncionario(txtNome.getText(), endereco,
										txtCPFCNPJ.getText(), contaPoupanca.isSelected(), contaCorrente.isSelected());
								janela1.dispose();
							}else {
								JOptionPane.showMessageDialog(null, "Por favor, escolha entre Conta Corrente ou Poupança", "Atenção",
										JOptionPane.ERROR_MESSAGE);
							}

						} catch (PessoaException e1) {
							JOptionPane.showMessageDialog(null, "Por favor, digite um CPF válido", "Atenção",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						try {
							pessoa = new PessoaFisica(txtNome.getText(), endereco, txtCPFCNPJ.getText());
							janela1.dispose();
							cadastraConta(pessoa);

						} catch (Exception e1) {
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "Por favor, digite um CPF válido", "Atenção",
									JOptionPane.ERROR_MESSAGE);
						}
					}

				} else if (radioJuridica.isSelected()) {
					this.cadastraEndereco();
					try {
						pessoa = new PessoaJuridica(txtNome.getText(), endereco, txtCPFCNPJ.getText());
						janela1.dispose();
						cadastraConta(pessoa);
						JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "",
								JOptionPane.INFORMATION_MESSAGE);

					} catch (PessoaException e1) {
						JOptionPane.showMessageDialog(null, "Por favor, digite um CNPJ válido", "Atenção",
								JOptionPane.ERROR_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Por favor, escolha Pessoa Física ou Pessoa Jurídica", "Atenção",
							JOptionPane.ERROR_MESSAGE);
				}

			}else {
				JOptionPane.showMessageDialog(null, "Não é possível realizar operações neste horário!"
						+ "\n\nA realização de cadastros é permitida das 10:00h às 15:00h");
				janela1.dispose();
			}
			
		}

	}

	public void cadastraConta(Pessoa pessoa) {
		if (contaPoupanca.isSelected()) {
			Conta conta = new Poupanca(pessoa);
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
			try {
				DataBase.salvaConta(conta);
			} catch (DataBaseException e) {
				JOptionPane.showMessageDialog(null, "Conta já existente!", "Atenção", JOptionPane.ERROR_MESSAGE);
			}
		} else if (contaCorrente.isSelected()) {
			Conta conta = new ContaCorrente(pessoa);
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

	public void cadastraEndereco() {
		if (txtTipe.getText() == null) {
			endereco = new Endereco(txttipoDeLogradouro.getText(), txtlogradouro.getText(),
					Integer.parseInt(txtnumero.getText()), txtbairro.getText(), txtcidade.getText(),
					txtestado.getText(), txtcep.getText());
		} else {
			endereco = new Endereco(txtTipe.getText(), txttipoDeLogradouro.getText(), txtlogradouro.getText(),
					Integer.parseInt(txtnumero.getText()), txtbairro.getText(), txtcidade.getText(),
					txtestado.getText(), txtcep.getText());
		}
	}
}
