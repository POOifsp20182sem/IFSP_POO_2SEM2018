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
		
		MaskFormatter forData = new MaskFormatter("##/##/####");
		JFormattedTextField mskDataNasc = new JFormattedTextField(forData);
		mskDataNasc.setBounds(117, 60, 77, 20);
		contentPane.add(mskDataNasc);
		
		MaskFormatter forTelefone = new MaskFormatter("(##) ####-####");
		JFormattedTextField mskTelefone = new JFormattedTextField(forTelefone);
		mskTelefone.setBounds(67, 101, 110, 20);
		contentPane.add(mskTelefone);
		
		MaskFormatter forCelular = new MaskFormatter("(##) #####-####");
		JFormattedTextField mskCelular = new JFormattedTextField(forCelular);
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
		
		MaskFormatter forCpf = new MaskFormatter("###.###.###-##");
		JFormattedTextField mskCpf = new JFormattedTextField(forCpf);
		MaskFormatter forCnpj = new MaskFormatter("##.###.###/####-##");
		JFormattedTextField mskCnpj = new JFormattedTextField(forCnpj);
		
		JComboBox cboTipo = new JComboBox() {{
			if(getSelectedIndex() == 0) {
				mskCpf.setVisible(true);
				mskCnpj.setVisible(false);
			}
			else if(getSelectedIndex() == 1) {
				mskCnpj.setVisible(true);
				mskCpf.setVisible(false);
			}
		}};
		
		cboTipo.setModel(new DefaultComboBoxModel(new String[] {"F\u00EDsica", "Jur\u00EDdica"}));
		cboTipo.setSelectedItem(-1);
		cboTipo.setBounds(53, 224, 116, 20);
		contentPane.add(cboTipo);
		
		
		/*mskCpf.setVisible(false);
		mskCnpj.setVisible(false);*/
		
		/*mskCpf.setVisible(true);
		mskCnpj.setVisible(true);*/
		
		mskCpf.setBounds(97, 271, 116, 20);
		contentPane.add(mskCpf);
		mskCnpj.setBounds(67, 299, 127, 20);
		contentPane.add(mskCnpj);
			
		
		JList list = new JList();
		list.setBounds(425, 284, 109, -263);
	}
}
