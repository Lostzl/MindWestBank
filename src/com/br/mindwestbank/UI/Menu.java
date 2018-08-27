package com.br.mindwestbank.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * Classe para montagem da tela de menu principal.
 * 
 * @author Joao Vitor / Lucas Vitor.
 * 
 * @version 1.0
 * 
 */
public class Menu implements ActionListener {
	private JFrame janela;
	private JLabel label1;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JPanel painel;
	private CaixaEletronico caixa;
	private Cadastro dados;

	/**
	 * Método construtor da tela
	 */

	public Cadastro getJanelaCadastro() {
		return this.dados;
	}

	public Menu() {
		janela = new JFrame("Menu");
		janela.setAutoRequestFocus(false);
		label1 = new JLabel("Escolha uma das operações abaixo!");
		label1.setBounds(10, 11, 240, 27);
		btn1 = new JButton("Caixa Eletrônico");
		btn1.setBounds(143, 49, 138, 23);
		btn2 = new JButton("Cadastro");
		btn2.setBounds(143, 83, 138, 23);
		btn3 = new JButton("Sair");
		btn3.setBounds(143, 117, 138, 23);
		painel = new JPanel();
		painel.setLayout(null);

		painel.add(label1);
		painel.add(btn1);
		painel.add(btn2);
		painel.add(btn3);
		janela.add(painel);

		btn3.addActionListener(this);
		btn2.addActionListener(this);
		btn1.addActionListener(this);

		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(false);
		janela.setBounds(0, 0, 440, 214);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn3) {// botão sair
			System.exit(0);
		} else if (e.getSource() == btn2) {// botão Dados1
			dados = new Cadastro();
		} else if (e.getSource() == btn1) {// botão CaixaEletrônico
			caixa = new CaixaEletronico();
			if (!((caixa.getDate().getHours() >= 7 && caixa.getDate().getHours() <= 22)
					|| (caixa.getDate().getHours() == 22 && caixa.getDate().getMinutes() == 0))) {
				JOptionPane.showMessageDialog(null, "Não é possível realizar operações neste horário!");
				caixa.getJanela().dispose();
			}
		}

	}
}
