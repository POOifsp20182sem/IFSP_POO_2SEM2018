package br.ifsp.farmacia.control.vendas;

import java.sql.SQLException;
import java.util.ArrayList;

import br.ifsp.farmacia.model.entities.Venda;
import br.ifsp.farmacia.model.persistence.vendas.VendaDAO;

public class VendaControl implements IVendaControl {
	
	private VendaDAO vd = new VendaDAO();
	
	public boolean cadastrarVenda(Venda ven) throws SQLException {
		return vd.insertVenda(ven);
	}

	public boolean atualizarVenda(Venda ven) throws SQLException {
		return vd.updateVenda(ven);
	}
	
	public boolean deletarVenda(Venda ven) throws SQLException {
		return vd.deleteVenda(ven);
	}
	
	public ArrayList<Venda> listarVenda (String filtro) throws SQLException {
		return vd.selectVenda(filtro);
	}
	
	public ArrayList<Venda> listarVenda () throws SQLException {
		return vd.selectVenda(null);
	}
}
