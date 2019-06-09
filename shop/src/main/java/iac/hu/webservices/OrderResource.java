package iac.hu.webservices;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import iac.hu.shop.model.Adres;
import iac.hu.shop.model.Bestelling;
import iac.hu.shop.model.Bestellingsregel;
import iac.hu.shop.model.Klant;
import iac.hu.shop.model.ServiceProvider;
import iac.hu.shop.persistence.AdresService;
import iac.hu.shop.persistence.KlantService;
import iac.hu.shop.persistence.OrderService;
import iac.hu.shop.persistence.OrderregelService;




@Path("/order")
public class OrderResource {
	OrderService os = ServiceProvider.getOrderService();
	OrderregelService or = ServiceProvider.getOrderregelService();
	AdresService as = ServiceProvider.getAdresService();
	KlantService ks = ServiceProvider.getKlantService();
	

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDate datum = LocalDate.now();
	
	

	@GET
	@Path("{id}")
    @Produces("application/json")
	public String getKlantById(@PathParam("id") int id) throws SQLException {
              
			JsonObjectBuilder job = Json.createObjectBuilder();
			Bestelling bestelling = os.getOder(id);
			job.add("id", bestelling.getId());
			job.add("aanvraagdatum", bestelling.getOrderDatum());
   			job.add("KlantID", bestelling.getKlantID());
   			job.add("achternaam", bestelling.getKlant().getAchternaam());
			job.add("voornaam", bestelling.getKlant().getVoornaam());
   			job.add("tussenvoegsel", bestelling.getKlant().getTussenvoegsel());
   			job.add("email", bestelling.getKlant().getEmail());
   		    job.add("geboortedatum",bestelling.getKlant().getGeboortedatum().toString());
   			job.add("adresID",bestelling.getKlant().getAdres().getId());
   			job.add("postcode",bestelling.getKlant().getAdres().getPostcode());
   			job.add("straat",bestelling.getKlant().getAdres().getStraat());
   			job.add("huisnummer",bestelling.getKlant().getAdres().getHuisnummer());
   			job.add("plaats",bestelling.getKlant().getAdres().getPlaats());
   			job.add("orderregels", bestelling.getRegels().toString());
			
   			
   		
   	return job.build().toString();	
   				
   			
	}
   			

// java nullpointers handle
   				
   			
   			
			


	
	
	
	
	

	@POST
    @Produces("application/json")
    public Response getGeneratedBusinessRule(@FormParam("klant") int klantID,@FormParam("orderRegel") String winkelwagen) throws SQLException{
		int id = os.createIdOrder();
		Bestelling bestelling = new Bestelling(id,dtf.format(datum),klantID);
		
		os.saveOrderAccount(bestelling);
			
		
	   
		

		JSONArray jsonArray = new JSONArray(winkelwagen);
		int length = jsonArray.length();
		for(int i = 0; i < length; i++) {
			Bestellingsregel regel = new Bestellingsregel();
			 JSONObject jb = jsonArray.getJSONObject(i);
	            int bestellingregelID = or.createIdOrderRegel();
	            int orderID = bestelling.getId();
	            regel.setId(bestellingregelID);
	            regel.setAantal(jb.getInt("aantal"));
	            regel.setLeverprijs(jb.getInt("prijs"));
	            regel.setProductID(jb.getInt("id"));
	            regel.setBestellingID(orderID);
	            or.saveOrderRegel(regel);
	         
	            
	    		//return Response.ok(regel).build();
 
		}     
		return Response.ok(bestelling).build();
	            
		}
		



@POST
@Path("gast")
@Produces("application/json")
public Response postGastOrder(@FormParam("voornaam") String voornaam,@FormParam("achternaam") String achternaam,
		@FormParam("postcode") String postcode,@FormParam("huisnummer") int huisnummer,
		@FormParam("straat") String straat,@FormParam("email") String email,@FormParam("gbdatum") Date gbdatum,
		@FormParam("mobiel") String mobiel,@FormParam("plaats") String plaats,@FormParam("orderRegel") String winkelwagen) throws SQLException {
	
	     int AdresID = as.uniqeIDAdres();
	     int KlantID = ks.uniqueKlant();
	     Adres adres = new Adres(AdresID,postcode,straat,huisnummer,plaats);
	     Klant klant = new Klant(KlantID,voornaam,achternaam,"",mobiel,gbdatum,adres.getId(),email);
	     as.save(adres);
	     ks.save(klant);
	    int id = os.createIdOrder();
	    Bestelling bestelling = new Bestelling(id,dtf.format(datum),klant.getId());
		os.saveOrderGast(bestelling);
			
		
	     
	     JSONArray jsonArray = new JSONArray(winkelwagen);
			int length = jsonArray.length();
			for(int i = 0; i < length; i++) {
				Bestellingsregel regel = new Bestellingsregel();
				 JSONObject jb = jsonArray.getJSONObject(i);
		            int bestellingregelID = or.createIdOrderRegel();
		            int orderID = bestelling.getId();
		            regel.setId(bestellingregelID);
		            regel.setAantal(jb.getInt("aantal"));
		            regel.setLeverprijs(jb.getInt("prijs"));
		            regel.setProductID(jb.getInt("id"));
		            regel.setBestellingID(orderID);
		            or.saveOrderRegel(regel);	          
			}     
	
	     return Response.ok(bestelling).build();

}

}