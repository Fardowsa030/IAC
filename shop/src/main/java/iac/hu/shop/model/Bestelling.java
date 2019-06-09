package iac.hu.shop.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bestelling {
	private int id;
	private String account;
	private String orderDatum;
	private int klantID;
	private Klant klant;
	private List<Bestellingsregel> regels = new ArrayList<>();
	
	


	public Bestelling(int id, String account, String orderDatum) {
		this.id = id;
		this.account = account;
		this.orderDatum = orderDatum;
	}
	


	public Bestelling(int id, String orderDatum, int klantID) {
		this.id = id;
		this.orderDatum = orderDatum;
		this.klantID = klantID;
	}




	public int getId() {
		return id;
	}


	public String getAccount() {
		return account;
	}


	public String getOrderDatum() {
		return orderDatum;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public void setOrderDatum(String orderDatum) {
		this.orderDatum = orderDatum;
	}




	public int getKlantID() {
		return klantID;
	}




	public void setKlantID(int klantID) {
		this.klantID = klantID;
	}




	public List<Bestellingsregel> getRegels() {
		return regels;
	}




	public void setRegels(List<Bestellingsregel> regels) {
		this.regels = regels;
	}



	public Klant getKlant() {
		return klant;
	}



	public void setKlant(Klant klant) {
		this.klant = klant;
	}
	
	
	
	

}
