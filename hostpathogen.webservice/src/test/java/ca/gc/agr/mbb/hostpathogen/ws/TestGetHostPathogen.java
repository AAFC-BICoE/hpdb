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

public class TestGetHostPathogen{
	long id = 1;
	int offsetValue = 12;
	int limitValue = 90;
	int counter = 9;
	
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
	public void shouldGetHostPathogenById(){
		String path = Nouns.HOSTPATHOGENS + "/" + id;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response);
		System.out.println(Response.Status.OK.getStatusCode() + " " + response.getStatus());
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldGetHostPathogenByPathogenId(){
		String path = Nouns.HOSTPATHOGENS + "/" + id + "/" +Nouns.PATHOGENS;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response);
		System.out.println(Response.Status.OK.getStatusCode() + " " + response.getStatus());
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldGetHostPathogenByHostId(){
		String path = Nouns.HOSTPATHOGENS;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response);
		System.out.println(Response.Status.OK.getStatusCode() + " " + response.getStatus());
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldGetHostPathogenByCountryList(){
		target = target.queryParam("countries", "canada");
		target = target.queryParam("countries", "usa");
		String path = Nouns.HOSTPATHOGENS;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response);
		System.out.println(Response.Status.OK.getStatusCode() + " " + response.getStatus());
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldGetHostPathogenByLocationList(){
		target = target.queryParam("locations", "ab");
		target = target.queryParam("locations", "ny");
		String path = Nouns.HOSTPATHOGENS;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response);
		System.out.println(Response.Status.OK.getStatusCode() + " " + response.getStatus());
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	    
	@Test
	public void shouldFailWithBadId(){
		String BadId = id + "a";
		String path = Nouns.HOSTPATHOGENS + "/" + BadId;
		System.err.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldFailWithPathogenBadId(){
		String BadId = id + "a";
		String path = Nouns.HOSTPATHOGENS + "/" + BadId + "/" + Nouns.PATHOGENS;
		System.err.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldFailWithHostBadId(){
		String BadId = id + "a";
		String path = Nouns.HOSTPATHOGENS + "/" + BadId + "/" + Nouns.HOSTS;
		System.err.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
	}
	    
	@Test
	public void shouldFailWithOutOfRangeId(){
		long outOfRangeId = id + 5;
		System.err.println("Out=" + outOfRangeId);
		String path = Main.BASE_URI + Nouns.HOSTPATHOGENS + "/" + outOfRangeId;
		System.err.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldGetHostPathogenOffsetAndLimit(){
		target = target.queryParam("offset", "1");
		target = target.queryParam("limit", "50");
	 	//String path = "location?offset=" + offsetValue + "&limit=" + limitValue;
	 	String path =  Nouns.HOSTPATHOGENS;
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
	 	//String path = "hostpathogen?offset=" + offsetValue + "&limit=" + limitValue;
	 	String path =  Nouns.HOSTPATHOGENS;
	 	System.out.println("path=[" + path + "]");
	 	Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
	 	System.out.println(Response.Status.BAD_REQUEST.getStatusCode() + " " + response.getStatus());
	 	System.out.println(response);
	 	assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
	}
	/*
	@Test
	public void shouldGetHostPathogenCount(){
		String path = Nouns.HOSTPATHOGENS + "/" + Nouns.COUNTS + "/" + counter;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(Response.Status.OK.getStatusCode() + " " + response.getStatus());
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldFailByHostPathogenCountExceededTen(){
		int InvalidCount = counter + 2;
	 	String path =  Nouns.HOSTPATHOGENS + "/" + Nouns.COUNTS + "/" + InvalidCount;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response);
		System.out.println(Response.Status.BAD_REQUEST.getStatusCode() + " " + response.getStatus());
		assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void shouldFailByHostPathogenCountNotInt(){
		String InvalidCount = counter + "a";
	 	String path =  Nouns.HOSTPATHOGENS + "/" + Nouns.COUNTS + "/" + InvalidCount;
		System.out.println("path=[" + path + "]");
		Response response = target.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response);
		System.out.println(Response.Status.BAD_REQUEST.getStatusCode() + " " + response.getStatus());
		assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
	}*/
}
