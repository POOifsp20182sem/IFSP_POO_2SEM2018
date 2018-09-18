package br.ifsp.farmacia.control.clientes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import DAO.JDBCClienteEspecial;
import MODELO.ClienteEspecial;

public class ClienteControl {
	
	public String cadastrarClienteEspecial(ClienteEspecial clienteEspecial) throws ParseException
	{
		JDBCClienteEspecial ce = new JDBCClienteEspecial();
		
		String mensagem;
		
		int ano;
		
		if(clienteEspecial.getCpf().trim().length() < 14)
		{
			mensagem = "Por favor, insere um cpf para o cliente!";
			return mensagem;
		}
		else if(clienteEspecial.getDataNascimento().trim().length() < 9)
		{
			mensagem = "Por favor, insere uma data de nascimento para o cliente!";
			return mensagem;
		}
		else if(clienteEspecial.getNome().trim().length() == 0)
		{
			mensagem = "Por favor, insere um nome para o cliente!";
			return mensagem;
		}
		
		SimpleDateFormat usuario = new SimpleDateFormat("dd/mm/yyyy");
		Date data = new Date();
		Calendar cal = GregorianCalendar.getInstance();
		GregorianCalendar anoData = new GregorianCalendar();
		
		data = usuario.parse(clienteEspecial.getDataNascimento());
		
		anoData.setTime(data);
		
		ano = cal.get(Calendar.YEAR) - anoData.get(Calendar.YEAR);
		
		
		if(ano < 60 )
		{
			mensagem = "Cliente deve ter no minimo 60 anos para ser aposentado!\nNão foi possivel cadastrar o cliente especial";
			return mensagem;
		}
		else
		{
			ce.cadastrarCliente(clienteEspecial);
			mensagem = "Cliente cadastrado com sucesso";
			return mensagem;
		}
		
	}
	
	public String atualizarClienteEspecial(ClienteEspecial clienteEspecial) throws ParseException
	{
		JDBCClienteEspecial ce = new JDBCClienteEspecial();
		String mensagem;
		
		int ano;
		
		SimpleDateFormat usuario = new SimpleDateFormat("dd/mm/yyyy");
		Date data = new Date();
		Calendar cal = GregorianCalendar.getInstance();
		GregorianCalendar anoData = new GregorianCalendar();
		
		data = usuario.parse(clienteEspecial.getDataNascimento());
		
		anoData.setTime(data);
		
		ano = cal.get(Calendar.YEAR) - anoData.get(Calendar.YEAR);
		
		if(clienteEspecial.getCpf().trim().length() < 14)
		{
			mensagem = "Por favor, insere um cpf para o cliente!";
			return mensagem;
		}
		else if(clienteEspecial.getDataNascimento().trim().length() < 9)
		{
			mensagem = "Por favor, insere uma data de nascimento para o cliente!";
			return mensagem;
		}
		else if(clienteEspecial.getNome().trim().length() == 0)
		{
			mensagem = "Por favor, insere um nome para o cliente!";
			return mensagem;
		}
		else if(ano < 60 )
		{
			mensagem = "Cliente deve ter no minimo 60 anos para ser aposentado!\nNão foi possivel cadastrar o cliente especial";
			return mensagem;
		}
		else
		{
			ce.atualizarCliente(clienteEspecial);
			mensagem = "Cliente atualizado com sucesso";
			return mensagem;
		}
	}
	
	public ArrayList<ClienteEspecial> obterClientesEspeciais()
	{
		JDBCClienteEspecial ce = new JDBCClienteEspecial();
		return ce.obterClientesEspeciais();
	}
	
	public ClienteEspecial obterClienteEspecial(String cpf)
	{
		if(cpf.trim().length() < 0)
		{
			JOptionPane.showMessageDialog(null,"Primeiro deve-se entrar com um CPF para procurar cliente!");
			return null;
		}
		else
		{
			JDBCClienteEspecial ce = new JDBCClienteEspecial();
			return ce.obterClienteEspecial(cpf);
		}
	}

}
