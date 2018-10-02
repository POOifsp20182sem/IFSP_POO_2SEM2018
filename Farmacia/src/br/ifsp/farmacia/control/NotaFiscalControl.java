package br.ifsp.farmacia.control;

import java.sql.SQLException;
import java.util.ArrayList;

import br.ifsp.farmacia.model.entities.NotaFiscal;
import br.ifsp.farmacia.model.persistence.INotaFiscalDAO;
import br.ifsp.farmacia.model.persistence.NotaFiscalDAO;

public class NotaFiscalControl implements INotaFiscalDAO {

	NotaFiscalDAO nfeDao = new NotaFiscalDAO();
	
	@Override
	public boolean emitirNotaFiscal(NotaFiscal nfe) throws SQLException {
		return nfeDao.emitirNotaFiscal(nfe);
	}

	@Override
	public boolean cancelarNotaFiscal(NotaFiscal nfe) throws SQLException {
		return nfeDao.cancelarNotaFiscal(nfe);
	}

	@Override
	public ArrayList<NotaFiscal> selectNotaFiscal() throws SQLException {
		return nfeDao.selectNotaFiscal();
	}

	@Override
	public ArrayList<NotaFiscal> selectNotaFiscal(String filtr) throws SQLException {
		return nfeDao.selectNotaFiscal(filtr);
	}
}
