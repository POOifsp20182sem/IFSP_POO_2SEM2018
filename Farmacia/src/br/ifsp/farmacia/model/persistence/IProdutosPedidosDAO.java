package br.ifsp.farmacia.model.persistence;

import java.sql.SQLException;

import br.ifsp.farmacia.model.entities.ProdutosPedidos;

/**
 * @author Alice Lima
 * 
 * Interface respons�vel por definir os m�todos
 * que s�o implementados pela classe ProdutosPedidosDAO.
 * Usada para o uso do padr�o de projeto MVC.
 */

public interface IProdutosPedidosDAO {
	
	public boolean insertProdutoPedido(ProdutosPedidos produtoPedido) throws SQLException;
	public boolean removeProdutoPedido(ProdutosPedidos produtoPedido) throws SQLException;
	public boolean updateProdutoPedido(ProdutosPedidos produtoPedido, ProdutosPedidos produtoPedidoNew) throws SQLException;

}
