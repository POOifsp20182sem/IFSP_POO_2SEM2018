package br.ifsp.farmacia.model.persistence.notaFiscal;

import br.ifsp.farmacia.model.entities.NotaFiscal;

public interface INotaFiscalDAO {
	public void emitirNotaFiscal(NotaFiscal nfe);
	public void cancelarNotaFiscal(NotaFiscal nfe);
}
