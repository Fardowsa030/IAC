package iac.hu.webservices;

import java.sql.SQLException;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import iac.hu.shop.model.Categorie;
import iac.hu.shop.model.Product;
import iac.hu.shop.model.ServiceProvider;
import iac.hu.shop.persistence.CategorieService;
import iac.hu.shop.persistence.ProductService;

@Path("/categorie")
public class CategorieRescource {
	private CategorieService cs = ServiceProvider.getCategorieService();
	private ProductService ps = ServiceProvider.getProductService();
		
		

		@GET
	    @Produces("application/json")
		public String getAllCountries() throws SQLException {
			JsonArrayBuilder jab = Json.createArrayBuilder();
			
			for (Categorie c : cs.findAll()) {
				JsonObjectBuilder job = Json.createObjectBuilder();
				job.add("id", c.getId());
				job.add("afbeelding", c.getAfbeeldingTekst());
				job.add("naam", c.getNaam());
				job.add("omschrijving", c.getOmschrijving());
				jab.add(job);
				}
			JsonArray array = jab.build();
			return array.toString();

		}
		


		
		/*
		
		@GET
		@Path("{id}")
		@Produces("application/json")
		public String getCategorieProducts(@PathParam("id") int id) throws SQLException  {
		
			Categorie categorie = cs.findCategorie(id);
			JsonArrayBuilder jab = Json.createArrayBuilder();
			
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("id", categorie.getId());
			job.add("afbeelding", categorie.getAfbeeldingTekst());
			job.add("naam", categorie.getNaam());
			job.add("omschrijving", categorie.getOmschrijving());
			for(Product p: categorie.getProduct()) {
				
				job.add("idproduct", p.getId());
				job.add("naamproduct", p.getNaam());
				job.add("omschrijvingproduct", p.getOmschrijving());
				job.add("afbeeldingproduct", p.getAfbeeldingTekst());
				job.add("prijsproduct", p.getPrijs());

				
			}
		
			jab.add(job);
			
			
		
			
			
		
			JsonArray array = jab.build();
			return array.toString();	
		}
		
*/
		@GET
		@Path("{id}")
	    @Produces("application/json")
		public String getAllProducts(@PathParam("id") int id) throws SQLException {
			JsonArrayBuilder jab = Json.createArrayBuilder();
			
			for (Product p: ps.findbyCategorie(id)) {
				JsonObjectBuilder job = Json.createObjectBuilder();
				job.add("id", p.getId());
				job.add("afbeelding", p.getAfbeeldingTekst());
				job.add("naam", p.getNaam());
				job.add("omschrijving", p.getOmschrijving());
				job.add("prijs", p.getPrijs());
				job.add("categorieid", p.getCategorie().getId());
				job.add("categorienaam", p.getCategorie().getNaam());
				job.add("categorieomschrijving", p.getCategorie().getOmschrijving());
				
				jab.add(job);
				}
			JsonArray array = jab.build();
			return array.toString();

		}
		
		
		
	
	
	

}
