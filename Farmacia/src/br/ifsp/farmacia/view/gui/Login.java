package br.ifsp.farmacia.view.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField pswSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setForeground(new Color(240, 248, 255));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setLabelFor(this);
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUsurio.setBounds(153, 53, 40, 14);
		contentPane.add(lblUsurio);
		
		txtUser = new JTextField();
		txtUser.setBounds(216, 53, 144, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setLabelFor(this);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSenha.setBounds(159, 88, 34, 14);
		contentPane.add(lblSenha);
		
		pswSenha = new JPasswordField();
		pswSenha.setBounds(216, 88, 144, 20);
		contentPane.add(pswSenha);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(166, 203, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(271, 203, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setLabelFor(this);
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTipo.setBounds(169, 127, 24, 14);
		contentPane.add(lblTipo);
		
		JComboBox cbxTipo = new JComboBox();
		cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"Atendente", "Gerente"}));
		cbxTipo.setBounds(216, 127, 144, 20);
		contentPane.add(cbxTipo);
	}
}
