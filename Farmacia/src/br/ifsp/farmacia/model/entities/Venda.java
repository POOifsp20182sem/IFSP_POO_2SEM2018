package br.ifsp.farmacia.model.entities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Venda {
	
	private int id;
	private String data; 
	private int idCliente;
	private int idFuncionario;
	private double total, desconto;
	
	public Venda() {}
	
	public Venda(String data, int idCliente, int idFuncionario, double total, double desconto) {
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

	
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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
