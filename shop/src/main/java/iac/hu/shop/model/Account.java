package iac.hu.shop.model;

import java.sql.Date;

public class Account {
	
	private int id;
	private Date openDatum;
	private String isActief;
	private String factuurAdres;
	private String email;
	private String wachtwoord;
	private Klant klant;
	
	public Account(int id, Date openDatum, String isActief, String factuurAdres, String email,
			String wachtwoord, Klant klant) {

		this.id = id;
		this.openDatum = openDatum;
		this.isActief = isActief;
		this.factuurAdres = factuurAdres;
		this.email = email;
		this.wachtwoord = wachtwoord;
		this.klant = klant;
	}
	
	public Account() {}

	public int getId() {
		return id;
	}

	public Date getOpenDatum() {
		return openDatum;
	}

	public String getIsActief() {
		return isActief;
	}

	public String getFactuurAdres() {
		return factuurAdres;
	}

	public String getEmail() {
		return email;
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	public Klant getKlant() {
		return klant;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setOpenDatum(Date openDatum) {
		this.openDatum = openDatum;
	}

	public void setIsActief(String isActief) {
		this.isActief = isActief;
	}

	public void setFactuurAdres(String factuurAdres) {
		this.factuurAdres = factuurAdres;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

	public void setKlant(Klant klant) {
		this.klant = klant;
	}
	
    

	
	
	
	
	
	

}

