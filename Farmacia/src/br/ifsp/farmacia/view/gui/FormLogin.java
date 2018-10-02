package br.ifsp.farmacia.view.gui;

import br.ifsp.farmacia.control.LoginControl;
import br.ifsp.farmacia.model.entities.Login;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import com.sun.glass.events.WindowEvent;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.SQLException;


public class FormLogin extends JFrame {

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
					FormLogin frame = new FormLogin();
					frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
	public FormLogin() {
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
		btnOk.addActionListener((e) -> {
				LoginControl loginControl = new LoginControl();
				Login login = new Login(txtUser.getText(),new String(pswSenha.getPassword()));
				try {
					if(loginControl.validarLogin(login)) {
						FormMenuPrincipal menuPrincipal = new FormMenuPrincipal();
						//o ideial � fechar o login
						FormLogin.this.dispose();
						//torna o form vis�vel
						menuPrincipal.setVisible(true);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		});
		btnOk.setBounds(166, 203, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		
		btnCancelar.addActionListener((e)-> {
				System.exit(0);
		});
		
		btnCancelar.setBounds(271, 203, 89, 23);
		contentPane.add(btnCancelar);
	}
}
