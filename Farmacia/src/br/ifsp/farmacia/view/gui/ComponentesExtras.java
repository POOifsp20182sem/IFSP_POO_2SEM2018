package br.ifsp.farmacia.view.gui;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ComponentesExtras {

	public Component criarImagem(String icone) {
		ImageIcon imagem = new ImageIcon(getClass().getResource(icone));
		JLabel ico = new JLabel(imagem);
		return ico;
	}

}
