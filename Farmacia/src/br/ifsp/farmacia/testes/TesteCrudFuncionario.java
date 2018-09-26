package br.ifsp.farmacia.testes;

import java.time.LocalDate;

import br.ifsp.farmacia.model.persistence.funcionarios.FuncionarioDAO;
import br.ifsp.farmacia.model.entities.Endereco;
import br.ifsp.farmacia.model.entities.EnumFuncionario;
import br.ifsp.farmacia.model.entities.Funcionario;

public class TesteCrudFuncionario {

	public static void main(String[] args) {


		Endereco end = new Endereco();
		end.setLogradouro("Irineu Bernardi");
		end.setNumero("97");
		end.setCidade("Monte Si�o");
		end.setBairro("");

		Funcionario func = new Funcionario("Xavier", LocalDate.of(1911, 4, 13) , end, "eder@gmail.com",
				"77777777", "65794333548", 2000.50, EnumFuncionario.GERENTE, "194944444");

		try {
			/* TODO: fazer o consoli parar de apagar os meus comentarios
			FuncionarioDAO funcImpl = new FuncionarioDAO();
			funcImpl.insertFuncionario(func);

			func.setId(3);
			funcImpl.updateFuncionario(func);

			func.setId(3);
			funcImpl.deleteFuncionario(func);
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
