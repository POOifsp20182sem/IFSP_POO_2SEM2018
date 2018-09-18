package br.ifsp.farmacia.view.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.ParseException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class Clientes {

	public static void main(String[] args) throws ParseException {
		
		JFrame frame = new JFrame("Cliente");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel painel = new JPanel();
		JPanel painel2 = new JPanel();
		JPanel painel3 = new JPanel();
		JLabel lblNome = new JLabel("Nome:");
		JLabel lblDNasc = new JLabel("Data Nascimento:");
		JLabel lblEndereco = new JLabel("Endereço:");
		JLabel lblEmail = new JLabel("E-mail:");
		JLabel lblTelefone = new JLabel("Telefone:");
		JLabel lblCelular = new JLabel("Celular:");
		JLabel lblTipo = new JLabel("Tipo:");
		JLabel lblDocumento = new JLabel("Documento:"); // mudar
		
		JTextField nome = new JTextField(10);
		JTextField endereco = new JTextField(10);
		JTextField email = new JTextField(10);
		JTextField documento = new JTextField(10);
		JComboBox tipo = new JComboBox();
		
		JButton salvar = new JButton("Salvar");
		JButton alterar = new JButton("Alterar");
		JButton excluir = new JButton("Excluir");
		JButton sair = new JButton("Sair");
		JButton pesquisar = new JButton("Pesquisar");
		
		MaskFormatter formData = new MaskFormatter("##/##/####");
		JFormattedTextField dataNasc = new JFormattedTextField(formData);
		
		MaskFormatter formTelefone = new MaskFormatter("(##) ####-####");
		JFormattedTextField telefone = new JFormattedTextField(formTelefone);
		
		MaskFormatter formCelular = new MaskFormatter("(##) #####-####");
		JFormattedTextField celular = new JFormattedTextField(formCelular);
		
		tipo.addItem("Física");
		tipo.addItem("Jurídica");
		
		JTable clientes = new JTable();
		
		painel.setLayout(new BoxLayout(painel, BoxLayout.PAGE_AXIS));
		painel.add(lblNome);
		painel.add(nome);
		painel.add(lblDNasc);
		painel.add(dataNasc);
		painel.add(lblEndereco);
		painel.add(endereco);
		painel.add(lblEmail);
		painel.add(email);
		painel.add(lblTelefone);
		painel.add(telefone);
		painel.add(lblCelular);
		painel.add(celular);
		painel.add(lblTipo);
		painel.add(tipo);
		painel.add(lblDocumento);
		painel.add(documento);
		
		painel2.setLayout(new FlowLayout());
		painel2.add(salvar);
		painel2.add(alterar);
		painel2.add(excluir);
		painel2.add(sair);
		
		JScrollPane scPane = new JScrollPane(clientes);
		clientes.setFillsViewportHeight(true);
		painel3.add(clientes);
		
		ComponentesExtras component = new ComponentesExtras();
		
		frame.setContentPane(painel);
		frame.add(component.criarImagem("cliente.png"));
		frame.add(painel2);
		frame.add(scPane);
		frame.pack();
		frame.setVisible(true);
		frame.setLocation(350, 200);
		
	}

}
