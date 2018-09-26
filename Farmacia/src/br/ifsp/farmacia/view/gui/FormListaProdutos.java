package br.ifsp.farmacia.view.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.ifsp.farmacia.control.produtos.ProdutoControl;
import br.ifsp.farmacia.model.entities.Produto;

public class FormListaProdutos extends JFrame {

	private JPanel painelFundo;
	private JPanel painelBotoes;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private DefaultTableModel modelo = new DefaultTableModel();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormListaProdutos frame = new FormListaProdutos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormListaProdutos() throws SQLException {
		criaTabela();
		criaJanela();
	}


	private void criaJanela() {
		painelBotoes = new JPanel();
		barraRolagem = new JScrollPane(tabela);
		painelFundo = new JPanel();
		painelFundo.setLayout(new BorderLayout());
		painelFundo.add(BorderLayout.CENTER, barraRolagem);

		getContentPane().add(painelFundo);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 320);
		setVisible(true);
	}


	private void criaTabela() throws SQLException {
		tabela = new JTable(modelo);
		modelo.addColumn("Id");
		modelo.addColumn("Apresentação");
		modelo.addColumn("Classe Terapeutica");
		modelo.addColumn("Codigo");
		modelo.addColumn("Fabricante");
		modelo.addColumn("Nome Comercial");
		modelo.addColumn("Principio Ativo");
		modelo.addColumn("Registro MS");
		modelo.addColumn("Unidade Medida");
		modelo.addColumn("Forma Farmaco");
		modelo.addColumn("Quantidade");
		tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(5).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(6).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(7).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(8).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(9).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(10).setPreferredWidth(10);
		popularDados(modelo);	
	}

	public static void popularDados(DefaultTableModel modelo) throws SQLException {
		// Número de linhas vazias na tabela
		modelo.setNumRows(0);
		ProdutoControl ctProduto = new ProdutoControl();

		for (Produto c : ctProduto.listarProduto()) {
			modelo.addRow(new Object[]{
					c.getId(),
					c.getApresentacao(),
					c.getClasseTerapeutica(),
					c.getCodigoBarras(),
					c.getFabricante(),
					c.getNomeComercial(),
					c.getPrincipioAtivo(),
					c.getRegistroMS(),
					c.getUnidadeMedida(),
					c.getFormaFarmaco(),
					c.getQtde()
			});
		}
	}
}
