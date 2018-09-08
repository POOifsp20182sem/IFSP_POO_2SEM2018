package br.ifsp.farmacia.view.gui;

import java.awt.*;
import javax.swing.*;

public class Login {

	public static void main(String args[]) {

		JFrame frame = new JFrame("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel painel = new JPanel();
		JPanel painel2 = new JPanel();
		JLabel lbluser = new JLabel("Usu�rio: ");
		JLabel lblpswd = new JLabel("Senha: ");

		JTextField user = new JTextField(30);
		JPasswordField pswd = new JPasswordField(20);

		JButton ok = new JButton("OK");
		JButton cancel = new JButton("Cancelar");

		painel.setLayout(new BoxLayout(painel, BoxLayout.PAGE_AXIS));
		painel.add(lbluser);
		painel.add(user);
		painel.add(lblpswd);
		painel.add(pswd);

		painel2.setLayout(new FlowLayout());
		painel2.add(ok);
		painel2.add(cancel);

		ComponentsLogin component = new ComponentsLogin();

		frame.setContentPane(painel);
		frame.add(component.criarImagem());
		frame.add(painel2);
		frame.pack();
		frame.setVisible(true);
		frame.setLocation(350, 200);

	}
}
