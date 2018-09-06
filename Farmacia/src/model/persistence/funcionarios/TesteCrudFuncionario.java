package model.persistence.funcionarios;

import java.util.Calendar;

import model.entities.Endereco;
import model.entities.EnumFuncionario;
import model.entities.Funcionario;

public class TesteCrudFuncionario {

	public static void main(String[] args) {
		
		
		Endereco end = new Endereco();
		end.setLogradouro("Irineu Bernardi");
		end.setNumero("97");
		end.setCidade("Monte Sião");
		end.setComplemento("");
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(1999, Calendar.FEBRUARY, 10);
		
		Funcionario func = new Funcionario("Cabana", calendar, end, "eder@gmail.com",
				"77777777", "65794333548", 2000.50, EnumFuncionario.GERENTE);
		
		//instanciar impl
		try {
		FuncionarioImpl funcImpl = new FuncionarioImpl();
		//testar insert passou
		//funcImpl.insertFuncionario(func);
		
		//teste update passou
		//func.setId(3);
		//funcImpl.updateFuncionario(func);
		
		//teste delete passou
		//func.setId(3);
		//funcImpl.deleteFuncionario(func);
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		

	}

}
