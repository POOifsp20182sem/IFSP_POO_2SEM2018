package model.persistence.clientes;

import java.util.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;

import model.entities.Cliente;
import model.entities.Endereco;
import model.entities.EnumCliente;

public class TesteBanco {

	public static void main(String[] args) throws java.text.ParseException, SQLException {
		
		Endereco end = new Endereco();
		end.setLogradouro("Irineu Bernardi");
		end.setNumero("97");
		end.setCidade("Monte Sião");
		end.setComplemento("");
		
		DateFormat f = DateFormat.getDateInstance();
         
	    Date date = f.parse("12/01/1995");
		Calendar calendar = toCalendar(date);
		
		Cliente cli = new Cliente("Éder", calendar , end, "eder@gmail", "1988845", "154544", EnumCliente.JURIDICA, "12409534612", false);
		
		ClienteDaoImpl cliDaoImpl= new ClienteDaoImpl();
		/* Insert Passou
		cliDaoImpl.insertCliente(cli2);
		*/
		
		//teste Update Passou!!
		//cli.setId(12);
		//cliDaoImpl.updateCliente(cli);
		
		//teste delete PASsou!!!
		//cli.setId(13);
		//cliDaoImpl.deleteCliente(cli);
		
		//teste select cliente -> fazendo preocedure ...
		
	}
	
	public static Calendar toCalendar(Date date){ 
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  return cal;
		}
	
}
