package br.ifsp.farmacia.view.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import br.ifsp.farmacia.control.ClienteControl;
import br.ifsp.farmacia.model.entities.Cliente;
import br.ifsp.farmacia.model.entities.Endereco;
import br.ifsp.farmacia.model.entities.EnumCliente;

public class FormListaClientes extends JFrame{


	private JPanel painelFundo;
	private JPanel painelBotoes;
	private static JTable tabela;
	private JScrollPane barraRolagem;
	private JButton btnInserir;
	private JButton btnExcluir;
	private JButton btnEditar;
	private DefaultTableModel modelo = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormListaClientes frame = new FormListaClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormListaClientes() throws SQLException {
		super("Clientes");
		criaTabela();
		criaJanela();
	}

	private void criaJanela() {
		setTitle("Lista Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		btnInserir = new JButton("Inserir");
		btnExcluir = new JButton("Excluir");
		btnEditar = new JButton("Editar");
		painelBotoes = new JPanel();
		barraRolagem = new JScrollPane(tabela);
		painelFundo = new JPanel();
		painelFundo.setLayout(new BorderLayout());
		painelFundo.add(BorderLayout.CENTER, barraRolagem);
		painelBotoes.add(btnInserir);
		painelBotoes.add(btnEditar);
		painelBotoes.add(btnExcluir);
		painelFundo.add(BorderLayout.SOUTH, painelBotoes);

		getContentPane().add(painelFundo);
		setSize(500, 320);
		setVisible(true);
		btnInserir.addActionListener(new BtnInserirListener());
		btnEditar.addActionListener(new BtnEditarListener());
		btnExcluir.addActionListener(new BtnExcluirListener());
	}

	/***
	 * Classes privadas responsáveis pelo crud básico
	 */

	private class BtnInserirListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			FormCliente fc;
			try {
				fc = new FormCliente();
				fc.setVisible(true);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	private class BtnEditarListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int selectedRow = -1;
			selectedRow = tabela.getSelectedRow();
			if(selectedRow >=0) {
				try {
					int id = (int) tabela.getValueAt(selectedRow, 0);
					FormCliente fc =new FormCliente(id);
					fc.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
			}else
				JOptionPane.showMessageDialog(null, "Selecione uma linha para atualizar.");
		}
	} 
	
	private class BtnExcluirListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int selectedRow = -1;
			selectedRow = tabela.getSelectedRow();
			if(selectedRow >= 0) {
				try {
					int id = (int) tabela.getValueAt(selectedRow, 0);
					FormCliente.excluirCliente(id);
					modelo.removeRow(selectedRow);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}else
				JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir.");
		}
	} 

	private void criaTabela() throws SQLException {
		tabela = new JTable(modelo);
		modelo.addColumn("Id");
		modelo.addColumn("Nome");
		modelo.addColumn("E-mail");
		modelo.addColumn("Endereço");
		modelo.addColumn("Telefone");
		modelo.addColumn("Celular");
		modelo.addColumn("Tipo");
		modelo.addColumn("CPF");
		modelo.addColumn("Data nasc");
		tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(5).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(6).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(7).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(8).setPreferredWidth(10);
		
		//popular tabela
		popularDados(modelo);

		//TODO:26-09-2018:ed:campo id aparece, porém não pode ser
		//retirado uma vez que existem várias excecoes associadas
		//tabela.removeColumn(tabela.getColumnModel().getColumn(0));
	}

	public static void popularDados(DefaultTableModel modelo) throws SQLException {
		// Número de linhas vazias na tabela
		modelo.setNumRows(0);
		ClienteControl ctCliente = new ClienteControl();

		for (Cliente c : ctCliente.listarCliente()) {
			modelo.addRow(new Object[]{
					c.getId(),
					c.getNome(),
					c.getEmail(),
					c.getEndereco(),
					c.getTelefone(),
					c.getCelular(),
					c.getTipoCliente(),
					c.getDocumento(),
					c.getDataNascimento()
			});
		}
	}
	
	public static void addCliente(DefaultTableModel modelo,Cliente c) {
		modelo.addRow(new Object[]{
				c.getId(),
				c.getNome(),
				c.getEmail(),
				c.getEndereco(),
				c.getTelefone(),
				c.getCelular(),
				c.getTipoCliente(),
				c.getDocumento(),
				c.getDataNascimento()
		});
	}
}
