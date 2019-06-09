package iac.hu.webservices;

import java.sql.SQLException;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


import iac.hu.shop.model.Product;
import iac.hu.shop.model.ServiceProvider;
import iac.hu.shop.persistence.ProductService;




@Path("/product")
public class ProductResource {
	
	private ProductService ps = ServiceProvider.getProductService();
	
	@POST
    @Produces("application/json")
	public Response createProduct(@FormParam("naam") String naam,
		@FormParam("omschrijving") String omschrijving,@FormParam("prijs") double prijs,@FormParam("afbeelding") String afbeelding) 
		throws SQLException {
		
		System.out.println("-- B opslaan");
		
		int id = ps.createUniqueIDProduct();
		Product product = new Product(id,naam,omschrijving,afbeelding,prijs);
		if(!ps.save(product)) {
			return Response.status(404).build();
		}
		
		System.out.println("product opgeslagen");
		return Response.ok(product).build();
		}
	
	
	
	@GET
    @Produces("application/json")
	public String getAll() throws SQLException {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Product p: ps.getAll()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("id", p.getId());
			job.add("afbeelding", p.getAfbeeldingTekst());
			job.add("naam", p.getNaam());
			job.add("omschrijving", p.getOmschrijving());
			job.add("prijs", p.getPrijs());
			job.add("aanmaakDatum", p.getAanmaakDatum().toString());
			
			jab.add(job);
			}
		JsonArray array = jab.build();
		
		return array.toString();

	}
		
	@GET
	@Path("/nieuw") 
    @Produces("application/json")
	public String getNieuweProducten() throws SQLException {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Product p: ps.NewProducts()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("id", p.getId());
			job.add("afbeelding", p.getAfbeeldingTekst());
			job.add("naam", p.getNaam());
			job.add("omschrijving", p.getOmschrijving());
			job.add("prijs", p.getPrijs());
			
			
			jab.add(job);
			}
		JsonArray array = jab.build();
		
		return array.toString();

	}
		


	@GET
    @Produces("application/json")
	public String getProducts(int id) throws SQLException {

			JsonObjectBuilder job = Json.createObjectBuilder();
			Product product = ps.findbyId(id);
			job.add("id", product.getId());
			job.add("afbeelding", product.getAfbeeldingTekst());
			job.add("naam", product.getNaam());
			job.add("omschrijving", product.getOmschrijving());
			job.add("prijs", product.getPrijs());
			
			return job.build().toString();	
			


	}
	
	
	@GET
	@Path("{id}")
    @Produces("application/json")
	public String getProductsById(@PathParam("id") int id) throws SQLException {

			JsonObjectBuilder job = Json.createObjectBuilder();
			Product product = ps.findbyId(id);
			job.add("id", product.getId());
			job.add("afbeelding", product.getAfbeeldingTekst());
			job.add("naam", product.getNaam());
			job.add("omschrijving", product.getOmschrijving());
			job.add("prijs", product.getPrijs());
			
			return job.build().toString();	
			


	}
	
	@DELETE
	@Path("{id}")
	@Produces("application/json")
	public Response deleteProduct(@PathParam("id") int id) throws SQLException {
		System.out.println("Delete product");
		Product found = null;
		for (Product p :ps.getAll()) {
			if (p.getId() == id) {
				found = p; 
				break;
			}
		}
		if (found == null) {
			return Response.status(404).build();
			} else {
				ps.delete(found);
				System.out.println("product verwijderd");
				return Response.ok().build();
			}
	}
	
	@PUT
	@Path("/update/{id}") 
	@Produces("application/json")
	public Response updateProduct(@PathParam("id") int id,
			@FormParam("naam_update") String naam,
								  @FormParam("omschrijving_update") String omschrijving,
								  @FormParam("prijs_update") double prijs,
								  @FormParam("afbeelding_update") String afbeelding) throws SQLException {
		
		System.out.println("upadte product");
		Product found = null;
		for (Product p :ps.getAll()) {
			if (p.getId() == id) {
				found = p; 
				 found.setNaam(naam);
				 found.setOmschrijving(omschrijving);
				 found.setPrijs(prijs);
				 found.setAfbeeldingTekst(afbeelding);
				break;
			}
		}
		if (found == null) {
			return Response.status(404).build();
			} else {
				ps.update(found);
				System.out.println("product gewijzigd");
				return Response.ok().build();
			}
	}

		
		    
	}

			
			

