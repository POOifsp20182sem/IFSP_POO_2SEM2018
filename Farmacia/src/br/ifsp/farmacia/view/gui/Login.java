package br.ifsp.farmacia.view.gui;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel painel = new JPanel();
		JPanel painel2 = new JPanel();
		JLabel lblUser = new JLabel("Usuário: ");
		JLabel lblPswd = new JLabel("Senha: ");

		JTextField user = new JTextField(30);
		JPasswordField pswd = new JPasswordField(20);

		JButton ok = new JButton("OK");
		JButton cancel = new JButton("Cancelar");

		painel.setLayout(new BoxLayout(painel, BoxLayout.PAGE_AXIS));
		painel.add(lblUser);
		painel.add(user);
		painel.add(lblPswd);
		painel.add(pswd);

		painel2.setLayout(new FlowLayout());
		painel2.add(ok);
		painel2.add(cancel);

		ComponentesExtras component = new ComponentesExtras();

		frame.setContentPane(painel);
		frame.add(component.criarImagem("icone.png"));
		frame.add(painel2);
		frame.pack();
		frame.setVisible(true);
		frame.setLocation(350, 200);

	}
}
