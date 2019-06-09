package iac.hu.shop.model;

import java.util.List;

public class Categorie {
	
	private int id;
	private String afbeeldingTekst;
	private String naam;
	private String omschrijving;
	//private List<Product> product;
	
	


	public Categorie(int id, String afbeeldingTekst, String naam, String omschrijving) {

		this.id = id;
		this.afbeeldingTekst = afbeeldingTekst;
		this.naam = naam;
		this.omschrijving = omschrijving;
	}




	public int getId() {
		return id;
	}


	public String getAfbeeldingTekst() {
		return afbeeldingTekst;
	}


	public String getNaam() {
		return naam;
	}


	public String getOmschrijving() {
		return omschrijving;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setAfbeeldingTekst(String afbeeldingTekst) {
		this.afbeeldingTekst = afbeeldingTekst;
	}


	public void setNaam(String naam) {
		this.naam = naam;
	}


	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	
	
	

}
