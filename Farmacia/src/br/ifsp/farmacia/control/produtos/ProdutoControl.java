package br.ifsp.farmacia.control.produtos;

import java.sql.SQLException;

import br.ifsp.farmacia.model.persistence.produtos.*;
import br.ifsp.farmacia.model.entities.*;

public class ProdutoControl {

	IProdutoDAO pd = new ProdutoDAO();

	public void cadastrarProduto(Produto prod) throws SQLException {
		pd.insertProduto(prod);
	}

	public void atualizarProduto(Produto prod) throws SQLException {
		pd.updateProduto(prod);
	}
	
	public void deletarProduto(Produto prod) throws SQLException {
		pd.deleteProduto(prod);
	}
	
	public void listarProduto (Produto prod) throws SQLException {
		pd.selectProduto(null);
	}
}
