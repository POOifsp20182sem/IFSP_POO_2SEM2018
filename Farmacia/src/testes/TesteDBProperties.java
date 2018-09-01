package testes;

import java.io.IOException;

import model.persistence.DBProperties;;


public class TesteDBProperties {

	public static void main(String[] args) {
		try {
			DBProperties properties = new DBProperties();

			System.out.println("URL:  " + properties.getUrl());
			System.out.println("User: " + properties.getUser());
			System.out.println("Pass: " + properties.getPasswd());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
