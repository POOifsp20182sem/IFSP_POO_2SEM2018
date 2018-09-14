package br.ifsp.farmacia.testes;

import br.ifsp.farmacia.model.entities.EnumFormaFarmaco;
import br.ifsp.farmacia.model.entities.Produto;
import br.ifsp.farmacia.model.persistence.produtos.ProdutoDAO;

public class TesteCrudProduto {

	public static void main(String[] args) {
		Produto prod = new Produto("Rem�dio forte", "Poderoso", EnumFormaFarmaco.DRAGEA,
				"eu que fiz", "batata frita", "tonela c�bica", "42666404",
				"numero aqui", "psicotropico", 120);

		ProdutoDAO prodDAO = new ProdutoDAO();
		
		try {
			//TODO:FormaFarmaco est� sendo inserido em letras mai�sculas
			/*
			prodDAO.insertProduto(prod);
			
			prod.setId(4);
			prodDAO.updateProduto(prod);
			*/
			
			for(Produto p: prodDAO.selectProduto()) {
				System.out.println(p.toString());
			}
				
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
