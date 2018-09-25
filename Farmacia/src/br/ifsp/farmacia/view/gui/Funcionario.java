package br.ifsp.farmacia.view.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import br.ifsp.farmacia.model.entities.EnumFuncionario;

//TODO:25-09-2018:ed:por favor renomear para seguir o padrão
public class Funcionario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Funcionario frame = new Funcionario();
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
	public Funcionario() throws ParseException {
		setTitle("Funcion\u00E1rio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 588, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 22, 39, 14);
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
		
		JTextField txtNome = new JTextField();
		txtNome.setBounds(59, 19, 124, 20);
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
		
		JTextField txtEndereco = new JTextField();
		txtEndereco.setBounds(66, 145, 128, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JTextField txtEmail = new JTextField();
		txtEmail.setBounds(53, 183, 141, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JComboBox cboTipo = new JComboBox();
		cboTipo.setModel(new DefaultComboBoxModel(EnumFuncionario.values()));
		cboTipo.setBounds(53, 224, 141, 20);
		contentPane.add(cboTipo);
		
		MaskFormatter forCpf = new MaskFormatter("###.###.###-##");
		JFormattedTextField mskCpf = new JFormattedTextField(forCpf);
		mskCpf.setBounds(82, 268, 112, 20);
		
		MaskFormatter forCnpj = new MaskFormatter("##.###.###/####-##");
		JFormattedTextField mskCnpj = new JFormattedTextField(forCnpj);
		mskCnpj.setBounds(82, 295, 150, 20);
		
		
		contentPane.add(mskCpf);
		contentPane.add(mskCnpj);
		
		JLabel lblSalario = new JLabel("Sal\u00E1rio:");
		lblSalario.setBounds(10, 342, 46, 14);
		contentPane.add(lblSalario);
		
		MaskFormatter forSalario = new MaskFormatter("R$ ####,##");
		JFormattedTextField mskSalario = new JFormattedTextField(forSalario);
		mskSalario.setBounds(67, 339, 110, 20);
		contentPane.add(mskSalario);
		
		JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setBounds(10, 393, 66, 14);
		contentPane.add(lblPesquisar);
		
		JTextField txtPesquisar = new JTextField();
		txtPesquisar.setBounds(78, 390, 136, 20);
		contentPane.add(txtPesquisar);
		txtPesquisar.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(468, 384, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(468, 271, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(468, 321, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(236, 389, 89, 23);
		contentPane.add(btnPesquisar);
	}
}
