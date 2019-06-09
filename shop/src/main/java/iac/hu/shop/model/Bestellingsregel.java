package iac.hu.shop.model;

public class Bestellingsregel {
	
	private int id;
	private int aantal;
	private int leverprijs;
	private Product product;
	private int productID;
	private Bestelling bestelling;
	private int bestellingID;
	
	public Bestellingsregel() {}
	
	
	public Bestellingsregel(int id, int aantal, int leverprijs, Product product, Bestelling bestelling) {

		this.id = id;
		this.aantal = aantal;
		this.leverprijs = leverprijs;
		this.product = product;
		this.bestelling = bestelling;
	}
	
	public Bestellingsregel(int id, int aantal, int leverprijs, int productID, int bestellingID) {

		this.id = id;
		this.aantal = aantal;
		this.leverprijs = leverprijs;
		this.productID = productID;
		this.bestellingID = bestellingID;
	}


	public int getId() {
		return id;
	}


	public int getProductID() {
		return productID;
	}

	public int getBestellingID() {
		return bestellingID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public void setBestellingID(int bestellingID) {
		this.bestellingID = bestellingID;
	}

	public int getAantal() {
		return aantal;
	}


	public int getLeverprijs() {
		return leverprijs;
	}


	public Product getProduct() {
		return product;
	}


	public Bestelling getBestelling() {
		return bestelling;
	}





	public void setId(int id) {
		this.id = id;
	}


	public void setAantal(int aantal) {
		this.aantal = aantal;
	}


	public void setLeverprijs(int leverprijs) {
		this.leverprijs = leverprijs;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public void setBestelling(Bestelling bestelling) {
		this.bestelling = bestelling;
	}


	@Override
	public String toString() {
		return "Bestellingsregel [id=" + id + ", aantal=" + aantal + ", leverprijs=" + leverprijs + ", productID="
				+ productID + ", bestellingID=" + bestellingID + "]";
	}
	
	
	


	
	
	
	
	

}
