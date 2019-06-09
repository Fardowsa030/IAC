package iac.hu.webservices;

import java.security.Key;
import java.sql.SQLException;
import java.util.AbstractMap.SimpleEntry;
import java.util.Calendar;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.DatatypeConverter;

import iac.hu.shop.model.Account;
import iac.hu.shop.model.ServiceProvider;
import iac.hu.shop.persistence.AccountDao;
import iac.hu.shop.persistence.AccountDaoImpl;
import iac.hu.shop.persistence.AccountService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;




@Path("/authentication")
public class AuthenticationResource {
    final static public Key key = MacProvider.generateKey();
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(@FormParam("gebruikersnaam") String username,
              @FormParam("wachtwoord") String password) throws SQLException {
               try {
            // Authenticate the user against the database
                    AccountDao dao = new AccountDaoImpl();
                    if(dao.validation(username, password)) {
                    
                    String token = createToken(username);
                    SimpleEntry<String, String> JWT = new SimpleEntry<String, String>("JWT", token);
                    return Response.ok(JWT).build();
                    }
                    } catch (JwtException | IllegalArgumentException e){
                    	System.out.println(e);
                    }
                              
                    	return Response.status(Response.Status.UNAUTHORIZED).build();}
   
               private String createToken(String email) throws JwtException {
            	   Calendar expiration = Calendar.getInstance();
            	   expiration.add(Calendar.MINUTE, 30);
            	   return Jwts.builder()
            	      .setSubject(email)
            	      .setExpiration(expiration.getTime())
            	      .claim("email", email)
            	      .signWith(SignatureAlgorithm.HS512, "test")
            	      .compact();
            	   
            	   
               }
            	   public String getUsername(String token) {
            		   Claims claims = Jwts.parser()         
            			       .setSigningKey(DatatypeConverter.parseBase64Binary("test"))
            			       .parseClaimsJws(token).getBody();
            			    return (claims.getSubject());

            	    }
            @POST
            @Path("/gegevens") 
            @Produces(MediaType.APPLICATION_JSON)
            @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
           	public String getAccountDetails(@FormParam("token") String jwt) throws SQLException {
            	   AccountService as = ServiceProvider.getAccountService();
            	   JsonObjectBuilder job = Json.createObjectBuilder();
            	   String gebruikersnaam = getUsername(jwt);
          	   System.out.println(gebruikersnaam);
           			Account account = as.getDetailsAccount(gebruikersnaam); 
           			job.add("account", account.getId());
           			job.add("email", account.getEmail());
           			job.add("id_klant", account.getKlant().getId());
           			job.add("achternaam", account.getKlant().getAchternaam());
           			job.add("voornaam", account.getKlant().getVoornaam());
           			job.add("tussenvoegsel",account.getKlant().getTussenvoegsel());
           			job.add("email-klant",account.getKlant().getEmail());
           			job.add("id-adres",account.getKlant().getAdres().getId());
           			job.add("postcode",account.getKlant().getAdres().getPostcode());
           			job.add("huisnummer",account.getKlant().getAdres().getHuisnummer());
           			job.add("straat",account.getKlant().getAdres().getStraat());
           			job.add("woonplaats",account.getKlant().getAdres().getPlaats());
           			
           			return job.build().toString();	
           			


           	}
           	
}

