package iac.hu.webservices;

import java.sql.SQLException;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import iac.hu.shop.model.Klant;
import iac.hu.shop.model.ServiceProvider;
import iac.hu.shop.persistence.KlantService;

@Path("/klant")
public class KlantResource {
	
	private KlantService as = ServiceProvider.getKlantService();
	
	@GET
	@Path("{id}")
    @Produces("application/json")
	public String getKlantById(@PathParam("id") int id) throws SQLException {

			JsonObjectBuilder job = Json.createObjectBuilder();
			Klant klant = as.KlantById(id);
			job.add("achternaam", klant.getAchternaam());
			job.add("voornaam", klant.getVoornaam());
   			job.add("KlantID", klant.getId());
   			job.add("tussenvoegsel", klant.getTussenvoegsel());
   			job.add("email", klant.getEmail());
   		    job.add("geboortedatum",klant.getGeboortedatum().toString());
   			job.add("adresID",klant.getAdres().getId());
   			job.add("mobielenummer",klant.getMobiel());
   			job.add("postcode",klant.getAdres().getPostcode());
   			job.add("straat",klant.getAdres().getStraat());
   			job.add("huisnummer",klant.getAdres().getHuisnummer());
   			job.add("plaats",klant.getAdres().getPlaats());

   			return job.build().toString();	
			


	}
	

}
