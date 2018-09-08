package br.ifsp.farmacia.view.gui;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ComponentsLogin {

	public Component criarImagem() {
		ImageIcon imagem = new ImageIcon(getClass().getResource("icone.png"));
		JLabel ico = new JLabel(imagem);
		return ico;
	}
}
