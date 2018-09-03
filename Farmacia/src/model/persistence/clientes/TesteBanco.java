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
		
		Cliente cli2 = new Cliente("Éder", calendar , end, "eder@gmail", "1988845", "154544", EnumCliente.JURIDICA, "12409534612", false);
		
		
		ClienteDaoImpl cdi = new ClienteDaoImpl();
		cdi.insertCliente(cli2);
		
	}
	
	public static Calendar toCalendar(Date date){ 
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  return cal;
		}
	
}
