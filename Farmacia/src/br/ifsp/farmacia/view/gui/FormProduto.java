package br.ifsp.farmacia.view.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import br.ifsp.farmacia.control.produtos.ProdutoControl;
import br.ifsp.farmacia.model.entities.EnumFormaFarmaco;
import br.ifsp.farmacia.model.entities.Produto;

import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FormProduto extends JFrame {

	private JPanel contentPane;
	//TODO: id é salva como textField até encontrar melhor alternativa
	private static int idProduto;
	private static JTextField txtNomeComercial;
	private static JTextField txtApresentacao;
	private static JTextField txtFabricante;
	private static JTextField txtPrincipioAtivo;
	private static JTextField txtUnidadeMedida;
	private static JTextField txtRegistroMs;
	private static JTextField txtCodigoBarras;
	private static JTextField txtClasseTerapeutica;
	private static JTextField txtPesquisar;
	private static JComboBox<EnumFormaFarmaco> cboForma = new JComboBox<>();
	private static JSpinner spnQuantidade;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormProduto frame = new FormProduto();
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
	public FormProduto() {
		setTitle("Medicamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeComercial = new JLabel("Nome Comercial:");
		lblNomeComercial.setBounds(10, 24, 97, 14);
		contentPane.add(lblNomeComercial);
		
		txtNomeComercial = new JTextField();
		txtNomeComercial.setBounds(115, 21, 149, 20);
		contentPane.add(txtNomeComercial);
		txtNomeComercial.setColumns(10);
		
		JLabel lblApresentao = new JLabel("Apresentação:");
		lblApresentao.setBounds(10, 72, 91, 14);
		contentPane.add(lblApresentao);
		
		txtApresentacao = new JTextField();
		txtApresentacao.setBounds(115, 69, 149, 20);
		contentPane.add(txtApresentacao);
		txtApresentacao.setColumns(10);
		
		JLabel lblFormaFarmaco = new JLabel("Forma Farmaco:");
		lblFormaFarmaco.setBounds(10, 120, 78, 14);
		contentPane.add(lblFormaFarmaco);
		
		cboForma.setModel(new DefaultComboBoxModel<>(EnumFormaFarmaco.values())); 
		cboForma.setBounds(115, 117, 149, 20);
		contentPane.add(cboForma);
		
		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setBounds(10, 165, 66, 14);
		contentPane.add(lblFabricante);
		
		txtFabricante = new JTextField();
		txtFabricante.setBounds(115, 162, 149, 20);
		contentPane.add(txtFabricante);
		txtFabricante.setColumns(10);
		
		JLabel lblPrincipioAtivo = new JLabel("Principio Ativo:");
		lblPrincipioAtivo.setBounds(10, 211, 78, 14);
		contentPane.add(lblPrincipioAtivo);
		
		txtPrincipioAtivo = new JTextField();
		txtPrincipioAtivo.setBounds(115, 208, 149, 20);
		contentPane.add(txtPrincipioAtivo);
		txtPrincipioAtivo.setColumns(10);
		
		JLabel lblUnidadeDeMedida = new JLabel("Unidade de Medida:");
		lblUnidadeDeMedida.setBounds(10, 261, 97, 14);
		contentPane.add(lblUnidadeDeMedida);
		
		txtUnidadeMedida = new JTextField();
		txtUnidadeMedida.setBounds(115, 258, 149, 20);
		contentPane.add(txtUnidadeMedida);
		txtUnidadeMedida.setColumns(10);
		
		JLabel lblRegistroMs = new JLabel("Registro MS:");
		lblRegistroMs.setBounds(10, 310, 66, 14);
		contentPane.add(lblRegistroMs);
		
		txtRegistroMs = new JTextField();
		txtRegistroMs.setBounds(115, 307, 149, 20);
		contentPane.add(txtRegistroMs);
		txtRegistroMs.setColumns(10);
		
		JLabel lblCodigoDeBarras = new JLabel("Código de Barras:");
		lblCodigoDeBarras.setBounds(325, 21, 86, 14);
		contentPane.add(lblCodigoDeBarras);
		
		txtCodigoBarras = new JTextField();
		txtCodigoBarras.setBounds(421, 18, 136, 20);
		contentPane.add(txtCodigoBarras);
		txtCodigoBarras.setColumns(10);
		
		JLabel lblClasseTerapeutica = new JLabel("Classe Terapeutica:");
		lblClasseTerapeutica.setBounds(314, 71, 97, 14);
		contentPane.add(lblClasseTerapeutica);
		
		txtClasseTerapeutica = new JTextField();
		txtClasseTerapeutica.setBounds(421, 68, 136, 20);
		contentPane.add(txtClasseTerapeutica);
		txtClasseTerapeutica.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(345, 120, 66, 14);
		contentPane.add(lblQuantidade);
		
		SpinnerModel sm = new SpinnerNumberModel(0, 0, 100, 1);
		spnQuantidade = new JSpinner(sm);
		spnQuantidade.setBounds(421, 117, 42, 20);
		contentPane.add(spnQuantidade);
		
		JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setBounds(10, 393, 66, 14);
		contentPane.add(lblPesquisar);
		
		txtPesquisar = new JTextField();
		txtPesquisar.setBounds(78, 390, 136, 20);
		contentPane.add(txtPesquisar);
		txtPesquisar.setColumns(10);
		
		ProdutoControl ctProduto = new ProdutoControl();
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Produto produto = new Produto();
					popularMedicamento(produto);
					ctProduto.cadastrarProduto(produto);
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(468, 384, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Produto produto = new Produto();
					popularMedicamento(produto);
					ctProduto.deletarProduto(produto);
					
				} catch (SQLException e1) {
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
					Produto produto = new Produto();
					popularMedicamento(produto);
					ctProduto.atualizarProduto(produto);
					
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
					ArrayList produtos = ctProduto.listarProduto(txtPesquisar.toString());
					JList jlist = new JList((ListModel) produtos);
					contentPane.add(jlist);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPesquisar.setBounds(236, 389, 89, 23);
		contentPane.add(btnPesquisar);
	}
	
	public static void popularMedicamento(Produto prod) {
		prod.setId(idProduto);
		prod.setApresentacao(txtApresentacao.toString());
		prod.setClasseTerapeutica(txtClasseTerapeutica.toString());
		prod.setCodigoBarras(txtCodigoBarras.toString());
		prod.setFabricante(txtFabricante.toString());
		prod.setNomeComercial(txtNomeComercial.toString());
		prod.setPrincipioAtivo(txtPrincipioAtivo.toString());
		prod.setRegistroMS(txtRegistroMs.toString());
		prod.setUnidadeMedida(txtUnidadeMedida.toString());
		prod.setFormaFarmaco((EnumFormaFarmaco) cboForma.getSelectedItem());
		prod.setQtde((int) spnQuantidade.getValue());
	}
	
}
