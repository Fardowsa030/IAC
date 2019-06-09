package iac.hu.webservices;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import iac.hu.shop.model.Aanbieding;
import iac.hu.shop.model.Product;
import iac.hu.shop.model.ServiceProvider;
import iac.hu.shop.persistence.AanbiedingService;


@Path("/aanbiedingen")
public class AanbiedingResource {
	
	private AanbiedingService as = ServiceProvider.getAanbiedingService();

	@GET
    @Produces("application/json")
	public String getAlleAanbiedingen() throws SQLException, ParseException {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		// current date formateren
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date dateobj = new Date();
		String currentDate = df.format(dateobj);		
        Date date1 = df.parse(currentDate);
        System.out.println("++" + date1);
        String date1_current = df.format(date1);
        System.out.println("///" +date1_current); 
        

		
		for (Aanbieding a : as.getAanbiedingen()) {
			System.out.println("--" + a.getVanDatum());
			 if (a.getVanDatum().before(date1) || a.getVanDatum().toString().equals(date1_current) && 
					 a.getTotDatum().after(date1) || a.getTotDatum().toString().equals(date1_current)) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("id", a.getId());
			job.add("vanDatum", a.getVanDatum().toString());
			job.add("totDatum", a.getTotDatum().toString());
			job.add("aanbiedingsprijs", a.getAanbiedingsprijs());
			job.add("reclameTekst", a.getReclameTekst());
			job.add("productID", a.getProduct().getId());
			job.add("productNaam", a.getProduct().getNaam());
			job.add("productOmschrijving", a.getProduct().getOmschrijving());
			job.add("productPrijs", a.getProduct().getPrijs());
			job.add("productAfbeelding", a.getProduct().getAfbeeldingTekst());
			jab.add(job);
             }
		
		}
		JsonArray array = jab.build();
		return array.toString();

	}
	
	@GET
	@Path("{id}")
    @Produces("application/json")
	public String getAanbieding(@PathParam("id") int id) throws SQLException {

			JsonObjectBuilder job = Json.createObjectBuilder();
			Aanbieding a = as.getAanbieding(id);
			job.add("aanbiedingsid", a.getId());
			job.add("vanDatum", a.getVanDatum().toString());
			job.add("totDatum", a.getTotDatum().toString());
			job.add("prijs", a.getAanbiedingsprijs());
			job.add("reclameTekst", a.getReclameTekst());
			job.add("id", a.getProduct().getId());
			job.add("naam", a.getProduct().getNaam());
			job.add("omschrijving", a.getProduct().getOmschrijving());
			job.add("productPrijs", a.getProduct().getPrijs());
			job.add("afbeelding", a.getProduct().getAfbeeldingTekst());
			
			return job.build().toString();	
			


	}
	

}
