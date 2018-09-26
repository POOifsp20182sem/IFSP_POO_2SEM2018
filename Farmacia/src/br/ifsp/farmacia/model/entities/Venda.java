package br.ifsp.farmacia.model.entities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Venda {
	
	private int id;
	private Date data = new Date(System.currentTimeMillis());  
	private int idCliente;
	private int idFuncionario;
	private double total, desconto;
	
	public Venda() {}
	
	public Venda(Date data, int idCliente, int idFuncionario, double total, double desconto) {
		this.data = data;
		this.idCliente = idCliente;
		this.idFuncionario = idFuncionario;
		this.total = total;
		this.desconto = desconto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	public String getStrDataNascimento() {
		return this.data.getDayOfMonth() + "." +
				this.data.getMonthValue() + "." +
				this.data.getYear();
	}
	
	public String getDataNascFormatado() {
		return this.data.getYear() + "-" +
				this.data.getMonthValue() + "-" +
				this.data.getDayOfMonth();
	}
	
	public void setDataNascimento(Date data) {
		this.data = data;
	}
	
	public void setDataNascimento(String data) {
		String [] strings = data.split("/"); 
		int dia,mes,ano;
		dia = Integer.parseInt(strings[0]);
		mes = Integer.parseInt(strings[1]);
		ano = Integer.parseInt(strings[2]);
		this.data = Date.of(ano, mes, dia);
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	
	@Override
	public String toString() {
		return "pedido [id=" + id + ", data_compra=" + data + ", cliente_id=" + idCliente + ", funcionario_id=" + idFuncionario
				+ ", total=" + total + ", desconto=" + desconto +"]";
	}

}
