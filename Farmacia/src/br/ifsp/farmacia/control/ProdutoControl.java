package br.ifsp.farmacia.control;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ifsp.farmacia.model.persistence.ProdutoDAO;
import br.ifsp.farmacia.model.persistence.*;
import br.ifsp.farmacia.model.entities.*;

public class ProdutoControl {

	private ProdutoDAO pd = new ProdutoDAO();

	public boolean cadastrarProduto(Produto prod) throws SQLException {
		return pd.insertProduto(prod);
	}

	public boolean atualizarProduto(Produto prod) throws SQLException {
		return pd.updateProduto(prod);
	}
	
	public boolean deletarProduto(Produto prod) throws SQLException {
		return pd.deleteProduto(prod);
	}
	
	public ArrayList<Produto> listarProduto (String prod) throws SQLException {
		return pd.selectProduto(null);
	}
	
	public ArrayList<Produto> listarProduto () throws SQLException {
		return pd.selectProduto(null);
	}
	
	public ArrayList<ClasseTerapeutica> listarClasseTerapeutica() throws SQLException{
		return pd.selectClasseTerapeutica();
	}
	
	public ArrayList<PrincipioAtivo> listarPrincipioAtivo() throws SQLException{
		return pd.selectPrincipioAtivo();
	}
}
