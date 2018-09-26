package br.ifsp.farmacia.view.gui;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import br.ifsp.farmacia.model.entities.Cliente;
import br.ifsp.farmacia.model.entities.Endereco;
import br.ifsp.farmacia.model.entities.EnumCliente;
import br.ifsp.farmacia.model.entities.EnumFuncionario;
import br.ifsp.farmacia.model.entities.Funcionario;
import br.ifsp.farmacia.control.funcionarios.FuncionarioControl;;

public class FormFuncionario extends JFrame {

	private JPanel contentPane;
	private static JTextField txtNome;
	private static JTextField txtLogradouro;
	private static JTextField txtNumero;
	private static JTextField txtCidade;
	private static JTextField txtBairro;	private static JTextField txtEmail;
	private static JFormattedTextField mskDataNasc;
	private static JFormattedTextField mskTelefone;
	private static JFormattedTextField mskCelular;
	private static JComboBox<EnumCliente> cboTipo = new JComboBox<>();
	private static JTextField txtUser;
	private static JPasswordField pswSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormFuncionario frame = new FormFuncionario();
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
	public FormFuncionario() throws ParseException {
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
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setLabelFor(this);
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUsurio.setBounds(153, 53, 40, 14);
		contentPane.add(lblUsurio);
		
		txtUser = new JTextField();
		txtUser.setBounds(250, 53, 144, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setLabelFor(this);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSenha.setBounds(159, 150, 34, 14);
		contentPane.add(lblSenha);
		
		pswSenha = new JPasswordField();
		pswSenha.setBounds(250, 150, 144, 20);
		contentPane.add(pswSenha);
		
		JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setBounds(10, 393, 66, 14);
		contentPane.add(lblPesquisar);
		
		JTextField txtPesquisar = new JTextField();
		txtPesquisar.setBounds(78, 390, 136, 20);
		contentPane.add(txtPesquisar);
		txtPesquisar.setColumns(10);
		
		FuncionarioControl ctFunc = new FuncionarioControl();
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				try {
					Funcionario func = new Funcionario();
					popularFuncionarios(func);
					ctFunc.cadastrarFuncionario(func);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(468, 384, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				try {
					Funcionario func = new Funcionario();
					popularFuncionarios(func);
					ctFunc.excluirFuncionario(func);
				}
				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnExcluir.setBounds(468, 271, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Funcionario func = new Funcionario();
						popularFuncionarios(func);
						ctFunc.atualizarFuncionario(func);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
		btnAlterar.setBounds(468, 321, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList func = ctFunc.listarFuncionarios(txtPesquisar.getText());
					JList list = new JList((ListModel) func);
					list.setBounds(425, 284, 109, -263);
					contentPane.add(list);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPesquisar.setBounds(236, 389, 89, 23);
		contentPane.add(btnPesquisar);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setBounds(10, 207, 63, 14);
		contentPane.add(lblLogradouro);
		
		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setBounds(237, 207, 46, 14);
		contentPane.add(lblNumero);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(83, 235, 136, 20);
		contentPane.add(txtBairro);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(283, 235, 63, 20);
		contentPane.add(txtCidade);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 238, 63, 14);
		contentPane.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(237, 238, 46, 14);
		contentPane.add(lblCidade);
	}
	
	public static void popularFuncionarios(Funcionario func) {
		func.setNome(txtNome.getText()); 
		func.setEmail(txtEmail.getText());
		func.setEndereco(new Endereco(txtLogradouro.getText(), txtNumero.getText(), txtBairro.getText(), txtCidade.getText()));
		func.setCelular(mskCelular.getText().replaceAll("\\D",""));
		func.setDataNascimento((String)mskDataNasc.getText());
		func.setTelefone(mskTelefone.getText().replaceAll("\\D",""));
		func.setTipoFuncionario((EnumFuncionario)cboTipo.getSelectedItem());
	}
}
