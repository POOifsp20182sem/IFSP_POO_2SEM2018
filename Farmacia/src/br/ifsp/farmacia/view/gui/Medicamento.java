package br.ifsp.farmacia.view.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import br.ifsp.farmacia.model.entities.EnumFormaFarmaco;
import javax.swing.JSpinner;

public class Medicamento extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeComercial;
	private JTextField txtApresentacao;
	private JTextField txtFabricante;
	private JTextField txtPrincipioAtivo;
	private JTextField txtUnidadeMedida;
	private JTextField txtRegistroMs;
	private JTextField txtCodigoBarras;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Medicamento frame = new Medicamento();
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
	public Medicamento() {
		setTitle("Medicamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 440);
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
		
		JLabel lblApresentao = new JLabel("Apresenta\u00E7\u00E3o:");
		lblApresentao.setBounds(10, 72, 91, 14);
		contentPane.add(lblApresentao);
		
		txtApresentacao = new JTextField();
		txtApresentacao.setBounds(115, 69, 149, 20);
		contentPane.add(txtApresentacao);
		txtApresentacao.setColumns(10);
		
		JLabel lblFormaFarmaco = new JLabel("Forma Farmaco:");
		lblFormaFarmaco.setBounds(10, 120, 78, 14);
		contentPane.add(lblFormaFarmaco);
		
		JComboBox cboForma = new JComboBox();
		cboForma.setModel(new DefaultComboBoxModel(EnumFormaFarmaco.values()));
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
		
		JTextField txtPrincipioAtivo = new JTextField();
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
		
		JLabel lblCodigoDeBarras = new JLabel("C\u00F3digo de Barras:");
		lblCodigoDeBarras.setBounds(325, 21, 86, 14);
		contentPane.add(lblCodigoDeBarras);
		
		txtCodigoBarras = new JTextField();
		txtCodigoBarras.setBounds(421, 18, 136, 20);
		contentPane.add(txtCodigoBarras);
		txtCodigoBarras.setColumns(10);
		
		JLabel lblClasseTerapeutica = new JLabel("Classe Terapeutica:");
		lblClasseTerapeutica.setBounds(314, 71, 97, 14);
		contentPane.add(lblClasseTerapeutica);
		
		textField = new JTextField();
		textField.setBounds(421, 68, 136, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(345, 120, 66, 14);
		contentPane.add(lblQuantidade);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(421, 117, 42, 20);
		contentPane.add(spinner);
	}
}
