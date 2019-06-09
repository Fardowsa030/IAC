package iac.hu.shop.model;

import java.sql.Date;

public class Product {
	
	private int id;
	private String naam;
	private String omschrijving;
	private String afbeeldingTekst;
	private double prijs;
	private Categorie categorie;
	private String aanmaakDatum;

	
	public Product(int id, String naam, String omschrijving, String afbeeldingTekst, double prijs,Categorie categorie) {

		this.id = id;
		this.naam = naam;
		this.omschrijving = omschrijving;
		this.afbeeldingTekst = afbeeldingTekst;
		this.prijs = prijs;
		this.categorie = categorie;

	}
	
	public Product(int id, String naam, String omschrijving, String afbeeldingTekst, double prijs) {

		this.id = id;
		this.naam = naam;
		this.omschrijving = omschrijving;
		this.afbeeldingTekst = afbeeldingTekst;
		this.prijs = prijs;
	
	}
	
	public Product(int id, String naam, String omschrijving, String afbeeldingTekst, double prijs,String aanmaakDatum) {

		this.id = id;
		this.naam = naam;
		this.omschrijving = omschrijving;
		this.afbeeldingTekst = afbeeldingTekst;
		this.prijs = prijs;
		this.aanmaakDatum = aanmaakDatum;
	
	}
	
	
	


	public int getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public String getOmschrijving() {
		return omschrijving;
	}

	public String getAfbeeldingTekst() {
		return afbeeldingTekst;
	}

	public double getPrijs() {
		return prijs;
	}


	public void setId(int id) {
		this.id = id;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public void setAfbeeldingTekst(String afbeeldingTekst) {
		this.afbeeldingTekst = afbeeldingTekst;
	}

	public void setPrijs(int prijs) {
		this.prijs = prijs;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getAanmaakDatum() {
		return aanmaakDatum;
	}

	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}

	public void setAanmaakDatum(String aanmaakDatum) {
		this.aanmaakDatum = aanmaakDatum;
	}
	
	
	
	



	
	
	

}
