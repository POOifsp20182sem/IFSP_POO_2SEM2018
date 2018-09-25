package br.ifsp.farmacia.view.gui;

import java.awt.EventQueue;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JList;

import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import br.ifsp.farmacia.control.clientes.ClienteControl;
import br.ifsp.farmacia.model.entities.Cliente;
import br.ifsp.farmacia.model.entities.Endereco;
import br.ifsp.farmacia.model.entities.EnumCliente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FormCliente extends JFrame {

	private JPanel contentPane;
	private static JTextField txtNome;
	private static JTextField txtEndereco;
	private static JTextField txtEmail;
	private static JTextField txtPesquisar;
	private static JFormattedTextField mskDataNasc;
	private static JFormattedTextField mskTelefone;
	private static JFormattedTextField mskCelular;
	private static JComboBox<EnumCliente> cboTipoCliente = new JComboBox<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCliente frame = new FormCliente();
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
	public FormCliente() throws ParseException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 622, 439);
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
		txtNome.setBounds(53, 26, 293, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		MaskFormatter forData = new MaskFormatter("##/##/####");
		mskDataNasc = new JFormattedTextField(forData);
		mskDataNasc.setBounds(117, 60, 77, 20);
		contentPane.add(mskDataNasc);
		
		MaskFormatter forTelefone = new MaskFormatter("(##) ####-####");
		mskTelefone = new JFormattedTextField(forTelefone);
		mskTelefone.setBounds(67, 101, 110, 20);
		contentPane.add(mskTelefone);
		
		MaskFormatter forCelular = new MaskFormatter("(##) #####-####");
	    mskCelular = new JFormattedTextField(forCelular);
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
		
		
		mskCpf.setBounds(97, 271, 116, 20);
		contentPane.add(mskCpf);
		mskCnpj.setBounds(67, 299, 127, 20);
		contentPane.add(mskCnpj);
		
		cboTipoCliente.setModel(new DefaultComboBoxModel<>(EnumCliente.values()));
		cboTipoCliente.setBounds(53, 224, 124, 20);
		contentPane.add(cboTipoCliente);
		
		ClienteControl ctCliente = new ClienteControl();
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Cliente cliente = new Cliente();
					popularCliente(cliente);
					ctCliente.CadastrarCliente(cliente);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(507, 348, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Cliente cliente = new Cliente();
					popularCliente(cliente);
					ctCliente.AtualizarCliente(cliente);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAlterar.setBounds(390, 270, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Cliente cliente = new Cliente();
					//TODO: pode ter um m�todo espec�fico, 
					//uma vez que � preciso pegar somente o id
					popularCliente(cliente);
					ctCliente.DeletarCliente(cliente);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnExcluir.setBounds(507, 270, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ArrayList clientes = ctCliente.listarCliente(txtPesquisar.toString());
					JList list = new JList((ListModel) clientes);
					list.setBounds(425, 284, 109, -263);
					contentPane.add(list);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPesquisar.setBounds(249, 348, 89, 23);
		contentPane.add(btnPesquisar);
		
		JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setBounds(10, 331, 63, 14);
		contentPane.add(lblPesquisar);
		
		txtPesquisar = new JTextField();
		txtPesquisar.setBounds(10, 349, 209, 20);
		contentPane.add(txtPesquisar);
		txtPesquisar.setColumns(10);
	}
	
	
	
	public static void popularCliente(Cliente cliente) {
		//Texts
		cliente.setNome(txtNome.getText()); 
		cliente.setEmail(txtEmail.getText());
		//TODO:25-09-2018:ed:Pode ser melhor esse endereco
		cliente.setEndereco(new Endereco(txtEndereco.getText()));
		//Masks
		//"\\D" remove todos os elementos que n�o sejam n�meros   
		cliente.setCelular(mskCelular.getText().replaceAll("\\D",""));
		cliente.setDataNascimento((String)mskDataNasc.getText());
		cliente.setTelefone(mskTelefone.getText().replaceAll("\\D",""));
		//combo
		cliente.setTipoCliente((EnumCliente)cboTipoCliente.getSelectedItem());
	}
}
