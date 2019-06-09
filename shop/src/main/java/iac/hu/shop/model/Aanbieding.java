package iac.hu.shop.model;

import java.util.Date;

public class Aanbieding {
	
	private int id;
	private Date vanDatum;
	private Date totDatum;
	private int aanbiedingsprijs;
	private String reclameTekst;
	private Product product;
	
	
	public Aanbieding(int id, Date vanDatum, Date totDatum, int aanbiedingsprijs, String reclameTekst,
			Product product) {

		this.id = id;
		this.vanDatum = vanDatum;
		this.totDatum = totDatum;
		this.aanbiedingsprijs = aanbiedingsprijs;
		this.reclameTekst = reclameTekst;
		this.product = product;
	}


	public int getId() {
		return id;
	}


	public Date getVanDatum() {
		return vanDatum;
	}


	public Date getTotDatum() {
		return totDatum;
	}


	public int getAanbiedingsprijs() {
		return aanbiedingsprijs;
	}


	public String getReclameTekst() {
		return reclameTekst;
	}


	public Product getProduct() {
		return product;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setVanDatum(Date vanDatum) {
		this.vanDatum = vanDatum;
	}


	public void setTotDatum(Date totDatum) {
		this.totDatum = totDatum;
	}


	public void setAanbiedingsprijs(int aanbiedingsprijs) {
		this.aanbiedingsprijs = aanbiedingsprijs;
	}


	public void setReclameTekst(String reclameTekst) {
		this.reclameTekst = reclameTekst;
	}


	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	

}
