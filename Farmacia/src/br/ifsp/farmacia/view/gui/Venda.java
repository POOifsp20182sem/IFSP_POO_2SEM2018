package br.ifsp.farmacia.view.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;

public class Venda extends JFrame {

	private JPanel contentPane;
	private JTextField txtValorTotal;
	private JTextField txtDesconto;
	private JTextField txtValorFinal;
	private JTextField txtValorPago;
	private JTextField txtTroco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Venda frame = new Venda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 * @throws ParseException 
	 */
	@SuppressWarnings("serial")
	public Venda() throws FileNotFoundException, ParseException {
		setTitle("Venda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 30, 46, 14);
		contentPane.add(lblCliente);
		
		JComboBox cboCliente = new JComboBox();
		cboCliente.setBounds(53, 27, 211, 20);
		contentPane.add(cboCliente);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(410, 157, 89, 23);
		contentPane.add(btnRemover);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.setBounds(410, 191, 89, 23);
		contentPane.add(btnConcluir);
		
		JLabel lblMedicamento = new JLabel("Medicamento:");
		lblMedicamento.setBounds(10, 75, 77, 14);
		contentPane.add(lblMedicamento);
		
		JComboBox cboMedicamento = new JComboBox();
		cboMedicamento.setBounds(97, 72, 167, 20);
		contentPane.add(cboMedicamento);
		
		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setBounds(10, 248, 55, 14);
		contentPane.add(lblValorTotal);
		
		JLabel lblDesconto = new JLabel("Desconto:");
		lblDesconto.setBounds(10, 273, 55, 14);
		contentPane.add(lblDesconto);
		
		JLabel lblValorFinal = new JLabel("Valor Final:");
		lblValorFinal.setBounds(10, 300, 55, 14);
		contentPane.add(lblValorFinal);
		
		txtValorTotal = new JTextField();
		txtValorTotal.setEditable(false);
		txtValorTotal.setBounds(75, 245, 86, 20);
		contentPane.add(txtValorTotal);
		txtValorTotal.setColumns(10);
		
		txtDesconto = new JTextField();
		txtDesconto.setEditable(false);
		txtDesconto.setBounds(75, 270, 86, 20);
		contentPane.add(txtDesconto);
		txtDesconto.setColumns(10);
		
		txtValorFinal = new JTextField();
		txtValorFinal.setEditable(false);
		txtValorFinal.setBounds(75, 297, 86, 20);
		contentPane.add(txtValorFinal);
		txtValorFinal.setColumns(10);
		
		JLabel lblFormaPagamento = new JLabel("Forma Pagamento:");
		lblFormaPagamento.setBounds(10, 179, 99, 14);
		contentPane.add(lblFormaPagamento);
		
		JRadioButton rdbtnDinheiro = new JRadioButton("Dinheiro");
		rdbtnDinheiro.setBounds(31, 200, 109, 23);
		contentPane.add(rdbtnDinheiro);
		
		JRadioButton rdbtnCarto = new JRadioButton("Cart\u00E3o");
		rdbtnCarto.setBounds(155, 200, 109, 23);
		contentPane.add(rdbtnCarto);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(306, 30, 40, 14);
		contentPane.add(lblData);
		
		MaskFormatter forData = new MaskFormatter("##/##/####");
		JFormattedTextField mskData = new JFormattedTextField(forData);
		mskData.setBounds(338, 27, 71, 20);
		contentPane.add(mskData);
		
		JLabel lblValorPago = new JLabel("Valor Pago:");
		lblValorPago.setBounds(348, 248, 55, 14);
		contentPane.add(lblValorPago);
		
		JLabel lblTroco = new JLabel("Troco:");
		lblTroco.setBounds(348, 273, 55, 14);
		contentPane.add(lblTroco);
		
		txtValorPago = new JTextField();
		txtValorPago.setColumns(10);
		txtValorPago.setBounds(413, 245, 86, 20);
		contentPane.add(txtValorPago);
		
		txtTroco = new JTextField();
		txtTroco.setEditable(false);
		txtTroco.setColumns(10);
		txtTroco.setBounds(413, 270, 86, 20);
		contentPane.add(txtTroco);
	}
}
