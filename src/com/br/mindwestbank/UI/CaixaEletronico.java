package com.br.mindwestbank.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

import com.br.mindwestbank.Data.DataBase;
import com.br.mindwestbank.Data.DataBaseException;
import com.br.mindwestbank.contas.exceptions.ContaException;
import com.br.mindwestbank.contas.modelo.Conta;

/**
 * Classe para montagem da tela do ATM, onde deve ser informado o número da
 * conta e a operação a ser realizada (saldo, saque, deposito). A janela
 * responsável pelo caixa eletrônico deverá exibir a hora atual, e somente
 * deverá ser possível realizar operações das 7:00hrs às 22:00hrs.
 * 
 * @author Joao Vitor / Lucas Vitor.
 * 
 * @version 1.0
 * 
 */

public class CaixaEletronico implements ActionListener, Runnable {

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

	private JFrame janela;
	private JTextField nConta;
	private JButton btn1;
	private JButton btn2;
	private JPanel painel;
	private JLabel label1;
	private JRadioButton saldo;
	private JRadioButton saque;
	private JRadioButton deposito;
	private JLabel horario;
	private JLabel dataTime;
	private Date data;
	private String hms;// hora_minuto_segundo
	private Conta conta;

	/**
	 * Método construtor da tela
	 */

	public CaixaEletronico() {
		janela = new JFrame("Caixa eletronico");
		btn1 = new JButton("OK");
		btn1.setBounds(188, 145, 47, 23);
		btn2 = new JButton("Voltar");
		btn2.setBounds(10, 145, 61, 23);
		painel = new JPanel();
		label1 = new JLabel("Numero da conta:");
		label1.setBounds(144, 40, 100, 14);
		saldo = new JRadioButton("Consultar Saldo");
		saldo.setBounds(65, 90, 115, 16);
		saque = new JRadioButton("Sacar");
		saque.setBounds(190, 90, 80, 16);
		deposito = new JRadioButton("Depositar");
		deposito.setBounds(260, 90, 140, 16);
		nConta = new JTextField(10);
		nConta.setBounds(144, 56, 126, 25);
		horario = new JLabel("00:00:00");
		horario.setBounds(355, 11, 59, 14);
		Thread contaHora = new Thread(this);
		contaHora.start();
		painel.setLayout(null);

		dataTime = new AtualizaData();
		dataTime.setBounds(10, 11, 64, 14);

		painel.add(label1);
		painel.add(saldo);
		painel.add(saque);
		painel.add(deposito);
		painel.add(nConta);
		painel.add(btn1);
		painel.add(btn2);
		painel.add(horario);
		painel.add(dataTime);
		janela.getContentPane().add(painel);

		btn1.addActionListener(this);
		btn2.addActionListener(this);
		saque.addActionListener(this);
		saldo.addActionListener(this);
		deposito.addActionListener(this);

		saldo.setSelected(true);

		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setResizable(false);// não permite redimensionamento
		janela.setBounds(0, 0, 435, 214);
		janela.setLocationRelativeTo(null);// centro da tela
		// janela.pack();
		janela.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			if ((this.data.getHours() >= 7 && this.data.getHours() <= 21)
					|| (this.data.getHours() == 22 && this.data.getMinutes() == 0)) {
				try {

					conta = DataBase.getConta(Integer.parseInt(nConta.getText()));
					Dados(conta);

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Digite um número de conta válido!", "Atenção",
							JOptionPane.ERROR_MESSAGE);
				} catch (DataBaseException e1) {
					JOptionPane.showMessageDialog(null, "Conta não encontrada!", "Atenção", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro desconhecido", "Atenção", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Não é possível realizar operações neste horário!"
						+ "\n\nA realização de operações é permitida das 7:00h às 22:00h");
				janela.dispose();
			}
		} else if (e.getSource() == btn2) {
			janela.dispose();
		}
		if (e.getSource() == saldo) {
			saldo.setSelected(true);
			deposito.setSelected(false);
			saque.setSelected(false);
		} else if (e.getSource() == deposito) {
			saldo.setSelected(false);
			deposito.setSelected(true);
			saque.setSelected(false);
		} else if (e.getSource() == saque) {
			saldo.setSelected(false);
			deposito.setSelected(false);
			saque.setSelected(true);
		}
	}

	public Date getDate() {
		return this.data;
	}

	public JFrame getJanela() {
		return this.janela;
	}

	public class AtualizaData extends JLabel {

		public AtualizaData() {
			Timer t = new Timer(1000,
					e -> setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
			t.setInitialDelay(0);
			t.start();
		}
	}

	private void Dados(Conta conta) {
		double dinheiro = 0;

		if (saldo.isSelected()) {
			JOptionPane.showMessageDialog(null, "Seu saldo atual é de " + conta.getSaldo());
		} else if (saque.isSelected()) {
			
			try {
				dinheiro = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantia a ser sacada"));
				conta.saque(dinheiro);
				JOptionPane.showMessageDialog(null, "Saque realizado com sucesso. Seu saldo atual é de " + conta.getSaldo());

			} catch (ContaException e) {
				JOptionPane.showMessageDialog(null, "Você não tem saldo suficiente para sacar essa quantia!", "Atenção",
						JOptionPane.ERROR_MESSAGE);
			}catch (NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Entrada inválida. Tente novamente!", "Atenção",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (deposito.isSelected()) {
			
			try {
				dinheiro = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantia a ser depositada"));
				conta.deposito(dinheiro);
				JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso. Seu saldo atual é de " + conta.getSaldo());
			}catch (NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Entrada inválida. Tente novamente!", "Atenção",
						JOptionPane.ERROR_MESSAGE);
			}
			
		}

	}

}
