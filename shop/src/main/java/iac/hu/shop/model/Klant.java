package iac.hu.shop.model;

import java.sql.Date;

public class Klant {
	
	private int id;
	private String voornaam;
	private String achternaam;
	private String tussenvoegsel;
	private String mobiel;
	private Date geboortedatum;
	private Adres adres;
	private int adresID;
	private String email;
	
	
	public Klant(int id, String voornaam, String achternaam, String tussenvoegsel,String mobiel, Date geboortedatum,
			Adres adres,String email) {
		this.id = id;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.tussenvoegsel = tussenvoegsel;
		this.mobiel = mobiel;
		this.geboortedatum = geboortedatum;
		this.adres = adres;
		this.email = email;
	}
	
	public Klant(int id, String voornaam, String achternaam, String tussenvoegsel,String mobiel, Date geboortedatum,
			int adresID,String email) {
		this.id = id;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.tussenvoegsel = tussenvoegsel;
		this.mobiel = mobiel;
		this.geboortedatum = geboortedatum;
		this.adresID = adresID;
		this.email = email;
	}


	public int getId() {
		return id;
	}


	public String getVoornaam() {
		return voornaam;
	}


	public String getAchternaam() {
		return achternaam;
	}


	public String getTussenvoegsel() {
		return tussenvoegsel;
	}




	public Date getGeboortedatum() {
		return geboortedatum;
	}


	public Adres getAdres() {
		return adres;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}


	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}


	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}





	public void setGeboortedatum(Date geboortedatum) {
		this.geboortedatum = geboortedatum;
	}


	public void setAdres(Adres adres) {
		this.adres = adres;
	}


	public String getMobiel() {
		return mobiel;
	}


	public void setMobiel(String mobiel) {
		this.mobiel = mobiel;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public int getAdresID() {
		return adresID;
	}

	public void setAdresID(int adresID) {
		this.adresID = adresID;
	}

	


	
	
	

}

