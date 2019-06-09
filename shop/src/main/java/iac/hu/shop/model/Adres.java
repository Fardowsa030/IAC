package iac.hu.shop.model;

public class Adres {
	
	private int id;
	private String postcode;
	private String straat;
	private int huisnummer;
	private String plaats;
	
	public Adres(int id, String postcode, String straat, int huisnummer,String plaats) {
		this.id = id;
		this.postcode = postcode;
		this.straat = straat;
		this.huisnummer = huisnummer;
		this.plaats = plaats;
	}
	

	public int getId() {
		return id;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getStraat() {
		return straat;
	}

	public int getHuisnummer() {
		return huisnummer;
	}

	

	public String getPlaats() {
		return plaats;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public void setHuisnummer(int huisnummer) {
		this.huisnummer = huisnummer;
	}

	

	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}


	@Override
	public String toString() {
		return "Adres [id=" + id + ", postcode=" + postcode + ", straat=" + straat + ", huisnummer=" + huisnummer
				+ ", plaats=" + plaats + "]";
	}
	
	
	
	
	

}
