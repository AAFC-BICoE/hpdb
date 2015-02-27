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

import ca.gc.agr.mbb.hostpathogen.ws.Nouns;


public class TestGetHost{
	//Mock value to test the WS//
	long id = 1;
	int counter = 9;
	int offsetValue = 12;
	int limitValue = 90;
	
	//Start the servlet to call for testing//
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

	/////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void shouldGetHostById(){
		String path = Nouns.HOSTS + "/" + id;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response);
		System.out.println(Response.Status.OK.getStatusCode() + " " + response.getStatus());
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldGetHostByPathogenId(){
		String path = Nouns.HOSTS + "/" + id + "/" + Nouns.PATHOGENS;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response);
		System.out.println(Response.Status.OK.getStatusCode() + " " + response.getStatus());
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldFailWithBadId(){
		String BadId = id + "a";
		String path = Nouns.HOSTS + "/" + BadId;
		System.err.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldFailWithPathogenBadId(){
		String BadId = id + "a";
		String path = Nouns.HOSTS + "/" + BadId + "/" + Nouns.PATHOGENS;
		System.err.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
	}
	@Test
	public void shouldFailWithOutOfRangeId(){
		long outOfRangeId = id + 5;
		System.err.println("Out=" + outOfRangeId);
		String path = Main.BASE_URI +Nouns.HOSTS + "/" + outOfRangeId;
		System.err.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
	}
	/*
	@Test
	public void shouldGetHostCount(){
		String path = Nouns.HOSTS + "/" + Nouns.COUNTS + "/" + counter;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(Response.Status.OK.getStatusCode() + " " + response.getStatus());
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldFailByHostCountExceededTen(){
		int InvalidCount = counter + 2;
	 	String path =  Nouns.HOSTS + "/" + Nouns.COUNTS + "/" + InvalidCount;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response);
		System.out.println(Response.Status.BAD_REQUEST.getStatusCode() + " " + response.getStatus());
		assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldFailByHostCountNotInt(){
		String InvalidCount = counter + "a";
	 	String path =  Nouns.HOSTS + "/" + Nouns.COUNTS + "/" + InvalidCount;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response);
		System.out.println(Response.Status.BAD_REQUEST.getStatusCode() + " " + response.getStatus());
		assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldGetHostSearchCount(){
		String path = Nouns.HOSTS + "/" + Nouns.COUNTS + "/" + counter;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(Response.Status.OK.getStatusCode() + " " + response.getStatus());
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldFailByHostSearchCountExceededTen(){
		int InvalidCount = counter + 2;
	 	String path =  Nouns.HOSTS + "/" + Nouns.COUNTS + "/" + InvalidCount;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response);
		System.out.println(Response.Status.BAD_REQUEST.getStatusCode() + " " + response.getStatus());
		assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldFailByHostSearchCountNotInt(){
		String InvalidCount = counter + "a";
	 	String path =  Nouns.HOSTS + "/" + Nouns.COUNTS + "/" + InvalidCount;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response);
		System.out.println(Response.Status.BAD_REQUEST.getStatusCode() + " " + response.getStatus());
		assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
	}*/
	
	@Test
	public void shouldGetHostSearchCount(){
		target = target.queryParam("family", "host_family");
		target = target.queryParam("genus", "host_species");
		target = target.queryParam("species", "host_genus");
		target = target.queryParam("countries", "pathogen_genus");
		target = target.queryParam("provstateterritory", "pathogen_species");
		String path = Nouns.HOSTS + "/" + Nouns.COUNT;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(Response.Status.OK.getStatusCode() + " " + response.getStatus());
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	/////////////////////////SEARCH/////////////////////////////////
	@Test
	public void shouldGetHostByFamilyName(){
		target = target.queryParam("offset", "1");
		target = target.queryParam("limit", "40");
		target = target.queryParam("family", "abc");
		//String path = "host?family=" + familyName;
		String path = Nouns.HOSTS;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(Response.Status.OK.getStatusCode() + " " + response.getStatus());
		System.out.println(response);
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldGetHostByGenusName(){
		target = target.queryParam("offset", "1");
		target = target.queryParam("limit", "40");
		target = target.queryParam("genus", "777");
		//String path = "host?genus=" + genusName;
		String path = Nouns.HOSTS;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(Response.Status.OK.getStatusCode() + " " + response.getStatus());
		System.out.println(response);
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldGetHostByGenusSpeciesName(){
		target = target.queryParam("offset", "1");
		target = target.queryParam("limit", "40");
		target = target.queryParam("genus", "777");
		target = target.queryParam("species", "foo");
		//String path = "host?genus=" + genPATHOGENSusName;
		String path = Nouns.HOSTS;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(Response.Status.OK.getStatusCode() + " " + response.getStatus());
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldGetHostByCountryName(){
		target = target.queryParam("offset", "1");
		target = target.queryParam("limit", "40");
		target = target.queryParam("countries", "777");
		//String path = "host?country=" + countryName;
		String path = Nouns.HOSTS;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(Response.Status.OK.getStatusCode() + " " + response.getStatus());
		System.out.println(response);
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldGetHostByProvStateName(){
		target = target.queryParam("offset", "1");
		target = target.queryParam("limit", "40");
		target = target.queryParam("provstateterritory", "777");
		//String path = "host?provstate=" + provstateName;
		String path = Nouns.HOSTS;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(Response.Status.OK.getStatusCode() + " " + response.getStatus());
		System.out.println(response);
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void ShouldGetHostSearchBySortField(){
		target = target.queryParam("offset", "1");
		target = target.queryParam("limit", "40");
		target = target.queryParam("sortField", "host_family");
		target = target.queryParam("sortField", "host_species");
		target = target.queryParam("sortField", "host_genus");
		target = target.queryParam("sortField", "pathogen_genus");
		target = target.queryParam("sortField", "pathogen_species");
		target = target.queryParam("sortField", "pathogen_virus");
		target = target.queryParam("sortField", "countries");
		target = target.queryParam("sortField", "provstateterritory");
		//String path = "host?sortField=" + sortField;
		String path = Nouns.HOSTS;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(Response.Status.OK.getStatusCode() + " " + response.getStatus());
		System.out.println(response);
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

	@Test
	public void shouldGetHostOffsetAndLimit(){
		target = target.queryParam("offset", "1");
		target = target.queryParam("limit", "50");
	 	//String path = "location?offset=" + offsetValue + "&limit=" + limitValue;
	 	String path =  Nouns.HOSTS;
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
	 	String path =  Nouns.HOSTS;
	 	System.out.println("path=[" + path + "]");
	 	Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
	 	System.out.println(Response.Status.BAD_REQUEST.getStatusCode() + " " + response.getStatus());
	 	System.out.println(response);
	 	assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
	}
}
