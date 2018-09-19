package br.ifsp.farmacia.control.clientes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import model.persistence.clientes.IClienteDAO;
import model.entities.Cliente;

public class ClienteControl {
	
	public String cadastrarCliente(Cliente cli) throws ParseException
	{
		ICLienteDAO ce = new IClienteDAO();
		
		String mensagem;
		
		int ano;
		
		if(cli.getDocumento().trim().length() < 11)
		{
			mensagem = "Por favor, insira um cpf para o cliente!";
			return mensagem;
		}
		else if(cli.getDataNascFormatado().trim().length() < 8)
		{
			mensagem = "Por favor, insira uma data de nascimento para o cliente!";
			return mensagem;
		}
		else if(cli.getNome().trim().length() == 0)
		{
			mensagem = "Por favor, insira um nome para o cliente!";
			return mensagem;
		}
		else if (cli.getEmail().trim().lenght() == 0) {
			mensagem = "Por favor, insira um e-mail do cliente!";
			return mensagem;
		}
		else if (cli.getEndereco().trim().lenght() == 0) {
			mensagem = "Por favor, insira o endereço do cliente!";
			return mensagem;
		}
		else if (cli.getTelefone().trim().lenght() == 0) {
			mensagem = "Por favor, insira um telefone fixo do cliente!";
			return mensagem;
		}
		else if (cli.getCelular().trim().lenght() == 0) {
			mensagem = "Por favor, insira um celular do cliente!";
			return mensagem;
		}
		
		SimpleDateFormat usuario = new SimpleDateFormat("dd/mm/yyyy");
		Date data = new Date();
		Calendar cal = GregorianCalendar.getInstance();
		GregorianCalendar anoData = new GregorianCalendar();
		
		data = usuario.parse(cli.getDataNascFormatado());
		
		anoData.setTime(data);
		
		ano = cal.get(Calendar.YEAR) - anoData.get(Calendar.YEAR);
		
		
		if(ano < 60 )
		{
			mensagem = "Não foi possivel cadastrar o cliente especial, deve ter no minimo 60 anos para ser aposentado!";
			return mensagem;
		}
		else
		{
			ce.insertCliente(cli);
			mensagem = "Cliente cadastrado com sucesso";
			return mensagem;
		}
		
	}
	
	public String atualizarCliente(Cliente cli) throws ParseException
	{
		IClienteDAO ce = new IClienteDAO();
		String mensagem;
		
		int ano;
		
		SimpleDateFormat usuario = new SimpleDateFormat("dd/mm/yyyy");
		Date data = new Date();
		Calendar cal = GregorianCalendar.getInstance();
		GregorianCalendar anoData = new GregorianCalendar();
		
		data = usuario.parse(cli.getDataNascFormatado());
		
		anoData.setTime(data);
		
		ano = cal.get(Calendar.YEAR) - anoData.get(Calendar.YEAR);
		
		if(cli.getDocumento().trim().length() < 11)
		{
			mensagem = "Por favor, insira um cpf para o cliente!";
			return mensagem;
		}
		else if(cli.getDataNascFormatado().trim().length() < 8)
		{
			mensagem = "Por favor, insira uma data de nascimento para o cliente!";
			return mensagem;
		}
		else if(cli.getNome().trim().length() == 0)
		{
			mensagem = "Por favor, insira um nome para o cliente!";
			return mensagem;
		}
		else if (cli.getEmail().trim().lenght() == 0) {
			mensagem = "Por favor, insira um e-mail do cliente!";
			return mensagem;
		}
		else if (cli.getEndereco().trim().lenght() == 0) {
			mensagem = "Por favor, insira o endereço do cliente!";
			return mensagem;
		}
		else if (cli.getTelefone().trim().lenght() == 0) {
			mensagem = "Por favor, insira um telefone fixo do cliente!";
			return mensagem;
		}
		else if (cli.getCelular().trim().lenght() == 0) {
			mensagem = "Por favor, insira um celular do cliente!";
			return mensagem;
		}
		else if(ano < 60 )
		{
			mensagem = "Não foi possivel cadastrar o cliente especial, deve ter no minimo 60 anos para ser aposentado!";
			return mensagem;
		}
		else
		{
			ce.updateCliente(cli);
			mensagem = "Cliente atualizado com sucesso";
			return mensagem;
		}
	}
}

