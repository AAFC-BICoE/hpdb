package ca.gc.agr.mbb.hostpathogen.ws.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.DefaultValue;
import javax.xml.bind.annotation.XmlRootElement;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import ca.gc.agr.mbb.hostpathogen.ws.Nouns;
import ca.gc.agr.mbb.hostpathogen.ws.WSConstants;
import ca.gc.agr.mbb.hostpathogen.nouns.Pathogen;

@Path(WSConstants.BASEPATH)
@XmlRootElement
@Produces({MediaType.APPLICATION_JSON})
@JsonInclude(Include.NON_DEFAULT)
public class PathogenWS implements Nouns, WSConstants{
	public PathogenWS()
	{
		super();
	}


	@GET @Path(Nouns.PATHOGENS)
	public Response GetListPathogens(@Context UriInfo uri,
			@DefaultValue(DEFAULT_PAGING_OFFSET_STRING) @QueryParam(PAGING_OFFSET_PARAMETER) Integer offset, 
			@DefaultValue(DEFAULT_PAGING_LIMIT_STRING) @QueryParam(PAGING_LIMIT_PARAMETER) Integer limit,
			@DefaultValue("") @QueryParam("genus") String genusString, 
			@DefaultValue("") @QueryParam("species") String speciesString, 
			@DefaultValue("") @QueryParam("virus") String virusString, 
			@DefaultValue("") @QueryParam("countries") String countryString, 
			@DefaultValue("true") @QueryParam("synonyms") String synonymsString,
			@DefaultValue("") @QueryParam("sortFields") final List<String> sortFieldsString)throws JSONException {

		CacheControl cc = new CacheControl();
		cc.setMaxAge(86400); 
		cc.setPrivate(true);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("offset", offset); 
		jsonObject.put("limit", limit);
		jsonObject.put("Pathogens Genus", genusString); 
		jsonObject.put("Pathogens Species", speciesString);
		jsonObject.put("Pathogens VirusMPLO", virusString);
		jsonObject.put("countries", countryString);
		jsonObject.put("Synonyms", synonymsString);
		jsonObject.put("Sort Fields", sortFieldsString.toString());

		String result = "\n GET Pathogens offset and limit and fieldQuery: \n" + jsonObject;
		System.out.println(result.toString());
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String pretJson = prettyGson.toJson(jsonObject);

		//Testing Pretty json printing 
		System.out.println(pretJson);

		if (limit - offset > DEFAULT_PAGING_LIMIT){
			System.out.println("Your request exceded the limit of 50!");
			return Response.status(400).cacheControl(cc).build();  
		}else if(genusString != null && !genusString.isEmpty() && speciesString != null && !speciesString.isEmpty() && virusString != null && !virusString.isEmpty()){
			return Response.status(400).cacheControl(cc).build();
		}else if (genusString != null && !genusString.isEmpty() && virusString != null && !virusString.isEmpty()){
			return Response.status(400).cacheControl(cc).build();
		}else if(virusString != null && !virusString.isEmpty() && speciesString !=null && !speciesString.isEmpty()){
			return Response.status(400).cacheControl(cc).build();
		}else{
			return Response.status(200).entity(result).cacheControl(cc).build();
		}
	}

	//======================Count for Search=============//
	@Path(Nouns.COUNT)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetCountPathogensSearchQuery(  
			@Context UriInfo uri,
			@DefaultValue(DEFAULT_PAGING_OFFSET_STRING) @QueryParam(PAGING_OFFSET_PARAMETER) Integer offset, 
			@DefaultValue(DEFAULT_PAGING_LIMIT_STRING) @QueryParam(PAGING_LIMIT_PARAMETER) Integer limit,
			@DefaultValue("") @QueryParam("genus") String genusString, 
			@DefaultValue("") @QueryParam("species") String speciesString, 
			@DefaultValue("") @QueryParam("virus") String virusString)throws JSONException { 

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Pathogens Genus", genusString); 
		jsonObject.put("Pathogens Species", speciesString);
		jsonObject.put("Pathogens VirusMPLO", virusString);
		String result = "\n GET Pathogens counts query: \n" + jsonObject;
		System.out.println(result);
		return Response.status(200).entity(result).build();
	}   

	//===========GET Pathogens by Id==============//
	@Path(WSConstants.ID_VALID)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetPathogensId(@PathParam(ID) String ID_VALID) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Pathogens ID", ID_VALID); 
		String result = "\n GET Pathogens ID: \n" + jsonObject;
		System.out.println(result);
		return Response.status(200).entity(result).cacheControl(null).build();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Pathogen GetPathohenID(@PathParam(ID) long ID_VALID) throws JSONException{
		Pathogen pathogen = new Pathogen();
		pathogen.getId();
		pathogen.setId(ID_VALID);
		System.out.println(pathogen);
		return pathogen;
	}
	//===========GET Pathogens by host Id==============//
	@Path(WSConstants.ID_VALID + Nouns.HOSTS)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetPathogensByHostId(@PathParam(ID) String ID_VALID) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Host ID", ID_VALID); 
		String result = "\n GET Pathogens by HostID: \n" + jsonObject;
		System.out.println(result);
		return Response.status(200).entity(result).build();
	}

	//===========GET Pathogens by Invalid ID==============//
	@Path(WSConstants.ID_INVALID)
	@GET
	@Produces("application/json")
	public Response GetPathogensNOTId(@PathParam(ID) String ID_INVALID) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Pathogens Bad ID", ID_INVALID); 

		System.out.println("\n\n GET Not PathogensID: \n" + jsonObject);
		return Response.status(400).build();
	}

	//===========GET Pathogens where bad host Id==============//
	@Path(WSConstants.ID_INVALID + Nouns.HOSTS)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetPathogensByHostBadId(@PathParam(ID) String ID_INVALID) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Host Invalid ID", ID_INVALID); 
		String result = "\n GET Pathogens Not HostID: \n" + jsonObject;
		System.out.println(result);
		return Response.status(400).entity(result).build();
	}
}
