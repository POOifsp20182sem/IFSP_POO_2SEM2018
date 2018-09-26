package br.ifsp.farmacia.model.persistence.notaFiscal;

import java.sql.SQLException;

import br.ifsp.farmacia.model.entities.NotaFiscal;

import java.util.ArrayList;


public interface INotaFiscalDAO {
	public boolean emitirNotaFiscal(NotaFiscal nfe) throws SQLException;
	public boolean cancelarNotaFiscal(NotaFiscal nfe) throws SQLException;
	public ArrayList<NotaFiscal> selectNotaFiscal() throws SQLException;
	public ArrayList<NotaFiscal> selectNotaFiscal(String filtr) throws SQLException;
}
