package iac.hu.webservices;

import java.sql.SQLException;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import iac.hu.shop.model.Account;
import iac.hu.shop.model.ServiceProvider;
import iac.hu.shop.persistence.AccountService;

@Path("/account")
public class AccountResource {
	
	private AccountService as = ServiceProvider.getAccountService();
	
	

	@GET
	@Path("{id}")
    @Produces("application/json")
	public String getAccountById(@PathParam("id") int id) throws SQLException {

			JsonObjectBuilder job = Json.createObjectBuilder();
			Account account = as.getAccountById(id);
			job.add("account", account.getId());
			job.add("email", account.getEmail());
   			job.add("id-klant", account.getKlant().getId());
   			job.add("achternaam", account.getKlant().getAchternaam());
   			job.add("voornaam", account.getKlant().getVoornaam());
   			job.add("tussenvoegsel",account.getKlant().getTussenvoegsel());
   			job.add("email-klant",account.getKlant().getEmail());
   			job.add("mobiel",account.getKlant().getMobiel());//
   			job.add("geboortedatum",account.getKlant().getGeboortedatum().toString());
   			job.add("id-adres",account.getKlant().getAdres().getId());
   			job.add("postcode",account.getKlant().getAdres().getPostcode());
   			job.add("huisnummer",account.getKlant().getAdres().getHuisnummer());
   			job.add("straat",account.getKlant().getAdres().getStraat());
   			job.add("woonplaats",account.getKlant().getAdres().getPlaats());
   			
   			return job.build().toString();	
			


	}
	
	
}
