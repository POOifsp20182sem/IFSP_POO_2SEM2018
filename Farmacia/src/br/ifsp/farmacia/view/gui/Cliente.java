package br.ifsp.farmacia.view.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Cliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente frame = new Cliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public Cliente() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 29, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblDataNascimento = new JLabel("Data Nascimento:");
		lblDataNascimento.setBounds(10, 63, 97, 14);
		contentPane.add(lblDataNascimento);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 104, 52, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setBounds(10, 148, 63, 14);
		contentPane.add(lblEndereco);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(204, 104, 46, 14);
		contentPane.add(lblCelular);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 186, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 227, 46, 14);
		contentPane.add(lblTipo);
		
		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setBounds(10, 274, 77, 14);
		contentPane.add(lblDocumento);
		
		txtNome = new JTextField();
		txtNome.setBounds(53, 26, 124, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		MaskFormatter formData = new MaskFormatter("##/##/####");
		JFormattedTextField mskDataNasc = new JFormattedTextField(formData);
		mskDataNasc.setBounds(117, 60, 77, 20);
		contentPane.add(mskDataNasc);
		
		JFormattedTextField mskTelefone = new JFormattedTextField();
		mskTelefone.setBounds(67, 101, 110, 20);
		contentPane.add(mskTelefone);
		
		JFormattedTextField mskCelular = new JFormattedTextField();
		mskCelular.setBounds(249, 101, 97, 20);
		contentPane.add(mskCelular);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(66, 145, 128, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(53, 183, 141, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JFormattedTextField mskDocumento = new JFormattedTextField();
		mskDocumento.setBounds(78, 271, 116, 20);
		contentPane.add(mskDocumento);
		
		JComboBox cboTipo = new JComboBox();
		cboTipo.setModel(new DefaultComboBoxModel(new String[] {"F\u00EDsica", "Jur\u00EDdica"}));
		cboTipo.setBounds(53, 224, 116, 20);
		contentPane.add(cboTipo);
		
		JList list = new JList();
		list.setBounds(425, 284, 109, -263);
	}
}
