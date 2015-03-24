package ca.gc.agr.mbb.hostpathogen.ws;

import static org.junit.Assert.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.gc.agr.mbb.hostpathogen.ws.Main;
import ca.gc.agr.mbb.hostpathogen.ws.Nouns;

public class TestGetPathogen{
	long id = 1;
	int offsetValue = 12;
	int limitValue = 90;
	String genusName = "abc";
	//String genusName = "12";
	String virusName = "def";
	//String virusName = "12";
	String speciesName = "fgh";
	//String speciesName = "12";
	String familyName = "abc";
	String orderName = "abc";
	String sortField = "genus";

	private HttpServer server;
	private WebTarget target;
	
	@Before
	public void setUp() throws Exception {
		server = Main.startServer();
	 
		Client client = ClientBuilder.newClient();
	        target = client.target(Main.BASE_URI);
	}
	
	@After
	public void tearDown() throws Exception {
		server.stop();
	}
	
	//////////////////////////////////////////
	@Test
	public void shouldGetPathogenById(){
		String path = Nouns.PATHOGENS + "/" + id;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(Response.Status.OK.getStatusCode() + " " + response.getStatus());
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldFailWithBadId(){
		String BadId = id + "a";
		String path = Nouns.PATHOGENS + "/" + BadId;
		System.err.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldFailWithOutOfRangeId(){
		long outOfRangeId = id + 5;
		System.err.println("Out=" + outOfRangeId);
		String path = Main.BASE_URI + Nouns.PATHOGENS + "/" + outOfRangeId;
		System.err.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldGetPathogenByHostId(){
		String path = Nouns.PATHOGENS + "/" + id + "/" + Nouns.HOSTS;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(Response.Status.OK.getStatusCode() + " " + response.getStatus());
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldFailWithHostBadId(){
		String BadId = id + "a";
		String path = Nouns.PATHOGENS + "/" + BadId + "/" + Nouns.HOSTS;
		System.err.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldFailWithOutOfRangeHostId(){
		long outOfRangeId = id + 5;
		System.err.println("Out=" + outOfRangeId);
		String path = Main.BASE_URI + Nouns.PATHOGENS + "/" + outOfRangeId + Nouns.HOSTS;
		System.err.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldGetPathogenSearchCount(){
		target = target.queryParam("genus", "777");
		target = target.queryParam("species", "1");
		target = target.queryParam("virus", "40");
		String path = Nouns.PATHOGENS + "/" + Nouns.COUNT;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(Response.Status.OK.getStatusCode() + " " + response.getStatus());
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	/////////////////////////SEARCH////////////////////////	
	@Test
	public void shouldGetPathogenByGenusName(){
		target = target.queryParam("offset", "1");
		target = target.queryParam("limit", "40");
		target = target.queryParam("genus", "777");
		//String path = "pathogens?genus=" + genusName;
		String path = Nouns.PATHOGENS;
		System.out.println("path=[" + path + "]");		
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(Response.Status.OK.getStatusCode() + " " + response.getStatus());
		System.out.println(response);
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldGetPathogenByGenusSpeciesName(){
		target = target.queryParam("offset", "1");
		target = target.queryParam("limit", "40");
		target = target.queryParam("genus", "777");
		target = target.queryParam("species", "foo");
		//String path = "pathogens?genus=" + genusName;
		String path = Nouns.PATHOGENS;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(Response.Status.OK.getStatusCode() + " " + response.getStatus());
		System.out.println(response);
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void ShouldGetPathogenByVirusMPLOName(){
		target = target.queryParam("offset", "1");
		target = target.queryParam("limit", "40");
		target = target.queryParam("virus", "foo");
		//String path = "pathogens?virusMPLO=" + virusName;
		String path = Nouns.PATHOGENS;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(Response.Status.OK.getStatusCode() + " " + response.getStatus());
		System.out.println(response);
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void ShouldGetPathogenSearchBySortField(){
		target = target.queryParam("offset", "1");
		target = target.queryParam("limit", "40");
		target = target.queryParam("sortField", "host_family");
		target = target.queryParam("sortField", "host_species");
		target = target.queryParam("sortField", "host_genus");
		target = target.queryParam("sortField", "pathogen_genus");
		target = target.queryParam("sortField", "pathogen_species");
		target = target.queryParam("sortField", "pathogen_virus");
		//String path = "pathogens?sortField=" + sortField;
		String path = Nouns.PATHOGENS;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(Response.Status.OK.getStatusCode() + " " + response.getStatus());
		System.out.println(response);
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldGetSpeciesName(){
		target = target.queryParam("offset", "1");
		target = target.queryParam("limit", "40");
		target = target.queryParam("species", "12d");
	 	//String path = "pathogens?virusMPLO=" + virusName + "&genus=" + genusName + "&species=" + speciesName;
	 	String path = Nouns.PATHOGENS;
	 	System.out.println("path=[" + path + "]");
	 	Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
	 	System.out.println(Response.Status.OK.getStatusCode() + " " + response.getStatus());
	 	System.out.println(response);
	 	assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}   
	
	/////////////////////////////fail Search///////////////////////////////////
	@Test
	public void shouldFailByGetVirusAndSpeciesName(){
		target = target.queryParam("offset", "1");
		target = target.queryParam("limit", "40");
		target = target.queryParam("virus", "foo");
		target = target.queryParam("species", "777");
	 	//String path = "pathogens?virusMPLO=" + virusName + "&genus=" + genusName;
	 	String path = Nouns.PATHOGENS;
	 	System.out.println("path=[" + path + "]");
	 	Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
	 	System.out.println(Response.Status.BAD_REQUEST.getStatusCode() + " " + response.getStatus());
	 	System.out.println(response);
	 	assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldFailByGetVirusAndGenusName(){
		target = target.queryParam("offset", "1");
		target = target.queryParam("limit", "40");
		target = target.queryParam("virus", "foo");
		target = target.queryParam("genus", "777");
	 	//String path = "pathogens?virus=" + virusName + "&genus=" + genusName;
	 	String path = Nouns.PATHOGENS;
	 	System.out.println("path=[" + path + "]");
	 	Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
	 	System.out.println(Response.Status.BAD_REQUEST.getStatusCode() + " " + response.getStatus());
	 	System.out.println(response);
	 	assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldFailByGetVirusGenusAndSpeciesName(){
		target = target.queryParam("offset", "1");
		target = target.queryParam("limit", "40");
		target = target.queryParam("virus", "foo");
		target = target.queryParam("genus", "777");
		target = target.queryParam("species", "12d");
	 	//String path = "pathogens?virusMPLO=" + virusName + "&genus=" + genusName;
	 	String path = Nouns.PATHOGENS;
	 	System.out.println("path=[" + path + "]");
	 	Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
	 	System.out.println(Response.Status.BAD_REQUEST.getStatusCode() + " " + response.getStatus());
	 	System.out.println(response);
	 	assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
	} 
	
	@Test
	public void shouldGetPathogenOffsetAndLimit(){
		target = target.queryParam("offset", "1");
		target = target.queryParam("limit", "50");
	 	//String path = "location?offset=" + offsetValue + "&limit=" + limitValue;
	 	String path =  Nouns.PATHOGENS;
	 	System.out.println("path=[" + path + "]");
	 	Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
	 	System.out.println(Response.Status.OK.getStatusCode() + " " + response.getStatus());
	 	System.out.println(response);
	 	assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldFailByOutOfRangeOffsetAndLimit(){
		target = target.queryParam("offset", "12");
		target = target.queryParam("limit", "90");
	 	//String path = "host?offset=" + offsetValue + "&limit=" + limitValue;
	 	String path =  Nouns.PATHOGENS;
	 	System.out.println("path=[" + path + "]");
	 	Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
	 	System.out.println(Response.Status.BAD_REQUEST.getStatusCode() + " " + response.getStatus());
	 	System.out.println(response);
	 	assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
	}
}
