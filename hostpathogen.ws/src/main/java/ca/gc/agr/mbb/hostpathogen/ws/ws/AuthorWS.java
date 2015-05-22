package ca.gc.agr.mbb.hostpathogen.ws.ws;

import java.util.Date;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlRootElement;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ca.gc.agr.mbb.hostpathogen.nouns.RefSources;
import ca.gc.agr.mbb.hostpathogen.ws.Nouns;
import ca.gc.agr.mbb.hostpathogen.ws.WSConstants;


@Path(Nouns.AUTHORS)
@XmlRootElement
@Produces({MediaType.APPLICATION_JSON})
public class AuthorWS implements Nouns, WSConstants{	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetAuthorInit(@Context final UriInfo uri,
			@DefaultValue(DEFAULT_PAGING_OFFSET_STRING) @QueryParam(PAGING_OFFSET_PARAMETER) Integer offset, 
			@DefaultValue(DEFAULT_PAGING_LIMIT_STRING) @QueryParam(PAGING_LIMIT_PARAMETER) Integer limit, Date getdate) throws JSONException {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("offset", offset);
		jsonObject.put("limit", limit);

		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String pretJson = prettyGson.toJson(jsonObject);
		//Testing Pretty json printing
		System.out.println(pretJson);
		//("offset", offset);
		//("limit", limit);
		String result = "\n GET Author offset and limit: \n" + jsonObject;

		if (limit - offset > DEFAULT_PAGING_LIMIT){
			System.out.println("Your request exceded the limit of 50!");
			return Response.status(400).build();       
		}else{
			return Response.created(uri.getRequestUri()).status(200).entity(result).build();
		}
	}

	//===========GET Author Id==============//
	@Path(WSConstants.ID_VALID)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetAuthorId(@PathParam(ID) final String ID_VALID) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Author ID", ID_VALID); 

		String result = "\n GET Author ID: \n" + jsonObject;
		System.out.println(result);
		return Response.status(200).entity(result).build();
	}   

	//===========GET Author Bad Id==============//
	@Path(WSConstants.ID_INVALID)
	@GET
	@Produces("application/json")
	public Response GetAuthorNOTId(@PathParam(ID) String ID_INVALID) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Author Bad ID", ID_INVALID); 

		System.out.println("\n GET Not Author ID: \n" + jsonObject);
		return Response.status(400).build();
	}

	//===========GET Author By Reference Id==============//
	@Path(WSConstants.ID_VALID + Nouns.REFERENCES)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetAuthorByReferenceId(@PathParam(ID) final String ID_VALID) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Author By Reference ID", ID_VALID); 

		String result = "\n GET Author By Reference ID: \n" + jsonObject;
		System.out.println(result);
		return Response.status(200).entity(result).build();
	}

	//===========GET Author By Bad Reference Id==============//
	@Path(WSConstants.ID_INVALID + Nouns.REFERENCES)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetAuthorByBadReferenceId(@PathParam(ID) String ID_INVALID) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Author By Bad Reference ID", ID_VALID); 

		String result = "\n GET Author By Bad Reference ID: \n" + jsonObject;
		System.out.println(result);
		return Response.status(400).entity(result).build();
	} 	
}