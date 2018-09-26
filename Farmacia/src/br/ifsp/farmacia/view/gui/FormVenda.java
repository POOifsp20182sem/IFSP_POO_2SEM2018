package br.ifsp.farmacia.view.gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.ifsp.farmacia.model.entities.Cliente;
import br.ifsp.farmacia.model.entities.Produto;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import br.ifsp.farmacia.model.persistence.clientes.ClienteDAO;
import br.ifsp.farmacia.control.vendas.VendaControl;
import br.ifsp.farmacia.model.entities.Cliente;
import br.ifsp.farmacia.model.entities.Venda;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormVenda extends JFrame {

	private static JComboBox cboMedicamento;
	private static JComboBox cboCliente;
	private static JTextField txtTroco;
	private JPanel contentPane;
	private JTextField txtValorTotal;
	private JTextField txtDesconto;
	private static JTextField txtValorFinal;
	private static JTextField txtValorPago;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormVenda frame = new FormVenda();
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
	 * @throws SQLException 
	 */

	public FormVenda() throws FileNotFoundException, ParseException, SQLException {
		setTitle("Venda");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 30, 46, 14);
		contentPane.add(lblCliente);
		
		JComboBox cboCliente = new JComboBox();
		//teste
		ClienteDAO cliDAO = new ClienteDAO();
		Cliente cli = new Cliente();
	     ArrayList<Cliente> lista = cliDAO.selectCliente();
	     cboCliente.addItem("");  
	     for(int i=0;i<lista.size();i++){
	         cboCliente.addItem(lista.get(i).getNome());
	     }
	     //ate aqui

		cboCliente = new JComboBox();
		cboCliente.setBounds(69, 27, 211, 20);
		contentPane.add(cboCliente);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(410, 157, 89, 23);
		contentPane.add(btnRemover);
		
		VendaControl ctVenda = new VendaControl();
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					Venda ven = new Venda();
					popularVenda(ven);
					ctVenda.cadastrarVenda(ven);
					troco();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnConcluir.setBounds(410, 191, 89, 23);
		contentPane.add(btnConcluir);
		
		JLabel lblMedicamento = new JLabel("Medicamento:");
		lblMedicamento.setBounds(10, 75, 93, 14);
		contentPane.add(lblMedicamento);
		
		cboMedicamento = new JComboBox();
		cboMedicamento.setBounds(113, 72, 167, 20);
		contentPane.add(cboMedicamento);
		
		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setBounds(10, 248, 68, 14);
		contentPane.add(lblValorTotal);
		
		JLabel lblDesconto = new JLabel("Desconto:");
		lblDesconto.setBounds(10, 273, 68, 14);
		contentPane.add(lblDesconto);
		
		JLabel lblValorFinal = new JLabel("Valor Final:");
		lblValorFinal.setBounds(10, 300, 68, 14);
		contentPane.add(lblValorFinal);
		
		txtValorTotal = new JTextField();
		txtValorTotal.setEditable(false);
		txtValorTotal.setBounds(88, 248, 86, 20);
		contentPane.add(txtValorTotal);
		txtValorTotal.setColumns(10);
		
		txtDesconto = new JTextField();
		txtDesconto.setEditable(false);
		txtDesconto.setBounds(88, 273, 86, 20);
		contentPane.add(txtDesconto);
		txtDesconto.setColumns(10);
		
		txtValorFinal = new JTextField();
		txtValorFinal.setEditable(false);
		txtValorFinal.setBounds(88, 300, 86, 20);
		contentPane.add(txtValorFinal);
		txtValorFinal.setColumns(10);
		
		JLabel lblFormaPagamento = new JLabel("Forma Pagamento:");
		lblFormaPagamento.setBounds(10, 179, 115, 14);
		contentPane.add(lblFormaPagamento);
		
		JRadioButton rdbtnDinheiro = new JRadioButton("Dinheiro");
		rdbtnDinheiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((rdbtnDinheiro.isSelected() == true) && (cboCliente.getSelectedItem() == null)) {
					 double desconto = Double.parseDouble(txtValorTotal.getText()) * 0.05; 
					 double valorFinal = Double.parseDouble(txtValorTotal.getText()) - desconto;
					 txtDesconto.setText(String.valueOf(desconto));
					 txtValorFinal.setText(String.valueOf(valorFinal));
				}
				else if((rdbtnDinheiro.isSelected() == true) && (cboCliente.getSelectedItem() != null)) {
					 double desconto = Double.parseDouble(txtValorTotal.getText()) * 0.15; 
					 double valorFinal = Double.parseDouble(txtValorTotal.getText()) - desconto;
					 txtDesconto.setText(String.valueOf(desconto));
					 txtValorFinal.setText(String.valueOf(valorFinal));
				}
			}
		});
		rdbtnDinheiro.setBounds(31, 200, 109, 23);
		contentPane.add(rdbtnDinheiro);
		
		JRadioButton rdbtnCarto = new JRadioButton("Cart\u00E3o");
		rdbtnCarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((rdbtnCarto.isSelected() == true) && (cboCliente.getSelectedItem() == null)) { 
					 double valorFinal = Double.parseDouble(txtValorTotal.getText());
					 txtDesconto.setText(String.valueOf(0));
					 txtValorFinal.setText(String.valueOf(valorFinal));
					 
				}
				else if((rdbtnCarto.isSelected() == true) && (cboCliente.getSelectedItem() != null)) {
					 double desconto = Double.parseDouble(txtValorTotal.getText()) * 0.15; 
					 double valorFinal = Double.parseDouble(txtValorTotal.getText()) - desconto;
					 txtDesconto.setText(String.valueOf(desconto));
					 txtValorFinal.setText(String.valueOf(valorFinal));
				}
			}
		});
		rdbtnCarto.setBounds(155, 200, 109, 23);
		contentPane.add(rdbtnCarto);
		
		ButtonGroup btnGroup = new ButtonGroup();
		
		btnGroup.add(rdbtnDinheiro);
		btnGroup.add(rdbtnCarto);
		
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(306, 30, 40, 14);
		contentPane.add(lblData);
		
		MaskFormatter forData = new MaskFormatter("##/##/####");
		JFormattedTextField mskData = new JFormattedTextField(forData);
		mskData.setBounds(338, 27, 71, 20);
		contentPane.add(mskData);
		
		JLabel lblValorPago = new JLabel("Valor Pago:");
		lblValorPago.setBounds(338, 248, 71, 14);
		contentPane.add(lblValorPago);
		
		JLabel lblTroco = new JLabel("Troco:");
		lblTroco.setBounds(338, 273, 71, 14);
		contentPane.add(lblTroco);
		
		txtValorPago = new JTextField();
		txtValorPago.setColumns(10);
		txtValorPago.setBounds(413, 248, 86, 20);
		contentPane.add(txtValorPago);
		
		txtTroco = new JTextField();
		txtTroco.setEditable(false);
		txtTroco.setColumns(10);
		txtTroco.setBounds(413, 273, 86, 20);
		contentPane.add(txtTroco);

	}
		
	public static void popularVenda(Venda ven) {
		Produto produto  = (Produto) cboMedicamento.getSelectedItem();
		Cliente cliente = (Cliente) cboCliente.getSelectedItem();
	}
	
	public static void troco() {
		double troco = Double.parseDouble(txtValorPago.getText()) -  Double.parseDouble(txtValorFinal.getText());
		txtTroco.setText(String.valueOf(troco));
	}
}
